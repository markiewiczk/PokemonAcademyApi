package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailsService;

import java.util.List;

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
        return pokemonDetailsService.getPokemonDetails(name);
    }

    @GetMapping
    public List<PokemonDetails> getPokemons(@RequestParam List<String> name) {
        return pokemonDetailsService.getPokemonDetails(name);
    }

}
