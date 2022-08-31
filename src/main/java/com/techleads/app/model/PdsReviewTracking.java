package com.techleads.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pds_rvw_trckng", schema = "scm_app_epds")
@Getter
@Setter
public class PdsReviewTracking implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PdsReviewTrackingKey pdsReviewTrackingKey;

    @Column(name = "pds_rvw_fclty_id")
    private String pdsReviewFacilityId;

    @Column(name = "pds_rvw_itm_nb")
    private String pdsReviewItemNumber;

    @Column(name = "pds_rvw_trckng_nb")
    private String pdsReviewTrackingNumber;

    @Column(name = "pds_rvw_rvsn_nb")
    private String pdsReviewRevisionNumber;


    @Column(name = "pds_rvw_trckng_sts_nm")
    private String pdsReviewTrackingStatusName;

    @Column(name = "pds_rvw_trckng_rspndr_id")
    private String pdsReviewTrackingResponderId;


    @Column(name = "pds_rvw_crte_usr_id")
    private String pdsReviewTrackingUserId;

    @Column(name = "pds_rvw_crte_ts")
    private LocalDateTime pdsReviewCreatedCreatedTs;

    @Column(name = "pds_rvw_updt_usr_id")
    private String pdsReviewUpdateUpdatedUserId;

    @Column(name = "pds_rvw_updt_ts")
    private LocalDateTime pdsReviewUpdateUpdatedTs;
}