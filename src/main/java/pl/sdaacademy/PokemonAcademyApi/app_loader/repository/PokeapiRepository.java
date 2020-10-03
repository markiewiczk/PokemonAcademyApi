package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeapiRepository {

    private static final String URL =
            "https://pokeapi.co/api/v2/pokemon?offset=%d&limit=%d";

    public PokemonResponse getPokemonResponse(int offset, int limit) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                String.format(URL, offset, limit), PokemonResponse.class);
    }
}
