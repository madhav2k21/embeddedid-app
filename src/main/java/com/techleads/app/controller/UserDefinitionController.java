package com.techleads.app.controller;

import com.techleads.app.model.UserDefinitionDTO;
import com.techleads.app.model.UserDistributionKey;
import com.techleads.app.model.UserMaintenanceResponse;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import com.techleads.app.service.UserDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserDefinitionController {

    @Autowired
    private UserDefinitionService userDefinitionService;

    @Autowired
    private UserDistRepository userDistRepository;


    @PostMapping(value = {"/test"})
    public ResponseEntity<UserMaintenanceResponse> saveUser(@RequestBody UserDefinitionDTO userDTO){
        UserMaintenanceResponse response = userDefinitionService.addUser(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = {"/test"})
    public ResponseEntity<List<UserMaintenanceResponse>> findAllUserDefinition(){
        List<UserMaintenanceResponse> allUserDefinition = userDefinitionService.findAllUserDefinition();
        return new ResponseEntity<>(allUserDefinition, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/test"})
    public ResponseEntity<String> deleteUserDefintionByUserDefintionKey(
            @RequestParam("userId") String userId,
            @RequestParam("area") String area) {
        String result = userDefinitionService.deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(userId, area);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping(value = {"/test/{userId}/{area}"})
    public Integer test(@PathVariable("userId") String userId, @PathVariable("area") String area){
        Integer integer = userDistRepository.deleteUserDistributionByUserIdAndArea(userId,area);
        return integer;
    }


}
