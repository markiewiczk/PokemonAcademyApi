package pl.sdaacademy.PokemonAcademyApi.pokemon_details.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemon(String name) {
        Pokemon pokemon = pokemonRepository.findByName(name).orElseThrow(()->{
            throw new NoPokemonFoundException(name);
        });
        return pokemon;
    }
}
