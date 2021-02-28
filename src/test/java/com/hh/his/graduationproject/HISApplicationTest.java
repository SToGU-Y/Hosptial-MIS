package com.hh.his.graduationproject;

import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.MenuMapper;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.service.PatientService;
import com.hh.his.graduationproject.service.StaffService;
import com.hh.his.graduationproject.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HISApplicationTest {

    @Autowired
    private StaffService staffService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private InpatientService service;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Test
    public void contextLoads() throws SQLException {
      //  System.out.println(patientService.findPatients().toString());
      //  System.out.println(mapper.findAllAdmission().toString());
       // List<InpatientInformationAddVO> allAdmission = service.findAllAdmission();
      //  System.out.println(allAdmission.toString());

      //  System.out.println(new BCryptPasswordEncoder().encode("123456"));
      //  System.out.println(redisUtil.hget("token","token_08924"));

      //  System.out.println(KeyUtil.createID());
      /*  BedConditionVO conditionVO = new BedConditionVO();
        List<InpatientInformation> bedByCondition = informationMapper.findBedByCondition(conditionVO);
        List<BedVO> bedVOS = BedConverter.INSTANCE.toVOList(bedByCondition);
        System.out.println(bedVOS);*/
     //   System.out.println(menuMapper.getMenusByUsername("08924"));
    }

}
