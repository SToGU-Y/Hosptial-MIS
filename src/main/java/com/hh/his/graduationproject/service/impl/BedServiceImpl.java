package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.BedMapper;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.InpatientWardMapper;
import com.hh.his.graduationproject.model.dto.BedAddDTO;
import com.hh.his.graduationproject.model.dto.BedUpdateDTO;
import com.hh.his.graduationproject.model.dto.WardUpdateDTO;
import com.hh.his.graduationproject.model.entity.Bed;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.BedConditionVO;
import com.hh.his.graduationproject.model.vo.condition.BedSelectConditionVO;
import com.hh.his.graduationproject.service.BedService;
import com.hh.his.graduationproject.utils.bean.BedConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private InpatientWardMapper wardMapper;

    @Override
    public PageInfo<BedSelectVO> findNullBed(Integer pageNum, BedSelectConditionVO conditionVO) {
        List<Bed> bedForTotal = bedMapper.selectNullBed(conditionVO);
        PageInfo<Bed> pageInfo1 = new PageInfo<>(bedForTotal);
        long total = pageInfo1.getTotal();

        PageHelper.startPage(pageNum,12);
        List<Bed> bedList = bedMapper.selectNullBed(conditionVO);

        List<BedSelectVO> bedSelectVOS = BedConverter.INSTANCE.toVOs(bedList);
        PageInfo<BedSelectVO> pageInfo = new PageInfo<>(bedSelectVOS);
        pageInfo.setTotal(total);
        return pageInfo;
    }


    @Override
    public int updateAdmission(InpatientBedAddVO addVO) {
        int i = informationMapper.updateBedAndWard(addVO);
        BedUpdateDTO bedUpdateDTO = new BedUpdateDTO();
        bedUpdateDTO.setId(addVO.getId());
        bedUpdateDTO.setBedStatus(1);
        bedMapper.updateBed(bedUpdateDTO);
        if (isFull(addVO.getWid())){
            WardUpdateDTO wardUpdateDTO = new WardUpdateDTO();
            wardUpdateDTO.setWid(addVO.getWid());
            wardUpdateDTO.setWardStatus(1);
            wardMapper.updateWardWithDTO(wardUpdateDTO);
        }
        return i;
    }

    @Override
    public int BedChange(InpatientBedChangeVO changeVO) {
        //旧病床更改状态
        BedUpdateDTO bedUpdateDTO = new BedUpdateDTO();
        bedUpdateDTO.setId(changeVO.getOldid());
        bedUpdateDTO.setBedStatus(0);
        bedMapper.updateBed(bedUpdateDTO);
        //旧病房更改状态
        WardUpdateDTO wardUpdateDTO = new WardUpdateDTO();
        wardUpdateDTO.setWid(changeVO.getOldwid());
        wardUpdateDTO.setWardStatus(0);
        wardMapper.updateWardWithDTO(wardUpdateDTO);

        //新病床更改状态
        InpatientBedAddVO addVO = new InpatientBedAddVO();
        addVO.setId(changeVO.getId());
        addVO.setWid(changeVO.getWid());
        addVO.setInpatientId(changeVO.getInpatientId());
        int i = this.updateAdmission(addVO);

        return i;
    }

    @Override
    public PageInfo<BedVO> findAllBed(Integer pageNum, BedConditionVO conditionVO) {

        PageHelper.startPage(pageNum,11);
        List<BedVO> byCondition = informationMapper.findBedByCondition(conditionVO);
        PageInfo<BedVO> bedVOPageInfo = new PageInfo<>(byCondition);

        return bedVOPageInfo;
    }

    @Override
    public PageInfo<BedVO> findBedNotNull(Integer pageNum, BedConditionVO conditionVO) {
        System.out.println("pageNum = "+pageNum);
        List<InpatientInformation> forTotal = informationMapper.findBedByCondition2(conditionVO);
        PageInfo<InpatientInformation> informationPageInfo = new PageInfo<>(forTotal);
        long total = informationPageInfo.getTotal();

        PageHelper.startPage(pageNum,11);
        List<InpatientInformation> byCondition = informationMapper.findBedByCondition2(conditionVO);

        List<BedVO> bedVOS = BedConverter.INSTANCE.toVOList(byCondition);
        PageInfo<BedVO> bedVOPageInfo = new PageInfo<>(bedVOS);
        bedVOPageInfo.setTotal(total);

        return bedVOPageInfo;
    }

    @Override
    public void addBed(BedAddDTO bed) throws Exception {
        bed.setBedStatus(0);
        InpatientWard wardById = wardMapper.findWardById(bed.getWid());

        List<Bed> bedList = bedMapper.selectBedByWid(bed.getWid());
        for (Bed b : bedList){
            if (b.getBid().equals(bed.getBid())){
                throw new Exception("病床号已存在");
            }
        }

        int i = bedMapper.insertBed(bed);



        Integer wardBedNum = wardById.getWardBedNum();

        WardUpdateDTO wardUpdateDTO = new WardUpdateDTO();
        wardUpdateDTO.setWid(bed.getWid());
        wardUpdateDTO.setWardBedNumber(wardBedNum+1);
        wardUpdateDTO.setWardStatus(0);
        wardMapper.updateWardWithDTO(wardUpdateDTO);

    }

    @Override
    public int delBed(Integer id) {

        Bed bed = bedMapper.selectById(id);
        InpatientWard ward = wardMapper.findWardById(bed.getWard().getWid());
        WardUpdateDTO wardUpdateDTO = new WardUpdateDTO();
        wardUpdateDTO.setWid(bed.getWard().getWid());
        wardUpdateDTO.setWardBedNumber(ward.getWardBedNum()-1);
        wardMapper.updateWardWithDTO(wardUpdateDTO);
        if (isFull(bed.getWard().getWid())){
            WardUpdateDTO wardUpdateDTO2 = new WardUpdateDTO();
            wardUpdateDTO2.setWid(bed.getWard().getWid());
            wardUpdateDTO2.setWardStatus(1);
            wardMapper.updateWardWithDTO(wardUpdateDTO2);
        }
        int i = bedMapper.delBedById(id);
        return i;
    }

    @Override
    public int returnBed(ReturnBedVO returnBed) {
        BedUpdateDTO bedUpdateDTO = new BedUpdateDTO();
        bedUpdateDTO.setId(returnBed.getId());
        bedUpdateDTO.setBedStatus(0);
        bedMapper.updateBed(bedUpdateDTO);

        WardUpdateDTO wardUpdateDTO = new WardUpdateDTO();
        wardUpdateDTO.setWid(returnBed.getWid());
        wardUpdateDTO.setWardStatus(0);
        int updateWard = wardMapper.updateWardWithDTO(wardUpdateDTO);

        InpatientBedAddVO bedAddVO = new InpatientBedAddVO();
        bedAddVO.setInpatientId(returnBed.getAdmissionId());
        informationMapper.updateBedAndWard(bedAddVO);

        return updateWard;
    }


    public boolean isFull(Integer wid){
        int wardBedNum = bedMapper.selectWardBedNumByWid(wid);
        int notNullBedNum = bedMapper.selectNotNullBedNumByWid(wid);
        if ( notNullBedNum == wardBedNum){
            return true;
        }else {
            return false;
        }
    }
}
