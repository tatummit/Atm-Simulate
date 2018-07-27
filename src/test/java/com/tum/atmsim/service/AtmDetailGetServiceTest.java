package com.tum.atmsim.service;

import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.repository.AtmDetailRepository;
import com.tum.atmsim.repository.entity.AtmDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmDetailGetServiceTest {

    @InjectMocks
    private AtmDetailGetService getService;

    @Mock
    private AtmDetailRepository mockRepository;

    @Test
    public void testGetSuccess() {
        //Given
        when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));
        //When
        AtmDetail atmDetail = getService.getAtmDetail(1L);
        //Then
        assertEquals(1L, atmDetail.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetNotFoundObject() {
        //When
        getService.getAtmDetail(1L);
    }

    @Test
    public void testGetAllObject() {
        //Given
        List<AtmDetail> mockList = new ArrayList<>();
        when(mockRepository.findAll()).thenReturn(mockList);
        //When
        List<AtmDetail> list = getService.getAllAtmDetailList();
        //Then
        assertEquals(mockList, list);
    }

    private AtmDetail mockAtmDetail() {
        AtmDetail atmDetail = new AtmDetail();
        atmDetail.setId(1L);
        return atmDetail;
    }

}