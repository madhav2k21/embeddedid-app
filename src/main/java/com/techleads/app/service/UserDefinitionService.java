package com.techleads.app.service;

import com.techleads.app.exception.UserDefinitionNotFoundException;
import com.techleads.app.model.*;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDefinitionService {

    private final UserDefinitionRepository userDefinitionRepository;

    private final UserDistributionRepository userDistributionRepository;

    private final UserDistRepository userDistRepository;

    public UserDefinitionService(UserDefinitionRepository userDefinitionRepository, UserDistributionRepository userDistributionRepository, UserDistRepository userDistRepository) {
        this.userDefinitionRepository = userDefinitionRepository;
        this.userDistributionRepository = userDistributionRepository;
        this.userDistRepository = userDistRepository;
    }


    public UserMaintenanceResponse addUser(UserDefDTO userDTO) {
        UserDefinitionKey key = new UserDefinitionKey(userDTO.getUserId(), userDTO.getArea());

        if (userDefinitionRepository.findById(key).isPresent()) {
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

        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse).orElse(null);

    }

    public List<UserMaintenanceResponse> findAllUserDefinition() {

        List<UserMaintenanceResponse> userMaintenanceResponses = new ArrayList<>();

        userDefinitionRepository.findAll().forEach(user -> userMaintenanceResponses.add(convertEntityToResponse(user)));

        return userMaintenanceResponses;
    }

    public String deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(String userDefinitionId, String userDefinitionWorkAreaName) {
        UserDefinitionKey userDefinitionKey = new UserDefinitionKey(userDefinitionId, userDefinitionWorkAreaName);

        return userDefinitionRepository.findById(userDefinitionKey).map(user -> {

            Optional<Integer> count = userDistributionRepository.deleteUserDistributionByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);

            userDefinitionRepository.deleteById(userDefinitionKey);
            return "User deleted successfully";
        }).orElseThrow(
                () -> new UserDefinitionNotFoundException("User not found with " + userDefinitionId + " and " + userDefinitionWorkAreaName));

    }

    public UserDefinition findByUserDefinitionKey(String userDefId, String userDefArea) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }


    public UserMaintenanceResponse findByUserDefinitionKey1(String userDefId, String userDefArea) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);

//        return userDefinitionRepository.findById(key).map(user-> convertEntityToResponse(user))
        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse)
                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }


    public UserDefinition updateUserDefinitionKey(String userDefId, String userDefArea, UserDefinition userdef) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .map(user -> {
                    user.setUserDefinitionUpdatedUserId("admin");
                    user.setUserDefinitionUpdatedTs(LocalDateTime.now());
                    user.setUserDefinitionFirstName(userdef.getUserDefinitionFirstName());
                    user.setUserDefinitionLastName(userdef.getUserDefinitionLastName());
                    user.setUserDefinitionDnId(userdef.getUserDefinitionDnId());
                    user.setUserDefinitionTitleName(userdef.getUserDefinitionTitleName());
                    return userDefinitionRepository.save(user);

                })

                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }

    public UserMaintenanceResponse updateUserDefinitionKey1(String userDefId, String userDefArea, UserDefinition userdef) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .map(user -> {
                    user.setUserDefinitionUpdatedUserId("admin");
                    user.setUserDefinitionUpdatedTs(LocalDateTime.now());

                    user.setUserDefinitionFirstName(userdef.getUserDefinitionFirstName());
                    user.setUserDefinitionLastName(userdef.getUserDefinitionLastName());
                    user.setUserDefinitionDnId(userdef.getUserDefinitionDnId());
                    user.setUserDefinitionTitleName(userdef.getUserDefinitionTitleName());
                    UserDefinition userDef = userDefinitionRepository.save(user);

                    return convertEntityToResponse(userDef);
                })

                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }


    public UserMaintenanceResponse updateUserDefinitionKey2(String userDefId, String userDefArea, UserDefDTO userDTO) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .map(user -> {


                    user.setUserDefinitionFirstName(userDTO.getFirstName());
                    user.setUserDefinitionLastName(userDTO.getLastName());
//                    user.setUserDefinitionDnId("TODO");
                    user.setUserDefinitionTitleName(userDTO.getTitle());

                    user.setUserDefinitionUpdatedUserId("admin");
                    user.setUserDefinitionUpdatedTs(LocalDateTime.now());

                    UserDefinition userDef = userDefinitionRepository.save(user);

                    return convertEntityToResponse(userDef);
                })

                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }

    private UserDistribution prepareUserDistribution(UserDefDTO userDTO, String userId) {


//        Integer key = userDistRepository.maxUserDistKeyId();
        Optional<Integer> key = userDistributionRepository.findMaxUserDistributionKey();
        Integer maxKey = key.isPresent() ? (key.get()+1) : 10;


//        key = Objects.isNull(key) ? 10 : key.get() + 1;

        UserDistributionKey uDisKey = new UserDistributionKey(userDTO.getUserId(), userDTO.getArea(), maxKey);
        UserDistribution userDist = new UserDistribution();
        userDist.setUserDistributionKey(uDisKey);
        userDist.setUserDistributionFacilityId(userDTO.getFacility());

        userDist.setUserDistributionCreatedUserId(userId);
        userDist.setUserDistributionCreatedTs(LocalDateTime.now());
        userDist.setUserDistributionUpdatedUserId(userId);
        userDist.setUserDistributionUpdatedTs(LocalDateTime.now());
        return userDist;
    }

    private String facilityId(String userDefinitionId, String userDefinitionWorkAreaName) {
        Optional<String> facilityIdByUserIdAndArea = userDistributionRepository.findFacilityIdByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);
        return facilityIdByUserIdAndArea.orElseGet(()-> "");
//        return userDistRepository.findFacilityIdByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);

    }

    private UserMaintenanceResponse convertEntityToResponse(UserDefinition user) {

        UserMaintenanceResponse response = new UserMaintenanceResponse();
        response.setUserId(user.getUserDefinitionKey().getUserDefinitionId());
        response.setArea(user.getUserDefinitionKey().getUserDefinitionWorkAreaName());
        response.setTitle(user.getUserDefinitionTitleName());
        response.setFirstName(user.getUserDefinitionFirstName());
        response.setLastName(user.getUserDefinitionLastName());
        response.setFacility(facilityId(user.getUserDefinitionKey().getUserDefinitionId(), user.getUserDefinitionKey().getUserDefinitionWorkAreaName()));

        return response;
    }


}
