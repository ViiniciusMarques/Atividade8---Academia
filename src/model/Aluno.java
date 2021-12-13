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
import org.hibernate.annotations.Fetch;

/**
 *
 * @author vinic
 */

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome, cpf, rg;
    
    @OneToOne
    private Usuario usuario;
    
    @ManyToOne
    private Instrutor instrutor;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "aluno")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Treino> treinos;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "aluno")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Historico> historicos;
    
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
    
    
}
