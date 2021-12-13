/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author vinic
 */

@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Double numeroRepeticoes;
    private String peso_tempo;
    
    @ManyToOne
    private Treino treino;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNumeroRepeticoes() {
        return numeroRepeticoes;
    }

    public void setNumeroRepeticoes(Double numeroRepeticoes) {
        this.numeroRepeticoes = numeroRepeticoes;
    }

    public String getPeso_tempo() {
        return peso_tempo;
    }

    public void setPeso_tempo(String peso_tempo) {
        this.peso_tempo = peso_tempo;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }   
    
}
