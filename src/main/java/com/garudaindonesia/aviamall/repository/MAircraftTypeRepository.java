package com.garudaindonesia.aviamall.repository;

import com.garudaindonesia.aviamall.model.MAircraftType;
import com.garudaindonesia.aviamall.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MAircraftTypeRepository extends JpaRepository<MAircraftType, Long>{

}