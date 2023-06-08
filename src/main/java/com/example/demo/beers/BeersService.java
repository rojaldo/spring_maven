package com.example.demo.beers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BeersService {

    @Autowired
    BeersRepository beersRepository;

    public BeerDto[] getBeersFromApi() {
        BeerDto[] beersDto = new RestTemplate().getForObject("https://api.punkapi.com/v2/beers", BeerDto[].class);
        for (BeerDto beerDto : beersDto) {
            beersRepository.save(BeerEntity.builder()
                    .name(beerDto.getName())
                    .description(beerDto.getDescription())
                    .tagline(beerDto.getTagline())
                    .firstBrewed(beerDto.getFirstBrewed())
                    .imageUrl(beerDto.getImageUrl())
                    .abv(beerDto.getAbv())
                    .ebc(beerDto.getEbc())
                    .ibu(beerDto.getIbu())
                    .build());
        }
        return beersDto;
    }

    public Iterable<BeerDto> getAllBeers() {
        List<BeerEntity> beers = this.beersRepository.findAll();
        List<BeerDto> beersDto = new ArrayList<>();
        for (BeerEntity beer : beers) {
            beersDto.add(BeerDto.builder()
                    .name(beer.getName())
                    .description(beer.getDescription())
                    .tagline(beer.getTagline())
                    .firstBrewed(beer.getFirstBrewed())
                    .imageUrl(beer.getImageUrl())
                    .abv(beer.getAbv())
                    .ebc(beer.getEbc())
                    .ibu(beer.getIbu())
                    .build());
        }
        return beersDto;
    }

    // get beers with abv greater than x
    public Iterable<BeerDto> getBeers(double abv) {
        List<BeerEntity> beers = this.beersRepository.findByAbvGreaterThanEqual(abv);
        List<BeerDto> beersDto = new ArrayList<>();
        for (BeerEntity beer : beers) {
            beersDto.add(BeerDto.builder()
                    .name(beer.getName())
                    .description(beer.getDescription())
                    .tagline(beer.getTagline())
                    .firstBrewed(beer.getFirstBrewed())
                    .imageUrl(beer.getImageUrl())
                    .abv(beer.getAbv())
                    .ebc(beer.getEbc())
                    .ibu(beer.getIbu())
                    .build());
        }
        return beersDto;
    }
    
}
