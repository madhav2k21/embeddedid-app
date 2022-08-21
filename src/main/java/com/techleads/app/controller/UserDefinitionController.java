package com.techleads.app.controller;

import com.techleads.app.model.UserDefDTO;
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
    public ResponseEntity<UserDefDTO> saveUser(@RequestBody UserDefDTO userDTO) {
        UserDefDTO response = userDefinitionService.addUser(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = {"/users/listall"})
    public ResponseEntity<List<UserDefDTO>> findAllUserDefinition() {
        List<UserDefDTO> allUserDefinition = userDefinitionService.findAllUserDefinition();
        return new ResponseEntity<>(allUserDefinition, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/users/delete"})
    public ResponseEntity<String> deleteUserDefintionByUserDefintionKey(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName) {
        String result = userDefinitionService.deleteByUserDefinitionIdAndUserDefinitionWorkAreaName(userId, areaName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = {"/users"})
    public ResponseEntity<UserDefDTO> findUserDefintionByUserDefintionKey1(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName) {
        UserDefDTO response = userDefinitionService.findByUserDefinitionKey1(userId, areaName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping(value = {"/users"})
    public ResponseEntity<UserDefDTO> updateUserDefintionByUserDefintionKey2(
            @RequestParam("userId") String userId,
            @RequestParam("areaName") String areaName, @RequestBody UserDefDTO userDTO) {
        UserDefDTO response = userDefinitionService.updateUserDefinitionKey(userId, areaName, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/test/{userId}/{area}"})
    public Integer test(@PathVariable("userId") String userId, @PathVariable("area") String area) {
        Integer integer = userDistRepository.deleteUserDistributionByUserIdAndArea(userId, area);
        return integer;
    }


}
