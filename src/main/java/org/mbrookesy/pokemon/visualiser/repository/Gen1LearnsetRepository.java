package org.mbrookesy.pokemon.visualiser.repository;

import org.mbrookesy.pokemon.visualiser.entities.Moves.Gen1Learnset;
import org.mbrookesy.pokemon.visualiser.entities.Moves.Gen1LearnsetId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gen1LearnsetRepository
        extends JpaRepository<Gen1Learnset, Gen1LearnsetId> {

    @Query("""
        SELECT g
        FROM Gen1Learnset g
        WHERE g.id.pokemonId = :pokemonId
    """)
    List<Gen1Learnset> findLearnsetByPokemonId(@Param("pokemonId") Long pokemonId);
}