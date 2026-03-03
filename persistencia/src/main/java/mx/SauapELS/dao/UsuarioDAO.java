package mx.SauapELS.dao;

import jakarta.persistence.EntityManager;
import mx.SauapELS.entity.Usuario;
import mx.SauapELS.persistence.AbstractDAO;

import java.util.List;

public class UsuarioDAO extends AbstractDAO<Usuario> {
    private final EntityManager entityManager;

    public UsuarioDAO(EntityManager em) {
        super(Usuario.class);
        this.entityManager = em;
    }

    public List<Usuario> obtenerTodos(){
        return entityManager
                .createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }

    public Usuario login(String correo, String contrasena) {
            List<Usuario> lista = entityManager.createQuery(
                            "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasena = :contrasena", Usuario.class)
                    .setParameter("correo", correo)
                    .setParameter("contrasena", contrasena)
                    .getResultList();
            if (lista.isEmpty()) {
                return null;
            }
            return lista.get(0);
        }


    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
