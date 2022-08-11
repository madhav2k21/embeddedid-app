package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDefinitionKey implements Serializable {
    private static final long serialVersionUID = 3566080135852841268L;
    @Column(name = "usr_dfntn_id")
    private String userDefinitionId;

    @Column(name = "usr_dfntn_wrk_ara_nm")
    private String userDefinitionWorkAreaName;
}
