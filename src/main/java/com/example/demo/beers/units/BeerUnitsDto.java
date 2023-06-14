package com.example.demo.beers.units;

import com.example.demo.beers.beers.BeerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BeerUnitsDto {
    
    private int quantity;

    private BeerDto beer;
}
