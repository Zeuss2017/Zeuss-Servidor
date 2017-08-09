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
@Table(name = "colegio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colegio.findAll", query = "SELECT c FROM Colegio c")
    , @NamedQuery(name = "Colegio.findById", query = "SELECT c FROM Colegio c WHERE c.id = :id")
    , @NamedQuery(name = "Colegio.findByCalendario", query = "SELECT c FROM Colegio c WHERE c.calendario = :calendario")
    , @NamedQuery(name = "Colegio.findByCiudad", query = "SELECT c FROM Colegio c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Colegio.findByDireccion", query = "SELECT c FROM Colegio c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Colegio.findByNombre", query = "SELECT c FROM Colegio c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Colegio.findByTelefono", query = "SELECT c FROM Colegio c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Colegio.findCities", query = "SELECT DISTINCT(c.ciudad) FROM Colegio c")})
public class Colegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "calendario")
    private String calendario;
    @Size(max = 255)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private Integer telefono;
    @OneToMany(mappedBy = "colegioId")
    private List<Profesor> profesorList;

    public Colegio() {
    }

    public Colegio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
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
        if (!(object instanceof Colegio)) {
            return false;
        }
        Colegio other = (Colegio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Colegio[ id=" + id + " ]";
    }
    
}
