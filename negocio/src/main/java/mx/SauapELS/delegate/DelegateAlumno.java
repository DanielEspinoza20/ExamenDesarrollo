package mx.SauapELS.delegate;

import mx.SauapELS.entity.Alumno;
import mx.SauapELS.integration.ServiceLocator;

import java.util.List;

public class DelegateAlumno {
    public void saveAlumno(Alumno alumno){
        ServiceLocator.getInstanceAlumnoDAO().save(alumno);
    }

    public List<Alumno> getAlumno(){
        return ServiceLocator.getInstanceAlumnoDAO().findAll();
    }

}