package org.mbrookesy.pokemon.visualiser.repository;

import org.mbrookesy.pokemon.visualiser.entities.Moves.Gen1TmLearnset;
import org.mbrookesy.pokemon.visualiser.entities.Moves.Gen1TmLearnsetId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Gen1TmLearnsetRepository
        extends JpaRepository<Gen1TmLearnset, Gen1TmLearnsetId> {

    List<Gen1TmLearnset> findLearnsetByPokemonId(Long pokemonId);
}
