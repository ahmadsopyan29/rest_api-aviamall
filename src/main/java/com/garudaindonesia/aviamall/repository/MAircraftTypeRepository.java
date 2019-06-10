package com.garudaindonesia.aviamall.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garudaindonesia.aviamall.model.MAircraftType;

@Repository
public interface MAircraftTypeRepository extends JpaRepository<MAircraftType, Long>{

}