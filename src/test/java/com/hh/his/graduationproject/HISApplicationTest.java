package com.hh.his.graduationproject;

import com.hh.his.graduationproject.dao.AnalysisMapper;
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
import java.util.*;

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

    @Autowired
    private AnalysisMapper analysisMapper;

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



        List<HashMap<String, Object>> maps = analysisMapper.MonthlyHospitalization("2021");
        List<HashMap<String, Object>> maps1 = analysisMapper.MonthlyDischarged("2021");
        Map<String, Long> map = new HashMap<>();
        Map<String, Long> map1 = new HashMap<>();
        if (maps != null && !maps.isEmpty()){
            for (HashMap<String, Object> hashMap : maps) {
                String key = null;
                Long value = null;
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if ("月份".equals(entry.getKey())) {
                        key = entry.getValue()+"月";
                    } else if ("住院人数".equals(entry.getKey())) {
                        value = (Long) entry.getValue();
                    }
                }
                map.put(key, value);
            }
        }
        if (maps1 != null && !maps1.isEmpty()){
            for (HashMap<String, Object> hashMap : maps1) {
                String key = null;
                Long value = null;
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if ("月份".equals(entry.getKey())) {
                        key = entry.getValue()+"月";
                    } else if ("出院人数".equals(entry.getKey())) {
                        value =  (Long)entry.getValue();
                    }
                }
                map1.put(key, value);
            }
        }
     //   System.out.println(map); //住院
      //  System.out.println(map1);//出院

        List<Map<String,String>> list = new ArrayList<>();

        if (map.size()>=map1.size()){
            for (Map.Entry<String,Long> entry: map.entrySet()){
                Map<String,String> map2 = new HashMap<>();
                map2.put("月份",entry.getKey());
                map2.put("住院",String.valueOf(entry.getValue()));
                map2.put("出院","0");
                list.add(map2);
            }
            for (Map.Entry<String,Long> entry: map1.entrySet()){
                for (Map map2 : list){
                    if (map2.containsValue(entry.getKey())){
                        map2.put("出院",String.valueOf(entry.getValue()));
                    }
                }

            }

        }else{
            for (Map.Entry<String,Long> entry: map1.entrySet()){
                Map<String,String> map2 = new HashMap<>();
                map2.put("月份",entry.getKey());
                map2.put("出院",String.valueOf(entry.getValue()));
                list.add(map2);
            }
            for (Map.Entry<String,Long> entry: map.entrySet()){
                for (Map map2 : list){
                    if (map2.containsValue(entry.getKey())){
                        map2.put("出院",entry.getValue());
                    }
                }

            }
        }


        System.out.println(list);


    }

}
