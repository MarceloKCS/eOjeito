/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marce
 */
public class GenericoDao<T extends EntidadeBase> {
    public EntityManager getEM(){
        EntityManagerFactory factory  = Persistence.createEntityManagerFactory("TowersPU");
        return factory.createEntityManager();
    }
    
    public T salvar(T t) throws Exception {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);//executa insert
            } else {
                if (!em.contains(t)) {
                    if (em.find(t.getClass(), t.getId()) == null) {
                        throw new Exception("Erro ao atualizar!");
                    }
                }
                t = em.merge(t);//executa update
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return t;
    }
    
    public void excluir(Class<T> classe, Long id) {
        EntityManager em = getEM();
        T t = em.find(classe, id);
        try {
            em.getTransaction().begin();
            em.remove(t);//executa delete
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public T procurarId(Class<T> classe, Long id) {
        EntityManager em = getEM();
        T t = null;
        try{
            t = em.find(classe, id);//executa select
        } finally {
            em.close();
        }
        return t;
    }
}
