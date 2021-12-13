/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author vinic
 */

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome_usuario;
    private String login;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private tipoUsuario tipo_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public tipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(tipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
}
