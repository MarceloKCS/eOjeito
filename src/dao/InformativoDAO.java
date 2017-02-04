/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Informativo;

/**
 *
 * @author JACIANA
 */
public class InformativoDAO {
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
    
    public Informativo salvar(Informativo informativo) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(informativo.getIdInformativo()== null) {
            em.persist(informativo);
          } else {
            informativo = em.merge(informativo);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return informativo;
    }
    
    public void excluir(Informativo informativo) {
        EntityManager em = getEntityManager();
        Informativo informativo = procurarId(informativo.getId());
		if (!em.contains(informativo))
			informativo = em.merge(informativo);
		try {
          em.getTransaction().begin();
          em.remove(informativo);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Informativo procurarId(Informativo informativo) {
        EntityManager entityManager = getEntityManager();
        Informativo informativo = null;
        try {
          informativo = entityManager.find(Informativo.class, informativo.getId());
        } finally {
          entityManager.close();
        }
        return informativo;
    }
}
