package com.garudaindonesia.aviamall.controller;

import com.garudaindonesia.aviamall.exception.ResourceNotFoundException;
import com.garudaindonesia.aviamall.model.Customer;
import com.garudaindonesia.aviamall.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
@Autowired
private  CustomerRepository customerRepository;

@GetMapping("/customer")
public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
        }

@GetMapping("/customer/{id}")
public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long customerId)
        throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
        }

@PostMapping("/customer")
public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
        }

@PutMapping("/customer/{id}")
public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") long customerId,
@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customer.setCode(customerDetails.getCode());
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setTelephone(customerDetails.getTelephone());
        customer.setNpwp(customerDetails.getNpwp());
        customer.setAddress(customerDetails.getAddress());
        customer.setCompany(customerDetails.getCompany());
        customer.setStatus(customerDetails.getStatus());

        final Customer updatedCustomer= customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
        }

@DeleteMapping("/customer/{id}")
public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") long customerId)
        throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        }
        }