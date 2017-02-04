/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Bloco;

/**
 *
 * @author Luis Fellipe
 */
public class BlocoDAO {
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
    
    public Bloco salvar(Bloco bloco) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(bloco.getIdBloco()== null) {
            em.persist(bloco);
          } else {
            bloco = em.merge(bloco);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return bloco;
    }
    
    public void excluir(Bloco bloco) {
        EntityManager em = getEntityManager();
        Bloco bloco = procurarId(bloco.getId());
		if (!em.contains(bloco))
			bloco = em.merge(bloco);
		try {
          em.getTransaction().begin();
          em.remove(bloco);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Bloco procurarId(Bloco bloco) {
        EntityManager entityManager = getEntityManager();
        Bloco bloco = null;
        try {
          bloco = entityManager.find(Bloco.class, bloco.getId());
        } finally {
          entityManager.close();
        }
        return bloco;
    }
}
