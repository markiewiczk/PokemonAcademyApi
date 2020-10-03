package pl.sdaacademy.PokemonAcademyApi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonLoaderService {

    private final PokeapiRepository pokeapiRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonLoaderService(PokeapiRepository pokeapiRepository, PokemonRepository pokemonRepository) {
        this.pokeapiRepository = pokeapiRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @PostConstruct
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
        List<Pokemon> pokemons = pokemonResults.stream()
                .map(pokemonResult -> {
                    String[] urlData = pokemonResult.getUrl().split("/");
                    int id = Integer.parseInt(urlData[urlData.length - 1]);
                    return new Pokemon(id, pokemonResult.getName(), pokemonResult.getUrl());
                }).collect(Collectors.toList());
        pokemonRepository.saveAll(pokemons);
    }
}
