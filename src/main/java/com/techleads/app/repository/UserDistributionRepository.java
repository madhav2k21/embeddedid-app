package com.techleads.app.repository;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDistributionRepository extends JpaRepository<UserDistribution, UserDistributionKey> {

//    Optional<List<UserDistributionKey>> findMaxByUserDistributionKey();
//    Optional<Integer> findByUserDistributionKeyUserDistributionKeyNumOrderByUserDistributionKeyUserDistributionKeyNumDesc();

    Optional<Integer>  findFirstByOrderByUserDistributionKeyUserDistributionKeyNumAsc();
//    void deleteByUserDistributionFacilityIdAndUserDefinitionWorkAreaName(String userDefinitionId,String userDefinitionWorkAreaName);

}
