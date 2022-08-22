package com.techleads.app.service;

import com.techleads.app.exception.EntityException;
import com.techleads.app.model.*;
import com.techleads.app.repository.PdsUserFacilityRelationshipRepository;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDefinitionServicebkup {

    private final UserDefinitionRepository userDefinitionRepository;

    private final UserDistributionRepository userDistributionRepository;

    private final UserDistRepository userDistRepository;
    final String TEMP_USER_ID = "admin";

    @Resource
    private final PdsUserFacilityRelationshipRepository pdsUserFacilityRelationshipRepository;

    public UserDefinitionServicebkup(UserDefinitionRepository userDefinitionRepository, UserDistributionRepository userDistributionRepository, UserDistRepository userDistRepository, PdsUserFacilityRelationshipRepository pdsUserFacilityRelationshipRepository) {
        this.userDefinitionRepository = userDefinitionRepository;
        this.userDistributionRepository = userDistributionRepository;
        this.userDistRepository = userDistRepository;
        this.pdsUserFacilityRelationshipRepository = pdsUserFacilityRelationshipRepository;
    }


    public UserMaintenanceResponse addUser(UserDefDTO userDTO) {
        saveToUserDefinition(userDTO);
        saveToUserFacilityRelationship(userDTO);

        UserDefinitionKey key=new UserDefinitionKey();

        key.setUserDefinitionId(userDTO.getUserId());
        key.setUserDefinitionId(userDTO.getArea());

        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse).orElse(null);

    }

    public UserDefDTO addUser1(UserDefDTO userDTO) {
        saveToUserDefinition(userDTO);
        saveToUserFacilityRelationship(userDTO);

        UserDefinitionKey key=new UserDefinitionKey();
        key.setUserDefinitionId(userDTO.getUserId());
        key.setUserDefinitionId(userDTO.getArea());

        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse1).orElse(null);

    }

    /* Insert User Data to User Definition Table */
    private void saveToUserDefinition(UserDefDTO userDTO) {

        UserDefinitionKey key = new UserDefinitionKey(userDTO.getUserId(), userDTO.getArea());

        // Check if User is already exists before save
        if (userDefinitionRepository.findById(key).isPresent()) {
            throw new EntityException("User is already exists with " + key.getUserDefinitionId() + " and "
                    + key.getUserDefinitionWorkAreaName());
        }

        UserDefinition user = new UserDefinition();

        user.setUserDefinitionKey(key);
        user.setUserDefinitionTitleName(userDTO.getTitle());
        user.setUserDefinitionDnId("TODO");
        user.setUserDefinitionFirstName(userDTO.getFirstName());
        user.setUserDefinitionLastName(userDTO.getLastName());

        user.setUserDefinitionCreatedUserId(TEMP_USER_ID);
        user.setUserDefinitionCreatedTs(LocalDateTime.now());
        user.setUserDefinitionUpdatedUserId(TEMP_USER_ID);
        user.setUserDefinitionUpdatedTs(LocalDateTime.now());

        userDefinitionRepository.save(user);

    }

    /* Insert User Data to User Facility Relationship Table */
    private void saveToUserFacilityRelationship(UserDefDTO userDTO) {

        PdsUserFacilityRelationshipKey key = new PdsUserFacilityRelationshipKey(userDTO.getFacility(),
                userDTO.getUserId(), userDTO.getArea());

        PdsUserFacilityRelationship facilityRel = new PdsUserFacilityRelationship();
        facilityRel.setPdsUserFacilityRelationshipKey(key);

        facilityRel.setPdsUserFacilityCreatedUserId(TEMP_USER_ID);
        facilityRel.setPdsUserFacilityCreatedTs(LocalDateTime.now());
        facilityRel.setPdsUserFacilityUpdatedUserId(TEMP_USER_ID);
        facilityRel.setPdsUserFacilityUpdatedTs(LocalDateTime.now());

        pdsUserFacilityRelationshipRepository.save(facilityRel);

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
                () -> new EntityException("User not found with " + userDefinitionId + " and " + userDefinitionWorkAreaName));

    }

    public UserDefinition findByUserDefinitionKey(String userDefId, String userDefArea) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .orElseThrow(() -> new EntityException("User not found with " + userDefId + " and " + userDefArea));
    }


    public UserMaintenanceResponse findByUserDefinitionKey1(String userDefId, String userDefArea) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);

//        return userDefinitionRepository.findById(key).map(user-> convertEntityToResponse(user))
        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse)
                .orElseThrow(() -> new EntityException("User not found with " + userDefId + " and " + userDefArea));
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

                .orElseThrow(() -> new EntityException("User not found with " + userDefId + " and " + userDefArea));
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

                .orElseThrow(() -> new EntityException("User not found with " + userDefId + " and " + userDefArea));
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

                .orElseThrow(() -> new EntityException("User not found with " + userDefId + " and " + userDefArea));
    }


    private String facilityId(String userDefinitionId, String userDefinitionWorkAreaName) {
        List<String> facilityIdByUserIdAndArea = userDistributionRepository.findFacilityIdByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);
        return facilityIdByUserIdAndArea
                .stream().findAny()
                .orElseGet(()-> "");
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

    private UserDefDTO convertEntityToResponse1(UserDefinition user) {

        UserDefDTO response = new UserDefDTO();
        response.setUserId(user.getUserDefinitionKey().getUserDefinitionId());
        response.setArea(user.getUserDefinitionKey().getUserDefinitionWorkAreaName());
        response.setTitle(user.getUserDefinitionTitleName());
        response.setFirstName(user.getUserDefinitionFirstName());
        response.setLastName(user.getUserDefinitionLastName());
        response.setFacility(facilityId(user.getUserDefinitionKey().getUserDefinitionId(), user.getUserDefinitionKey().getUserDefinitionWorkAreaName()));

        return response;
    }


}
