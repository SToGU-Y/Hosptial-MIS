package com.hh.his.graduationproject;

import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.PatientMapper;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.service.PatientService;
import com.hh.his.graduationproject.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.dc.pr.PRError;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HISApplicationTest {

    @Autowired
    private StaffService staffService;

    @Autowired
    DataSource dataSource;
    @Autowired
    private PatientService patientService;
    @Autowired
    private InpatientService service;


    @Test
    public void contextLoads() throws SQLException {
      //  System.out.println(patientService.findPatients().toString());
      //  System.out.println(mapper.findAllAdmission().toString());
       // List<InpatientInformationVO> allAdmission = service.findAllAdmission();
      //  System.out.println(allAdmission.toString());
    }

}
