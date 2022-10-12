package com.guavus.msscbrewery.services;

import com.guavus.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().customerId(UUID.randomUUID())
                .customerName("Haresh").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customer) {
        return CustomerDto.builder().customerId(UUID.randomUUID()).build();
    }
}
