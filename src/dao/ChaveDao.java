/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Chave;

/**
 *
 * @author marce
 */
public class ChaveDao {
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("TowersPU");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }
    
    public Chave salvar(Chave chave) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(chave.getIdChave()== null) {
            em.persist(chave);
          } else {
            chave = em.merge(chave);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return chave;
    }
    
    public void excluir(Chave chave) {
        EntityManager em = getEntityManager();
        Chave chave = procurarId(chave.getId());
		if (!em.contains(chave))
			chave = em.merge(chave);
		try {
          em.getTransaction().begin();
          em.remove(chave);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Chave procurarId(Chave chave) {
        EntityManager entityManager = getEntityManager();
        Chave chave = null;
        try {
          chave = entityManager.find(Chave.class, chave.getId());
        } finally {
          entityManager.close();
        }
        return chave;
    }
}
