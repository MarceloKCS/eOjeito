/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.MovimentacaoCategoria;

/**
 *
 * @author Luis Fellipe
 */
public class MovimentacaoCategoriaDAO {
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
    
    public MovimentacaoCategoria salvar(MovimentacaoCategoria movimentacaoCategoria) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(movimentacaoCategoria.getIdMovimentacaoCategoria()== null) {
            em.persist(movimentacaoCategoria);
          } else {
            movimentacaoCategoria = em.merge(movimentacaoCategoria);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return movimentacaoCategoria;
    }
    
    public void excluir(MovimentacaoCategoria movimentacaoCategoria) {
        EntityManager em = getEntityManager();
        MovimentacaoCategoria movimentacaoCategoria = procurarId(movimentacaoCategoria.getId());
		if (!em.contains(movimentacaoCategoria))
			movimentacaoCategoria = em.merge(movimentacaoCategoria);
		try {
          em.getTransaction().begin();
          em.remove(movimentacaoCategoria);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public MovimentacaoCategoria procurarId(MovimentacaoCategoria movimentacaoCategoria) {
        EntityManager entityManager = getEntityManager();
        MovimentacaoCategoria movimentacaoCategoria = null;
        try {
          movimentacaoCategoria = entityManager.find(MovimentacaoCategoria.class, movimentacaoCategoria.getId());
        } finally {
          entityManager.close();
        }
        return movimentacaoCategoria;
    }
}
