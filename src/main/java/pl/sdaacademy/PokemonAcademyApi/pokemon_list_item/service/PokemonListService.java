package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonListItem;

import java.util.List;

@Service
public class PokemonListService {

    private final PokemonRepository pokemonRepository;

    public PokemonListService(PokemonRepository pokemonRepository) {
         this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonListItem> getPokemonListItem() {
        //map response from pokeapi based on url https://pokeapi.co/api/v2/ability/51/
        // to PokemonListItem
        pokemonRepository.findAll()
                .stream().map()

    }
}
