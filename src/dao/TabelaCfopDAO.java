/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.TabelaCfop;

/**
 *
 * @author Luis Fellipe
 */
public class TabelaCfopDAO {
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
    
    public TabelaCfop salvar(TabelaCfop tabelaCfop) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(tabelaCfop.getIdTabelaCfop()== null) {
            em.persist(tabelaCfop);
          } else {
            tabelaCfop = em.merge(tabelaCfop);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return tabelaCfop;
    }
    
    public void excluir(TabelaCfop tabelaCfop) {
        EntityManager em = getEntityManager();
        TabelaCfop tabelaCfop = procurarId(tabelaCfop.getId());
		if (!em.contains(tabelaCfop))
			tabelaCfop = em.merge(tabelaCfop);
		try {
          em.getTransaction().begin();
          em.remove(tabelaCfop);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public TabelaCfop procurarId(TabelaCfop tabelaCfop) {
        EntityManager entityManager = getEntityManager();
        TabelaCfop tabelaCfop = null;
        try {
          tabelaCfop = entityManager.find(TabelaCfop.class, tabelaCfop.getId());
        } finally {
          entityManager.close();
        }
        return tabelaCfop;
    }
}
