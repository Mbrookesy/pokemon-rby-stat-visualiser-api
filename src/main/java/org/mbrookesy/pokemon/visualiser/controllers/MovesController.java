package org.mbrookesy.pokemon.visualiser.controllers;

import org.mbrookesy.pokemon.visualiser.entities.Moves.*;
import org.mbrookesy.pokemon.visualiser.repository.Gen1LearnsetRepository;
import org.mbrookesy.pokemon.visualiser.repository.Gen1TmLearnsetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moveset")
public class MovesController {
    private final Gen1LearnsetRepository gen1LearnsetRepository;
    private final Gen1TmLearnsetRepository gen1TmLearnsetRepository;

    public MovesController(Gen1LearnsetRepository gen1LearnsetRepository, Gen1TmLearnsetRepository gen1TmLearnsetRepository) {
        this.gen1LearnsetRepository = gen1LearnsetRepository;
        this.gen1TmLearnsetRepository = gen1TmLearnsetRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPokemonWithLearnset(@PathVariable Long id) {

        List<Gen1Learnset> learnset = gen1LearnsetRepository.findLearnsetByPokemonId(id);

        List<Gen1TmLearnset> tmLearnset = gen1TmLearnsetRepository.findLearnsetByPokemonId(id);

        List<Gen1LearnsetResponse> moves = learnset.stream()
                .map(entry -> new Gen1LearnsetResponse(
                        entry.getMove().getId(),
                        entry.getMove().getName(),
                        entry.getMove().getType(),
                        entry.getMove().getCategory(),
                        entry.getMove().getPower(),
                        entry.getMove().getAccuracy(),
                        entry.getMove().getPp(),
                        entry.getId().getLevelLearned(),
                        entry.getId().getIsYellowOnly()
                ))
                .toList();

        List<Gen1TmLearnsetResponse> tmMoves = tmLearnset.stream()
                .map(entry -> new Gen1TmLearnsetResponse(
                        entry.getTm().getMove().getId(),
                        entry.getTm().getMove().getName(),
                        entry.getTm().getTm_name(),
                        entry.getTm().getMove().getType(),
                        entry.getTm().getMove().getCategory(),
                        entry.getTm().getMove().getPower(),
                        entry.getTm().getMove().getAccuracy(),
                        entry.getTm().getMove().getPp(),
                        entry.getId().getIsYellowOnly()
                ))
                .toList();



        return ResponseEntity.ok(new FullGen1Learnset(moves, tmMoves));
    }

}
