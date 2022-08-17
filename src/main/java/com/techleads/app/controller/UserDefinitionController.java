package com.techleads.app.controller;

import com.techleads.app.model.UserDefinition;
import com.techleads.app.model.UserDefDTO;
import com.techleads.app.model.UserMaintenanceResponse;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.service.UserDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDefinitionController {

    @Autowired
    private UserDefinitionService userDefinitionService;

    @Autowired
    private UserDistRepository userDistRepository;


    @PostMapping(value = {"/user/save"})
    public ResponseEntity<UserMaintenanceResponse> saveUser(@RequestBody UserDefDTO userDTO){
        UserMaintenanceResponse response = userDefinitionService.addUser(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = {"/user/listall"})
    public ResponseEntity<List<UserMaintenanceResponse>> findAllUserDefinition(){
        List<UserMaintenanceResponse> allUserDefinition = userDefinitionService.findAllUserDefinition();
        return new ResponseEntity<>(allUserDefinition, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/user/delete"})
    public ResponseEntity<String> deleteUserDefintionByUserDefintionKey(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName) {
        String result = userDefinitionService.deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(userId, areaName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = {"/user"})
    public ResponseEntity<UserDefinition> findUserDefintionByUserDefintionKey(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName) {
        UserDefinition userDef = userDefinitionService.findByUserDefinitionKey(userId, areaName);
        return new ResponseEntity<>(userDef, HttpStatus.OK);
    }

    @GetMapping(value = {"/users"})
    public ResponseEntity<UserMaintenanceResponse> findUserDefintionByUserDefintionKey1(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName) {
        UserMaintenanceResponse response = userDefinitionService.findByUserDefinitionKey1(userId, areaName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = {"/user"})
    public ResponseEntity<UserDefinition> updateUserDefintionByUserDefintionKey(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName, @RequestBody UserDefinition userDef) {
        UserDefinition userDefinition = userDefinitionService.updateUserDefinitionKey(userId, areaName, userDef);
        return new ResponseEntity<>(userDefinition, HttpStatus.OK);
    }


    @PutMapping(value = {"/users"})
    public ResponseEntity<UserMaintenanceResponse> updateUserDefintionByUserDefintionKey1(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName, @RequestBody UserDefinition userDef) {
        UserMaintenanceResponse response = userDefinitionService.updateUserDefinitionKey1(userId, areaName, userDef);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = {"/users2"})
    public ResponseEntity<UserMaintenanceResponse> updateUserDefintionByUserDefintionKey2(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName, @RequestBody UserDefDTO userDTO) {
        UserMaintenanceResponse response = userDefinitionService.updateUserDefinitionKey2(userId, areaName, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping(value = {"/test/{userId}/{area}"})
    public Integer test(@PathVariable("userId") String userId, @PathVariable("area") String area){
        Integer integer = userDistRepository.deleteUserDistributionByUserIdAndArea(userId,area);
        return integer;
    }


}
