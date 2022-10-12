package com.guavus.msscbrewery.web.controller;

import com.guavus.msscbrewery.services.CustomerService;
import com.guavus.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+customerId.toString());
        return new ResponseEntity<>(customerService.getCustomerById(customerId), headers, HttpStatus.OK);
    }

    @PostMapping({"{someString}/{id}"})
    public ResponseEntity<CustomerDto> postCustomer(@RequestBody CustomerDto customer, @PathVariable("id") UUID customerId, @PathVariable("someString") String smString) {
        System.out.println(smString);
        System.out.println(customerId.toString());
        System.out.println(customer.getCustomerId());
        System.out.println(customer.getCustomerName());
        CustomerDto savedDto = customerService.saveCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+savedDto.getCustomerId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postCustomer(@RequestBody CustomerDto customer) {
        CustomerDto savedDto = customerService.saveCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+savedDto.getCustomerId().toString());
    }
}
