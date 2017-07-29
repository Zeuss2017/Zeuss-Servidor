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
@Table(name = "Estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findById", query = "SELECT e FROM Estudiante e WHERE e.id = :id")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByFechaNacimiento", query = "SELECT e FROM Estudiante e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Estudiante.findByUsername", query = "SELECT e FROM Estudiante e WHERE e.username = :username")
    , @NamedQuery(name = "Estudiante.findByCurso", query = "SELECT e FROM Estudiante e WHERE e.cursoid.id = :id")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "username")
    private String username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<ResultadoAct> resultadoActList;
    @JoinColumn(name = "Curso_id", referencedColumnName = "id")
    @ManyToOne
    private Curso cursoid;

    public Estudiante() {
    }

    public Estudiante(Integer id) {
        this.id = id;
    }

    public Estudiante(Integer id, String nombre, String fechaNacimiento, String username) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public List<ResultadoAct> getResultadoActList() {
        return resultadoActList;
    }

    public void setResultadoActList(List<ResultadoAct> resultadoActList) {
        this.resultadoActList = resultadoActList;
    }

    public Curso getCursoid() {
        return cursoid;
    }

    public void setCursoid(Curso cursoid) {
        this.cursoid = cursoid;
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
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Estudiante[ id=" + id + " ]";
    }
    
}
