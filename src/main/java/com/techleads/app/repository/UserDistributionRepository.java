package com.techleads.app.repository;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDistributionRepository extends JpaRepository<UserDistribution, UserDistributionKey> {

}
