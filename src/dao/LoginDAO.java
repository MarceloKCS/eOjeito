/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Login;

/**
 *
 * @author Luis Fellipe
 */
public class LoginDAO {
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
    
    public Login salvar(Login login) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(login.getIdLogin()== null) {
            em.persist(login);
          } else {
            login = em.merge(login);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return login;
    }
    
    public void excluir(Login login) {
        EntityManager em = getEntityManager();
        Login login = procurarId(login.getId());
		if (!em.contains(login))
			login = em.merge(login);
		try {
          em.getTransaction().begin();
          em.remove(login);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Login procurarId(Login login) {
        EntityManager entityManager = getEntityManager();
        Login login = null;
        try {
          login = entityManager.find(Login.class, login.getId());
        } finally {
          entityManager.close();
        }
        return login;
    }
}
