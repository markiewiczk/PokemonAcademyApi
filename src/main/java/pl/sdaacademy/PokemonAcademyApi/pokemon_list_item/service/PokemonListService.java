package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokeapiPokemonListItemRepository;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonListItem;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonListService {

    private final PokemonRepository pokemonRepository;
    private final PokeapiPokemonListItemRepository pokeapiPokemonListItemRepository;
    private final PokemonListItemTransformer pokemonListItemTransformer;

    public PokemonListService(PokemonRepository pokemonRepository,
                              PokeapiPokemonListItemRepository pokeapiPokemonListItemRepository,
                              PokemonListItemTransformer pokemonListItemTransformer) {
         this.pokemonRepository = pokemonRepository;
         this.pokeapiPokemonListItemRepository = pokeapiPokemonListItemRepository;
         this.pokemonListItemTransformer = pokemonListItemTransformer;
    }

    public List<PokemonListItem> getPokemonListItem() {
        ///zestaw danych 100 elementów
        //strona 1: 1-10
        //strona 2: 11-20
        //strona 3: 21-30
        Pageable pageable = PageRequest.of(3, 10);
        return pokemonRepository.findAll()
                .stream()
                .map(Pokemon::getUrl)
                .map(pokeapiPokemonListItemRepository::getPokemonListItemResponse)
                .map(pokemonListItemTransformer::transformToPokemonListItem)
                .collect(Collectors.toList());
    }
}
