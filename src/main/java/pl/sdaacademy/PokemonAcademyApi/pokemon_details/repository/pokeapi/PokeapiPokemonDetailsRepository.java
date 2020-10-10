package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeapiPokemonDetailsRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public PokeapiPokemonDetailsRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokemonDetailsResponse getPokemonDetailsResponse(String url) {
        return restTemplate.getForObject(url, PokemonDetailsResponse.class);
    }
}
