package entity;

import entity.Estudiante;
import entity.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-09T17:32:50")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> periodo;
    public static volatile ListAttribute<Curso, Estudiante> estudianteList;
    public static volatile SingularAttribute<Curso, Integer> id;
    public static volatile SingularAttribute<Curso, String> nombre;
    public static volatile SingularAttribute<Curso, Profesor> profesorUsername;
    public static volatile SingularAttribute<Curso, Integer> activo;

}