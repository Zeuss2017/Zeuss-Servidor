package entity;

import entity.Actividad;
import entity.Estudiante;
import entity.ResultadoActPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T19:49:26")
@StaticMetamodel(ResultadoAct.class)
public class ResultadoAct_ { 

    public static volatile SingularAttribute<ResultadoAct, Integer> maxNivel;
    public static volatile SingularAttribute<ResultadoAct, Estudiante> estudiante;
    public static volatile SingularAttribute<ResultadoAct, Integer> totalAciertos;
    public static volatile SingularAttribute<ResultadoAct, ResultadoActPK> resultadoActPK;
    public static volatile SingularAttribute<ResultadoAct, Integer> totalTiempo;
    public static volatile SingularAttribute<ResultadoAct, Integer> totalEjRelizados;
    public static volatile SingularAttribute<ResultadoAct, Integer> totalErrores;
    public static volatile SingularAttribute<ResultadoAct, Actividad> actividad;

}