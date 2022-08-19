package com.techleads.app.service;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionDTO;
import com.techleads.app.model.UserDistributionKey;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class UserDistributionImportCSVService {
    private final String TEMP_USER_ID = "admin";
    @Autowired
    private UserDistributionRepository userDistributionRepository;
    public void readCSVAndSaveUserDistribution(MultipartFile file) {
        try {
            List<UserDistributionDTO> userDistributionDTOList = UserDistributionCSVHelper.csvToUserDistributionDTO(file.getInputStream());
//            List<UserDistribution> userDistributionList=new ArrayList<>();
            userDistributionDTOList.forEach(dto->{
                UserDistribution usrDis=new UserDistribution();

                UserDistributionKey key=new UserDistributionKey();
                //primary key for UserDistribution starts
                key.setUserDefinitionId(dto.getUserId());
                key.setUserDefinitionWorkAreaName(dto.getAreaName());
                key.setUserDistributionKey(findMaxUserDistKey());
                usrDis.setUserDistributionKey(key);
                //primary key UserDistribution ends

                usrDis.setUserDistributionFacilityId(dto.getFacility());
                usrDis.setUserDistributionPgrmCode(dto.getProgramCode());
                usrDis.setUserDistributionSupplierNumber(dto.getSupplierNum());
                usrDis.setUserDistributionPartFamilyCode(dto.getPartFamily());
                usrDis.setUserDistributionShopClassInd(dto.getShopClass());
                usrDis.setUserDistributionPartNumber(dto.getPartNumber());

                usrDis.setUserDistributionCreatedUserId(TEMP_USER_ID);
                usrDis.setUserDistributionCreatedTs(LocalDateTime.now());
                usrDis.setUserDistributionUpdatedUserId(TEMP_USER_ID);
                usrDis.setUserDistributionUpdatedTs(LocalDateTime.now());
                userDistributionRepository.save(usrDis);
//                userDistributionList.add(usrDis);
            });

//            userDistributionRepository.saveAll(userDistributionList);
        } catch (IOException e) {
            throw new RuntimeException("failed to store csv data: " + e.getMessage());
        }
    }

    private Integer findMaxUserDistKey(){
        Optional<Integer> key = userDistributionRepository.findMaxUserDistributionKey();
        return key.isPresent() ? (key.get()+1) : 10;
    }
}