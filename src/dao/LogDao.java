/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.EntidadeBase;
import pojo.Log;

/**
 *
 * @author marce
 */
public class LogDAO {
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
    
    public Log salvar(Log log) {
        EntityManager entityManager = getEntityManager();
        try {
          entityManager.getTransaction().begin();
          if(log.getIdLog()== null) {
            entityManager.persist(log);
          } else {
            log = entityManager.merge(log);
          }
          entityManager.getTransaction().commit();
        } finally {
          entityManager.close();
        }
        return log;
    }
    
    public void excluir(Log log) {
        EntityManager entityManager = getEntityManager();
        Log log = procurarId(log.getId());
		if (!em.contains(log))
			log = em.merge(log);
		try {
          entityManager.getTransaction().begin();
          entityManager.remove(log);
          entityManager.getTransaction().commit();
        } finally {
          entityManager.close();
        }
    }
    
    public Log procurarId(Log log) {
        EntityManager entityManager = getEntityManager();
        Log log = null;
        try {
          log = entityManager.find(Log.class, log.getId());
        } finally {
          entityManager.close();
        }
        return log;
    }
}
