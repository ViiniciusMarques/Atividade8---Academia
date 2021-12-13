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


public class AlunoController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Aluno aluno){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void Atualizar(Aluno aluno){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public  List<Aluno> Listar(){
        EntityManager em = getEntityManager();
        List<Aluno> alunos = em.createQuery("from Aluno a").getResultList();
        em.close();
        emf.close();
        return alunos;
    }
    
    public  List<Aluno> ListarPorNome(String nome){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Aluno a where nome like :nome");
        consulta.setParameter("nome", "%"+nome+"%");
        
        List<Aluno> alunos = consulta.getResultList();
        
        em.close();
        emf.close();
        return alunos;
    }
    
    public  List<Aluno> ListarPorInstrutor(int idInstrutor){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Aluno a where instrutor_id = :idInstrutor");
        consulta.setParameter("idInstrutor", idInstrutor);
        
        List<Aluno> alunos = consulta.getResultList();
        
        em.close();
        emf.close();
        return alunos;
    }
    
    
    public  Aluno Consultar(int id){
        EntityManager em = getEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        emf.close();
        return aluno;
    }
    
    public Aluno ConsultarPorNome(String nome){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Aluno a where nome = :nome");
        consulta.setParameter("nome", nome);
        
        Aluno aluno = (Aluno) consulta.getSingleResult();
        
        em.close();
        emf.close();
        return aluno;
    }
     
     public void Remover(int id){
        EntityManager em = getEntityManager();
        Aluno aluno = em.find(Aluno.class,id);
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
}
