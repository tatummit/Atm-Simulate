package com.tum.atmsim.controller;

import com.tum.atmsim.model.WithDrawRequest;
import com.tum.atmsim.model.WithDrawResponse;
import com.tum.atmsim.service.AtmWithdrawService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AtmWithdrawControllerTest {

    @InjectMocks
    private AtmWithdrawController controller;

    @Mock
    private AtmWithdrawService withdrawService;

    @Test
    public void withDrawMoneySuccesCase() {
        ResponseEntity<WithDrawResponse> response = controller.withDrawMoney(1L, new WithDrawRequest());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}