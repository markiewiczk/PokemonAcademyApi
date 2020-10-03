package pl.sdaacademy.PokemonAcademyApi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokeapiRepository;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonRepository;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResponse;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonLoaderService {

    private final PokeapiRepository pokeapiRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonLoaderService(PokeapiRepository pokeapiRepository, PokemonRepository pokemonRepository) {
        this.pokeapiRepository = pokeapiRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public void loadPokemonList() {
        PokemonResponse pokemonResponse;
        List<PokemonResult> pokemonResults = new ArrayList<>();
        int offset = 0;
        int limit = 20;
        do {
            pokemonResponse =
                    pokeapiRepository.getPokemonResponse(offset, limit);
            pokemonResults.addAll(pokemonResponse.getResults());
            offset+=limit;
        } while (pokemonResponse.getNext() != null);
    }
}
