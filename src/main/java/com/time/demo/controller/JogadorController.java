package com.time.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.time.demo.dto.JogadorDTO;
import com.time.demo.model.Jogador;
import com.time.demo.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    // POST /jogador/criar
    @PostMapping("/criar")
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador jogador) {
        Jogador salvo = jogadorRepository.save(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // GET /jogador/{idJogador}
    @GetMapping("/{idJogador}")
    public ResponseEntity<JogadorDTO> getJogador(@PathVariable int idJogador) {
        return jogadorRepository.findById(idJogador)
                .map(jogador -> ResponseEntity.ok(jogador.dto()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}