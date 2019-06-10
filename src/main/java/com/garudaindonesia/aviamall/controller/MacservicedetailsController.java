package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.Macservicedetails;
import com.garudaindonesia.aviamall.repository.MacservicedetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MacservicedetailsController {
@Autowired
private MacservicedetailsRepository macservicedetailsRepository;

@GetMapping("/macservicedetails")
public List<Macservicedetails> getAllMacservicedetails() {
        return macservicedetailsRepository.findAll();
        }

@GetMapping("/macservicedetails/{id}")
public ResponseEntity<Macservicedetails> getMacservicedetailsById(@PathVariable(value = "id") long macservicedetailsId)
        throws ResourceNotFoundException {
        Macservicedetails macservicedetails = macservicedetailsRepository.findById(macservicedetailsId)
        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + macservicedetailsId));
        return ResponseEntity.ok().body(macservicedetails);
        }

@PostMapping("/macservicedetails")
public Macservicedetails createMacservicedetails(@Valid @RequestBody Macservicedetails macservicedetails) {
        return macservicedetailsRepository.save(macservicedetails);
        }

@PutMapping("/macservicedetails/{id}")
public ResponseEntity<Macservicedetails> updateMacservicedetails(@PathVariable(value = "id") long macservicedetailsId,
@Valid @RequestBody Macservicedetails macserviceDetails) throws ResourceNotFoundException {
        Macservicedetails macservicedetails = macservicedetailsRepository.findById(macservicedetailsId)
        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + macservicedetailsId));

        macservicedetails.setM_ac_service_header_code(macserviceDetails.getM_ac_service_header_code());
        macservicedetails.setCode(macserviceDetails.getCode());
        macservicedetails.setTitle(macserviceDetails.getTitle());
        macservicedetails.setDescription(macserviceDetails.getDescription());
        macservicedetails.setStatus(macserviceDetails.getStatus());

        final Macservicedetails updatedMacservicedetails= macservicedetailsRepository.save(macservicedetails);
        return ResponseEntity.ok(updatedMacservicedetails);
        }

@DeleteMapping("/macservicedetails/{id}")
public Map<String, Boolean> deleteMAcservicedetails(@PathVariable(value = "id") long MacservicesetailsId)
        throws ResourceNotFoundException {
        Macservicedetails macservicedetails = macservicedetailsRepository.findById(MacservicesetailsId)
        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + MacservicesetailsId));

        macservicedetailsRepository.delete(macservicedetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        }