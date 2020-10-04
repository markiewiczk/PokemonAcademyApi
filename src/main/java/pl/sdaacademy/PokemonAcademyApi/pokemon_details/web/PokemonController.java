package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailsService;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    private final PokemonDetailsService pokemonDetailsService;

    @Autowired
    public PokemonController(PokemonDetailsService pokemonDetailsService) {
        this.pokemonDetailsService = pokemonDetailsService;
    }

    @GetMapping("/{name}")
    public PokemonDetails getPokemon(@PathVariable String name) {
        return pokemonDetailsService.getPokemon(name);
    }
}
