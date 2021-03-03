package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResult {

    private List<MedicalAdviceQueryVO> selectiveList;
    private String username;
    private String remarks;

}
