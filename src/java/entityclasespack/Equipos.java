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
 * @author Bolivar
 */
@Entity
@Table(name = "EQUIPOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findById", query = "SELECT e FROM Equipos e WHERE e.id = :id")
    , @NamedQuery(name = "Equipos.findByDescripccion", query = "SELECT e FROM Equipos e WHERE e.descripccion = :descripccion")
    , @NamedQuery(name = "Equipos.findByNoserial", query = "SELECT e FROM Equipos e WHERE e.noserial = :noserial")
    , @NamedQuery(name = "Equipos.findByServicetag", query = "SELECT e FROM Equipos e WHERE e.servicetag = :servicetag")
    , @NamedQuery(name = "Equipos.findByEstado", query = "SELECT e FROM Equipos e WHERE e.estado = :estado")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "DESCRIPCCION")
    private String descripccion;
    @Size(max = 50)
    @Column(name = "NOSERIAL")
    private String noserial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SERVICETAG")
    private String servicetag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "IDMARCAS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Marcas idmarcas;
    @JoinColumn(name = "IDMODELO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Modelos idmodelo;
    @JoinColumn(name = "IDTIPOTCONECCION", referencedColumnName = "ID")
    @ManyToOne
    private Tecnologiaconeccion idtipotconeccion;
    @JoinColumn(name = "IDTIPOEQUIPOS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tipoequipos idtipoequipos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipo")
    private Collection<Rentaydevolucion> rentaydevolucionCollection;

    public Equipos() {
    }

    public Equipos(Integer id) {
        this.id = id;
    }

    public Equipos(Integer id, String servicetag, String estado) {
        this.id = id;
        this.servicetag = servicetag;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public String getNoserial() {
        return noserial;
    }

    public void setNoserial(String noserial) {
        this.noserial = noserial;
    }

    public String getServicetag() {
        return servicetag;
    }

    public void setServicetag(String servicetag) {
        this.servicetag = servicetag;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Marcas getIdmarcas() {
        return idmarcas;
    }

    public void setIdmarcas(Marcas idmarcas) {
        this.idmarcas = idmarcas;
    }

    public Modelos getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Modelos idmodelo) {
        this.idmodelo = idmodelo;
    }

    public Tecnologiaconeccion getIdtipotconeccion() {
        return idtipotconeccion;
    }

    public void setIdtipotconeccion(Tecnologiaconeccion idtipotconeccion) {
        this.idtipotconeccion = idtipotconeccion;
    }

    public Tipoequipos getIdtipoequipos() {
        return idtipoequipos;
    }

    public void setIdtipoequipos(Tipoequipos idtipoequipos) {
        this.idtipoequipos = idtipoequipos;
    }

    @XmlTransient
    public Collection<Rentaydevolucion> getRentaydevolucionCollection() {
        return rentaydevolucionCollection;
    }

    public void setRentaydevolucionCollection(Collection<Rentaydevolucion> rentaydevolucionCollection) {
        this.rentaydevolucionCollection = rentaydevolucionCollection;
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
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasespack.Equipos[ id=" + id + " ]";
    }
    
}
