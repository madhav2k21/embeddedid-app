package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMaintenanceResponse {

    private String facility;
    private String userId;
    private String firstName;
    private String lastName;
    private String title;
    private String area;
}
