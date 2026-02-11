package org.mbrookesy.pokemon.visualiser.repository;

import org.mbrookesy.pokemon.visualiser.entities.EncounterTable.RouteEncounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncounterRepository extends JpaRepository<RouteEncounter, Long> {

    List<RouteEncounter> findByPokemonId(Long pokemonId);
}
