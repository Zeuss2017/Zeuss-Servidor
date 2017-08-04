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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariajosemendoza
 */
@Entity
@Table(name = "Ejercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejercicio.findAll", query = "SELECT e FROM Ejercicio e")
    , @NamedQuery(name = "Ejercicio.findById", query = "SELECT e FROM Ejercicio e WHERE e.id = :id")
    , @NamedQuery(name = "Ejercicio.findByEnunciado1", query = "SELECT e FROM Ejercicio e WHERE e.enunciado1 = :enunciado1")
    , @NamedQuery(name = "Ejercicio.findByEnunciado2", query = "SELECT e FROM Ejercicio e WHERE e.enunciado2 = :enunciado2")
    , @NamedQuery(name = "Ejercicio.findByEnunciado3", query = "SELECT e FROM Ejercicio e WHERE e.enunciado3 = :enunciado3")
    , @NamedQuery(name = "Ejercicio.findByNivel", query = "SELECT e FROM Ejercicio e WHERE e.nivel = :nivel")})
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "enunciado1")
    private String enunciado1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "enunciado2")
    private String enunciado2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "enunciado3")
    private String enunciado3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @JoinColumn(name = "Actividad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Actividad actividadid;
    @JoinColumn(name = "Profesor_username", referencedColumnName = "username")
    @ManyToOne
    private Profesor profesorusername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejercicioid")
    private List<Respuesta> respuestaList;

    public Ejercicio() {
    }

    public Ejercicio(Integer id) {
        this.id = id;
    }

    public Ejercicio(Integer id, String enunciado1,String enunciado2,String enunciado3,int nivel) {
        this.id = id;
        this.enunciado1 = enunciado1;
        this.enunciado2 = enunciado2;
        this.enunciado3 = enunciado3;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado1() {
        return enunciado1;
    }

    public void setEnunciado1(String enunciado) {
        this.enunciado1 = enunciado;
    }

    public String getEnunciado2() {
        return enunciado2;
    }

    public void setEnunciado2(String enunciado2) {
        this.enunciado2 = enunciado2;
    }

    public String getEnunciado3() {
        return enunciado3;
    }

    public void setEnunciado3(String enunciado3) {
        this.enunciado3 = enunciado3;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Actividad getActividadid() {
        return actividadid;
    }

    public void setActividadid(Actividad actividadid) {
        this.actividadid = actividadid;
    }

    public Profesor getProfesorusername() {
        return profesorusername;
    }

    public void setProfesorusername(Profesor profesorusername) {
        this.profesorusername = profesorusername;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
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
        return "co.edu.javeriana.universityapp.entity.Ejercicio[ id=" + id + " ]";
    }
    
}
