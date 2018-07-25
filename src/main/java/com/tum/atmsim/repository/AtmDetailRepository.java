package com.tum.atmsim.repository;

import com.tum.atmsim.repository.entity.AtmDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmDetailRepository extends JpaRepository<AtmDetail, Long> {

}
