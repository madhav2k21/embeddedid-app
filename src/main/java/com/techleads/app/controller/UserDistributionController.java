package com.techleads.app.controller;

import com.techleads.app.model.ResponseMessage;
import com.techleads.app.model.UserDistributionResponse;
import com.techleads.app.service.UserDistributionCSVHelper;
import com.techleads.app.service.UserDistributionImportCSVService;
import com.techleads.app.service.UserDistributionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
public class UserDistributionController {

    @Autowired
    private UserDistributionService userDistributionService;
    @Autowired
    private UserDistributionImportCSVService userDistributionImportCSVService;

    @GetMapping(value = {"/dist"})
    public List<UserDistributionResponse> findAllDistributions() {
        return userDistributionService.findAllDistributions();
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        HttpHeaders responseHeaders = new HttpHeaders();
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("File_import_Task_Execution_Time_in_Seconds");


        if (UserDistributionCSVHelper.hasCSVFormat(file)) {
            try {
                userDistributionImportCSVService.readCSVAndSaveUserDistribution(file);
                message = "Saved the file data successfully: " + file.getOriginalFilename();
                stopWatch.stop();
                responseHeaders.set(stopWatch.getLastTaskInfo().getTaskName(), String.valueOf(stopWatch.getLastTaskInfo().getTimeSeconds()));
                log.info(stopWatch.getLastTaskInfo().getTaskName());
                log.info(String.valueOf(stopWatch.getLastTaskInfo().getTimeSeconds()));
                return ResponseEntity.ok()
                        .headers(responseHeaders)
                        .body(new ResponseMessage(message));

            } catch (Exception e) {
                message = "Could not save the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(responseHeaders).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(responseHeaders).body(new ResponseMessage(message));
    }

    @DeleteMapping(value = {"/dist"})
    public String deltest(@RequestParam("userId") String userId,
                          @RequestParam("areaName") String areaName) {
        return userDistributionService.testDel(userId, areaName);
    }

    @GetMapping("/headers")
    public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("import_time_processed_in");

        stopWatch.stop();
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("Baeldung-Example-Header",
//                "Value-ResponseEntityBuilderWithHttpHeaders");

        String taskName = stopWatch.getLastTaskInfo().getTaskName();
        double timeSeconds = stopWatch.getLastTaskInfo().getTimeSeconds();
        log.info(taskName);
        log.info(String.valueOf(timeSeconds));
        responseHeaders.set(taskName, String.valueOf(timeSeconds));
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Response with header using ResponseEntity");
    }
}
