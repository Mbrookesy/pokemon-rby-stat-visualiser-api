package org.mbrookesy.pokemon.visualiser.controllers;

import org.mbrookesy.pokemon.visualiser.entities.EncounterTable.CleanEncounter;
import org.mbrookesy.pokemon.visualiser.entities.EncounterTable.EncounterTable;
import org.mbrookesy.pokemon.visualiser.entities.EncounterTable.RouteEncounter;
import org.mbrookesy.pokemon.visualiser.repository.EncounterRepository;
import org.mbrookesy.pokemon.visualiser.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/encounter-table")
public class EncounterTableController {
    private final EncounterRepository repository;
    private final LocationRepository locationRepository;

    public EncounterTableController(EncounterRepository repository, LocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/{id}")
    public EncounterTable getAllEncounters(@PathVariable Long id) {
        List<RouteEncounter> encounters = repository.findByPokemonId(id);

        List<CleanEncounter> cleanEncounters = new ArrayList<>();

        for(RouteEncounter encounter : encounters) {
            cleanEncounters.add(new CleanEncounter(
                    locationRepository.findGameLocationByLocationId(encounter.getLocation_id()).getLocationName(),
                    encounter.isInRedVersion(),
                    encounter.isInBlueVersion(),
                    encounter.isInYellowVersion(),
                    encounter.getEncounter_percentage(),
                    encounter.getLevel_min(),
                    encounter.getLevel_max(),
                    encounter.getArea(),
                    encounter.getEnvironment()
            ));
        }

        return new EncounterTable(cleanEncounters);
    }

}
