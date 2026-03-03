package mx.SauapELS.facade;

import mx.SauapELS.delegate.DelegateUsuario;
import mx.SauapELS.entity.Usuario;

public class FacadeUsuario {

    private final DelegateUsuario delegateUsuario;

    public FacadeUsuario() {
        this.delegateUsuario = new DelegateUsuario();
    }

    // ORDEN CORRECTO
    public Usuario login(String username, String password) {
        return delegateUsuario.login(username, password);
    }

    public void saveUsuario(Usuario usuario) {
        delegateUsuario.saveUsuario(usuario);
    }
}