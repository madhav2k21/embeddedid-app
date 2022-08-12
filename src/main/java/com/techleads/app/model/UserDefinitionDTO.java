package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDefinitionDTO {

    private String facility;
    private String userId;
    private String area;
    private String title;
    private String firstName;
    private String lastName;
    private String createdUserId;

    private LocalDateTime createdTs;

    private String updatedUserId;

    private LocalDateTime updatedTs;

}
