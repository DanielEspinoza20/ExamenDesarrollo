package mx.SauapELS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "rol", length = 20, nullable = false)
    private String rol;

    // 🔹 Constructor vacío (OBLIGATORIO para JPA)
    public Usuario() {
    }

    // 🔹 Constructor con parámetros
    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // 🔹 Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // 🔹 equals y hashCode (buena práctica en entidades)

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(idUsuario, other.idUsuario);
    }

    // 🔹 toString

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}