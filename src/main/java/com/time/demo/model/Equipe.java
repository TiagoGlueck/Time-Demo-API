package com.time.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.time.demo.dto.EquipeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;

    private String nome;

    @OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
    private List<Jogador> elenco;

    public Equipe() {
        this.elenco = new ArrayList<>();
    }

    public Equipe(String nome) {
        this.nome = nome;
        this.elenco = new ArrayList<>();
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getElenco() {
        return elenco;
    }

    public void adicionarJogador(Jogador jogador) {
        this.elenco.add(jogador);
        jogador.setEquipe(this);
    }

    public int getPlantelSize() {
        return elenco.size();
    }

    public String jogadoresPlantel() {
        StringBuilder plantel = new StringBuilder("Plantel " + nome + "\n");
        int cont = 1;
        for (Jogador jogador : elenco) {
            plantel.append(cont + ". " + jogador.getNome() + "\n");
            cont++;
        }
        return plantel.toString();
    }

    public EquipeDTO dto() {
        return new EquipeDTO(nome, elenco.size());
    }
}