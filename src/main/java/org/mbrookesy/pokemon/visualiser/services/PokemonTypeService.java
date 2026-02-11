package org.mbrookesy.pokemon.visualiser.services;

import org.mbrookesy.pokemon.visualiser.entities.Pokemon.Pokemon;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonResistances;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonType;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonWeaknesses;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PokemonTypeService {

    public PokemonWeaknesses getTypeWeaknesses(Pokemon pokemon) {
        PokemonType type1 = pokemon.getType1();
        PokemonType type2 = pokemon.getType2();

        if (type2 == null) {
            return new PokemonWeaknesses(type1.getWeaknesses(), Collections.emptyList());
        } else {
            List<PokemonType> filteredType1Weaknesses = type1.getWeaknesses().stream().filter(type -> !type2.getResistancesAndImmunities().contains(type)).toList();
            List<PokemonType> filteredType2Weaknesses = type2.getWeaknesses().stream().filter(type -> !type1.getResistancesAndImmunities().contains(type)).toList();

            Map<Boolean, List<PokemonType>> partitionedList = Stream.concat(filteredType1Weaknesses.stream(), filteredType2Weaknesses.stream())
                    .collect(groupingBy(type -> type, counting()))
                    .entrySet().stream()
                    .collect(partitioningBy(entry -> entry.getValue() > 1, mapping(Map.Entry::getKey, toList())));

            List<PokemonType> singleWeaknessList = partitionedList.get(false);
            List<PokemonType> doubleWeaknessList = partitionedList.get(true);

            singleWeaknessList.sort(Comparator.comparing(Enum::name));
            doubleWeaknessList.sort(Comparator.comparing(Enum::name));

            return new PokemonWeaknesses(singleWeaknessList, doubleWeaknessList);
        }
    }

    public PokemonResistances getTypeResistances(Pokemon pokemon) {
        PokemonType type1 = pokemon.getType1();
        PokemonType type2 = pokemon.getType2();

        if (type2 == null) {
            return new PokemonResistances(type1.getResistances(), Collections.emptyList(), type1.getImmunities());
        } else {
            List<PokemonType> filteredType1Resistances = type1.getResistances().stream().filter(type -> !type2.getWeaknesses().contains(type)).toList();
            List<PokemonType> filteredType2Resistances = type2.getResistances().stream().filter(type -> !type1.getWeaknesses().contains(type)).toList();

            Map<Boolean, List<PokemonType>> partitionedList = Stream.concat(filteredType1Resistances.stream(), filteredType2Resistances.stream())
                    .collect(groupingBy(type -> type, counting()))
                    .entrySet().stream()
                    .collect(partitioningBy(entry -> entry.getValue() > 1, mapping(Map.Entry::getKey, toList())));


            List<PokemonType> immunities = new ArrayList<>(Stream.concat(type1.getImmunities().stream(), type2.getImmunities().stream()).collect(toSet()).stream().toList());
            List<PokemonType> singleResistanceList = partitionedList.get(false);
            List<PokemonType> doubleResistanceList = partitionedList.get(true);

            singleResistanceList.sort(Comparator.comparing(Enum::name));
            doubleResistanceList.sort(Comparator.comparing(Enum::name));
            immunities.sort(Comparator.comparing(Enum::name));

            singleResistanceList.removeAll(immunities);
            doubleResistanceList.removeAll(immunities);

            return new PokemonResistances(singleResistanceList, doubleResistanceList, immunities);
        }
    }
}
