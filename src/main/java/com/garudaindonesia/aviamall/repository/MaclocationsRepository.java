package com.garudaindonesia.aviamall.repository;


import com.garudaindonesia.aviamall.model.Maclocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaclocationsRepository extends JpaRepository<Maclocations, Long>{

}