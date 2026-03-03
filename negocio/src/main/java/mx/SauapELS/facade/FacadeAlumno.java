package mx.SauapELS.facade;

import mx.SauapELS.delegate.DelegateAlumno;
import mx.SauapELS.entity.Alumno;

import java.util.List;

public class FacadeAlumno {

    private final DelegateAlumno delegateAlumno;

    public FacadeAlumno() {
        this.delegateAlumno = new DelegateAlumno();
    }

    public void guardarAlumno(Alumno alumno){
        delegateAlumno.saveAlumno(alumno);
    }

    public List<Alumno> getAlumnos(){
        return delegateAlumno.getAlumno();
    }

}
