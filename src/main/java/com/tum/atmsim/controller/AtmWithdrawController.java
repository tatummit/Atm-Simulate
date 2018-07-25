package com.tum.atmsim.controller;

import com.tum.atmsim.model.WithDrawRequest;
import com.tum.atmsim.model.WithDrawResponse;
import com.tum.atmsim.service.AtmWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/atm/{id}")
public class AtmWithdrawController {

    @Autowired
    private AtmWithdrawService service;

    @RequestMapping(value = "withdraw", method = RequestMethod.POST)
    public ResponseEntity<WithDrawResponse> withDrawMoney(@PathVariable("id") long id, @RequestBody WithDrawRequest request) {
        WithDrawResponse response = service.withdrawMoney(id, request);
        return ResponseEntity.ok(response);
    }
}
