package com.tum.atmsim.controller;

import com.tum.atmsim.repository.entity.AtmDetail;
import com.tum.atmsim.service.AtmDetailGetService;
import com.tum.atmsim.service.AtmDetailUpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AtmRestControllerTest {

    @InjectMocks
    private AtmRestController controller;

    @Mock
    private AtmDetailGetService mockInsertService;

    @Mock
    private AtmDetailUpdateService mockUpdateService;

    @Test
    public void getATMProfileSuccesCase() {
        ResponseEntity<AtmDetail> response = controller.getATMProfile(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateATMProfileSuccessCase() {
        ResponseEntity<AtmDetail> response = controller.updateATMProfile(1L, new AtmDetail());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}