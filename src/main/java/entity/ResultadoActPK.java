/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mariajosemendoza
 */
@Embeddable
public class ResultadoActPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Estudiante_id")
    private int estudianteid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Actividad_id")
    private int actividadid;

    public ResultadoActPK() {
    }

    public ResultadoActPK(int estudianteid, int actividadid) {
        this.estudianteid = estudianteid;
        this.actividadid = actividadid;
    }

    public int getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(int estudianteid) {
        this.estudianteid = estudianteid;
    }

    public int getActividadid() {
        return actividadid;
    }

    public void setActividadid(int actividadid) {
        this.actividadid = actividadid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += estudianteid;
        hash += actividadid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoActPK)) {
            return false;
        }
        ResultadoActPK other = (ResultadoActPK) object;
        if (this.estudianteid != other.estudianteid) {
            return false;
        }
        if (this.actividadid != other.actividadid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.ResultadoActPK[ estudianteid=" + estudianteid + ", actividadid=" + actividadid + " ]";
    }
    
}
