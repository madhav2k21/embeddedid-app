package com.techleads.app.repository;

import com.techleads.app.model.PdsReviewTracking;
import com.techleads.app.model.PdsReviewTrackingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PdsReviewTrackingRepository extends JpaRepository<PdsReviewTracking, PdsReviewTrackingKey> {



       /*@Query(value = " select CONCAT(usr_dfntn_frst_nm,' ',usr_dfntn_lst_nm) from scm_app_epds.usr_dfntn join scm_app_epds.pds_rvw_trckng on pds_rvw_trckng_rvwr_id = usr_dfntn_id and pds_trckng_ky = (:trackingKey) and pds_rvw_trckng_sts_nm = 'Approved' ", nativeQuery = true)

       List<String> getApprovedUsers(@Param("trackingKey") Long trackingKey);



       @Query(value = " select CONCAT(usr_dfntn_frst_nm,' ',usr_dfntn_lst_nm) from scm_app_epds.usr_dfntn join scm_app_epds.pds_rvw_trckng on pds_rvw_trckng_rvwr_id = usr_dfntn_id and pds_trckng_ky = (:trackingKey) and pds_rvw_trckng_sts_nm = 'Waiting' ", nativeQuery = true)

       List<String> getWaitingUsers(@Param("trackingKey") Long trackingKey);



       @Query(value = " select CONCAT(usr_dfntn_frst_nm,' ',usr_dfntn_lst_nm) from scm_app_epds.usr_dfntn join scm_app_epds.pds_rvw_trckng on pds_rvw_trckng_rvwr_id = usr_dfntn_id and pds_trckng_ky = (:trackingKey) and pds_rvw_trckng_sts_nm = 'Rejected' ", nativeQuery = true)

       List<String> getRejectedUsers(@Param("trackingKey") Long trackingKey);*/




//    @Query(" select distinct new com.nna.scmpops.epds.dto.Approvals ( CONCAT(ud.userDefinitionFirstName,' ',ud.userDefinitionLastName), ud.userDefinitionTitleName ) from UserDefinition ud join PdsReviewTracking pr on pr.pdsReviewTrackingKey.pdsReviewTrackingReviewerId = ud.userDefinitionKey.userDefinitionId and pr.pdsReviewTrackingKey.pdsTrackingKey = (:trackingKey) and pr.pdsReviewTrackingStatusName = 'Approved' ")

//    List<Approvals> getApprovedUsers(@Param("trackingKey") Long trackingKey);
//
//
//
//    @Query(" select distinct new com.nna.scmpops.epds.dto.Approvals ( CONCAT(ud.userDefinitionFirstName,' ',ud.userDefinitionLastName), ud.userDefinitionTitleName ) from UserDefinition ud join PdsReviewTracking pr on pr.pdsReviewTrackingKey.pdsReviewTrackingReviewerId = ud.userDefinitionKey.userDefinitionId and pr.pdsReviewTrackingKey.pdsTrackingKey = (:trackingKey) and pr.pdsReviewTrackingStatusName = 'Waiting' ")
//
//    List<Approvals> getWaitingUsers(@Param("trackingKey") Long trackingKey);
//
//
//
//    @Query(" select distinct new com.nna.scmpops.epds.dto.Approvals ( CONCAT(ud.userDefinitionFirstName,' ',ud.userDefinitionLastName), ud.userDefinitionTitleName ) from UserDefinition ud join PdsReviewTracking pr on pr.pdsReviewTrackingKey.pdsReviewTrackingReviewerId = ud.userDefinitionKey.userDefinitionId and pr.pdsReviewTrackingKey.pdsTrackingKey = (:trackingKey) and pr.pdsReviewTrackingStatusName = 'Rejected' ")
//
//    List<Approvals> getRejectedUsers(@Param("trackingKey") Long trackingKey);

    @Query(value = "SELECT MAX(PDS_RVW_TRCKNG_RSPNS_NB) AS PDS_RVW_TRCKNG_RSPNS_NB FROM SCM_APP_EPDS.PDS_RVW_TRCKNG WHERE PDS_TRCKNG_KY=:trakngKey AND PDS_VRSN_NB=:vrsnNb AND PDS_RVW_TRCKNG_TYP_NM=:typNm AND PDS_RVW_TRCKNG_RVWR_ID=:rvwrId",nativeQuery=true)
    Optional<Integer>  findMaxRvwTrckngRspnsNum(
            @Param("trakngKey") Long trakngKey,
            @Param("vrsnNb") Short vrsnNb,
            @Param("typNm") String typNm,
            @Param("rvwrId") String rvwrId
    );
}
