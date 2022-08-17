package com.techleads.app.repository;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDistributionRepository extends JpaRepository<UserDistribution, UserDistributionKey> {


//    @Query(value = " select distinct cd_nm from scm_app_epds.pds_cd_list where cd_list_ky = (:pdsstage) ", nativeQuery=true)
   @Query(value = "SELECT  USR_DSTBTN_FCLTY_ID  FROM USR_DSTBTN  WHERE  USR_DFNTN_ID =:userId AND USR_DFNTN_WRK_ARA_NM =:area",nativeQuery=true)
   Optional<String> findFacilityIdByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);

    @Query(value = " SELECT max(USR_DSTBTN_KY) as USR_DSTBTN_KY FROM USR_DSTBTN ", nativeQuery=true)
    Optional<Integer>   findMaxUserDistributionKey();

    @Modifying
    @Query(value = "DELETE FROM USR_DSTBTN where USR_DFNTN_ID =(:userId) AND USR_DFNTN_WRK_ARA_NM =(:area)", nativeQuery=true)
    Optional<Integer> deleteUserDistributionByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);

//    Optional<Integer> deleteBy(@Param("userId") String userId, @Param("area") String area);



//    Optional<List<UserDistributionKey>> findMaxByUserDistributionKey();
//    Optional<Integer> findByUserDistributionKeyUserDistributionKeyNumOrderByUserDistributionKeyUserDistributionKeyNumDesc();

    Optional<Integer>  findFirstByOrderByUserDistributionKeyUserDistributionKeyNumAsc();
//    void deleteByUserDistributionFacilityIdAndUserDefinitionWorkAreaName(String userDefinitionId,String userDefinitionWorkAreaName);

}
