package mx.SauapELS.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import mx.SauapELS.entity.Usuario;
import mx.SauapELS.persistence.AbstractDAO;
import mx.SauapELS.persistence.HibernateUtil;

public class UsuarioDAO extends AbstractDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager();
    }

    public Usuario login(String username, String password) {
        try {
            return getEntityManager().createQuery(
                            "SELECT u FROM Usuario u WHERE u.username = :user AND u.password = :pass",
                            Usuario.class)
                    .setParameter("user", username)
                    .setParameter("pass", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}