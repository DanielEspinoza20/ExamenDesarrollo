package mx.SauapELS.dao;

import jakarta.persistence.EntityManager;
import mx.SauapELS.entity.UnidadAprendizaje;
import mx.SauapELS.persistence.AbstractDAO;
import mx.SauapELS.persistence.HibernateUtil;

public class UnidadDAO extends AbstractDAO<UnidadAprendizaje> {

    public UnidadDAO() {
        super(UnidadAprendizaje.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager();
    }
}