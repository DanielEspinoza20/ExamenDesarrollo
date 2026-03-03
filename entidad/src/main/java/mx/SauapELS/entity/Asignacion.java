package mx.SauapELS.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "asignacion")
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsignacion")
    private Integer idAsignacion;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private UnidadAprendizaje unidad;

    public Asignacion() {
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public UnidadAprendizaje getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadAprendizaje unidad) {
        this.unidad = unidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignacion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Asignacion other = (Asignacion) obj;
        return Objects.equals(idAsignacion, other.idAsignacion);
    }
}