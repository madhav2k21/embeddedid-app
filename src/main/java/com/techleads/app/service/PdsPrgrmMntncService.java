package com.techleads.app.service;

import com.techleads.app.exception.EntityException;
import com.techleads.app.model.PdsPrgrmMntnc;
import com.techleads.app.model.PdsPrgrmMntncDTO;
import com.techleads.app.repository.PdsPrgrmMntncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdsPrgrmMntncService {
    final String TEMP_USER_ID = "admin";
    @Autowired
    private PdsPrgrmMntncRepository pdsProgramMaintenanceRepository;


    public List<PdsPrgrmMntncDTO> findAllPdsPrgrmMntnc() {
        List<PdsPrgrmMntnc> pdsPrgrmMntncList = pdsProgramMaintenanceRepository.findAll();

        List<PdsPrgrmMntncDTO> pdsPrgrmMntncDTOList = new ArrayList<>();

        pdsPrgrmMntncList.forEach(entity -> pdsPrgrmMntncDTOList.add(convertPdsPrgrmMntncToEntityDTO(entity)));

        return pdsPrgrmMntncDTOList;
    }


    public PdsPrgrmMntncDTO savePdsPrgrmMntnc(PdsPrgrmMntncDTO dto) {

        try {
            PdsPrgrmMntnc entity = convertPdsPrgrmMntncDTOToEntity(dto);

            PdsPrgrmMntnc savedEntity = pdsProgramMaintenanceRepository.save(entity);

            return convertPdsPrgrmMntncToEntityDTO(savedEntity);
        } catch (Exception e) {
            throw new EntityException("Exception occurred in savePdsPrgrmMntnc()");
        }
    }


    public PdsPrgrmMntncDTO updatePdsPrgrmMntnc(PdsPrgrmMntncDTO dto, Integer prgrmMntncNumKey) {

        return pdsProgramMaintenanceRepository.findById(prgrmMntncNumKey).map(entity -> {

            entity.setProgmMntncItemNum(dto.getProgmMntncItemNum());
            entity.setProgmMntncFacilityId(dto.getProgmMntncFacilityId());
            entity.setProgmMntncTrackingNum(dto.getProgmMntncTrackingNum());
            entity.setProgmMntncRivisionNum(dto.getProgmMntncRivisionNum());
            entity.setProgmMntncCenterTypNum(dto.getProgmMntncCenterTypNum());
            entity.setProgmMntncCenterRetunModeCd(dto.getProgmMntncCenterRetunModeCd());
            entity.setProgmMntncValueNum(dto.getProgmMntncValueNum());

            entity.setProgmMntncUpdtedUsrId(TEMP_USER_ID);
            entity.setProgmMntncUpdtedTs(LocalDateTime.now());

            PdsPrgrmMntnc updatedEntity = pdsProgramMaintenanceRepository.save(entity);

            return convertPdsPrgrmMntncToEntityDTO(updatedEntity);
        }).orElseThrow(() -> new EntityException("PdsProgramMaintence not found with" + prgrmMntncNumKey));


    }


    public PdsPrgrmMntncDTO findPdsPrgrmMntncById(Integer prgrmMntncNumKey) {
        return pdsProgramMaintenanceRepository.findById(prgrmMntncNumKey).map(entity -> {
            return convertPdsPrgrmMntncToEntityDTO(entity);
        }).orElseThrow(() -> new EntityException("PdsProgramMaintence not found with " + prgrmMntncNumKey));

    }


    public String deletePdsPrgrmMntncById(Integer prgrmMntncNumKey) {
        return pdsProgramMaintenanceRepository.findById(prgrmMntncNumKey).map(entity -> {
            return "Program Maintenance deleted successfully";
        }).orElseThrow(() -> new EntityException("PdsProgramMaintence not found with " + prgrmMntncNumKey));

    }

    private PdsPrgrmMntnc convertPdsPrgrmMntncDTOToEntity(PdsPrgrmMntncDTO dto) {

        PdsPrgrmMntnc entity = new PdsPrgrmMntnc();

        entity.setProgmMntncItemNumKey(dto.getProgmMntncItemNumKey());
        entity.setProgmMntncItemNum(dto.getProgmMntncItemNum());
        entity.setProgmMntncFacilityId(dto.getProgmMntncFacilityId());
        entity.setProgmMntncTrackingNum(dto.getProgmMntncTrackingNum());
        entity.setProgmMntncRivisionNum(dto.getProgmMntncRivisionNum());
        entity.setProgmMntncCenterTypNum(dto.getProgmMntncCenterTypNum());
        entity.setProgmMntncCenterRetunModeCd(dto.getProgmMntncCenterRetunModeCd());
        entity.setProgmMntncValueNum(dto.getProgmMntncValueNum());

        entity.setProgmMntncCrtedUsrId(TEMP_USER_ID);
        entity.setProgmMntncCrtedTs(LocalDateTime.now());
        entity.setProgmMntncUpdtedUsrId(TEMP_USER_ID);
        entity.setProgmMntncUpdtedTs(LocalDateTime.now());

        return entity;
    }

    private PdsPrgrmMntncDTO convertPdsPrgrmMntncToEntityDTO(PdsPrgrmMntnc entity) {
        PdsPrgrmMntncDTO dto = new PdsPrgrmMntncDTO();
        dto.setProgmMntncItemNumKey(entity.getProgmMntncItemNumKey());
        dto.setProgmMntncItemNum(entity.getProgmMntncItemNum());
        dto.setProgmMntncFacilityId(entity.getProgmMntncFacilityId());
        dto.setProgmMntncTrackingNum(entity.getProgmMntncTrackingNum());
        dto.setProgmMntncRivisionNum(entity.getProgmMntncRivisionNum());
        dto.setProgmMntncCenterTypNum(entity.getProgmMntncCenterTypNum());
        dto.setProgmMntncCenterRetunModeCd(entity.getProgmMntncCenterRetunModeCd());
        dto.setProgmMntncValueNum(entity.getProgmMntncValueNum());
        return dto;
    }


}
