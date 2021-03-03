package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedUpdateDTO {

    private Integer id;
    private Integer bid;
    private Integer wid;
    private Integer bedStatus;

}
