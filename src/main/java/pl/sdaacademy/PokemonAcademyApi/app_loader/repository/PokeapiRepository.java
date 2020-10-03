package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeapiRepository {
    private final String urlAddress;
    private final RestTemplate restTemplate;

    @Autowired
    public PokeapiRepository(RestTemplate restTemplate, @Value("${pokeapi.url}") String urlAddress) {
        this.restTemplate = restTemplate;
        this.urlAddress = urlAddress;
    }

    public PokemonResponse getPokemonResponse(int offset, int limit) {
        return restTemplate.getForObject(
                String.format(urlAddress, offset, limit), PokemonResponse.class);
    }
}
