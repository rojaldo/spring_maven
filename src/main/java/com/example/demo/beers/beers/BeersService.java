package com.example.demo.beers.beers;

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

    public Iterable<BeerDto> getFilteredByAbvBeers(double abvGte, double abvLte) {
        List<BeerEntity> beers = this.beersRepository.findByAbvBetween(abvGte, abvLte);
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

    public Iterable<BeerDto> getFilteredByIbuBeers(double ibuGte, double ibuLte) {
        List<BeerEntity> beers = this.beersRepository.findByIbuBetween(ibuGte, ibuLte);
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

    public Iterable<BeerDto> getFilteredByEbcBeers (double ebcGte, double ebcLte) {
        List<BeerEntity> beers = this.beersRepository.findByEbcBetween(ebcGte, ebcLte);
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

    Iterable<BeerDto> getFilteredByNameBeers (String name) {
        System.out.println("name: " + name);
        List<BeerEntity> beers = this.beersRepository.findByNameContaining(name);
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

    Iterable<BeerDto> getFilteredByKeywordBeers (String keyWord) {
        List<BeerEntity> beers = this.beersRepository.findByDescriptionContaining(keyWord);
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
