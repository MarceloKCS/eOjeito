/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Endereco;

/**
 *
 * @author JACIANA
 */
public class EnderecoDAO {
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
    
    public Endereco salvar(Endereco endereco) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(endereco.getIdEndereco()== null) {
            em.persist(endereco);
          } else {
            endereco = em.merge(endereco);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return endereco;
    }
    
    public void excluir(Endereco endereco) {
        EntityManager em = getEntityManager();
        Endereco endereco = procurarId(endereco.getId());
		if (!em.contains(endereco))
			endereco = em.merge(endereco);
		try {
          em.getTransaction().begin();
          em.remove(endereco);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Endereco procurarId(Endereco endereco) {
        EntityManager entityManager = getEntityManager();
        Endereco endereco = null;
        try {
          endereco = entityManager.find(Endereco.class, endereco.getId());
        } finally {
          entityManager.close();
        }
        return endereco;
    }
}
