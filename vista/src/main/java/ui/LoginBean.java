package ui;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import mx.SauapELS.entity.Usuario;
import mx.SauapELS.facade.FacadeUsuario;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Usuario usuario;
    private FacadeUsuario facade = new FacadeUsuario();

    public String login() {
        System.out.println("LOG: Intentando login con: " + username);
        usuario = facade.login(username, password);

        if (usuario != null) {
            System.out.println("LOG: Usuario encontrado. Rol en BD: " + usuario.getRol());

            if ("ADMINISTRADOR".equals(usuario.getRol())) {
                return "admin?faces-redirect=true";
            } else if ("PROFESOR".equals(usuario.getRol())) {
                return "profesor?faces-redirect=true";
            } else {
                System.out.println("LOG: El rol '" + usuario.getRol() + "' no tiene ruta asignada.");
            }
        } else {
            System.out.println("LOG: Credenciales incorrectas para el usuario: " + username);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrectos"));
        }
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Usuario getUsuario() { return usuario; }
}