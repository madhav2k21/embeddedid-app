package com.techleads.app.controller;

import com.techleads.app.model.ResponseMessage;
import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionResponse;
import com.techleads.app.service.UserDistributionCSVHelper;
import com.techleads.app.service.UserDistributionImportCSVService;
import com.techleads.app.service.UserDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserDistributionController {

    @Autowired
    private UserDistributionService userDistributionService;
    @Autowired
    private UserDistributionImportCSVService userDistributionImportCSVService;

    @GetMapping(value = {"/dist"})
    public List<UserDistributionResponse> findAllDistributions(){
        return userDistributionService.findAllDistributions();
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        if (UserDistributionCSVHelper.hasCSVFormat(file)) {
            try {
                userDistributionImportCSVService.readCSVAndSaveUserDistribution(file);
                message = "Saved the file data successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not save the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @DeleteMapping(value = {"/dist"})
    public String deltest(@RequestParam("userId") String userId,
                          @RequestParam("areaName") String areaName){
        return userDistributionService.testDel(userId,areaName);
    }
}
