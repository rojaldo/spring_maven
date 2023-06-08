package com.example.demo.beers;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeersRepository extends JpaRepository<BeerEntity, Long> {

    BeerEntity findById(long id);
    BeerEntity findByName(String name);
    // find by abv greater than or equal to
    List<BeerEntity> findByAbvGreaterThanEqual(double abv);

}
