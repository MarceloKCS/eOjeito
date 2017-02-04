/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Visita;

/**
 *
 * @author JACIANA
 */
public class VisitaDAO {
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
    
    public Visita salvar(Visita visita) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(visita.getIdVisita()== null) {
            em.persist(visita);
          } else {
            visita = em.merge(visita);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return visita;
    }
    
    public void excluir(Visita visita) {
        EntityManager em = getEntityManager();
        Visita visita = procurarId(visita.getId());
		if (!em.contains(visita))
			visita = em.merge(visita);
		try {
          em.getTransaction().begin();
          em.remove(visita);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Visita procurarId(Visita visita) {
        EntityManager entityManager = getEntityManager();
        Visita visita = null;
        try {
          visita = entityManager.find(Visita.class, visita.getId());
        } finally {
          entityManager.close();
        }
        return visita;
    }
}
