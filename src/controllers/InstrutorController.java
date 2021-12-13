/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Instrutor;

/**
 *
 * @author vinic
 */
public class InstrutorController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Instrutor instrutor){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(instrutor);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void Atualizar(Instrutor instrutor){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(instrutor);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public  List<Instrutor> Listar(){
        EntityManager em = getEntityManager();
        List<Instrutor> instrutores = em.createQuery("from Instrutor i").getResultList();
        em.close();
        emf.close();
        return instrutores;
    }
    
    //Consulta uma lista de produtos cujo nome contenham o parametro nome
    public  List<Instrutor> ListarPorNome(String nome){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Instrutor p where nome like :nome");
        consulta.setParameter("nome", "%"+nome+"%");
        
        List<Instrutor> instrutores = consulta.getResultList();
        
        em.close();
        emf.close();
        return instrutores;
    }
    
    
     public  Instrutor Consultar(int id){
        EntityManager em = getEntityManager();
        Instrutor instrutor = em.find(Instrutor.class, id);
        em.close();
        emf.close();
        return instrutor;
    }
     
     public void Remover(int id){
        EntityManager em = getEntityManager();
        Instrutor instrutor = em.find(Instrutor.class, id);
        em.getTransaction().begin();
        em.remove(instrutor);
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
}
