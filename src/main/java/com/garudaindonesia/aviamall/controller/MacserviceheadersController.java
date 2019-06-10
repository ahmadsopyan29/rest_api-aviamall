package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.Macserviceheaders;
import com.garudaindonesia.aviamall.repository.MacserviceheadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MacserviceheadersController {
        @Autowired
        private MacserviceheadersRepository macserviceheadersRepository;

        @GetMapping("/macserviceheaders")
        public List<Macserviceheaders> getAllMacserviceheaders() {
                return macserviceheadersRepository.findAll();
        }

        @GetMapping("/macserviceheaders/{id}")
        public ResponseEntity<Macserviceheaders> getMacserviceheadersById(@PathVariable(value = "id") long macserviceheadersId)
                throws ResourceNotFoundException {
                Macserviceheaders macserviceheaders = macserviceheadersRepository.findById(macserviceheadersId)
                        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + macserviceheadersId));
                return ResponseEntity.ok().body(macserviceheaders);
        }

        @PostMapping("/macserviceheaders")
        public Macserviceheaders createMacserviceheaders(@Valid @RequestBody Macserviceheaders macserviceheaders) {
                return macserviceheadersRepository.save(macserviceheaders);
        }

        @PutMapping("/macserviceheaders/{id}")
        public ResponseEntity<Macserviceheaders> updateMacserviceheaders(@PathVariable(value = "id") long macserviceheadersId,
                @Valid @RequestBody Macserviceheaders macserviceHeaders) throws ResourceNotFoundException {
                Macserviceheaders macserviceheaders = macserviceheadersRepository.findById(macserviceheadersId)
                        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + macserviceheadersId));

                macserviceheaders.setCode(macserviceHeaders.getCode());
                macserviceheaders.setDescription(macserviceHeaders.getDescription());

                final Macserviceheaders updatedMacserviceheaders= macserviceheadersRepository.save(macserviceheaders);
                return ResponseEntity.ok(updatedMacserviceheaders);
        }

        @DeleteMapping("/macserviceheaders/{id}")
        public Map<String, Boolean> deleteMAcserviceheaders(@PathVariable(value = "id") long MacservicesetailsId)
                throws ResourceNotFoundException {
                Macserviceheaders macserviceheaders = macserviceheadersRepository.findById(MacservicesetailsId)
                        .orElseThrow(() -> new ResourceNotFoundException("Ac Location not found for this id :: " + MacservicesetailsId));

                macserviceheadersRepository.delete(macserviceheaders);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return response;
        }
}