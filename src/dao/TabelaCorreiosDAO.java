/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.TabelaCorreios;

/**
 *
 * @author Luis Fellipe
 */
public class TabelaCorreiosDAO {
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
    
    public TabelaCorreios salvar(TabelaCorreios tabelaCorreios) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(tabelaCorreios.getIdTabelaCorreios()== null) {
            em.persist(tabelaCorreios);
          } else {
            tabelaCorreios = em.merge(tabelaCorreios);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return tabelaCorreios;
    }
    
    public void excluir(TabelaCorreios tabelaCorreios) {
        EntityManager em = getEntityManager();
        TabelaCorreios tabelaCorreios = procurarId(tabelaCorreios.getId());
		if (!em.contains(tabelaCorreios))
			tabelaCorreios = em.merge(tabelaCorreios);
		try {
          em.getTransaction().begin();
          em.remove(tabelaCorreios);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public TabelaCorreios procurarId(TabelaCorreios tabelaCorreios) {
        EntityManager entityManager = getEntityManager();
        TabelaCorreios tabelaCorreios = null;
        try {
          tabelaCorreios = entityManager.find(TabelaCorreios.class, tabelaCorreios.getId());
        } finally {
          entityManager.close();
        }
        return tabelaCorreios;
    }
}
