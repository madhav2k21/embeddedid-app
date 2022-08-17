package com.techleads.app.controller;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionResponse;
import com.techleads.app.service.UserDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDistributionController {

    @Autowired
    private UserDistributionService userDistributionService;

    @GetMapping(value = {"/dist"})
    public List<UserDistributionResponse> findAllDistributions(){
        return userDistributionService.findAllDistributions();
    }

    @DeleteMapping(value = {"/dist"})
    public String deltest(@RequestParam("userId") String userId,
                          @RequestParam("areaName") String areaName){
        return userDistributionService.testDel(userId,areaName);
    }
}
