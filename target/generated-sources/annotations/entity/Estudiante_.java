package entity;

import entity.Curso;
import entity.ResultadoAct;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-26T17:10:07")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> fechaNacimiento;
    public static volatile ListAttribute<Estudiante, ResultadoAct> resultadoActList;
    public static volatile SingularAttribute<Estudiante, Integer> id;
    public static volatile SingularAttribute<Estudiante, Curso> cursoid;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile SingularAttribute<Estudiante, String> username;

}