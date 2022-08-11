package com.techleads.app.service;

import com.techleads.app.model.*;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserDefinitionService {

    @Autowired
    private UserDefinitionRepository userDefinitionRepository;

    @Autowired
    private UserDistributionRepository userDistributionRepository;

    public List<UserMaintenanceResponse> findAllUserDefinition(){
        List<UserDefinition> userDefinitions = userDefinitionRepository.findAll();
        List<UserDistribution> userDistributions = userDistributionRepository.findAll();

        List<UserMaintenanceResponse> userMaintenanceResponses=new ArrayList<>();

        userDefinitions.stream().forEach(user->{
            UserMaintenanceResponse userMaintenanceResponse=new UserMaintenanceResponse();
            String userDefinitionId = user.getUserDefinitionKey().getUserDefinitionId().trim();
            String userDefinitionWorkArea = user.getUserDefinitionKey().getUserDefinitionWorkAreaName().trim();

            userMaintenanceResponse.setUserId(userDefinitionId);
            userMaintenanceResponse.setTitle(user.getUserDefinitionTitleName());
            userMaintenanceResponse.setFirstName(user.getUserDefinitionFirstName());
            userMaintenanceResponse.setLastName(user.getUserDefinitionLastName());
            userMaintenanceResponse.setArea(userDefinitionWorkArea);
            userMaintenanceResponse.setFacility(facilityId(userDistributions, userDefinitionId,userDefinitionWorkArea ));
            userMaintenanceResponses.add(userMaintenanceResponse);
        });

        return userMaintenanceResponses;
    }

    private String facilityId(List<UserDistribution> userDistributions, String userDefinitionId,String userDefinitionWorkAreaName ){
        String facilityId = userDistributions.stream()
                .filter(getUserDistributionPredicate(userDefinitionId, userDefinitionWorkAreaName))
                .map(UserDistribution::getUserDistributionFacilityId).findFirst().orElse("N/A");

        return facilityId;

    }

    public String deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(String userDefinitionId,String userDefinitionWorkAreaName){
        UserDefinitionKey userDefinitionKey=new UserDefinitionKey(userDefinitionId,userDefinitionWorkAreaName);

        if(userDefinitionRepository.findById(userDefinitionKey).isPresent()){
            UserDistributionKey userDistributionKey = findUserDistribution(userDefinitionId, userDefinitionWorkAreaName);
            //delete child table reference
            if(Objects.nonNull(userDistributionKey)){
                userDistributionRepository.deleteById(userDistributionKey);
            }

            userDefinitionRepository.deleteById(userDefinitionKey);
            return "User deleted successfully";
        }
        return "User not found with "+ userDefinitionId+" and "+userDefinitionWorkAreaName;


    }

    private UserDistributionKey findUserDistribution(String userDefinitionId,String userDefinitionWorkAreaName){
        List<UserDistribution> userDistributions = userDistributionRepository.findAll();

        Optional<UserDistribution> userDistribution = userDistributions.stream()
                .filter(getUserDistributionPredicate(userDefinitionId, userDefinitionWorkAreaName))
                .findFirst();

       if(userDistribution.isPresent()){
           return userDistribution.get().getUserDistributionKey();
       }
       return null;
    }

    private Predicate<UserDistribution> getUserDistributionPredicate(String userDefinitionId, String userDefinitionWorkAreaName) {
        return user -> user.getUserDistributionKey().getUserDefinitionId().trim().equals(userDefinitionId) && user.getUserDistributionKey().getUserDefinitionWorkAreaName().trim().equals(userDefinitionWorkAreaName);
    }
}
