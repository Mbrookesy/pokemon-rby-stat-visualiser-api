package org.mbrookesy.pokemon.visualiser.services;

import org.junit.jupiter.api.Test;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.Pokemon;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonResistances;
import org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonWeaknesses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mbrookesy.pokemon.visualiser.entities.Pokemon.PokemonType.*;

public class PokemonTypeServiceTests {

    Pokemon basePokemon = new Pokemon(100L, "TestPokemon", null, null, 10, 10, 10 ,10 , 10);

    @Test
    void weaknessWith1TypeTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(ROCK);

        PokemonWeaknesses result = typeService.getTypeWeaknesses(basePokemon);

        PokemonWeaknesses expectedResult = new PokemonWeaknesses(
                Arrays.asList(FIGHTING, GROUND, WATER, GRASS),
                Collections.emptyList()
        );

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void weaknessWith2TypeTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(BUG);
        basePokemon.setType2(GRASS);

        PokemonWeaknesses result = typeService.getTypeWeaknesses(basePokemon);

        PokemonWeaknesses expectedResult = new PokemonWeaknesses(
                Arrays.asList(BUG, ICE, ROCK),
                Arrays.asList(FIRE, FLYING, POISON)
        );

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void resistanceWith1TypeTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(ROCK);

        PokemonResistances result = typeService.getTypeResistances(basePokemon);

        PokemonResistances expectedResult = new PokemonResistances(
                (Arrays.asList(NORMAL, FLYING, POISON, FIRE)),
                Collections.emptyList(),
                Collections.emptyList()
        );

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void resistanceWith2TypeTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(BUG);
        basePokemon.setType2(GRASS);

        PokemonResistances result = typeService.getTypeResistances(basePokemon);

        PokemonResistances expectedResult = new PokemonResistances(
                Arrays.asList(ELECTRIC, FIGHTING, WATER),
                Arrays.asList(GRASS, GROUND),
                Collections.emptyList());

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void resistanceWith1ImmunityTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(ROCK);
        basePokemon.setType2(GROUND);

        PokemonResistances result = typeService.getTypeResistances(basePokemon);

        PokemonResistances expectedResult = new PokemonResistances(
                Arrays.asList(FIRE, FLYING, NORMAL, ROCK),
                List.of(POISON),
                List.of(ELECTRIC)
        );

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void resistanceWith2ImmunitiesTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(GHOST);
        basePokemon.setType2(NORMAL);

        PokemonResistances result = typeService.getTypeResistances(basePokemon);

        PokemonResistances expectedResult = new PokemonResistances(
                Arrays.asList(BUG, POISON),
                Collections.emptyList(),
                Arrays.asList(FIGHTING, GHOST, NORMAL)
        );

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void resistanceWithSharedImmunityAndResistanceTest() {
        PokemonTypeService typeService = new PokemonTypeService();

        basePokemon.setType1(GHOST);
        basePokemon.setType2(ROCK);

        PokemonResistances result = typeService.getTypeResistances(basePokemon);

        PokemonResistances expectedResult = new PokemonResistances(
                Arrays.asList(BUG, FIRE, FLYING),
                List.of(POISON),
                Arrays.asList(FIGHTING, NORMAL)
        );

        assertThat(result).isEqualTo(expectedResult);
    }
}
