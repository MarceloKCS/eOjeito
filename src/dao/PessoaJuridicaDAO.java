/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.PessoaJuridica;

/**
 *
 * @author JACIANA
 */
public class PessoaJuridicaDAO {
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
    
    public PessoaJuridica salvar(PessoaJuridica pessoaJuridica) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(pessoaJuridica.getIdPessoaJuridica()== null) {
            em.persist(pessoaJuridica);
          } else {
            pessoaJuridica = em.merge(pessoaJuridica);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return pessoaJuridica;
    }
    
    public void excluir(PessoaJuridica pessoaJuridica) {
        EntityManager em = getEntityManager();
        PessoaJuridica pessoaJuridica = procurarId(pessoaJuridica.getId());
		if (!em.contains(pessoaJuridica))
			pessoaJuridica = em.merge(pessoaJuridica);
		try {
          em.getTransaction().begin();
          em.remove(pessoaJuridica);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public PessoaJuridica procurarId(PessoaJuridica pessoaJuridica) {
        EntityManager entityManager = getEntityManager();
        PessoaJuridica pessoaJuridica = null;
        try {
          pessoaJuridica = entityManager.find(PessoaJuridica.class, pessoaJuridica.getId());
        } finally {
          entityManager.close();
        }
        return pessoaJuridica;
    }
}
