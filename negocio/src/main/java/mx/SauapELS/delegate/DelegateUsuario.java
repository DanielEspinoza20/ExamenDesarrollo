package mx.SauapELS.delegate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mx.SauapELS.entity.Usuario;
import mx.SauapELS.persistence.HibernateUtil;

import java.util.List;

public class DelegateUsuario {

    public Usuario login(String username, String password) {

        EntityManager em = null;
        Usuario usuario = null;

        try {
            em = HibernateUtil.getEntityManager();

            TypedQuery<Usuario> query =
                    em.createQuery(
                            "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password",
                            Usuario.class
                    );

            query.setParameter("username", username);
            query.setParameter("password", password);

            usuario = query.getSingleResult();

        } catch (Exception e) {
            usuario = null;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return usuario;
    }

    public List<Usuario> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<Usuario> lista =
                em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                        .getResultList();
        em.close();
        return lista;
    }

    public void saveUsuario(Usuario usuario) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }
}