package pl.sdaacademy.PokemonAcademyApi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokeapiRepository;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResponse;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResult;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonLoaderService {

    private final PokeapiRepository pokeapiRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonTransformer pokemonTransformer;
    private final int startOffset;
    private final int limit;

    @Autowired
    public PokemonLoaderService(PokeapiRepository pokeapiRepository,
                                PokemonRepository pokemonRepository,
                                PokemonTransformer pokemonTransformer,
                                @Value("${pokeapi.start_offset}") int startOffset,
                                @Value("${pokeapi.limit}") int limit) {
        this.pokeapiRepository = pokeapiRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonTransformer = pokemonTransformer;
        this.startOffset = startOffset;
        this.limit = limit;
    }

    @PostConstruct
    public void loadPokemonList() {
        PokemonResponse pokemonResponse;
        List<PokemonResult> pokemonResults = new ArrayList<>();
        int offset = startOffset;
        int limit = this.limit;
        do {
            pokemonResponse =
                    pokeapiRepository.getPokemonResponse(offset, limit);
            pokemonResults.addAll(pokemonResponse.getResults());
            offset += limit;
        } while (pokemonResponse.getNext() != null);
        List<Pokemon> pokemons = pokemonTransformer.transformToPokemonList(pokemonResults);
        pokemonRepository.saveAll(pokemons);
    }
}
