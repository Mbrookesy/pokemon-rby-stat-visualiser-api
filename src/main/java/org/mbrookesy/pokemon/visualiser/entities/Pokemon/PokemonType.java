package org.mbrookesy.pokemon.visualiser.entities.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum PokemonType {
    NORMAL, FIRE, FIGHTING, WATER, FLYING, GRASS, POISON, ELECTRIC, GROUND, PSYCHIC, ROCK, ICE, BUG, DRAGON, GHOST;

    public List<PokemonType> getWeaknesses() {
        return switch (this) {
            case NORMAL   -> new ArrayList<>(List.of(FIGHTING));
            case FIGHTING -> new ArrayList<>(Arrays.asList(FLYING, PSYCHIC));
            case FLYING   -> new ArrayList<>(Arrays.asList(ROCK, ELECTRIC, ICE));
            case POISON   -> new ArrayList<>(Arrays.asList(GROUND, BUG, PSYCHIC));
            case GROUND   -> new ArrayList<>(Arrays.asList(WATER, GRASS, ICE));
            case ROCK     -> new ArrayList<>(Arrays.asList(FIGHTING, GROUND, WATER, GRASS));
            case BUG      -> new ArrayList<>(Arrays.asList(FLYING, POISON, ROCK, FIRE));
            case GHOST    -> new ArrayList<>(List.of(GHOST));
            case FIRE     -> new ArrayList<>(Arrays.asList(GROUND, ROCK, WATER));
            case WATER    -> new ArrayList<>(Arrays.asList(GRASS, ELECTRIC));
            case GRASS    -> new ArrayList<>(Arrays.asList(FLYING, POISON, BUG, FIRE, ICE));
            case ELECTRIC -> new ArrayList<>(List.of(GROUND));
            case PSYCHIC  -> new ArrayList<>(List.of(BUG));
            case ICE      -> new ArrayList<>(Arrays.asList(FIGHTING, ROCK, FIRE));
            case DRAGON   -> new ArrayList<>(Arrays.asList(ICE, DRAGON));
        };
    }

    public List<PokemonType> getResistances() {
        return switch (this) {
            case NORMAL   -> new ArrayList<>();
            case FIGHTING -> new ArrayList<>(Arrays.asList(ROCK, BUG));
            case FLYING   -> new ArrayList<>(Arrays.asList(FIGHTING, BUG, GRASS));
            case POISON   -> new ArrayList<>(Arrays.asList(FIGHTING, POISON, GRASS));
            case GROUND   -> new ArrayList<>(Arrays.asList(POISON, ROCK));
            case ROCK     -> new ArrayList<>(Arrays.asList(NORMAL, FLYING, POISON, FIRE));
            case BUG      -> new ArrayList<>(Arrays.asList(FIGHTING, GROUND, GRASS));
            case GHOST    -> new ArrayList<>(Arrays.asList(POISON, BUG));
            case FIRE     -> new ArrayList<>(Arrays.asList(BUG, FIRE, GRASS));
            case WATER    -> new ArrayList<>(Arrays.asList(FIRE, WATER, ICE));
            case GRASS    -> new ArrayList<>(Arrays.asList(GROUND, WATER, GRASS, ELECTRIC));
            case ELECTRIC -> new ArrayList<>(Arrays.asList(FLYING, ELECTRIC));
            case PSYCHIC  -> new ArrayList<>(Arrays.asList(FIGHTING, PSYCHIC));
            case ICE      -> new ArrayList<>(List.of(ICE));
            case DRAGON   -> new ArrayList<>(Arrays.asList(FIRE, WATER, GRASS, ELECTRIC));
        };
    }

    public List<PokemonType> getImmunities() {
        return switch (this) {
            case NORMAL, PSYCHIC -> new ArrayList<>(List.of(GHOST));
            case FLYING          -> new ArrayList<>(List.of(GROUND));
            case GROUND          -> new ArrayList<>(List.of(ELECTRIC));
            case GHOST           -> new ArrayList<>(Arrays.asList(NORMAL, FIGHTING));
            default              -> Collections.emptyList();
        };
    }

    public List<PokemonType> getResistancesAndImmunities() {
        return Stream.concat(getResistances().stream(), getImmunities().stream()).toList();
    }
}
