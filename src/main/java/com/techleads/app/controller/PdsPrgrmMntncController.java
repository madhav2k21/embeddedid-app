package com.techleads.app.controller;

import com.techleads.app.model.PdsPrgrmMntncDTO;
import com.techleads.app.service.PdsPrgrmMntncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PdsPrgrmMntncController {

    @Autowired
    private PdsPrgrmMntncService pdsPrgrmMntncService;

    @GetMapping(value = {"/prgrmmntnc/list"})
    public ResponseEntity<List<PdsPrgrmMntncDTO>> findAllPdsPrgrmMntnc() {

        List<PdsPrgrmMntncDTO> allPdsPrgrmMntnc = pdsPrgrmMntncService.findAllPdsPrgrmMntnc();


        return new ResponseEntity<>(allPdsPrgrmMntnc, HttpStatus.OK);

    }




    @PostMapping(value = {"/prgrmmntnc/save"})
    public ResponseEntity<PdsPrgrmMntncDTO> savePdsPrgrmMntnc(@RequestBody PdsPrgrmMntncDTO dto) {

        PdsPrgrmMntncDTO pdsPrgrmMntncDTO = pdsPrgrmMntncService.savePdsPrgrmMntnc(dto);


        return new ResponseEntity<>(pdsPrgrmMntncDTO, HttpStatus.CREATED);

    }

    @PutMapping(value = {"/prgrmmntnc/update"})
    public ResponseEntity<PdsPrgrmMntncDTO> updatePdsPrgrmMntnc(
            @RequestBody PdsPrgrmMntncDTO dto,
            @RequestParam("prgrmMntncNumKey") Integer prgrmMntncNumKey) {


        PdsPrgrmMntncDTO response = pdsPrgrmMntncService.updatePdsPrgrmMntnc(dto, prgrmMntncNumKey);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping(value = {"/prgrmmntnc"})
    public ResponseEntity<PdsPrgrmMntncDTO> findPdsPrgrmMntncById(
            @RequestParam("prgrmMntncNumKey") Integer prgrmMntncNumKey) {
        PdsPrgrmMntncDTO response = pdsPrgrmMntncService.findPdsPrgrmMntncById(prgrmMntncNumKey);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping(value = {"/prgrmmntnc/delete"})
    public ResponseEntity<String> deletePdsPrgrmMntncById(
            @RequestParam("prgrmMntncNumKey") Integer prgrmMntncNumKey) {
        String response = pdsPrgrmMntncService.deletePdsPrgrmMntncById(prgrmMntncNumKey);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
