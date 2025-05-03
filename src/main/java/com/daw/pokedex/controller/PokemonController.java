package com.daw.pokedex.controller;

import com.daw.pokedex.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PokemonController {

    // Lista de Pokémon de ejemplo
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

    // Endpoint para obtener un Pokémon por ID
    @GetMapping("/pokemon/{pokemonId}")
    public Pokemon getPokemonById(@PathVariable int pokemonId) {
        // Buscar el Pokémon en la lista por ID
        Optional<PokemonSummary> pokemonSummary = pokemonList.stream()
                .filter(p -> p.getId() == pokemonId)
                .findFirst();

        if (pokemonSummary.isPresent()) {
            // Convertir PokemonSummary a Pokemon (aquí deberías agregar las evoluciones si las tienes)
            PokemonSummary summary = pokemonSummary.get();
            return new Pokemon(
                    summary.getId(),
                    summary.getName(),
                    summary.getWeight(),
                    summary.getTypes(),
                    summary.getAbilities(),
                    summary.getSprites(),
                    getEvolutions(summary.getId()) // Método para obtener evoluciones (implementar según necesidad)
            );
        } else {
            throw new RuntimeException("Pokémon no encontrado con ID: " + pokemonId);
        }
    }

    // Endpoint para obtener lista paginada de Pokémon
    @GetMapping("/pokedex")
    public PokemonListResponse getPokedex(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit) {

        // Aplicar paginación
        List<PokemonSummary> sublist = pokemonList.stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

        // Crear respuesta con paginación
        return new PokemonListResponse(pokemonList.size(), sublist);
    }

    // Método auxiliar para obtener evoluciones (debes implementarlo según tus necesidades)
    private List<Evolution> getEvolutions(int pokemonId) {
        // Aquí deberías implementar la lógica para obtener las evoluciones
        // Por ahora devolvemos una lista vacía
        return List.of();
    }
}