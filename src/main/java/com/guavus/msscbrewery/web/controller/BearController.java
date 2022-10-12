package com.guavus.msscbrewery.web.controller;

import com.guavus.msscbrewery.services.BeerService;
import com.guavus.msscbrewery.services.CustomerService;
import com.guavus.msscbrewery.web.model.BearDto;
import com.guavus.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BearController {

    private final BeerService beerService;

    public BearController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BearDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping({"/{beerId}"})
    public ResponseEntity handlePost(BearDto beerDto) {
        BearDto savedDto = beerService.saveNewBear(beerDto);
        HttpHeaders httpHeader = new HttpHeaders();
        //todo add hostname to the url
        httpHeader.add("Location", "/api/v1/beer/"+savedDto.getId().toString());
        return new ResponseEntity(httpHeader, HttpStatus.CREATED);
    }

}
