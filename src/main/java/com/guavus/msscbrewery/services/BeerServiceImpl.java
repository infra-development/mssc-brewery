package com.guavus.msscbrewery.services;

import com.guavus.msscbrewery.web.model.BearDto;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BearDto getBeerId(UUID beerId) {
        return BearDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BearDto saveNewBear(BearDto beerDto) {
        return BearDto.builder().id(UUID.randomUUID()).build();

    }
}
