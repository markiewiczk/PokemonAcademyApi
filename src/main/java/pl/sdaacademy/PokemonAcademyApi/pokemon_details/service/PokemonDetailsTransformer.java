package pl.sdaacademy.PokemonAcademyApi.pokemon_details.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.PokemonDetailsResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonDetailsTransformer {

    public PokemonDetails transformToPokemonDetails(
            PokemonDetailsResponse pokemonDetailsResponse) {
        String name = pokemonDetailsResponse.getName();
        int height = pokemonDetailsResponse.getHeight();
        int weight = pokemonDetailsResponse.getWeight();
        String imageUrl = pokemonDetailsResponse
                .getSprites()
                .getOther()
                .getOfficialArtwork()
                .getImageUrl();

        List<String> abilities = pokemonDetailsResponse.getAbilities()
                .stream().map(
                        (ability -> ability.getAbilityDetails().getName()))
                .collect(Collectors.toList());

        List<String> types = pokemonDetailsResponse.getTypes()
                .stream().map(type -> type.getTypeDetails().getName())
                .collect(Collectors.toList());
        return new PokemonDetails(abilities,
                types,
                imageUrl,
                weight,
                height,
                name);
    }
}
