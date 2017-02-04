/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.PessoaFisica;

/**
 *
 * @author JACIANA
 */
public class PessoaFisicaDAO {
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
    
    public PessoaFisica salvar(PessoaFisica pessoaFisica) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(pessoaFisica.getIdPessoaFisica()== null) {
            em.persist(pessoaFisica);
          } else {
            pessoaFisica = em.merge(pessoaFisica);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return pessoaFisica;
    }
    
    public void excluir(PessoaFisica pessoaFisica) {
        EntityManager em = getEntityManager();
        PessoaFisica pessoaFisica = procurarId(pessoaFisica.getId());
		if (!em.contains(pessoaFisica))
			pessoaFisica = em.merge(pessoaFisica);
		try {
          em.getTransaction().begin();
          em.remove(pessoaFisica);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public PessoaFisica procurarId(PessoaFisica pessoaFisica) {
        EntityManager entityManager = getEntityManager();
        PessoaFisica pessoaFisica = null;
        try {
          pessoaFisica = entityManager.find(PessoaFisica.class, pessoaFisica.getId());
        } finally {
          entityManager.close();
        }
        return pessoaFisica;
    }
}
