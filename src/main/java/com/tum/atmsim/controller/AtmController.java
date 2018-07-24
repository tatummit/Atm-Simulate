package com.tum.atmsim.controller;

import com.tum.atmsim.model.AtmDetail;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1/atm")
public class AtmController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getATMProfile(@PathVariable("id") Long id) {
        return ResponseEntity.ok("hello");
    }

}
