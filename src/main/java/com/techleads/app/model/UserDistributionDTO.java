package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDistributionDTO {

    private String packageEngineer;
    private String facility;
    private String userId;
    private String areaName;
    private Integer usrDistKey;
    private String programCode;
    private String supplierNum;
    private String partFamily;
    private String shopClass;
    private String partNumber;
}
