package com.techleads.app.repository;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionKey;
import com.techleads.app.model.UserDistributionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDistributionRepository extends JpaRepository<UserDistribution, UserDistributionKey> {


//    @Query(value = " select distinct cd_nm from scm_app_epds.pds_cd_list where cd_list_ky = (:pdsstage) ", nativeQuery=true)
   @Query(value = "SELECT  USR_DSTBTN_FCLTY_ID  FROM scm_app_epds.USR_DSTBTN  WHERE  USR_DFNTN_ID =:userId AND USR_DFNTN_WRK_ARA_NM =:area",nativeQuery=true)
//   Optional<String> findFacilityIdByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);
   List<String> findFacilityIdByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);

    @Query(value = " SELECT max(USR_DSTBTN_KY) as USR_DSTBTN_KY FROM scm_app_epds.USR_DSTBTN ", nativeQuery=true)
    Optional<Integer>   findMaxUserDistributionKey();


    @Modifying
    @Query(value = "DELETE FROM scm_app_epds.USR_DSTBTN where USR_DFNTN_ID =(:userId) AND USR_DFNTN_WRK_ARA_NM =(:area)", nativeQuery=true)
    Optional<Integer> deleteUserDistributionByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);

    @Query("select new com.techleads.app.model.UserDistributionResponse" +
            "(CONCAT(t1.userDefinitionFirstName,' ',t1.userDefinitionLastName) as packageEngineer," +
            "t2.userDistributionFacilityId as facility," +
            "t2.userDistributionKey.userDefinitionId as userId," +
            "t2.userDistributionKey.userDefinitionWorkAreaName as areaName," +
            "t2.userDistributionKey.userDistributionKey as usrDistKey," +
            "t2.userDistributionPgrmCode as programCode," +
            "t2.userDistributionSupplierNumber as supplierNum," +
            "t2.userDistributionPartFamilyCode as partFamily," +
            "t2.userDistributionShopClassInd as shopClass)" +
            "FROM UserDefinition AS t1  INNER JOIN UserDistribution AS t2  ON t1.userDefinitionKey.userDefinitionId = t2.userDistributionKey.userDefinitionId and t1.userDefinitionKey.userDefinitionWorkAreaName = t2.userDistributionKey.userDefinitionWorkAreaName")
    List<UserDistributionResponse> findAllUserDistributionJoinUserDefId();


//    Optional<Integer> deleteBy(@Param("userId") String userId, @Param("area") String area);



//    Optional<List<UserDistributionKey>> findMaxByUserDistributionKey();
//    Optional<Integer> findByUserDistributionKeyUserDistributionKeyNumOrderByUserDistributionKeyUserDistributionKeyNumDesc();

//    Optional<Integer>  findFirstByOrderByUserDistributionKeyUserDistributionKeyNumAsc();
//    void deleteByUserDistributionFacilityIdAndUserDefinitionWorkAreaName(String userDefinitionId,String userDefinitionWorkAreaName);

}
