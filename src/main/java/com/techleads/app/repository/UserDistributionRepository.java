package com.techleads.app.repository;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDistributionRepository extends JpaRepository<UserDistribution, UserDistributionKey> {

//    void deleteByUserDistributionFacilityIdAndUserDefinitionWorkAreaName(String userDefinitionId,String userDefinitionWorkAreaName);

}
