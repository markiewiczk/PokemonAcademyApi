package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {

    @JsonProperty("ability")
    private AbilityDetails abilityDetails;

    public AbilityDetails getAbilityDetails() {
        return abilityDetails;
    }

    public void setAbilityDetails(AbilityDetails abilityDetails) {
        this.abilityDetails = abilityDetails;
    }
}
