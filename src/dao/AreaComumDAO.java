/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.AreaComum;

/**
 *
 * @author Luis Fellipe
 */
public class AreaComumDAO {
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
    
    public AreaComum salvar(AreaComum areaComum) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(areaComum.getIdAreaComum()== null) {
            em.persist(areaComum);
          } else {
            areaComum = em.merge(areaComum);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return areaComum;
    }
    
    public void excluir(AreaComum areaComum) {
        EntityManager em = getEntityManager();
        AreaComum areaComum = procurarId(areaComum.getId());
		if (!em.contains(areaComum))
			areaComum = em.merge(areaComum);
		try {
          em.getTransaction().begin();
          em.remove(areaComum);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public AreaComum procurarId(AreaComum areaComum) {
        EntityManager entityManager = getEntityManager();
        AreaComum areaComum = null;
        try {
          areaComum = entityManager.find(AreaComum.class, areaComum.getId());
        } finally {
          entityManager.close();
        }
        return areaComum;
    }
}
