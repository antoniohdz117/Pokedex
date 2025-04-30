import java.util.*;

class PokemonSummary {
    private int id;
    private String name;
    private int weight;
    private List<TypeSlot> types;
    private List<AbilitySlot> abilities;
    private Sprite sprites;
    // Getters and setters


    public PokemonSummary(int id, String name, int weight, List<TypeSlot> types, List<AbilitySlot> abilities, Sprite sprites) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.types = types;
        this.abilities = abilities;
        this.sprites = sprites;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<TypeSlot> getTypes() {
        return types;
    }

    public List<AbilitySlot> getAbilities() {
        return abilities;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTypes(List<TypeSlot> types) {
        this.types = types;
    }

    public void setAbilities(List<AbilitySlot> abilities) {
        this.abilities = abilities;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }
}

