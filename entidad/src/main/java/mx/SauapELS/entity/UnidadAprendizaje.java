package mx.SauapELS.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "unidad_aprendizaje")
public class UnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUnidad")
    private Integer idUnidad;

    public UnidadAprendizaje() {
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUnidad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UnidadAprendizaje other = (UnidadAprendizaje) obj;
        return Objects.equals(idUnidad, other.idUnidad);
    }
}