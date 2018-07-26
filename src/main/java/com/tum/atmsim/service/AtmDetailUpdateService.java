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
public class AtmDetailUpdateService {

    @Autowired
    private AtmDetailRepository atmDetailRepository;

    @Transactional(rollbackOn = Exception.class)
    public AtmDetail updateAtmDetail(long id, AtmDetail atmDetail) {
        AtmDetail oldAtmDetail = atmDetailRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        validateRequest(atmDetail);

        atmDetail.setId(oldAtmDetail.getId());
        atmDetail.setLastUpdatedDate(oldAtmDetail.getLastUpdatedDate());
        atmDetail.setLastUpdatedDate(new Date());
        return atmDetailRepository.save(atmDetail);
    }

    private void validateRequest(AtmDetail atmDetail) {
        if (atmDetail.getNumOfBath20() < 0) {
            throw new InvalidRequestException("Number of Bath 20 must greater than 0");
        }

        if (atmDetail.getNumOfBath50() < 0) {
            throw new InvalidRequestException("Number of Bath 50 must greater than 0");
        }
    }
}
