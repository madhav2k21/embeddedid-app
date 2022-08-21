package com.techleads.app.repository;

import com.techleads.app.model.PdsUserFacilityRelationship;
import com.techleads.app.model.PdsUserFacilityRelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PdsUserFacilityRelationshipRepository
		extends JpaRepository<PdsUserFacilityRelationship, PdsUserFacilityRelationshipKey> {

	@Query(value ="SELECT PDS_USR_FCLTY_ID FROM PDS_USR_FCLTY_RLNSHP WHERE PDS_USR_FCLTY_USR_DFNTN_ID =:userId AND PDS_USR_FCLTY_WRK_ARA_NM =:area",nativeQuery=true)
	List<String> findFacilityIdByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);

	@Modifying
	@Query(value = "DELETE FROM PDS_USR_FCLTY_RLNSHP WHERE PDS_USR_FCLTY_USR_DFNTN_ID =:userId AND PDS_USR_FCLTY_WRK_ARA_NM =:area", nativeQuery=true)
	Optional<Integer> deletePdsUserFacilityRelationshipByUserIdAndArea(@Param("userId") String userId, @Param("area") String area);

	@Modifying
	@Query(value = "UPDATE PDS_USR_FCLTY_RLNSHP SET PDS_USR_FCLTY_ID =:facilityId, PDS_USR_FCLTY_UPDT_TS = current_timestamp  WHERE PDS_USR_FCLTY_USR_DFNTN_ID =:userId AND PDS_USR_FCLTY_WRK_ARA_NM =:area", nativeQuery=true)
	Optional<Integer> updatePdsUserFacilityRelationshipByUserIdAndArea(
			@Param("facilityId") String facilityId,
			@Param("userId") String userId, @Param("area") String area);

}
