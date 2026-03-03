package mx.SauapELS.delegate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mx.SauapELS.entity.Usuario;
import mx.SauapELS.persistence.HibernateUtil;

import java.util.List;

public List<Usuario> findAll() {

    EntityManager em = null;
    List<Usuario> lista = null;

    try {
        em = HibernateUtil.getEntityManager();

        TypedQuery<Usuario> query =
                em.createQuery("SELECT u FROM Usuario u", Usuario.class);

        lista = query.getResultList();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (em != null) {
            em.close();
        }
    }

    return lista;
}