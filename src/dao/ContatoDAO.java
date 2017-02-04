/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Contato;

/**
 *
 * @author Luis Fellipe
 */
public class ContatoDAO {
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
    
    public Contato salvar(Contato contato) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(contato.getIdContato()== null) {
            em.persist(contato);
          } else {
            contato = em.merge(contato);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return contato;
    }
    
    public void excluir(Contato contato) {
        EntityManager em = getEntityManager();
        Contato contato = procurarId(contato.getId());
		if (!em.contains(contato))
			contato = em.merge(contato);
		try {
          em.getTransaction().begin();
          em.remove(contato);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Contato procurarId(Contato contato) {
        EntityManager entityManager = getEntityManager();
        Contato contato = null;
        try {
          contato = entityManager.find(Contato.class, contato.getId());
        } finally {
          entityManager.close();
        }
        return contato;
    }
}
