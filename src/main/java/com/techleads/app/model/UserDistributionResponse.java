package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDistributionResponse {
    private String packageEngineer;
    private String facility;
    private String userId;
    private String areaName;
    private Integer usrDistKey;
    private String programCode;
    private String supplierNum;
    private String partFamily;
    private String shopClass;

    public UserDistributionResponse(String packageEngineer, String facility, String userId, String areaName, Integer usrDistKey) {
        this.packageEngineer = packageEngineer;
        this.facility = facility;
        this.userId = userId;
        this.areaName = areaName;
        this.usrDistKey = usrDistKey;
    }
}
