package com.time.demo.model;

import com.time.demo.dto.JogadorDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJogador;

    private String nome;
    private int idade;
    private int altura;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    public Jogador() {
    }

    public Jogador(String nome, int idade, int altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String jogador() {
        return String.format("Nome:%s\nIdade:%d\nAltura(cm):%d", nome, idade, altura);
    }

    public JogadorDTO dto() {
        return new JogadorDTO(nome, idade, altura);
    }
}