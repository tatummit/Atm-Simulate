package com.tum.atmsim.controller;

import com.tum.atmsim.repository.entity.AtmDetail;
import com.tum.atmsim.service.AtmDetailGetService;
import com.tum.atmsim.service.AtmDetailUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/atm")
public class AtmRestController {

    @Autowired
    private AtmDetailGetService getService;

    @Autowired
    private AtmDetailUpdateService updateService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AtmDetail> getATMProfile(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getService.getAtmDetail(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AtmDetail> updateATMProfile(@PathVariable("id") Long id, @RequestBody AtmDetail atmDetail) {
        return ResponseEntity.ok(updateService.updateAtmDetail(id, atmDetail));
    }

}
