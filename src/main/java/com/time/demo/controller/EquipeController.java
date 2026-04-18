package com.time.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.time.demo.model.Equipe;
import com.time.demo.model.Jogador;
import com.time.demo.repository.EquipeRepository;
import com.time.demo.repository.JogadorRepository;


@RestController
@RequestMapping("/time")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    // POST /time/criar
    @PostMapping("/criar")
    public ResponseEntity<Equipe> criarEquipe(@RequestBody Equipe equipe) {
        Equipe salva = equipeRepository.save(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // GET /time/{idEquipe}
    @GetMapping("/{idEquipe}")
    public ResponseEntity<String> localizarEquipe(@PathVariable int idEquipe) {
        return equipeRepository.findById(idEquipe)
                .map(equipe -> ResponseEntity.ok(
                        String.format("A equipe tem %d no plantel", equipe.getPlantelSize())))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipe não encontrada"));
    }

    // GET /time/plantel/{idEquipe}
    @GetMapping("/plantel/{idEquipe}")
    public ResponseEntity<String> getPlantel(@PathVariable int idEquipe) {
        return equipeRepository.findById(idEquipe)
                .map(equipe -> ResponseEntity.ok(equipe.jogadoresPlantel()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipe não encontrada"));
    }

    // POST /time/{idEquipe}/registrar/{idJogador}
    @PostMapping("/{idEquipe}/registrar/{idJogador}")
    public ResponseEntity<String> registrar(@PathVariable int idEquipe, @PathVariable int idJogador) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Jogador jogador = jogadorRepository.findById(idJogador).orElse(null);

        if (equipe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipe não encontrada");
        }
        if (jogador == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
        }

        jogador.setEquipe(equipe);
        jogadorRepository.save(jogador);

        return ResponseEntity.ok("Jogador vinculado com sucesso!");
    }
}