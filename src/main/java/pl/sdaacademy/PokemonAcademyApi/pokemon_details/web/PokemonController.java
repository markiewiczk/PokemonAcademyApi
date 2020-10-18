package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailsService;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonList;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.service.PokemonListService;

import java.util.List;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    private final PokemonDetailsService pokemonDetailsService;
    private final PokemonListService pokemonListService;

    @Autowired
    public PokemonController(PokemonDetailsService pokemonDetailsService,
                             PokemonListService pokemonListService) {
        this.pokemonDetailsService = pokemonDetailsService;
        this.pokemonListService = pokemonListService;
    }

    @GetMapping("/{name}")
    @CrossOrigin
    public PokemonDetails getPokemon(@PathVariable String name) {
        return pokemonDetailsService.getPokemonDetails(name);
    }

    @GetMapping
    @CrossOrigin
    public List<PokemonDetails> getPokemons(@RequestParam List<String> name) {
        return pokemonDetailsService.getPokemonDetails(name);
    }

    @GetMapping("/list")
    @CrossOrigin
    public PokemonList getPokemonsList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return pokemonListService.getPokemonListItem(page, size);
    }
}
