package com.techleads.app.service;

import com.techleads.app.model.*;
import com.techleads.app.repository.PdsReviewTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PdsReviewTrackingService {
    private final String TEMP_USER_ID = "admin";

    private final String APPROVED="Approved";

    @Autowired
    private PdsReviewTrackingRepository pdsReviewTrackingRepository;

    public PdsReviewTrackingDTO savePdsReviewTracking(PdsReviewTrackingDTO dto) {


        PdsReviewTrackingKey key = getPdsReviewTrackingKey(dto);

        PdsReviewTracking entity = convertDtoTOEntity(dto, key);


        PdsReviewTracking savedEntity = pdsReviewTrackingRepository.save(entity);

        return convertEntityToDTO(savedEntity);

    }

    private Integer maxRvwTrckngRspnsNum(PdsReviewTrackingDTO dto) {
        Optional<Integer> maxRvwTrckngRspnsNum = pdsReviewTrackingRepository.findMaxRvwTrckngRspnsNum(
                dto.getPdsTrackingKey(),
                dto.getPdsVersionNumber(),
                dto.getPdsReviewTrackingTypeName(),
                dto.getPdsReviewTrackingReviewerId()
        );
        return maxRvwTrckngRspnsNum.isPresent() ? (maxRvwTrckngRspnsNum.get() + 1) : 1;

    }


    private PdsReviewTrackingDTO convertEntityToDTO(PdsReviewTracking entity) {

        PdsReviewTrackingDTO dto = new PdsReviewTrackingDTO();

        dto.setPdsReviewTrackingReviewerId(entity.getPdsReviewTrackingKey().getPdsReviewTrackingReviewerId());
        dto.setPdsReviewTrackingResponseNumber(entity.getPdsReviewTrackingKey().getPdsReviewTrackingResponseNumber());
        dto.setPdsVersionNumber(entity.getPdsReviewTrackingKey().getPdsVersionNumber());
        dto.setPdsReviewTrackingTypeName(entity.getPdsReviewTrackingKey().getPdsReviewTrackingTypeName());
        dto.setPdsTrackingKey(entity.getPdsReviewTrackingKey().getPdsTrackingKey());


        dto.setPdsReviewFacilityId(entity.getPdsReviewFacilityId());
        dto.setPdsReviewItemNumber(entity.getPdsReviewItemNumber());
        dto.setPdsReviewTrackingNumber(entity.getPdsReviewTrackingNumber());
        dto.setPdsReviewRevisionNumber(entity.getPdsReviewRevisionNumber());

        dto.setPdsReviewTrackingStatusName(entity.getPdsReviewTrackingStatusName());
        dto.setPdsReviewTrackingResponderId(entity.getPdsReviewTrackingResponderId());

        return dto;

    }

    private PdsReviewTracking convertDtoTOEntity(PdsReviewTrackingDTO dto, PdsReviewTrackingKey key) {


        PdsReviewTracking entity = new PdsReviewTracking();

        entity.setPdsReviewTrackingKey(key);

        entity.setPdsReviewFacilityId(dto.getPdsReviewFacilityId());
        entity.setPdsReviewItemNumber(dto.getPdsReviewItemNumber());
        entity.setPdsReviewTrackingNumber(dto.getPdsReviewTrackingNumber());
        entity.setPdsReviewRevisionNumber(dto.getPdsReviewRevisionNumber());


        entity.setPdsReviewTrackingStatusName(dto.getPdsReviewTrackingStatusName());
        entity.setPdsReviewTrackingResponderId(dto.getPdsReviewTrackingResponderId());


        entity.setPdsReviewTrackingUserId(TEMP_USER_ID);
        entity.setPdsReviewCreatedCreatedTs(LocalDateTime.now());
        entity.setPdsReviewUpdateUpdatedUserId(TEMP_USER_ID);
        entity.setPdsReviewUpdateUpdatedTs(LocalDateTime.now());

        return entity;

    }

    private PdsReviewTrackingKey getPdsReviewTrackingKey(PdsReviewTrackingDTO dto) {
        PdsReviewTrackingKey key = new PdsReviewTrackingKey();

        key.setPdsTrackingKey(dto.getPdsTrackingKey());
        key.setPdsVersionNumber(dto.getPdsVersionNumber());
        key.setPdsReviewTrackingTypeName(dto.getPdsReviewTrackingTypeName());

        key.setPdsReviewTrackingReviewerId(dto.getPdsReviewTrackingReviewerId());
        key.setPdsReviewTrackingResponseNumber(maxRvwTrckngRspnsNum(dto));


        return key;
    }

//    public List<ApproverNames> findAllApproverNames(String areaName, String facilityId){
//        List<ApproverNames> allApproverNames = pdsReviewTrackingRepository.findAllApproverNames(areaName, facilityId);
//        return allApproverNames;
//    }

    public AllApproverNames findAllApproverNames(String areaName, String facilityId) {
        List<ApproverNames> allApproverNames = pdsReviewTrackingRepository.findAllApproverNames(areaName, facilityId);

        capitalizeFullName(allApproverNames);


        AllApproverNames approverNames = new AllApproverNames();

        //recent starts
        List<Recent> recentList = getRecentList(allApproverNames);
        approverNames.setRecent(recentList);
        //recent ends

        //All starts
        List<AllUsers> all = getAllUsersList(allApproverNames);
        approverNames.setAll(all);
        //All ends

        //ApprovedUsers starts
        List<ApprovedUsers> approvedUsers = getApprovedUsersList(allApproverNames);
        approverNames.setApprovedUsers(approvedUsers);
        //ApprovedUsers starts

        return approverNames;
    }


    public  List<DelinkingReqDTO> findAllDelinkingRequest(){
        return pdsReviewTrackingRepository.findAllDelinkingRequest();
    }

    private void capitalizeFullName(List<ApproverNames> allApproverNames) {
        allApproverNames.forEach(names->{
            if (Objects.nonNull(names.getFullName()) && names.getFullName().length() > 0) {
                String[] name = names.getFullName().split("\\s+");
                if (name.length == 2) {
                    String firstName = StringUtils.capitalize(name[0]);
                    String lastName = StringUtils.capitalize(name[1]);
                    names.setFullName(firstName + " " + lastName);
                } else if (name.length == 1) {
                    String firstName = StringUtils.capitalize(name[0]);
                    names.setFullName(firstName);
                }
            }
        });
    }

    private List<ApprovedUsers> getApprovedUsersList(List<ApproverNames> allApproverNames) {
        return allApproverNames.stream().skip(4)
                .filter(names -> APPROVED.equals(names.getStatusName()))
                .map(names -> {
                    ApprovedUsers apprUsers = new ApprovedUsers();

                    apprUsers.setAreaName(names.getAreaName());
                    apprUsers.setFullName(names.getFullName());
                    apprUsers.setUserId(names.getUserId());
                    return apprUsers;
                })

                .collect(Collectors.toList());
    }

    private List<AllUsers> getAllUsersList(List<ApproverNames> allApproverNames) {
        return allApproverNames.stream().skip(4)
                .filter(names -> !"Approved".equals(names.getStatusName()))
                .map(names -> {
                    AllUsers allUsers = new AllUsers();

                    allUsers.setAreaName(names.getAreaName());
                    allUsers.setFullName(names.getFullName());
                    allUsers.setUserId(names.getUserId());
                    return allUsers;
                })

                .collect(Collectors.toList());
    }

    private List<Recent> getRecentList(List<ApproverNames> allApproverNames) {
        return allApproverNames.stream().limit(4).map(names -> {
            Recent recent = new Recent();
            recent.setAreaName(names.getAreaName());
            recent.setFullName(names.getFullName());
            recent.setUserId(names.getUserId());
            return recent;
        }).collect(Collectors.toList());
    }


}
