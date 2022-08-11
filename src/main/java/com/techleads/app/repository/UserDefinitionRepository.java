package com.techleads.app.repository;

import com.techleads.app.model.UserDefinition;
import com.techleads.app.model.UserDefinitionKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDefinitionRepository extends JpaRepository<UserDefinition, UserDefinitionKey> {
}
