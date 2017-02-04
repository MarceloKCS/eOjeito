/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Ocorrencia;

/**
 *
 * @author JACIANA
 */
public class OcorrenciaDAO {
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
    
    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(ocorrencia.getIdOcorrencia()== null) {
            em.persist(ocorrencia);
          } else {
            ocorrencia = em.merge(ocorrencia);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return ocorrencia;
    }
    
    public void excluir(Ocorrencia ocorrencia) {
        EntityManager em = getEntityManager();
        Ocorrencia ocorrencia = procurarId(ocorrencia.getId());
		if (!em.contains(ocorrencia))
			ocorrencia = em.merge(ocorrencia);
		try {
          em.getTransaction().begin();
          em.remove(ocorrencia);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Ocorrencia procurarId(Ocorrencia ocorrencia) {
        EntityManager entityManager = getEntityManager();
        Ocorrencia ocorrencia = null;
        try {
          ocorrencia = entityManager.find(Ocorrencia.class, ocorrencia.getId());
        } finally {
          entityManager.close();
        }
        return ocorrencia;
    }
}
