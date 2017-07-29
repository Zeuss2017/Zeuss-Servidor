/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariajosemendoza
 */
@Entity
@Table(name = "ResultadoAct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoAct.findAll", query = "SELECT r FROM ResultadoAct r")
    , @NamedQuery(name = "ResultadoAct.findByEstudianteid", query = "SELECT r FROM ResultadoAct r WHERE r.resultadoActPK.estudianteid = :estudianteid")
    , @NamedQuery(name = "ResultadoAct.findByActividadid", query = "SELECT r FROM ResultadoAct r WHERE r.resultadoActPK.actividadid = :actividadid")
    , @NamedQuery(name = "ResultadoAct.findByTotalAciertos", query = "SELECT r FROM ResultadoAct r WHERE r.totalAciertos = :totalAciertos")
    , @NamedQuery(name = "ResultadoAct.findByTotalErrores", query = "SELECT r FROM ResultadoAct r WHERE r.totalErrores = :totalErrores")
    , @NamedQuery(name = "ResultadoAct.findByTotalTiempo", query = "SELECT r FROM ResultadoAct r WHERE r.totalTiempo = :totalTiempo")
    , @NamedQuery(name = "ResultadoAct.findByMaxNivel", query = "SELECT r FROM ResultadoAct r WHERE r.maxNivel = :maxNivel")
    , @NamedQuery(name = "ResultadoAct.findByTotalEjRelizados", query = "SELECT r FROM ResultadoAct r WHERE r.totalEjRelizados = :totalEjRelizados")})
public class ResultadoAct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResultadoActPK resultadoActPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalAciertos")
    private int totalAciertos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalErrores")
    private int totalErrores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalTiempo")
    private int totalTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxNivel")
    private int maxNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalEjRelizados")
    private int totalEjRelizados;
    @JoinColumn(name = "Actividad_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividad actividad;
    @JoinColumn(name = "Estudiante_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public ResultadoAct() {
    }

    public ResultadoAct(ResultadoActPK resultadoActPK) {
        this.resultadoActPK = resultadoActPK;
    }

    public ResultadoAct(ResultadoActPK resultadoActPK, int totalAciertos, int totalErrores, int totalTiempo, int maxNivel, int totalEjRelizados) {
        this.resultadoActPK = resultadoActPK;
        this.totalAciertos = totalAciertos;
        this.totalErrores = totalErrores;
        this.totalTiempo = totalTiempo;
        this.maxNivel = maxNivel;
        this.totalEjRelizados = totalEjRelizados;
    }

    public ResultadoAct(int estudianteid, int actividadid) {
        this.resultadoActPK = new ResultadoActPK(estudianteid, actividadid);
    }

    public ResultadoActPK getResultadoActPK() {
        return resultadoActPK;
    }

    public void setResultadoActPK(ResultadoActPK resultadoActPK) {
        this.resultadoActPK = resultadoActPK;
    }

    public int getTotalAciertos() {
        return totalAciertos;
    }

    public void setTotalAciertos(int totalAciertos) {
        this.totalAciertos = totalAciertos;
    }

    public int getTotalErrores() {
        return totalErrores;
    }

    public void setTotalErrores(int totalErrores) {
        this.totalErrores = totalErrores;
    }

    public int getTotalTiempo() {
        return totalTiempo;
    }

    public void setTotalTiempo(int totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

    public int getMaxNivel() {
        return maxNivel;
    }

    public void setMaxNivel(int maxNivel) {
        this.maxNivel = maxNivel;
    }

    public int getTotalEjRelizados() {
        return totalEjRelizados;
    }

    public void setTotalEjRelizados(int totalEjRelizados) {
        this.totalEjRelizados = totalEjRelizados;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultadoActPK != null ? resultadoActPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoAct)) {
            return false;
        }
        ResultadoAct other = (ResultadoAct) object;
        if ((this.resultadoActPK == null && other.resultadoActPK != null) || (this.resultadoActPK != null && !this.resultadoActPK.equals(other.resultadoActPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.ResultadoAct[ resultadoActPK=" + resultadoActPK + " ]";
    }
    
}
