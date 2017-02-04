/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.InformativoCategoria;

/**
 *
 * @author Luis Fellipe
 */
public class InformativoCategoriaDAO {
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
    
    public InformativoCategoria salvar(InformativoCategoria informativoCategoria) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(informativoCategoria.getIdInformativoCategoria()== null) {
            em.persist(informativoCategoria);
          } else {
            informativoCategoria = em.merge(informativoCategoria);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return informativoCategoria;
    }
    
    public void excluir(InformativoCategoria informativoCategoria) {
        EntityManager em = getEntityManager();
        InformativoCategoria informativoCategoria = procurarId(informativoCategoria.getId());
		if (!em.contains(informativoCategoria))
			informativoCategoria = em.merge(informativoCategoria);
		try {
          em.getTransaction().begin();
          em.remove(informativoCategoria);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public InformativoCategoria procurarId(InformativoCategoria informativoCategoria) {
        EntityManager entityManager = getEntityManager();
        InformativoCategoria informativoCategoria = null;
        try {
          informativoCategoria = entityManager.find(InformativoCategoria.class, informativoCategoria.getId());
        } finally {
          entityManager.close();
        }
        return informativoCategoria;
    }
}
