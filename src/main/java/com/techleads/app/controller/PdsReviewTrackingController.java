package com.techleads.app.controller;

import com.techleads.app.model.PdsReviewTracking;
import com.techleads.app.model.PdsReviewTrackingDTO;
import com.techleads.app.service.PdsReviewTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdsReviewTrackingController {

    @Autowired
   private PdsReviewTrackingService pdsReviewTrackingService;

   @PostMapping(value = {"/pdsreviewtracking/save"})
    public ResponseEntity<PdsReviewTrackingDTO> savePdsReviewTracking(@RequestBody PdsReviewTrackingDTO dto){

        PdsReviewTrackingDTO reponse = pdsReviewTrackingService.savePdsReviewTracking(dto);
        return new ResponseEntity<>(reponse, HttpStatus.CREATED);

    }

    @GetMapping(value = {"/test"})
    public ResponseEntity<PdsReviewTrackingDTO> savePdsReviewTracking(){

        PdsReviewTrackingDTO reponse = new PdsReviewTrackingDTO();
        return new ResponseEntity<>(reponse, HttpStatus.OK);

    }
}
