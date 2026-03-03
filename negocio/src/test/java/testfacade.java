import mx.SauapELS.entity.Alumno;
import mx.SauapELS.facade.FacadeAlumno;
import mx.SauapELS.integration.ServiceFacadeLocator;

public class testfacade {
    public static void main(String[] args) {
        FacadeAlumno alumnoFacade = ServiceFacadeLocator.getInstanceFacadeAlumno();



        for (Alumno alumno : alumnoFacade.getAlumnos()) {
            System.out.println(alumno.getNombre()+ " " + alumno.getApellidos() + "|| id [" + alumno.getId()+ "]");
        }
    }
}
