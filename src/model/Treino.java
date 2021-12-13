/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author vinic
 */

@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    
    @ManyToOne
    private Aluno aluno;
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "treino")
    private List<Atividade> atividade;

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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Atividade> getAtividade() {
        return atividade;
    }

    public void setAtividade(List<Atividade> atividade) {
        this.atividade = atividade;
    }
      
}
