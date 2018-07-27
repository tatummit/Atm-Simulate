package com.tum.atmsim.service;

import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.repository.AtmDetailRepository;
import com.tum.atmsim.repository.entity.AtmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmDetailGetService {

    @Autowired
    private AtmDetailRepository atmDetailRepository;

    public AtmDetail getAtmDetail(long id) {
        return getSafeAtmDetail(id);
    }

    public List<AtmDetail> getAllAtmDetailList() {
        return atmDetailRepository.findAll();
    }

    private AtmDetail getSafeAtmDetail(long id) {
        return atmDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("atm id not found"));
    }

}
