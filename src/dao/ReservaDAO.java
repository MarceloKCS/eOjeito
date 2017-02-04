/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Reserva;

/**
 *
 * @author JACIANA
 */
public class ReservaDAO {
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
    
    public Reserva salvar(Reserva reserva) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(reserva.getIdReserva()== null) {
            em.persist(reserva);
          } else {
            reserva = em.merge(reserva);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return reserva;
    }
    
    public void excluir(Reserva reserva) {
        EntityManager em = getEntityManager();
        Reserva reserva = procurarId(reserva.getId());
		if (!em.contains(reserva))
			reserva = em.merge(reserva);
		try {
          em.getTransaction().begin();
          em.remove(reserva);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Reserva procurarId(Reserva reserva) {
        EntityManager entityManager = getEntityManager();
        Reserva reserva = null;
        try {
          reserva = entityManager.find(Reserva.class, reserva.getId());
        } finally {
          entityManager.close();
        }
        return reserva;
    }
}
