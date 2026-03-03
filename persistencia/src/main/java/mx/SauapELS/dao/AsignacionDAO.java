package mx.SauapELS.dao;

import jakarta.persistence.EntityManager;
import mx.SauapELS.entity.Asignacion;
import mx.SauapELS.persistence.AbstractDAO;
import mx.SauapELS.persistence.HibernateUtil;

public class AsignacionDAO extends AbstractDAO<Asignacion> {

    public AsignacionDAO() {
        super(Asignacion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager();
    }
}