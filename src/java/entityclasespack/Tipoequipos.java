/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclasespack;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Bolivar
 */
@Entity
@Table(name = "TIPOEQUIPOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoequipos.findAll", query = "SELECT t FROM Tipoequipos t")
    , @NamedQuery(name = "Tipoequipos.findById", query = "SELECT t FROM Tipoequipos t WHERE t.id = :id")
    , @NamedQuery(name = "Tipoequipos.findByDescripcion", query = "SELECT t FROM Tipoequipos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipoequipos.findByEstado", query = "SELECT t FROM Tipoequipos t WHERE t.estado = :estado")})
public class Tipoequipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoequipos")
    private Collection<Equipos> equiposCollection;

    public Tipoequipos() {
    }

    public Tipoequipos(Integer id) {
        this.id = id;
    }

    public Tipoequipos(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
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
        if (!(object instanceof Tipoequipos)) {
            return false;
        }
        Tipoequipos other = (Tipoequipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasespack.Tipoequipos[ id=" + id + " ]";
    }
    
}
