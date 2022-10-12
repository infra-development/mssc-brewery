package com.guavus.msscbrewery.services;

import com.guavus.msscbrewery.web.model.BearDto;

import java.util.UUID;

public interface BeerService {

    public BearDto getBeerId(UUID beerId);

    BearDto saveNewBear(BearDto beerDto);
}
