package org.mbrookesy.pokemon.visualiser.entities.Pokemon;

import java.util.List;

public record PokemonResistances(List<PokemonType> resistances, List<PokemonType> doubleResistances, List<PokemonType> immunities) { }