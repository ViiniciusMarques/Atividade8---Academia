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
import model.Treino;

/**
 *
 * @author vinic
 */
public class TreinoController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Treino treino){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(treino);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void Atualizar(Treino treino){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(treino);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public  List<Treino> Listar(){
        EntityManager em = getEntityManager();
        List<Treino> treinos = em.createQuery("from Treino t").getResultList();
        em.close();
        emf.close();
        return treinos;
    }
    
    //Consulta uma lista de produtos cujo nome contenham o parametro nome
    public  List<Treino> ListarPorAluno(Aluno aluno){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Treino t where aluno_id = :idAluno");
        consulta.setParameter("idAluno", aluno.getId());
        
        List<Treino> treinos = consulta.getResultList();
        
        em.close();
        emf.close();
        return treinos;
    }
    
    
     public  Treino Consultar(int id){
        EntityManager em = getEntityManager();
        Treino treino = em.find(Treino.class,id);
        em.close();
        emf.close();
        return treino;
    }
     
     public void Remover(int id){
        EntityManager em = getEntityManager();
        Treino treino = em.find(Treino.class,id);
        em.getTransaction().begin();
        em.remove(treino);
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
}
