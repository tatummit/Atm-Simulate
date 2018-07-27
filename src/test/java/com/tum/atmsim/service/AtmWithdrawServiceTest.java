package com.tum.atmsim.service;

import com.tum.atmsim.exception.InvalidRequestException;
import com.tum.atmsim.exception.NotEnoughNoteException;
import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.model.WithDrawRequest;
import com.tum.atmsim.model.WithDrawResponse;
import com.tum.atmsim.repository.AtmDetailRepository;
import com.tum.atmsim.repository.entity.AtmDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmWithdrawServiceTest {

    @InjectMocks
    private AtmWithdrawService atmWithdrawService;

    @Mock
    private AtmDetailRepository mockRepository;

    private AtmDetail mockAtmDetail() {
        AtmDetail atmDetail = new AtmDetail();
        atmDetail.setId(1L);
        atmDetail.setNumOfBath50(100);
        atmDetail.setNumOfBath20(100);
        return atmDetail;
    }

    private AtmDetail mockAtmDetailWithZeroNote() {
        AtmDetail atmDetail = new AtmDetail();
        atmDetail.setId(1L);
        atmDetail.setNumOfBath50(0);
        atmDetail.setNumOfBath20(0);
        return atmDetail;
    }

    /***
     *  give ATM#1 have 100 bank20bath and 100 bank50bath.
     *  when withdraw 100 bath
     *  then ATM withdraw 0 bank20bath and 2 bank50bath.
     *       Remaining note in ATM is
     *       bank50bath 98 note.
     *       bank20bath 100 note.
     */
    @Test
    public void testWithdrawSuccessCase() {
        //Given
        when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));

        //When
        WithDrawRequest request = new WithDrawRequest();
        request.setAmount(100);
        WithDrawResponse response = atmWithdrawService.withdrawMoney(1, request);

        //Then
        ArgumentCaptor<AtmDetail> argumentCaptor = ArgumentCaptor.forClass(AtmDetail.class);
        verify(mockRepository).save(argumentCaptor.capture());
        AtmDetail atmDetail = argumentCaptor.getValue();
        assertEquals(98, atmDetail.getNumOfBath50());
        assertEquals(100, atmDetail.getNumOfBath20());

        assertEquals(0, response.getWithDrawBank20Bath().intValue());
        assertEquals(2, response.getWithDrawBank50Bath().intValue());
        assertEquals(100, response.getWithDrawAmount().intValue());
        assertEquals(6900, response.getRemainAmount().intValue());
        assertEquals(100, response.getRemainBank20Bath().intValue());
        assertEquals(98, response.getRemainBank50Bath().intValue());

    }

    /***
     *  give ATM#1 have 100 bank20bath and 100 bank50bath.
     *  when withdraw 160 bath
     *  then ATM withdraw 3 bank20bath and 2 bank50bath.
     *       Remaining note in ATM is
     *       bank50bath 98 note.
     *       bank20bath 97 note.
     */
    @Test
    public void testWithdrawFindSolutionSuccessCase() {
        //Given
        when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));

        //When
        WithDrawRequest request = new WithDrawRequest();
        request.setAmount(160);
        WithDrawResponse response = atmWithdrawService.withdrawMoney(1, request);

        //Then
        ArgumentCaptor<AtmDetail> argumentCaptor = ArgumentCaptor.forClass(AtmDetail.class);
        verify(mockRepository).save(argumentCaptor.capture());
        AtmDetail atmDetail = argumentCaptor.getValue();
        assertEquals(98, atmDetail.getNumOfBath50());
        assertEquals(97, atmDetail.getNumOfBath20());

        assertEquals(3, response.getWithDrawBank20Bath().intValue());
        assertEquals(2, response.getWithDrawBank50Bath().intValue());
        assertEquals(160, response.getWithDrawAmount().intValue());
        assertEquals(6840, response.getRemainAmount().intValue());
        assertEquals(97, response.getRemainBank20Bath().intValue());
        assertEquals(98, response.getRemainBank50Bath().intValue());

    }

    /***
     *  give ATM#1 have 100 bank20bath and 100 bank50bath.
     *  when withdraw 30 bath
     *  then throw a not enough note exception
     */
    @Test(expected = NotEnoughNoteException.class)
    public void testWithdrawWithUnsupportedAmount() {
        try {
            //Given
            when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetail()));

            //When
            WithDrawRequest request = new WithDrawRequest();
            request.setAmount(30);
            atmWithdrawService.withdrawMoney(1, request);
        } finally {
            //Then
            verify(mockRepository, never()).save(any(AtmDetail.class));
        }
    }

    /***
     *  give ATM#1 have 0 bank20bath and 0 bank50bath.
     *  when withdraw 100 bath
     *  then throw an not enough note exception
     */
    @Test(expected = NotEnoughNoteException.class)
    public void testWithdrawWithZeroNote() {
        try {
            //Given
            when(mockRepository.findById(eq(1L))).thenReturn(Optional.of(mockAtmDetailWithZeroNote()));
            //When
            WithDrawRequest request = new WithDrawRequest();
            request.setAmount(100);
            atmWithdrawService.withdrawMoney(1, request);
        } finally {
            //Then
            verify(mockRepository, never()).save(any(AtmDetail.class));
        }
    }

    /***
     *  when withdraw null
     *  then throw an invalid request exception
     */
    @Test(expected = InvalidRequestException.class)
    public void testWithdrawWithNullRequest() {
        try {
            atmWithdrawService.withdrawMoney(1, null);
        } finally {
            //Then
            verify(mockRepository, never()).save(any(AtmDetail.class));
        }
    }

    /***
     *  give no ATM#1 profile
     *  when withdraw 100 bath
     *  then throw an resource not found exception
     */
    @Test(expected = ResourceNotFoundException.class)
    public void testWithdrawWithNotFoundAtmDetail() {
        try {
            //When
            WithDrawRequest request = new WithDrawRequest();
            request.setAmount(100);
            atmWithdrawService.withdrawMoney(1, request);
        } finally {
            //Then
            verify(mockRepository, never()).save(any(AtmDetail.class));
        }
    }

}