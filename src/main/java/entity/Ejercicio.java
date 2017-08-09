/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joche
 */
@Entity
@Table(name = "ejercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejercicio.findAll", query = "SELECT e FROM Ejercicio e")
    , @NamedQuery(name = "Ejercicio.findById", query = "SELECT e FROM Ejercicio e WHERE e.id = :id")
    , @NamedQuery(name = "Ejercicio.findByNivel", query = "SELECT e FROM Ejercicio e WHERE e.nivel = :nivel")
    , @NamedQuery(name = "Ejercicio.findByEnunciado3", query = "SELECT e FROM Ejercicio e WHERE e.enunciado3 = :enunciado3")
    , @NamedQuery(name = "Ejercicio.findByEnunciado1", query = "SELECT e FROM Ejercicio e WHERE e.enunciado1 = :enunciado1")
    , @NamedQuery(name = "Ejercicio.findByEnunciado2", query = "SELECT e FROM Ejercicio e WHERE e.enunciado2 = :enunciado2")
    , @NamedQuery(name = "Ejercicio.findByEscenario", query = "SELECT e FROM Ejercicio e WHERE e.escenario = :escenario")})
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nivel")
    private Integer nivel;
    @Size(max = 255)
    @Column(name = "enunciado3")
    private String enunciado3;
    @Size(max = 255)
    @Column(name = "enunciado1")
    private String enunciado1;
    @Size(max = 255)
    @Column(name = "enunciado2")
    private String enunciado2;
    @Size(max = 2147483647)
    @Column(name = "escenario")
    private String escenario;
    @OneToMany(mappedBy = "ejercicioId")
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "actividad_id", referencedColumnName = "id")
    @ManyToOne
    private Actividad actividadId;
    @JoinColumn(name = "profesor_username", referencedColumnName = "username")
    @ManyToOne
    private Profesor profesorUsername;

    public Ejercicio() {
    }

    public Ejercicio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getEnunciado3() {
        return enunciado3;
    }

    public void setEnunciado3(String enunciado3) {
        this.enunciado3 = enunciado3;
    }

    public String getEnunciado1() {
        return enunciado1;
    }

    public void setEnunciado1(String enunciado1) {
        this.enunciado1 = enunciado1;
    }

    public String getEnunciado2() {
        return enunciado2;
    }

    public void setEnunciado2(String enunciado2) {
        this.enunciado2 = enunciado2;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public Actividad getActividadId() {
        return actividadId;
    }

    public void setActividadId(Actividad actividadId) {
        this.actividadId = actividadId;
    }

    public Profesor getProfesorUsername() {
        return profesorUsername;
    }

    public void setProfesorUsername(Profesor profesorUsername) {
        this.profesorUsername = profesorUsername;
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
        if (!(object instanceof Ejercicio)) {
            return false;
        }
        Ejercicio other = (Ejercicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ejercicio[ id=" + id + " ]";
    }
    
}
