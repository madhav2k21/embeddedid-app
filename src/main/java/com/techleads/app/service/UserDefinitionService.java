package com.techleads.app.service;

import com.techleads.app.exception.UserDefinitionNotFoundException;
import com.techleads.app.model.*;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class UserDefinitionService {

    @Autowired
    private UserDefinitionRepository userDefinitionRepository;

    @Autowired
    private UserDistributionRepository userDistributionRepository;

    @Autowired
    private UserDistRepository userDistRepository;


    public UserMaintenanceResponse addUser(UserDefinitionDTO userDTO) {
        UserDefinitionKey key = new UserDefinitionKey(userDTO.getUserId(), userDTO.getArea());


        if(userDefinitionRepository.findById(key).isPresent()){
            throw new UserDefinitionNotFoundException("User already exists " + key.getUserDefinitionId() + " and " + key.getUserDefinitionWorkAreaName());
        }
        final String TEMP_USER_ID = "admin";
        userDTO.setCreatedUserId(TEMP_USER_ID);
        userDTO.setUpdatedUserId(TEMP_USER_ID);

        UserDefinition user = new UserDefinition();
        user.setUserDefinitionKey(key);
        user.setUserDefinitionTitleName(userDTO.getTitle());
        user.setUserDefinitionDnId("TODO");
        user.setUserDefinitionFirstName(userDTO.getFirstName());
        user.setUserDefinitionLastName(userDTO.getLastName());

        user.setUserDefinitionCreatedUserId(userDTO.getCreatedUserId());
        user.setUserDefinitionCreatedTs(LocalDateTime.now());
        user.setUserDefinitionUpdatedUserId(userDTO.getUpdatedUserId());
        user.setUserDefinitionUpdatedTs(LocalDateTime.now());

        userDefinitionRepository.save(user);

        UserDistribution userDist = prepareUserDistribution(userDTO, userDTO.getCreatedUserId());

        userDistributionRepository.save(userDist);


      return  userDefinitionRepository.findById(key).map(this::convertEntityToResponse).orElse(null);

    }

    private UserDistribution prepareUserDistribution(UserDefinitionDTO userDTO, String userId) {


        Integer key = userDistRepository.maxUserDistKeyId();
        key = Objects.isNull(key) ? 10 : key + 1;

        UserDistributionKey uDisKey = new UserDistributionKey(userDTO.getUserId(), userDTO.getArea(), key);
        UserDistribution userDist = new UserDistribution();
        userDist.setUserDistributionKey(uDisKey);
        userDist.setUserDistributionFacilityId(userDTO.getFacility());

        userDist.setUserDistributionCreatedUserId(userId);
        userDist.setUserDistributionCreatedTs(LocalDateTime.now());
        userDist.setUserDistributionUpdatedUserId(userId);
        userDist.setUserDistributionUpdatedTs(LocalDateTime.now());
        return userDist;
    }


    public UserMaintenanceResponse convertEntityToResponse(UserDefinition user) {

        UserMaintenanceResponse response = new UserMaintenanceResponse();
            response.setUserId(user.getUserDefinitionKey().getUserDefinitionId());
            response.setArea(user.getUserDefinitionKey().getUserDefinitionWorkAreaName());
            response.setTitle(user.getUserDefinitionTitleName());
            response.setFirstName(user.getUserDefinitionFirstName());
            response.setLastName(user.getUserDefinitionFirstName());
            response.setFacility(facilityId(user.getUserDefinitionKey().getUserDefinitionId(), user.getUserDefinitionKey().getUserDefinitionWorkAreaName()));

        return response;
    }


    public List<UserMaintenanceResponse> findAllUserDefinition() {
        List<UserDefinition> userDefinitions = userDefinitionRepository.findAll();


        List<UserMaintenanceResponse> userMaintenanceResponses = new ArrayList<>();

        userDefinitions.forEach(user -> {
            UserMaintenanceResponse userMaintenanceResponse = new UserMaintenanceResponse();
            String userDefinitionId = user.getUserDefinitionKey().getUserDefinitionId().trim();
            String userDefinitionWorkArea = user.getUserDefinitionKey().getUserDefinitionWorkAreaName().trim();

            userMaintenanceResponse.setUserId(userDefinitionId);
            userMaintenanceResponse.setTitle(user.getUserDefinitionTitleName());
            userMaintenanceResponse.setFirstName(user.getUserDefinitionFirstName());
            userMaintenanceResponse.setLastName(user.getUserDefinitionLastName());
            userMaintenanceResponse.setArea(userDefinitionWorkArea);
//            user.getUserDistributions().stream().map(dis-> userMaintenanceResponse.setFacility(dis.getUserDistributionFacilityId()));
            userMaintenanceResponse.setFacility(facilityId(userDefinitionId, userDefinitionWorkArea));

            userMaintenanceResponses.add(userMaintenanceResponse);
        });

        Stream<Stream<String>> streamStream = userDefinitions.stream()
                .map(user -> user.getUserDistributions().stream().map(UserDistribution::getUserDistributionFacilityId));

        return userMaintenanceResponses;
    }

    private String facilityId(String userDefinitionId, String userDefinitionWorkAreaName) {
        return userDistRepository.findFacilityIdByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);

    }

    public String deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(String userDefinitionId, String userDefinitionWorkAreaName) {
        UserDefinitionKey userDefinitionKey = new UserDefinitionKey(userDefinitionId, userDefinitionWorkAreaName);

        return  userDefinitionRepository.findById(userDefinitionKey).map(user -> {
            userDefinitionRepository.deleteById(userDefinitionKey);
            return "User deleted successfully";
        }).orElseThrow(
                ()-> new UserDefinitionNotFoundException("User not found with " + userDefinitionId + " and " + userDefinitionWorkAreaName));

    }

    public UserDefinition findByUserDefinitionKey(String userDefId, String userDefArea){
        UserDefinitionKey key=new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)

                .orElseThrow(()-> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }


    public UserMaintenanceResponse findByUserDefinitionKey1(String userDefId, String userDefArea){
        UserDefinitionKey key=new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key).map(user->{

                    UserMaintenanceResponse resp=new UserMaintenanceResponse();
                    String userId=user.getUserDefinitionKey().getUserDefinitionId();
                    String area=user.getUserDefinitionKey().getUserDefinitionWorkAreaName();
                    resp.setUserId(userId);
                    resp.setFirstName(user.getUserDefinitionFirstName());
                    resp.setLastName(user.getUserDefinitionLastName());
                    resp.setTitle(user.getUserDefinitionTitleName());
                    resp.setArea(area);
                    resp.setFacility(facilityId(userId,area));
                    return resp;
                })

                .orElseThrow(()-> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }


    public UserDefinition updateUserDefinitionKey(String userDefId, String userDefArea, UserDefinition userdef){
        UserDefinitionKey key=new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .map(user->{
                  user.setUserDefinitionUpdatedUserId("admin");
                  user.setUserDefinitionUpdatedTs(LocalDateTime.now());
                  user.setUserDefinitionFirstName(userdef.getUserDefinitionFirstName());
                  user.setUserDefinitionLastName(userdef.getUserDefinitionLastName());
                  user.setUserDefinitionDnId(userdef.getUserDefinitionDnId());
                  user.setUserDefinitionTitleName(userdef.getUserDefinitionTitleName());
                  return userDefinitionRepository.save(user);

                })

                .orElseThrow(()-> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }

    public UserMaintenanceResponse updateUserDefinitionKey1(String userDefId, String userDefArea, UserDefinition userdef){
        UserDefinitionKey key=new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .map(user->{
                    user.setUserDefinitionUpdatedUserId("admin");
                    user.setUserDefinitionUpdatedTs(LocalDateTime.now());
                    user.setUserDefinitionFirstName(userdef.getUserDefinitionFirstName());
                    user.setUserDefinitionLastName(userdef.getUserDefinitionLastName());
                    user.setUserDefinitionDnId(userdef.getUserDefinitionDnId());
                    user.setUserDefinitionTitleName(userdef.getUserDefinitionTitleName());
                    UserDefinition userDef = userDefinitionRepository.save(user);

                    UserMaintenanceResponse resp=new UserMaintenanceResponse();
                    String userId=userDef.getUserDefinitionKey().getUserDefinitionId();
                    String area=userDef.getUserDefinitionKey().getUserDefinitionWorkAreaName();
                    resp.setUserId(userId);
                    resp.setFirstName(userDef.getUserDefinitionFirstName());
                    resp.setLastName(userDef.getUserDefinitionLastName());
                    resp.setTitle(userDef.getUserDefinitionTitleName());
                    resp.setArea(area);
                    resp.setFacility(facilityId(userId,area));
                    return resp;

                })

                .orElseThrow(()-> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }



}
