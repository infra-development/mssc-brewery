package com.guavus.msscbrewery.services;

import com.guavus.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    public CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customer);
}
