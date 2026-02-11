package org.mbrookesy.pokemon.visualiser.entities.Locations;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gen1_places")
@Getter
@Setter
@NoArgsConstructor
public class GameLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String locationName;

    public GameLocation(Long locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }
}
