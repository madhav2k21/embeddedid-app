package com.techleads.app.service;

import com.techleads.app.model.PdsReviewTracking;
import com.techleads.app.model.PdsReviewTrackingDTO;
import com.techleads.app.model.PdsReviewTrackingKey;
import com.techleads.app.repository.PdsReviewTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PdsReviewTrackingService {
    private final String TEMP_USER_ID = "admin";

    @Autowired
    private PdsReviewTrackingRepository  pdsReviewTrackingRepository;

    public PdsReviewTrackingDTO savePdsReviewTracking(PdsReviewTrackingDTO dto){


        PdsReviewTrackingKey key = getPdsReviewTrackingKey(dto);

        PdsReviewTracking entity = convertDtoTOEntity(dto, key);


        PdsReviewTracking savedEntity = pdsReviewTrackingRepository.save(entity);

        PdsReviewTrackingDTO reponseDTO = convertEntityToDTO(savedEntity);
        return reponseDTO;

    }

    private Integer maxRvwTrckngRspnsNum(PdsReviewTrackingDTO dto){
        Optional<Integer> maxRvwTrckngRspnsNum = pdsReviewTrackingRepository.findMaxRvwTrckngRspnsNum(
                dto.getPdsTrackingKey(),
                dto.getPdsVersionNumber(),
                dto.getPdsReviewTrackingTypeName(),
                dto.getPdsReviewTrackingReviewerId()
        );
        return maxRvwTrckngRspnsNum.isPresent() ? (maxRvwTrckngRspnsNum.get()+1) : 1;

    }


    private PdsReviewTrackingDTO convertEntityToDTO(PdsReviewTracking entity){

        PdsReviewTrackingDTO dto=new PdsReviewTrackingDTO();

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

    private PdsReviewTracking convertDtoTOEntity(PdsReviewTrackingDTO dto,PdsReviewTrackingKey key){



        PdsReviewTracking entity=new PdsReviewTracking();

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
        PdsReviewTrackingKey key=new PdsReviewTrackingKey();

        key.setPdsTrackingKey(dto.getPdsTrackingKey());
        key.setPdsVersionNumber(dto.getPdsVersionNumber());
        key.setPdsReviewTrackingTypeName(dto.getPdsReviewTrackingTypeName());

        key.setPdsReviewTrackingReviewerId(dto.getPdsReviewTrackingReviewerId());
        key.setPdsReviewTrackingResponseNumber(maxRvwTrckngRspnsNum(dto));



        return key;
    }


}
