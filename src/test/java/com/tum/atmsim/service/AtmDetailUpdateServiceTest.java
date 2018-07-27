package com.tum.atmsim.service;

import com.tum.atmsim.exception.InvalidRequestException;
import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.repository.AtmDetailRepository;
import com.tum.atmsim.repository.entity.AtmDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmDetailUpdateServiceTest {

    @InjectMocks
    private AtmDetailUpdateService service;

    @Mock
    private AtmDetailRepository mockRepository;

    private AtmDetail mockAtmDetail() {
        AtmDetail atmDetail = new AtmDetail();
        atmDetail.setId(1L);
        return atmDetail;
    }

    @Test
    public void testUpdateSuccessCase() {
        //Given
        when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));
        when(mockRepository.save(any(AtmDetail.class))).thenAnswer(argv -> argv.getArgument(0));
        //When
        AtmDetail newDetail = new AtmDetail();
        newDetail.setNumOfBath20(100);
        newDetail.setNumOfBath50(100);
        AtmDetail actual = service.updateAtmDetail(1L, newDetail);
        //Then
        assertEquals(100, actual.getNumOfBath20());
        assertEquals(100, actual.getNumOfBath50());
        assertNotNull(actual.getLastUpdatedDate());
    }

    @Test(expected = InvalidRequestException.class)
    public void testUpdateWithNegative20BathNote() {
        //Given
        when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));
        //When
        AtmDetail newDetail = new AtmDetail();
        newDetail.setNumOfBath20(-100);
        newDetail.setNumOfBath50(100);
        service.updateAtmDetail(1L, newDetail);
        //Then
        //throw exception
    }

    @Test(expected = InvalidRequestException.class)
    public void testUpdateWithNegative50BathNote() {
        //Given
        when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));
        //When
        AtmDetail newDetail = new AtmDetail();
        newDetail.setNumOfBath20(100);
        newDetail.setNumOfBath50(-100);
        service.updateAtmDetail(1L, newDetail);
        //Then
        //throw exception
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetNotFoundObject() {
        //When
        AtmDetail newDetail = new AtmDetail();
        newDetail.setNumOfBath20(100);
        newDetail.setNumOfBath50(100);
        service.updateAtmDetail(1L, newDetail);
    }
}