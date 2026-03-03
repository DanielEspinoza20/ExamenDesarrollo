import mx.SauapELS.dao.AlumnoDAO;
import mx.SauapELS.entity.Alumno;
import mx.SauapELS.persistence.HibernateUtil;

public class testDAO {

    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO(HibernateUtil.getEntityManager());



        for (Alumno alumno : alumnoDAO.findAll()) {
            System.out.println(alumno.getNombre()+ " " + alumno.getApellidos() + "|| id [" + alumno.getId()+ "]");
        }
    }
}
