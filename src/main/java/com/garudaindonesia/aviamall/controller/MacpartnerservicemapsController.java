package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.Macpartnerservicemaps;
import com.garudaindonesia.aviamall.repository.MacpartnerservicemapsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MacpartnerservicemapsController {
@Autowired
private MacpartnerservicemapsRepository macpartnerservicemapsRepository;

@GetMapping("/macpartnerservicemaps")
public List<Macpartnerservicemaps> getAllMacpartnerservicemaps() {
        return macpartnerservicemapsRepository.findAll();
        }

@GetMapping("/macpartnerservicemaps/{id}")
public ResponseEntity<Macpartnerservicemaps> getMacpartnerservicemapsById(@PathVariable(value = "id") long macpartnerservicemapsId)
        throws ResourceNotFoundException {
        Macpartnerservicemaps macpartnerservicemaps = macpartnerservicemapsRepository.findById(macpartnerservicemapsId)
        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + macpartnerservicemapsId));
        return ResponseEntity.ok().body(macpartnerservicemaps);
        }

@PostMapping("/macpartnerservicemaps")
public Macpartnerservicemaps createMacpartnerservicemaps(@Valid @RequestBody Macpartnerservicemaps macpartnerservicemaps) {
        return macpartnerservicemapsRepository.save(macpartnerservicemaps);
        }

@PutMapping("/macpartnerservicemaps/{id}")
public ResponseEntity<Macpartnerservicemaps> updateMacpartnerservicemaps(@PathVariable(value = "id") long macpartnerservicemapsId,
@Valid @RequestBody Macpartnerservicemaps macpartnerservicemapsDetails) throws ResourceNotFoundException {
        Macpartnerservicemaps macpartnerservicemaps = macpartnerservicemapsRepository.findById(macpartnerservicemapsId)
        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + macpartnerservicemapsId));

        macpartnerservicemaps.setM_ac_service_details_code(macpartnerservicemapsDetails.getM_ac_service_details_code());
        macpartnerservicemaps.setM_partner_maps_id(macpartnerservicemapsDetails.getM_partner_maps_id());


        final Macpartnerservicemaps updatedMacpartnerservicemaps= macpartnerservicemapsRepository.save(macpartnerservicemaps);
        return ResponseEntity.ok(updatedMacpartnerservicemaps);
        }

@DeleteMapping("/macpartnerservicemaps/{id}")
public Map<String, Boolean> deleteMAclocations(@PathVariable(value = "id") long MacpartnerservicemapsId)
        throws ResourceNotFoundException {
        Macpartnerservicemaps macpartnerservicemaps = macpartnerservicemapsRepository.findById(MacpartnerservicemapsId)
        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + MacpartnerservicemapsId));

        macpartnerservicemapsRepository.delete(macpartnerservicemaps);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
}