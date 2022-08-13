package com.techleads.app.service;

import com.techleads.app.model.*;
import com.techleads.app.repository.UserDefinitionRepository;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

@Service
public class UserDefinitionService {

    @Autowired
    private UserDefinitionRepository userDefinitionRepository;

    @Autowired
    private UserDistributionRepository userDistributionRepository;

    @Autowired
    private UserDistRepository userDistRepository;

    private Integer maxUserDistKeyId() {
        Optional<UserDistributionKey> userDistributionKey = userDistributionRepository.findAll()
                .stream().max(Comparator.comparing(userDist -> userDist.getUserDistributionKey().getUserDistributionKeyNum())).map(UserDistribution::getUserDistributionKey);

        if (userDistributionKey.isPresent()) {
            return userDistributionKey.get().getUserDistributionKeyNum();
        }
        return null;
    }

    public UserMaintenanceResponse addUser(UserDefinitionDTO userDTO) {

        UserDefinitionKey key = new UserDefinitionKey(userDTO.getUserId(), userDTO.getArea());
        UserDefinition user = new UserDefinition();
        user.setUserDefinitionKey(key);
        user.setUserDefinitionTitleName(userDTO.getTitle());
        user.setUserDefinitionDnId("TODO");
        user.setUserDefinitionFirstName(userDTO.getFirstName());
        user.setUserDefinitionLastName(userDTO.getLastName());

        String createUserId = userDTO.getCreatedUserId() == null ? "admin" : userDTO.getCreatedUserId();
        user.setUserDefinitionCreatedUserId(createUserId);
        user.setUserDefinitionCreatedTs(LocalDateTime.now());
        String updatedUserId = userDTO.getUpdatedUserId() == null ? "admin" : userDTO.getUpdatedUserId();
        user.setUserDefinitionUpdatedUserId(updatedUserId);
        user.setUserDefinitionUpdatedTs(LocalDateTime.now());

        userDefinitionRepository.save(user);

        UserDistribution userDist = getUserDistribution(userDTO, createUserId, updatedUserId);

        userDistributionRepository.save(userDist);

        if (userDefinitionRepository.findById(key).isPresent()) {
            Optional<UserDefinition> userkey = userDefinitionRepository.findById(key);
            return findUserDefinitionByKey(userkey.get().getUserDefinitionKey().getUserDefinitionId().trim(), userkey.get().getUserDefinitionKey().getUserDefinitionWorkAreaName());
        }
        return null;


    }

    private UserDistribution getUserDistribution(UserDefinitionDTO userDTO, String createUserId, String updatedUserId) {

//        Integer key = maxUserDistKeyId();

        Integer key = userDistRepository.maxUserDistKeyId();
        key = Objects.isNull(key) ? 10 : key + 1;

        UserDistributionKey uDisKey = new UserDistributionKey(userDTO.getUserId(), userDTO.getArea(), key);
        UserDistribution userDist = new UserDistribution();
        userDist.setUserDistributionKey(uDisKey);
        userDist.setUserDistributionFacilityId(userDTO.getFacility());

        userDist.setUserDistributionCreatedUserId(createUserId);
        userDist.setUserDistributionCreatedTs(LocalDateTime.now());
        userDist.setUserDistributionUpdatedUserId(updatedUserId);
        userDist.setUserDistributionUpdatedTs(LocalDateTime.now());
        return userDist;
    }


    public UserMaintenanceResponse findUserDefinitionByKey(String userDefinitionId, String userDefinitionWorkAreaName) {
        UserDefinitionKey key = new UserDefinitionKey(userDefinitionId, userDefinitionWorkAreaName);
        Optional<UserDefinition> user = userDefinitionRepository.findById(key);

        UserMaintenanceResponse response = new UserMaintenanceResponse();
        if (user.isPresent()) {
            response.setUserId(user.get().getUserDefinitionKey().getUserDefinitionId());
            response.setArea(user.get().getUserDefinitionKey().getUserDefinitionWorkAreaName());
            response.setTitle(user.get().getUserDefinitionTitleName());
            response.setFirstName(user.get().getUserDefinitionFirstName());
            response.setLastName(user.get().getUserDefinitionFirstName());
            response.setFacility(facilityId(userDefinitionId, userDefinitionWorkAreaName));
        }

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
            userMaintenanceResponse.setFacility(facilityId(userDefinitionId, userDefinitionWorkArea));
            userMaintenanceResponses.add(userMaintenanceResponse);
        });

        return userMaintenanceResponses;
    }

    private String facilityId(String userDefinitionId, String userDefinitionWorkAreaName) {
//        List<UserDistribution> userDistributions = userDistributionRepository.findAll();
//        String facilityId = userDistributions.stream()
//                .filter(getUserDistributionPredicate(userDefinitionId, userDefinitionWorkAreaName))
//                .map(UserDistribution::getUserDistributionFacilityId).findFirst().orElse("N/A");
        String facilityId = userDistRepository.findFacilityIdByUserIdAndArea(userDefinitionId, userDefinitionWorkAreaName);
        return facilityId;

    }

    public String deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(String userDefinitionId, String userDefinitionWorkAreaName) {
        UserDefinitionKey userDefinitionKey = new UserDefinitionKey(userDefinitionId, userDefinitionWorkAreaName);

        if (userDefinitionRepository.findById(userDefinitionKey).isPresent()) {
//            UserDistributionKey userDistributionKey = findUserDistribution(userDefinitionId, userDefinitionWorkAreaName);
//            if (Objects.nonNull(userDistributionKey)) {
//                userDistributionRepository.deleteById(userDistributionKey);
//            }
            //delete child table reference
            userDistRepository.deleteUserDistributionByUserIdAndArea(userDefinitionId,userDefinitionWorkAreaName);

            userDefinitionRepository.deleteById(userDefinitionKey);
            return "User deleted successfully";
        }
        return "User not found with " + userDefinitionId + " and " + userDefinitionWorkAreaName;


    }

    private UserDistributionKey findUserDistribution(String userDefinitionId, String userDefinitionWorkAreaName) {
        List<UserDistribution> userDistributions = userDistributionRepository.findAll();

        Optional<UserDistribution> userDistribution = userDistributions.stream()
                .filter(getUserDistributionPredicate(userDefinitionId, userDefinitionWorkAreaName))
                .findFirst();

        if (userDistribution.isPresent()) {
            return userDistribution.get().getUserDistributionKey();
        }
        return null;
    }

    private Predicate<UserDistribution> getUserDistributionPredicate(String userDefinitionId, String userDefinitionWorkAreaName) {
        return user -> user.getUserDistributionKey().getUserDefinitionId().trim().equals(userDefinitionId) && user.getUserDistributionKey().getUserDefinitionWorkAreaName().trim().equals(userDefinitionWorkAreaName);
    }
}
