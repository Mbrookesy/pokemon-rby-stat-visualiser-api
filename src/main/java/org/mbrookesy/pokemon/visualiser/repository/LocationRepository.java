package org.mbrookesy.pokemon.visualiser.repository;

import org.mbrookesy.pokemon.visualiser.entities.Locations.GameLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<GameLocation, Long> {
    GameLocation findGameLocationByLocationId(Long locationId);
}
