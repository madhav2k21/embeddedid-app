package com.techleads.app.controller;

import com.techleads.app.model.TestSequence;
import com.techleads.app.repository.TestSequeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestSequenceController {

    @Autowired
    private TestSequeneRepository testSequeneRepository;


    @PostMapping(value = {"/sequence/save"})
    public ResponseEntity<TestSequence> savePdsPrgrmMntnc(@RequestBody TestSequence entity) {

        entity.setUserDefinitionUpdatedUserId("admin");
        entity.setUserDefinitionCreatedUserId("admin");
        entity.setUserDefinitionUpdatedTs(LocalDateTime.now());
        entity.setUserDefinitionCreatedTs(LocalDateTime.now());

        TestSequence save = testSequeneRepository.save(entity);

        return new ResponseEntity<>(save, HttpStatus.CREATED);

    }


}
