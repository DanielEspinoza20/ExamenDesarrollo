package mx.SauapELS.integration;

import mx.SauapELS.facade.FacadeAsignacion;
import mx.SauapELS.facade.FacadeProfesor;
import mx.SauapELS.facade.FacadeUnidad;
import mx.SauapELS.facade.FacadeUsuario;

public class ServiceFacadeLocator {

    private static FacadeUsuario facadeUsuario;
    private static FacadeAsignacion facadeAsignacion;
    private static FacadeProfesor facadeProfesor;
    private static FacadeUnidad facadeUnidad;

    public static FacadeUnidad getInstanceFacadeUnidad() {
        if (facadeUnidad == null) {
            facadeUnidad = new FacadeUnidad();
            return facadeUnidad;
        }
        return facadeUnidad;
    }

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        }
        return facadeProfesor;
    }

    public static FacadeAsignacion getInstanceFacadeAsignacion() {
        if (facadeAsignacion == null) {
            facadeAsignacion = new FacadeAsignacion();
            return facadeAsignacion;
        }
        return facadeAsignacion;
    }

    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }
}
