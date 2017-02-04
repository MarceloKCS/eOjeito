/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Veiculo;

/**
 *
 * @author JACIANA
 */
public class VeiculoDAO {
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
    
    public Veiculo salvar(Veiculo veiculo) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(veiculo.getIdVeiculo()== null) {
            em.persist(veiculo);
          } else {
            veiculo = em.merge(veiculo);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return veiculo;
    }
    
    public void excluir(Veiculo veiculo) {
        EntityManager em = getEntityManager();
        Veiculo veiculo = procurarId(veiculo.getId());
		if (!em.contains(veiculo))
			veiculo = em.merge(veiculo);
		try {
          em.getTransaction().begin();
          em.remove(veiculo);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Veiculo procurarId(Veiculo veiculo) {
        EntityManager entityManager = getEntityManager();
        Veiculo veiculo = null;
        try {
          veiculo = entityManager.find(Veiculo.class, veiculo.getId());
        } finally {
          entityManager.close();
        }
        return veiculo;
    }
}
