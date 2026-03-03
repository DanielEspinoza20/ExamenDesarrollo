package ui;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.IOException;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import mx.SauapELS.delegate.DelegateUsuario;
import mx.SauapELS.persistence.AbstractDAO;

import mx.SauapELS.entity.Usuario;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    private Usuario usuario;

    private DelegateUsuario delegate = new DelegateUsuario();

    public String login() {

        usuario = delegate.login(username, password);

        if (usuario != null) {

            if ("ADMINISTRADOR".equalsIgnoreCase(usuario.getRol())) {
                System.out.println("Usuario encontrado: " + usuario);
                return "admin?faces-redirect=true";
            } else if ("PROFESOR".equalsIgnoreCase(usuario.getRol())) {
                System.out.println("Usuario encontrado: " + usuario);
                return "profesor?faces-redirect=true";
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "Usuario o contraseña incorrectos"));
        }

        return null;
    }

    public String logout() {

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .invalidateSession();

        return "/login.xhtml?faces-redirect=true";
    }

    // MÉTODO PARA PROTEGER ADMIN
    public void verificarAdmin() throws IOException {

        if (usuario == null ||
                !"ADMINISTRADOR".equalsIgnoreCase(usuario.getRol())) {

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("../login.xhtml");
        }
    }

    // MÉTODO PARA PROTEGER PROFESOR
    public void verificarProfesor() throws IOException {

        if (usuario == null ||
                !"PROFESOR".equalsIgnoreCase(usuario.getRol())) {

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("../login.xhtml");
        }
    }

    // Getters y Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}