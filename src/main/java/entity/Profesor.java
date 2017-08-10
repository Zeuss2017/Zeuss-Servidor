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
 * @author Maria Jose Mendoza Rincon
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByUsername", query = "SELECT p FROM Profesor p WHERE p.username = :username")
    , @NamedQuery(name = "Profesor.findByContrasena", query = "SELECT p FROM Profesor p WHERE p.contrasena = :contrasena")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "profesorUsername")
    private List<Curso> cursoList;
    @JoinColumn(name = "colegio_id", referencedColumnName = "id")
    @ManyToOne
    private Colegio colegioId;
    @OneToMany(mappedBy = "profesorUsername")
    private List<Ejercicio> ejercicioList;

    public Profesor() {
    }

    public Profesor(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public Colegio getColegioId() {
        return colegioId;
    }

    public void setColegioId(Colegio colegioId) {
        this.colegioId = colegioId;
    }

    @XmlTransient
    public List<Ejercicio> getEjercicioList() {
        return ejercicioList;
    }

    public void setEjercicioList(List<Ejercicio> ejercicioList) {
        this.ejercicioList = ejercicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Profesor[ username=" + username + " ]";
    }
    
}
