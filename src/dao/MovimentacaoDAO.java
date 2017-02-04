/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Movimentacao;

/**
 *
 * @author Luis Fellipe
 */
public class MovimentacaoDAO {
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
    
    public Movimentacao salvar(Movimentacao movimentacao) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(movimentacao.getIdMovimentacao()== null) {
            em.persist(movimentacao);
          } else {
            movimentacao = em.merge(movimentacao);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return movimentacao;
    }
    
    public void excluir(Movimentacao movimentacao) {
        EntityManager em = getEntityManager();
        Movimentacao movimentacao = procurarId(movimentacao.getId());
		if (!em.contains(movimentacao))
			movimentacao = em.merge(movimentacao);
		try {
          em.getTransaction().begin();
          em.remove(movimentacao);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Movimentacao procurarId(Movimentacao movimentacao) {
        EntityManager entityManager = getEntityManager();
        Movimentacao movimentacao = null;
        try {
          movimentacao = entityManager.find(Movimentacao.class, movimentacao.getId());
        } finally {
          entityManager.close();
        }
        return movimentacao;
    }
}
