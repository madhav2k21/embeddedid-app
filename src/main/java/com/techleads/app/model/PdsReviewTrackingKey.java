package com.techleads.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class PdsReviewTrackingKey implements Serializable {

//    pds_trckng_ky,
//    pds_vrsn_nb,
//    pds_rvw_trckng_typ_nm,
//    pds_rvw_trckng_rvwr_id,
//    pds_rvw_trckng_rspns_nb

    private static final long serialVersionUID = 1L;

    @Column(name = "pds_rvw_trckng_typ_nm")
    private String pdsReviewTrackingTypeName;

    @Column(name = "pds_rvw_trckng_rvwr_id")
    private String pdsReviewTrackingReviewerId;

    @Column(name = "pds_rvw_trckng_rspns_nb")
    private double pdsReviewTrackingResponseNumber;

    @Column(name = "pds_vrsn_nb")
    private Short pdsVersionNumber;

    @Column(name = "pds_trckng_ky")
    private Long pdsTrackingKey;
}