package com.example.demo.beers.units;

import com.example.demo.beers.beers.BeerEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BeerUnitsRequest {
    
    private int quantity;

    @JsonProperty("beer_id")
    private long beerId;
}
