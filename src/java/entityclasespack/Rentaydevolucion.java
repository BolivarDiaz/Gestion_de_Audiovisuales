/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclasespack;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bolivar
 */
@Entity
@Table(name = "RENTAYDEVOLUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentaydevolucion.findAll", query = "SELECT r FROM Rentaydevolucion r")
    , @NamedQuery(name = "Rentaydevolucion.findByNoprestamo", query = "SELECT r FROM Rentaydevolucion r WHERE r.noprestamo = :noprestamo")
    , @NamedQuery(name = "Rentaydevolucion.findByFechaprestamo", query = "SELECT r FROM Rentaydevolucion r WHERE r.fechaprestamo = :fechaprestamo")
    , @NamedQuery(name = "Rentaydevolucion.findByFechadevolucion", query = "SELECT r FROM Rentaydevolucion r WHERE r.fechadevolucion = :fechadevolucion")
    , @NamedQuery(name = "Rentaydevolucion.findByComentario", query = "SELECT r FROM Rentaydevolucion r WHERE r.comentario = :comentario")
    , @NamedQuery(name = "Rentaydevolucion.findByEstado", query = "SELECT r FROM Rentaydevolucion r WHERE r.estado = :estado")})
public class Rentaydevolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOPRESTAMO")
    private Integer noprestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAPRESTAMO")
    @Temporal(TemporalType.DATE)
    private Date fechaprestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADEVOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fechadevolucion;
    @Size(max = 50)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleados idempleado;
    @JoinColumn(name = "IDEQUIPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Equipos idequipo;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios idusuario;

    public Rentaydevolucion() {
    }

    public Rentaydevolucion(Integer noprestamo) {
        this.noprestamo = noprestamo;
    }

    public Rentaydevolucion(Integer noprestamo, Date fechaprestamo, Date fechadevolucion, String estado) {
        this.noprestamo = noprestamo;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
        this.estado = estado;
    }

    public Integer getNoprestamo() {
        return noprestamo;
    }

    public void setNoprestamo(Integer noprestamo) {
        this.noprestamo = noprestamo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleados getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleados idempleado) {
        this.idempleado = idempleado;
    }

    public Equipos getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Equipos idequipo) {
        this.idequipo = idequipo;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noprestamo != null ? noprestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rentaydevolucion)) {
            return false;
        }
        Rentaydevolucion other = (Rentaydevolucion) object;
        if ((this.noprestamo == null && other.noprestamo != null) || (this.noprestamo != null && !this.noprestamo.equals(other.noprestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasespack.Rentaydevolucion[ noprestamo=" + noprestamo + " ]";
    }
    
}
