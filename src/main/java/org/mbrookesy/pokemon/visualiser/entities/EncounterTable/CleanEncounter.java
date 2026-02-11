package org.mbrookesy.pokemon.visualiser.entities.EncounterTable;

public record CleanEncounter(
        String locationName,
        Boolean foundInRed,
        Boolean foundInBlue,
        Boolean foundInYellow,
        Float encounterPercentage,
        Integer levelMin,
        Integer levelMax,
        String area,
        String environment
) { }
