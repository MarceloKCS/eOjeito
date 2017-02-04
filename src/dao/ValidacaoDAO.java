/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Validacao;

/**
 *
 * @author JACIANA
 */
public class ValidacaoDAO {
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
    
    public Validacao salvar(Validacao validacao) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(validacao.getIdValidacao()== null) {
            em.persist(validacao);
          } else {
            validacao = em.merge(validacao);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return validacao;
    }
    
    public void excluir(Validacao validacao) {
        EntityManager em = getEntityManager();
        Validacao validacao = procurarId(validacao.getId());
		if (!em.contains(validacao))
			validacao = em.merge(validacao);
		try {
          em.getTransaction().begin();
          em.remove(validacao);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Validacao procurarId(Validacao validacao) {
        EntityManager entityManager = getEntityManager();
        Validacao validacao = null;
        try {
          validacao = entityManager.find(Validacao.class, validacao.getId());
        } finally {
          entityManager.close();
        }
        return validacao;
    }
}
