/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.Apartamento;

/**
 *
 * @author Luis Fellipe
 */
public class ApartamentoDAO {
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
    
    public Apartamento salvar(Apartamento apartamento) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(apartamento.getIdApartamento()== null) {
            em.persist(apartamento);
          } else {
            apartamento = em.merge(apartamento);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return apartamento;
    }
    
    public void excluir(Apartamento apartamento) {
        EntityManager em = getEntityManager();
        Apartamento apartamento = procurarId(apartamento.getId());
		if (!em.contains(apartamento))
			apartamento = em.merge(apartamento);
		try {
          em.getTransaction().begin();
          em.remove(apartamento);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Apartamento procurarId(Apartamento apartamento) {
        EntityManager entityManager = getEntityManager();
        Apartamento apartamento = null;
        try {
          apartamento = entityManager.find(Apartamento.class, apartamento.getId());
        } finally {
          entityManager.close();
        }
        return apartamento;
    }
}
