package com.daw.pokemon.practicaSpring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon/{pokemonId}")

public class PokemonController {

    private final List<PokemonSummary> pokemonList = Arrays.asList(
            new PokemonSummary(30, "nidorina", 200,
                    List.of(new TypeSlot(new Type("poison", "https://pokeapi.co/api/v2/type/4/"), 1)),
                    List.of(
                            new AbilitySlot(new Ability("poison-point", "https://pokeapi.co/api/v2/ability/38/"), false, 1),
                            new AbilitySlot(new Ability("rivalry", "https://pokeapi.co/api/v2/ability/79/"), false, 2),
                            new AbilitySlot(new Ability("hustle", "https://pokeapi.co/api/v2/ability/55/"), true, 3)
                    ),
                    new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/30.png")
            ),
            new PokemonSummary(31, "nidoqueen", 600,
                    List.of(
                            new TypeSlot(new Type("poison", "https://pokeapi.co/api/v2/type/4/"), 1),
                            new TypeSlot(new Type("ground", "https://pokeapi.co/api/v2/type/5/"), 2)
                    ),
                    List.of(
                            new AbilitySlot(new Ability("poison-point", "https://pokeapi.co/api/v2/ability/38/"), false, 1),
                            new AbilitySlot(new Ability("rivalry", "https://pokeapi.co/api/v2/ability/79/"), false, 2),
                            new AbilitySlot(new Ability("sheer-force", "https://pokeapi.co/api/v2/ability/125/"), true, 3)
                    ),
                    new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/31.png")
            ),
            new PokemonSummary(25, "pikachu", 60,
                    List.of(new TypeSlot(new Type("electric", "https://pokeapi.co/api/v2/type/13/"), 1)),
                    List.of(
                            new AbilitySlot(new Ability("static", "https://pokeapi.co/api/v2/ability/9/"), false, 1),
                            new AbilitySlot(new Ability("lightning-rod", "https://pokeapi.co/api/v2/ability/31/"), true, 3)
                    ),
                    new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png")
            ),
            new PokemonSummary(172, "pichu", 20,
                    List.of(new TypeSlot(new Type("electric", "https://pokeapi.co/api/v2/type/13/"), 1)),
                    List.of(
                            new AbilitySlot(new Ability("static", "https://pokeapi.co/api/v2/ability/9/"), false, 1),
                            new AbilitySlot(new Ability("lightning-rod", "https://pokeapi.co/api/v2/ability/31/"), true, 3)
                    ),
                    new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/172.png")
            ),
            new PokemonSummary(26, "raichu", 300,
                    List.of(new TypeSlot(new Type("electric", "https://pokeapi.co/api/v2/type/13/"), 1)),
                    List.of(
                            new AbilitySlot(new Ability("static", "https://pokeapi.co/api/v2/ability/9/"), false, 1),
                            new AbilitySlot(new Ability("lightning-rod", "https://pokeapi.co/api/v2/ability/31/"), true, 3)
                    ),
                    new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png")
            )
    );

    public List<PokemonSummary> getPokemonList() {
        return pokemonList;
    }
}