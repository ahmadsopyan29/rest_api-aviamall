package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.MAircraftType;
import com.garudaindonesia.aviamall.repository.MAircraftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MAircraftTypeController {
@Autowired
private MAircraftTypeRepository maircrafttypeRepository;

@GetMapping("/m_aircraft_type")
public List<MAircraftType> getAllMAircraftType() {
        return maircrafttypeRepository.findAll();
        }

@GetMapping("/m_aircraft_type/{id}")
public ResponseEntity<MAircraftType> getMAircraftTypeById(@PathVariable(value = "id") Long maircrafttypeId)
        throws ResourceNotFoundException {
        MAircraftType m_aircraft_type = maircrafttypeRepository.findById(maircrafttypeId)
        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + maircrafttypeId));
        return ResponseEntity.ok().body(m_aircraft_type);
        }

@PostMapping("/m_aircraft_type")
public MAircraftType createType(@Valid @RequestBody MAircraftType createType) {
        return maircrafttypeRepository.save(createType);
        }

@PutMapping("/m_aircraft_type/{id}")
public ResponseEntity<MAircraftType> updateTypeAir(@PathVariable(value = "id") Long MAircraftTypeId,
@Valid @RequestBody MAircraftType MAircraftTypeDetails) throws ResourceNotFoundException {
        MAircraftType mAircraftType = maircrafttypeRepository.findById(MAircraftTypeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + MAircraftTypeId));

        mAircraftType.setDescription(MAircraftTypeDetails.getDescription());
        mAircraftType.setDescription(MAircraftTypeDetails.getDescription());
final MAircraftType updatedMAircraftType= maircrafttypeRepository.save(mAircraftType);
        return ResponseEntity.ok(updatedMAircraftType);
        }

@DeleteMapping("/m_aircraft_type/{id}")
public Map<String, Boolean> deleteMAircraftType(@PathVariable(value = "id") Long MAircraftTypeId)
        throws ResourceNotFoundException {
        MAircraftType mAircraftType = maircrafttypeRepository.findById(MAircraftTypeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + MAircraftTypeId));

        maircrafttypeRepository.delete(mAircraftType);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        }