package com.techleads.app.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TestSequenceKey {

    private static final long serialVersionUID = 3566080135852841268L;
    @Column(name = "usr_dfntn_id")
    private String userDefinitionId;

    @Column(name = "usr_dfntn_wrk_ara_nm")
    private String userDefinitionWorkAreaName;
}
