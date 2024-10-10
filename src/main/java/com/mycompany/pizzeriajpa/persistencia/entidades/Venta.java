

package com.mycompany.pizzeriajpa.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Saul Neri
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombreCliente;

    @Column(name = "tel_cliente", nullable = false, length = 100)
    private String telCliente;

    @Column(name = "fecha_hora", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaHora;

    @Column(name = "monto_total", nullable = false, precision = 10, scale = 2)
    private Float montoTotal;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;
    
    @OneToMany(mappedBy = "venta", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ProductoVenta> productosVenta;
    
    public Venta() {
        this.fechaHora = new Timestamp(System.currentTimeMillis());
    }
    
    public Venta(Long id) {
        this.id = id;
    }
           
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pizzeriajpa.persistencia.entidades.Venta[ id=" + id + " ]";
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the telCliente
     */
    public String getTelCliente() {
        return telCliente;
    }

    /**
     * @param telCliente the telCliente to set
     */
    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    /**
     * @return the fechaHora
     */
    public Timestamp getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the montoTotal
     */
    public Float getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the productosVenta
     */
    public List<ProductoVenta> getProductosVenta() {
        return productosVenta;
    }

    /**
     * @param productosVenta the productosVenta to set
     */
    public void setProductosVenta(List<ProductoVenta> productosVenta) {
        this.productosVenta = productosVenta;
    }

}
