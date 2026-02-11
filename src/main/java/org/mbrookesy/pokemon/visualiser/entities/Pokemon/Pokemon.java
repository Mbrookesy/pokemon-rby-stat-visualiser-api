package org.mbrookesy.pokemon.visualiser.entities.Pokemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("unused")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private PokemonType type1;

    private PokemonType type2;

    private int hp;
    private int attack;
    private int defense;
    private int special;
    private int speed;

    public Pokemon(Long id, String name, PokemonType type1, PokemonType type2, int hp, int attack, int defense, int special, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.special = special;
        this.speed = speed;
    }

    public int getStatTotal() {
        return this.hp + this.attack + this.defense + this.speed + this.special;
    }
}
