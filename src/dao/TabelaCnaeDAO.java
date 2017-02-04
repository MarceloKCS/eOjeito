/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author JACIANA
 */
public class TabelaCnaeDAO {
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
    
    public TabelaCnae salvar(TabelaCnae tabelaCnae) {
        EntityManager em = getEntityManager();
        try {
          em.getTransaction().begin();
          if(tabelaCnae.getIdTabelaCnae()== null) {
            em.persist(tabelaCnae);
          } else {
            tabelaCnae = em.merge(tabelaCnae);
          }
          em.getTransaction().commit();
        } finally {
          em.close();
        }
        return tabelaCnae;
    }
    
    public void excluir(TabelaCnae tabelaCnae) {
        EntityManager em = getEntityManager();
        TabelaCnae tabelaCnae = procurarId(tabelaCnae.getId());
		if (!em.contains(tabelaCnae))
			tabelaCnae = em.merge(tabelaCnae);
		try {
          em.getTransaction().begin();
          em.remove(tabelaCnae);
          em.getTransaction().commit();
        } finally {
          em.close();
        }
    }
    
    public TabelaCnae procurarId(TabelaCnae tabelaCnae) {
        EntityManager entityManager = getEntityManager();
        TabelaCnae tabelaCnae = null;
        try {
          tabelaCnae = entityManager.find(TabelaCnae.class, tabelaCnae.getId());
        } finally {
          entityManager.close();
        }
        return tabelaCnae;
    }
}
