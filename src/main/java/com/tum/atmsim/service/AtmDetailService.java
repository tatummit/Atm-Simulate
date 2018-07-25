package com.tum.atmsim.service;

import com.tum.atmsim.exception.InvalidRequestException;
import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.repository.AtmDetailRepository;
import com.tum.atmsim.repository.entity.AtmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class AtmDetailService {

    @Autowired
    private AtmDetailRepository atmDetailRepository;

    public AtmDetail getAtmDetail(long id) {
        return getSafeAtmDetail(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public AtmDetail updateAtmDetail(long id,AtmDetail atmDetail) {
        AtmDetail oldAtmDetail = atmDetailRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (atmDetail.getNumOfBath20() < 0) {
            throw new InvalidRequestException("Number of Bath 20 must greater than 0");
        }

        if (atmDetail.getNumOfBath50() < 0) {
            throw new InvalidRequestException("Number of Bath 50 must greater than 0");
        }

        atmDetail.setId(oldAtmDetail.getId());
        atmDetail.setLastUpdatedDate(oldAtmDetail.getLastUpdatedDate());
        atmDetail.setLastUpdatedDate(new Date());
        return atmDetailRepository.save(atmDetail);
    }

    private AtmDetail getSafeAtmDetail(long id) {
        return atmDetailRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("atm id not found"));
    }

}
