/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.FuncionarioCargo;

/**
 *
 * @author Luis Fellipe
 */
public class FuncionarioCargoDAO {
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
    
    public FuncionarioCargo salvar(FuncionarioCargo funcionarioCargo) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(funcionarioCargo.getIdFuncionarioCargo()== null) {
            em.persist(funcionarioCargo);
          } else {
            funcionarioCargo = em.merge(funcionarioCargo);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return funcionarioCargo;
    }
    
    public void excluir(FuncionarioCargo funcionarioCargo) {
        EntityManager em = getEntityManager();
        FuncionarioCargo funcionarioCargo = procurarId(funcionarioCargo.getId());
		if (!em.contains(funcionarioCargo))
			funcionarioCargo = em.merge(funcionarioCargo);
		try {
          em.getTransaction().begin();
          em.remove(funcionarioCargo);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public FuncionarioCargo procurarId(FuncionarioCargo funcionarioCargo) {
        EntityManager entityManager = getEntityManager();
        FuncionarioCargo funcionarioCargo = null;
        try {
          funcionarioCargo = entityManager.find(FuncionarioCargo.class, funcionarioCargo.getId());
        } finally {
          entityManager.close();
        }
        return funcionarioCargo;
    }
}
