package entity;

import entity.Colegio;
import entity.Curso;
import entity.Ejercicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-08T22:12:10")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, Colegio> colegioId;
    public static volatile ListAttribute<Profesor, Ejercicio> ejercicioList;
    public static volatile SingularAttribute<Profesor, String> contrasena;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile ListAttribute<Profesor, Curso> cursoList;
    public static volatile SingularAttribute<Profesor, String> username;

}