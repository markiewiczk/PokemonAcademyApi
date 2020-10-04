package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonService;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return pokemonService.getPokemon(name);
    }
}
