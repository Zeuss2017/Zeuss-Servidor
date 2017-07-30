package entity;

import entity.Ejercicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T19:49:26")
@StaticMetamodel(Respuesta.class)
public class Respuesta_ { 

    public static volatile SingularAttribute<Respuesta, Integer> correcta;
    public static volatile SingularAttribute<Respuesta, String> enunciado;
    public static volatile SingularAttribute<Respuesta, Integer> id;
    public static volatile SingularAttribute<Respuesta, Ejercicio> ejercicioid;

}