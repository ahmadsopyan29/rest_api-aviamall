package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.MAircraftType;
import com.garudaindonesia.aviamall.repository.MAircraftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MAircraftTypeController {
@Autowired
private MAircraftTypeRepository maircrafttypeRepository;

@GetMapping("/maircrafttype")
public List<MAircraftType> getAllMAircraftType() {
        return maircrafttypeRepository.findAll();
        }

@GetMapping("/maircrafttype/{id}")
public ResponseEntity<MAircraftType> getMAircraftTypeById(@PathVariable(value = "id") long maircrafttypeId)
        throws ResourceNotFoundException {
        MAircraftType maircrafttype = maircrafttypeRepository.findById(maircrafttypeId)
        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + maircrafttypeId));
        return ResponseEntity.ok().body(maircrafttype);
        }

@PostMapping("/maircrafttype")
public MAircraftType createMAircraftType(@Valid @RequestBody MAircraftType maircrafttype) {
        return maircrafttypeRepository.save(maircrafttype);
        }

@PutMapping("/maircrafttype/{id}")
public ResponseEntity<MAircraftType> updateMAircraftType(@PathVariable(value = "id") long maircraftypeId,
@Valid @RequestBody MAircraftType maircrafttypeDetails) throws ResourceNotFoundException {
        MAircraftType maircrafttype = maircrafttypeRepository.findById(maircraftypeId)
        .orElseThrow(() -> new ResourceNotFoundException("Aircraft Type not found for this id :: " + maircraftypeId));

        maircrafttype.setCode(maircrafttypeDetails.getCode());
        maircrafttype.setDescription(maircrafttypeDetails.getDescription());
        maircrafttype.setType(maircrafttypeDetails.getType());
        maircrafttype.setRemarks(maircrafttypeDetails.getRemarks());

        final MAircraftType updatedMAircraftType= maircrafttypeRepository.save(maircrafttype);
        return ResponseEntity.ok(updatedMAircraftType);
        }

@DeleteMapping("/maircrafttype/{id}")
public Map<String, Boolean> deleteMAircraftType(@PathVariable(value = "id") long MAircraftTypeId)
        throws ResourceNotFoundException {
        MAircraftType mAircraftType = maircrafttypeRepository.findById(MAircraftTypeId)
        .orElseThrow(() -> new ResourceNotFoundException("Aircraft Type not found for this id :: " + MAircraftTypeId));

        maircrafttypeRepository.delete(mAircraftType);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        }