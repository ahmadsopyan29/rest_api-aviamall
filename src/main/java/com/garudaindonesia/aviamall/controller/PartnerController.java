package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.Partner;
import com.garudaindonesia.aviamall.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PartnerController {
        @Autowired
        private PartnerRepository partnerRepository ;

        @GetMapping("/m_aircraft_type")
        public List<PartnerRepository> getAllPartner() {
                return partnerRepository.findAll();
        }

        @GetMapping("/m_aircraft_type/{id}")
        public ResponseEntity<PartnerRepository> getPartnerById(@PathVariable(value = "id") Long partnerId)
                throws ResourceNotFoundException {
                Partner partner = PartnerRepository.findById(partnerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Type not found for this id :: " + partnerId));
                return ResponseEntity.ok().body(partner);
        }

        @PostMapping("/m_aircraft_type")
        public PartnerRepository createType(@Valid @RequestBody Partner createType) {
                return partnerRepository.save(createType);
        }

        @PutMapping("/m_aircraft_type/{id}")
        public ResponseEntity<PartnerRepository> updateTypePartner(@PathVariable(value = "id") Long PartnerId,
                                                           @Valid @RequestBody Partner PartnerDetails) throws ResourceNotFoundException {
                Partner partner = partnerRepository.findById(PartnerId)
                        .orElseThrow(()-> new ResourceNotFoundException("Partner not found for this id :: " + PartnerId));
                partner.setName_partner(PartnerDetails.getName_partner());
                partner.setAddress_partner(PartnerDetails.getAddress_partner());
                partner.setCity_partner(PartnerDetails.getCity_partner());
                partner.setCountry(PartnerDetails.getCity_partner());
                partner.setAggre_no(PartnerDetails.getAggre_no());
                partner.setAggre_exp_date(PartnerDetails.getAggre_exp_date());
                partner.setStatus(PartnerDetails.getStatus());
                final Partner updateTypePartner( = partnerRepository.save(partner);
                return ResponseEntity.ok(updateTypePartner);
        }

        @DeleteMapping("/m_aircraft_type/{id}")
        public Map<String, Boolean> deletePartner(@PathVariable(value = "id") Long PartnerId)
                throws ResourceNotFoundException {
                Partner partner = partnerRepository.findById(PartnerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + PartnerId));

                PartnerRepository.delete(partner);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return response;
        }
}