package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pds_prgrm_mntnc1", schema = "scm_app_epds")
public class TestSequence {
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

        @Column(name = "usr_dfntn_crte_ts")
        private LocalDateTime userDefinitionCreatedTs;

        @Column(name = "usr_dfntn_updt_usr_id")
        private String userDefinitionUpdatedUserId;

        @Column(name = "usr_dfntn_updt_ts")
        private LocalDateTime userDefinitionUpdatedTs;

}