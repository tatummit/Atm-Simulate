package com.tum.atmsim.controller;

import com.tum.atmsim.repository.entity.AtmDetail;
import com.tum.atmsim.service.AtmDetailService;
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
    private AtmDetailService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AtmDetail> getATMProfile(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getAtmDetail(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AtmDetail> updateATMProfile(@PathVariable("id") Long id, @RequestBody AtmDetail atmDetail) {
        return ResponseEntity.ok(service.updateAtmDetail(id, atmDetail));
    }

}
