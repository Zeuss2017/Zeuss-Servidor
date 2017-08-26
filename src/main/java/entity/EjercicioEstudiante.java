/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maria Jose Mendoza Rincon
 */
@Entity
@Table(name = "EjercicioEstudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EjercicioEstudiante.findAll", query = "SELECT e FROM EjercicioEstudiante e")
    , @NamedQuery(name = "EjercicioEstudiante.findById", query = "SELECT e FROM EjercicioEstudiante e WHERE e.id = :id")
    , @NamedQuery(name = "EjercicioEstudiante.findByAciertos", query = "SELECT e FROM EjercicioEstudiante e WHERE e.aciertos = :aciertos")
    , @NamedQuery(name = "EjercicioEstudiante.findByErrores", query = "SELECT e FROM EjercicioEstudiante e WHERE e.errores = :errores")
    , @NamedQuery(name = "EjercicioEstudiante.findByTiempo", query = "SELECT e FROM EjercicioEstudiante e WHERE e.tiempo = :tiempo")
    , @NamedQuery(name = "EjercicioEstudiante.findByConsecutivo", query = "SELECT e FROM EjercicioEstudiante e WHERE e.consecutivo = :consecutivo")
    , @NamedQuery(name = "EjercicioEstudiante.findByNivel", query = "SELECT e FROM EjercicioEstudiante e WHERE e.nivel = :nivel")
    , @NamedQuery(name = "EjercicioEstudiante.findByActividadId", query = "SELECT e FROM EjercicioEstudiante e WHERE e.actividadEstudianteid.id = :idActividadEstudiante")})
public class EjercicioEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aciertos")
    private int aciertos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "errores")
    private int errores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo")
    private int tiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consecutivo")
    private int consecutivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @JoinColumn(name = "actividadEstudiante_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ActividadEstudiante actividadEstudianteid;

    public EjercicioEstudiante() {
    }

    public EjercicioEstudiante(Integer id) {
        this.id = id;
    }

    public EjercicioEstudiante(Integer id, int aciertos, int errores, int tiempo, int consecutivo, int nivel) {
        this.id = id;
        this.aciertos = aciertos;
        this.errores = errores;
        this.tiempo = tiempo;
        this.consecutivo = consecutivo;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ActividadEstudiante getActividadEstudianteid() {
        return actividadEstudianteid;
    }

    public void setActividadEstudianteid(ActividadEstudiante actividadEstudianteid) {
        this.actividadEstudianteid = actividadEstudianteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EjercicioEstudiante)) {
            return false;
        }
        EjercicioEstudiante other = (EjercicioEstudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EjercicioEstudiante[ id=" + id + " ]";
    }
    
}
