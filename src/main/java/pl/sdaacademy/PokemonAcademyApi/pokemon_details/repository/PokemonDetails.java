package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class PokemonDetails {
    @ElementCollection
    private List<String> abilities;
    @ElementCollection
    private List<String> types;
    private String imageUrl;
    private int weight;
    private int height;
    @Id
    private String name;

    public PokemonDetails() {

    }

    public PokemonDetails(List<String> abilities, List<String> types, String imageUrl, int weight, int height, String name) {
        this.abilities = abilities;
        this.types = types;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.height = height;
        this.name = name;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
