/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maria Jose Mendoza Rincon
 */
@Entity
@Table(name = "ActividadEstudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadEstudiante.findAll", query = "SELECT a FROM ActividadEstudiante a")
    , @NamedQuery(name = "ActividadEstudiante.findById", query = "SELECT a FROM ActividadEstudiante a WHERE a.id = :id")
    , @NamedQuery(name = "ActividadEstudiante.findByAciertos", query = "SELECT a FROM ActividadEstudiante a WHERE a.aciertos = :aciertos")
    , @NamedQuery(name = "ActividadEstudiante.findByErrores", query = "SELECT a FROM ActividadEstudiante a WHERE a.errores = :errores")
    , @NamedQuery(name = "ActividadEstudiante.findByTiempo", query = "SELECT a FROM ActividadEstudiante a WHERE a.tiempo = :tiempo")
    , @NamedQuery(name = "ActividadEstudiante.findByCompletado", query = "SELECT a FROM ActividadEstudiante a WHERE a.completado = :completado")
    , @NamedQuery(name = "ActividadEstudiante.findByNivelMaximo", query = "SELECT a FROM ActividadEstudiante a WHERE a.nivelMaximo = :nivelMaximo")
    , @NamedQuery(name = "ActividadEstudiante.findByActEst", query = "SELECT a FROM ActividadEstudiante a WHERE a.actividadId.id = :idActividad AND a.estudianteId.id=:idEstudiante")
    , @NamedQuery(name = "ActividadEstudiante.findByIdEstudiante", query = "SELECT a FROM ActividadEstudiante a WHERE a.estudianteId.id=:idEstudiante")
    , @NamedQuery(name = "ActividadEstudiante.findByCurso", query = "SELECT a FROM ActividadEstudiante a WHERE a.estudianteId.cursoId.id=:idCurso")})
public class ActividadEstudiante implements Serializable {

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
    @Column(name = "completado")
    private int completado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelMaximo")
    private int nivelMaximo;
    @JoinColumn(name = "actividad_id", referencedColumnName = "id")
    @ManyToOne
    private Actividad actividadId;
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estudiante estudianteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadEstudianteid")
    private List<EjercicioEstudiante> ejercicioEstudianteList;

    public ActividadEstudiante() {
    }

    public ActividadEstudiante(Integer id) {
        this.id = id;
    }

    public ActividadEstudiante(Integer id, int aciertos, int errores, int tiempo, int completado, int nivelMaximo) {
        this.id = id;
        this.aciertos = aciertos;
        this.errores = errores;
        this.tiempo = tiempo;
        this.completado = completado;
        this.nivelMaximo = nivelMaximo;
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

    public int getCompletado() {
        return completado;
    }

    public void setCompletado(int completado) {
        this.completado = completado;
    }

    public int getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(int nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
    }

    public Actividad getActividadId() {
        return actividadId;
    }

    public void setActividadId(Actividad actividadId) {
        this.actividadId = actividadId;
    }

    public Estudiante getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Estudiante estudianteId) {
        this.estudianteId = estudianteId;
    }

    @XmlTransient
    public List<EjercicioEstudiante> getEjercicioEstudianteList() {
        return ejercicioEstudianteList;
    }

    public void setEjercicioEstudianteList(List<EjercicioEstudiante> ejercicioEstudianteList) {
        this.ejercicioEstudianteList = ejercicioEstudianteList;
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
        if (!(object instanceof ActividadEstudiante)) {
            return false;
        }
        ActividadEstudiante other = (ActividadEstudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActividadEstudiante[ id=" + id + " ]";
    }
    
}
