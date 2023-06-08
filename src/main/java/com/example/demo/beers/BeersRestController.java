package com.example.demo.beers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BeersRestController {

    @Autowired
    BeersService beersService;
    
    @GetMapping("/beers")
    public ResponseEntity<Iterable<BeerDto>> getBeers(@RequestParam(required = false, defaultValue = "0") Double abv) {
        if (abv > 0) {
            return ResponseEntity.status(200).body(this.beersService.getBeers(abv));
        }
        return ResponseEntity.status(200).body(this.beersService.getAllBeers());
    }

}
