/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pojo.Usuario;

/**
 *
 * @author Luis Fellipe
 */
public class UsuarioDAO {
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
    
    public Usuario salvar(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(usuario.getIdUsuario()== null) {
            em.persist(usuario);
          } else {
            usuario = em.merge(usuario);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return usuario;
    }
    
    public void excluir(Usuario usuario) {
        EntityManager em = getEntityManager();
        Usuario usuario = procurarId(usuario.getId());
		if (!em.contains(usuario))
			usuario = em.merge(usuario);
		try {
          em.getTransaction().begin();
          em.remove(usuario);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public Usuario procurarId(Usuario usuario) {
        EntityManager entityManager = getEntityManager();
        Usuario usuario = null;
        try {
          usuario = entityManager.find(Usuario.class, usuario.getId());
        } finally {
          entityManager.close();
        }
        return usuario;
    }
}
