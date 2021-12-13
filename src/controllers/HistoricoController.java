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
import model.Aluno;
import model.Historico;

/**
 *
 * @author vinic
 */
public class HistoricoController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Historico historico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(historico);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void Atualizar(Historico historico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(historico);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public  List<Historico> Listar(){
        EntityManager em = getEntityManager();
        List<Historico> historicos = em.createQuery("from Historico h").getResultList();
        em.close();
        emf.close();
        return historicos;
    }
    
    public  List<Historico> ListarPorAluno(Aluno aluno){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Historico h where aluno_id = :idAluno");
        consulta.setParameter("idAluno", aluno.getId());
        
        List<Historico> historicos = consulta.getResultList();
        
        em.close();
        emf.close();
        return historicos;
    }
    
    
     public Historico Consultar(int id){
        EntityManager em = getEntityManager();
        Historico hist = em.find(Historico.class,id);
        em.close();
        emf.close();
        return hist;
    }
     
     public void Remover(int id){
        EntityManager em = getEntityManager();
        Historico hist = em.find(Historico.class,id);
        em.getTransaction().begin();
        em.remove(hist);
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
}
