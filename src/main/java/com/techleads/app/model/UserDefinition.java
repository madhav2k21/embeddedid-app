package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
//@Table(name = "usr_dstbtn", schema = "scm_app_epds")
@Table(name = "usr_dfntn")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDefinition implements Serializable {
    @EmbeddedId
    private UserDefinitionKey userDefinitionKey;

    @Column(name = "usr_dfntn_dn_id")
    private String userDefinitionDnId;

    @Column(name = "usr_dfntn_frst_nm")
    private String userDefinitionFirstName;

    @Column(name = "usr_dfntn_lst_nm")
    private String userDefinitionLastName;

    @Column(name = "usr_dfntn_ttl_nm")
    private String userDefinitionTitleName;

    @Column(name = "usr_dfntn_crte_usr_id")
    private String userDefinitionCreatedUserId;

    @Column(name = "usr_dfntn_crte_tmsatmp")
    private LocalDateTime userDefinitionCreatedTs;

    @Column(name = "usr_dfntn_updt_usr_id")
    private String userDefinitionUpdatedUserId;

    @Column(name = "usr_dfntn_updt_ts")
    private LocalDateTime userDefinitionUpdatedTs;
}
