package com.techleads.app.repository;

import com.techleads.app.model.PdsPrgrmMntnc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdsPrgrmMntncRepository extends JpaRepository<PdsPrgrmMntnc, Integer> {
}
