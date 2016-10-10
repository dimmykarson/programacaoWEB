/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.locadora.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sticdev30
 */
public abstract class BaseDAO {

    @PersistenceContext(unitName = "locadoraPU")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public abstract Class getClassUnit();

    public void save(Object obj) {
        entityManager.persist(obj);
    }

    public Object update(Object obj) {
        return entityManager.merge(obj);
    }

    public List listAll() {
        Query q = entityManager.createQuery("from " + getClassUnit().getSimpleName());
        return q.getResultList();
    }

    public Object unique(String campo, Object valor) {
        Query q = entityManager.createQuery(""
                + " from " + getClassUnit().getSimpleName() + ""
                + " where " + campo + " = :v ");
        q.setParameter("v", valor);
        try {
            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
