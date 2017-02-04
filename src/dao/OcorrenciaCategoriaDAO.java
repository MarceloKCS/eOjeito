/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.OcorrenciaCategoria;

/**
 *
 * @author Luis Fellipe
 */
public class OcorrenciaCategoriaDAO {
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
    
    public OcorrenciaCategoria salvar(OcorrenciaCategoria ocorrenciaCategoria) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(ocorrenciaCategoria.getIdOcorrenciaCategoria()== null) {
            em.persist(ocorrenciaCategoria);
          } else {
            ocorrenciaCategoria = em.merge(ocorrenciaCategoria);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return ocorrenciaCategoria;
    }
    
    public void excluir(OcorrenciaCategoria ocorrenciaCategoria) {
        EntityManager em = getEntityManager();
        OcorrenciaCategoria ocorrenciaCategoria = procurarId(ocorrenciaCategoria.getId());
		if (!em.contains(ocorrenciaCategoria))
			ocorrenciaCategoria = em.merge(ocorrenciaCategoria);
		try {
          em.getTransaction().begin();
          em.remove(ocorrenciaCategoria);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public OcorrenciaCategoria procurarId(OcorrenciaCategoria ocorrenciaCategoria) {
        EntityManager entityManager = getEntityManager();
        OcorrenciaCategoria ocorrenciaCategoria = null;
        try {
          ocorrenciaCategoria = entityManager.find(OcorrenciaCategoria.class, ocorrenciaCategoria.getId());
        } finally {
          entityManager.close();
        }
        return ocorrenciaCategoria;
    }
}
