package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;

import com.garudaindonesia.aviamall.model.Maclocations;
import com.garudaindonesia.aviamall.repository.MaclocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MaclocationsController {
@Autowired
private MaclocationsRepository maclocationsRepository;

@GetMapping("/maclocations")
public List<Maclocations> getAllMaclocations() {
        return maclocationsRepository.findAll();
        }

@GetMapping("/maclocations/{id}")
public ResponseEntity<Maclocations> getMaclocationsById(@PathVariable(value = "id") long maclocationsId)
        throws ResourceNotFoundException {
        Maclocations maclocations = maclocationsRepository.findById(maclocationsId)
        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + maclocationsId));
        return ResponseEntity.ok().body(maclocations);
        }

@PostMapping("/maclocations")
public Maclocations createMaclocations(@Valid @RequestBody Maclocations maclocations) {
        return maclocationsRepository.save(maclocations);
        }

@PutMapping("/maclocations/{id}")
public ResponseEntity<Maclocations> updateMaclocations(@PathVariable(value = "id") long maclocationsId,
@Valid @RequestBody Maclocations maclocationsDetails) throws ResourceNotFoundException {
        Maclocations maclocations = maclocationsRepository.findById(maclocationsId)
        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + maclocationsId));

        maclocations.setCode(maclocationsDetails.getCode());
        maclocations.setType(maclocationsDetails.getType());
        maclocations.setName(maclocationsDetails.getName());
        maclocations.setAddress(maclocationsDetails.getAddress());
        maclocations.setCity(maclocationsDetails.getCity());
        maclocations.setCountry(maclocationsDetails.getCountry());
        maclocations.setLattitude(maclocationsDetails.getLattitude());
        maclocations.setLongitude(maclocationsDetails.getLongitude());
        maclocations.setStatus(maclocationsDetails.getStatus());

        final Maclocations updatedMaclocations= maclocationsRepository.save(maclocations);
        return ResponseEntity.ok(updatedMaclocations);
        }

@DeleteMapping("/maclocations/{id}")
public Map<String, Boolean> deleteMAclocations(@PathVariable(value = "id") long MaclocationsId)
        throws ResourceNotFoundException {
        Maclocations maclocations = maclocationsRepository.findById(MaclocationsId)
        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + MaclocationsId));

        maclocationsRepository.delete(maclocations);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        }