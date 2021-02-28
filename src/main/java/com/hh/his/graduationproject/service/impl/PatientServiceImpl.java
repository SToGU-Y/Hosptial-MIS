package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.PatientMapper;
import com.hh.his.graduationproject.model.dto.PatientUpdateDTO;
import com.hh.his.graduationproject.model.dto.PidUpdate;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.condition.PatientConditionVO;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.PatientVO;
import com.hh.his.graduationproject.service.PatientService;
import com.hh.his.graduationproject.utils.bean.PatientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.List;

/**
 * 病人管理业务
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    /**
     * 查询所有病人
     * @return
     */
    public List<PatientVO> findPatients() {
        List<Patient> patients = patientMapper.findPatients();
        List<PatientVO> patientVos = new ArrayList<PatientVO>();
        for(Patient patient : patients){
            PatientVO patientVO = PatientConverter.INSTANCE.doToVo(patient);
            patientVO.setNativePlace(patient.getProvince()+patient.getCity());
            patientVos.add(patientVO);
        }
        return patientVos;
    }

    /**
     * 按条件查询病人信息
     * @param conditionDTO
     * @return
     */
    @Override
    public PageInfo<PatientVO> findPatientsByConditions(Integer pageNum,PatientConditionVO conditionDTO) {
        List<Patient> patients = patientMapper.findPatientsByConditions(conditionDTO);
        PageInfo<Patient> forToal = new PageInfo<>(patients);
        long total = forToal.getTotal();

        PageHelper.startPage(pageNum,10);
        List<Patient> patientList = patientMapper.findPatientsByConditions(conditionDTO);

        List<PatientVO> patientVos = PatientConverter.INSTANCE.toVOList(patientList);
        PageInfo<PatientVO> pageInfo = new PageInfo<>(patientVos);
        pageInfo.setTotal(total);

        return pageInfo;
    }

    @Override
    public Patient findPatientByPid(String pid) {
        Patient patient = patientMapper.findPatientByPid(pid);
        return patient;
    }

    @Override
    public int updatePatient(PatientUpdateDTO patient) {
        try {
            int i = patientMapper.updatePatientWithPid(patient);
            if (!patient.getPid().equals(patient.getOldpid())){
                PidUpdate pidUpdate = new PidUpdate();
                pidUpdate.setPid(patient.getOldpid());
                pidUpdate.setNewPid(patient.getPid());
                informationMapper.updatePid(pidUpdate);
            }
            return i;
        }catch (Exception e){
            return 0;
        }
    }


    @Override
    public int deletePatientByPid(List<PatientVO> list) throws Exception {
        int i = 0;
        for (PatientVO patientVO : list){
            List<InpatientInformation> inpatientInformations = informationMapper.selectAdmissionByPid(patientVO.getPid());
            if (inpatientInformations.size()>0){
                throw new Exception("该病人存在住院记录，无法删除");
            }
        }
        for (PatientVO pid: list) {
            i = i + patientMapper.deletePatientByPid(pid.getPid());
        }
        return i;
    }

}
