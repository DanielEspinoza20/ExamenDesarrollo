package mx.SauapELS.dao;

import jakarta.persistence.EntityManager;
import mx.SauapELS.entity.Profesor;
import mx.SauapELS.persistence.AbstractDAO;
import mx.SauapELS.persistence.HibernateUtil;

public class ProfesorDAO extends AbstractDAO<Profesor> {

    public ProfesorDAO() {
        super(Profesor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager();
    }
}