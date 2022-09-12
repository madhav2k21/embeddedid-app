package com.techleads.app.controller;

import com.techleads.app.model.AllApproverNames;
import com.techleads.app.model.ApproverNames;
import com.techleads.app.model.DelinkingReqDTO;
import com.techleads.app.model.PdsReviewTrackingDTO;
import com.techleads.app.service.PdsReviewTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PdsReviewTrackingController {

    @Autowired
    private PdsReviewTrackingService pdsReviewTrackingService;

    @PostMapping(value = {"/pdsreviewtracking/save"})
    public ResponseEntity<PdsReviewTrackingDTO> savePdsReviewTracking(@RequestBody PdsReviewTrackingDTO dto) {

        PdsReviewTrackingDTO reponse = pdsReviewTrackingService.savePdsReviewTracking(dto);
        return new ResponseEntity<>(reponse, HttpStatus.CREATED);

    }

    @GetMapping(value = {"/test"})
    public ResponseEntity<PdsReviewTrackingDTO> savePdsReviewTracking() {

        PdsReviewTrackingDTO reponse = new PdsReviewTrackingDTO();
        return new ResponseEntity<>(reponse, HttpStatus.OK);

    }

    @GetMapping(value = {"/names"})
    public ResponseEntity<AllApproverNames> findAllApproverNames(@RequestParam("areaName") String areaName,
                                                                 @RequestParam("facilityId") String facilityId) {
        AllApproverNames response = pdsReviewTrackingService.findAllApproverNames(areaName, facilityId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = {"/delink"})
    public ResponseEntity<List<DelinkingReqDTO>> findAllDelinkingRequest() {
        List<DelinkingReqDTO> response = pdsReviewTrackingService.findAllDelinkingRequest();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
