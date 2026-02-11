package org.mbrookesy.pokemon.visualiser.controllers;

import org.mbrookesy.pokemon.visualiser.entities.Pokemon.*;
import org.mbrookesy.pokemon.visualiser.repository.PokemonRepository;
import org.mbrookesy.pokemon.visualiser.services.PokemonTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonRepository repository;
    PokemonTypeService typeService = new PokemonTypeService();

    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PokemonSummary> getAllNames() {
        return repository.findAllPokemonWithNames();
    }

    @GetMapping("/{id}")
    public FullPokemon getByDexNumber(@PathVariable Long id) {
        Pokemon pokemon = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon not found"));
        PokemonWeaknesses weaknesses = typeService.getTypeWeaknesses(pokemon);
        PokemonResistances resistances = typeService.getTypeResistances(pokemon);

        return new FullPokemon(pokemon, weaknesses, resistances);
    }
}
