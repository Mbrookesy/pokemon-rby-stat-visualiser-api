package org.mbrookesy.pokemon.visualiser.entities.Moves;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gen1_tms")
@Getter
@Setter
@NoArgsConstructor
public class Gen1Tm {

    @Id
    @Column(name = "tm_id")
    private Integer id;

    @Column(name = "tm_name")
    private String tm_name;

    @ManyToOne
    @JoinColumn(name = "move_fk")
    private Gen1Move move;
}
