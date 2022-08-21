package com.techleads.app.service;

import com.techleads.app.exception.UserDefinitionNotFoundException;
import com.techleads.app.model.*;
import com.techleads.app.repository.PdsUserFacilityRelationshipRepository;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserDefinitionService {

    final String TEMP_USER_ID = "admin";
    private final UserDefinitionRepository userDefinitionRepository;
    private final UserDistributionRepository userDistributionRepository;
    private final UserDistRepository userDistRepository;
    @Resource
    private final PdsUserFacilityRelationshipRepository pdsUserFacilityRelationshipRepository;

    public UserDefinitionService(UserDefinitionRepository userDefinitionRepository, UserDistributionRepository userDistributionRepository, UserDistRepository userDistRepository, PdsUserFacilityRelationshipRepository pdsUserFacilityRelationshipRepository) {
        this.userDefinitionRepository = userDefinitionRepository;
        this.userDistributionRepository = userDistributionRepository;
        this.userDistRepository = userDistRepository;
        this.pdsUserFacilityRelationshipRepository = pdsUserFacilityRelationshipRepository;
    }


    public UserDefDTO addUser(UserDefDTO userDTO) {
        saveToUserDefinition(userDTO);
        saveToUserFacilityRelationship(userDTO);

        UserDefinitionKey key = new UserDefinitionKey();

        key.setUserDefinitionId(userDTO.getUserId());
        key.setUserDefinitionWorkAreaName(userDTO.getArea());

        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse).orElse(null);

    }


    public List<UserDefDTO> findAllUserDefinition() {

        List<UserDefDTO> userDefDTOsList = new ArrayList<>();

        userDefinitionRepository.findAll().forEach(user -> userDefDTOsList.add(convertEntityToResponse(user)));

        return userDefDTOsList;
    }

    public String deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(String userDefinitionId, String userDefinitionWorkAreaName) {
        UserDefinitionKey userDefinitionKey = new UserDefinitionKey(userDefinitionId, userDefinitionWorkAreaName);

        return userDefinitionRepository.findById(userDefinitionKey).map(user -> {

            pdsUserFacilityRelationshipRepository.deletePdsUserFacilityRelationshipByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);

            userDefinitionRepository.deleteById(userDefinitionKey);
            return "User deleted successfully";
        }).orElseThrow(
                () -> new UserDefinitionNotFoundException("User not found with " + userDefinitionId + " and " + userDefinitionWorkAreaName));

    }


    public UserDefDTO findByUserDefinitionKey1(String userDefId, String userDefArea) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);

        return userDefinitionRepository.findById(key).map(this::convertEntityToResponse)
                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }





    public UserDefDTO updateUserDefinitionKey(String userDefId, String userDefArea, UserDefDTO userDTO) {
        UserDefinitionKey key = new UserDefinitionKey(userDefId, userDefArea);
        return userDefinitionRepository.findById(key)
                .map(user -> {


                    user.setUserDefinitionFirstName(userDTO.getFirstName());
                    user.setUserDefinitionLastName(userDTO.getLastName());
//                    user.setUserDefinitionDnId("TODO");
                    user.setUserDefinitionTitleName(userDTO.getTitle());

                    user.setUserDefinitionUpdatedUserId("admin");
                    user.setUserDefinitionUpdatedTs(LocalDateTime.now());
                    //TODO need to check if the UI gives existing facilityId else use below
                    pdsUserFacilityRelationshipRepository.updatePdsUserFacilityRelationshipByUserIdAndArea(userDTO.getFacility(),userDefId,userDefArea);

                    UserDefinition userDef = userDefinitionRepository.save(user);

                    return convertEntityToResponse(userDef);
                })

                .orElseThrow(() -> new UserDefinitionNotFoundException("User not found with " + userDefId + " and " + userDefArea));
    }

    /* Insert User Data to User Definition Table */
    private void saveToUserDefinition(UserDefDTO userDTO) {

        UserDefinitionKey key = new UserDefinitionKey(userDTO.getUserId(), userDTO.getArea());

        // Check if User is already exists before save
        if (userDefinitionRepository.findById(key).isPresent()) {
            throw new UserDefinitionNotFoundException("User is already exists with " + key.getUserDefinitionId() + " and "
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

    private String facilityId(String userDefinitionId, String userDefinitionWorkAreaName) {
        List<String> facilityIdByUserIdAndArea = pdsUserFacilityRelationshipRepository.findFacilityIdByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);
        return facilityIdByUserIdAndArea
                .stream().findAny()
                .orElse("");

    }


    private UserDefDTO convertEntityToResponse(UserDefinition user) {

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
