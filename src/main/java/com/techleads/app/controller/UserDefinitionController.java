package com.techleads.app.controller;

import com.techleads.app.model.UserDefinitionDTO;
import com.techleads.app.service.UserDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDefinitionController {

    @Autowired
    private UserDefinitionService userDefinitionService;


    @GetMapping(value = {"/test"})
    public ResponseEntity<List<UserDefinitionDTO>> findAllUserDefinition(){
        List<UserDefinitionDTO> allUserDefinition = userDefinitionService.findAllUserDefinition();
        return new ResponseEntity<>(allUserDefinition, HttpStatus.OK);
    }


}
