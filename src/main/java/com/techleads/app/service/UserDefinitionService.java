package com.techleads.app.service;

import com.techleads.app.model.UserDefinition;
import com.techleads.app.model.UserDefinitionDTO;
import com.techleads.app.model.UserDistribution;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDefinitionService {

    @Autowired
    private UserDefinitionRepository userDefinitionRepository;

    @Autowired
    private UserDistributionRepository userDistributionRepository;

    public List<UserDefinitionDTO> findAllUserDefinition(){
        List<UserDefinition> userDefinitions = userDefinitionRepository.findAll();
        List<UserDistribution> userDistributions = userDistributionRepository.findAll();

        List<UserDefinitionDTO> userDefinitionDTOS=new ArrayList<>();

        userDefinitions.stream().forEach(user->{
            UserDefinitionDTO dto=new UserDefinitionDTO();
            dto.setUserDefinitionId(user.getUserDefinitionKey().getUserDefinitionId());
            dto.setUserDefinitionTitleName(user.getUserDefinitionTitleName());
            dto.setUserDefinitionFirstName(user.getUserDefinitionFirstName());
            dto.setUserDefinitionLastName(user.getUserDefinitionLastName());
            dto.setUserDefinitionWorkAreaName(user.getUserDefinitionKey().getUserDefinitionWorkAreaName());
            dto.setFacility(facilityId(userDistributions, user.getUserDefinitionKey().getUserDefinitionId() ));
            userDefinitionDTOS.add(dto);
        });

        return userDefinitionDTOS;
    }

    private String facilityId(List<UserDistribution> userDistributions, String userDefinitionId ){
        String facilityId = userDistributions.stream()
                .filter(user -> user.getUserDistributionKey().getUserDefinitionId().equals(userDefinitionId))
                .map(UserDistribution::getUserDistributionFacilityId).findFirst().orElse("N/A");

        return facilityId;

    }
}
