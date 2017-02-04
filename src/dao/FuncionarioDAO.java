/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Funcionario;

/**
 *
 * @author Luis Fellipe
 */
public class FuncionarioDAO {
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
    
    public Funcionario salvar(Funcionario funcionario) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(funcionario.getIdFuncionario()== null) {
            em.persist(funcionario);
          } else {
            funcionario = em.merge(funcionario);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return funcionario;
    }
    
    public void excluir(Funcionario funcionario) {
        EntityManager em = getEntityManager();
        Funcionario funcionario = procurarId(funcionario.getId());
		if (!em.contains(funcionario))
			funcionario = em.merge(funcionario);
		try {
          em.getTransaction().begin();
          em.remove(funcionario);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Funcionario procurarId(Funcionario funcionario) {
        EntityManager entityManager = getEntityManager();
        Funcionario funcionario = null;
        try {
          funcionario = entityManager.find(Funcionario.class, funcionario.getId());
        } finally {
          entityManager.close();
        }
        return funcionario;
    }
}
