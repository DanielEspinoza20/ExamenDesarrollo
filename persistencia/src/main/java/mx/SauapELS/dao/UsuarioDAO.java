package mx.SauapELS.dao;

import mx.SauapELS.entity.Usuario;
import mx.SauapELS.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioDAO {

    public Usuario login(String username, String password) {

        Session session = null;
        Usuario usuario = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Query<Usuario> query = session.createQuery(
                    "FROM Usuario u WHERE u.username = :user AND u.password = :pass",
                    Usuario.class
            );

            query.setParameter("user", username);
            query.setParameter("pass", password);

            usuario = query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return usuario;
    }

    public void saveUsuario(Usuario usuario) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}