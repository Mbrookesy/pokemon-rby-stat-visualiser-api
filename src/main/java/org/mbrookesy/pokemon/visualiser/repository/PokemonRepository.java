package org.mbrookesy.pokemon.visualiser.repository;

import org.mbrookesy.pokemon.visualiser.entities.Pokemon.Pokemon;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query("SELECT p.id AS id, p.name AS name FROM Pokemon p")
    List<PokemonSummary> findAllPokemonWithNames();

}
