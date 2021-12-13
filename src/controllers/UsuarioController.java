/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Usuario;
import model.tipoUsuario;

/**
 *
 * @author vinic
 */
public class UsuarioController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void criaUsuarioMaster(){
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Query consulta = em.createQuery("from Usuario u where login = :login").setParameter("login", "master");
            
            if(consulta.getResultList().isEmpty()){
                Usuario u = new Usuario();
                u.setLogin("master");
                u.setNome_usuario("Master");
                u.setSenha("master");
                u.setTipo_usuario(tipoUsuario.Master);
                em.persist(u);
                em.getTransaction().commit();
                em.close();
                emf.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void Cadastrar(Usuario usuario){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public Usuario verificarLogin(String login, String password){
        try{
            EntityManager em = getEntityManager();
            Query consulta = em.createQuery("from Usuario u where login = :login and senha = :password")
                    .setParameter("login", login).setParameter("password", password);
            if(!consulta.getResultList().isEmpty()){
                Usuario u = new Usuario();
                u = (Usuario) consulta.getSingleResult();
                System.out.println(u.getNome_usuario());
                return u;
            }
        }
            
        catch(Exception ex){
            System.out.println(ex);
        }
        return null;  
    }
    
}
