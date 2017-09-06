package entity;

import entity.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-05T21:16:23")
@StaticMetamodel(Colegio.class)
public class Colegio_ { 

    public static volatile SingularAttribute<Colegio, String> ciudad;
    public static volatile SingularAttribute<Colegio, String> direccion;
    public static volatile SingularAttribute<Colegio, String> calendario;
    public static volatile SingularAttribute<Colegio, Integer> id;
    public static volatile SingularAttribute<Colegio, Integer> telefono;
    public static volatile ListAttribute<Colegio, Profesor> profesorList;
    public static volatile SingularAttribute<Colegio, String> nombre;

}