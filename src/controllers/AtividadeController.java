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
import model.Atividade;
import model.Treino;

/**
 *
 * @author vinic
 */
public class AtividadeController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Atividade atv){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(atv);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void Atualizar(Atividade atv){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(atv);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public  List<Atividade> Listar(){
        EntityManager em = getEntityManager();
        List<Atividade> atividades = em.createQuery("from Atividade a").getResultList();
        em.close();
        emf.close();
        return atividades;
    }
    
    public  List<Atividade> ListarPorTreino(Treino treino){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Atividade a where treino_id = :idTreino");
        consulta.setParameter("idTreino", treino.getId());
        
        List<Atividade> atividades = consulta.getResultList();
        
        em.close();
        emf.close();
        return atividades;
    }
    
    
     public  Atividade Consultar(int id){
        EntityManager em = getEntityManager();
        Atividade atv = em.find(Atividade.class,id);
        em.close();
        emf.close();
        return atv;
    }
     
     public void Remover(int id){
        EntityManager em = getEntityManager();
        Atividade atv = em.find(Atividade.class,id);
        em.getTransaction().begin();
        em.remove(atv);
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
}
