
package com.mycompany.pizzeriajpa.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Saul Neri
 */
@Entity
@Table(name="venta_producto")
public class ProductoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "monto_total", nullable = false, precision = 10, scale = 2)
    private Float montoTotal;

    @Column(name = "precio_producto", nullable = false, precision = 10, scale = 2)
    private Float precioProducto;
    
    public ProductoVenta() {
        
    }
    
    public ProductoVenta(Producto producto, int cantidad) {
        if (producto!=null) {
            this.montoTotal = producto.getPrecio() * Math.abs(cantidad);
            this.precioProducto = producto.getPrecio();
            this.cantidad = cantidad;
            this.producto = producto;
        }
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
        if (!(object instanceof ProductoVenta)) {
            return false;
        }
        ProductoVenta other = (ProductoVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pizzeriajpa.persistencia.entidades.ProductoVenta[ id=" + id + " ]";
    }

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
     * @return the precioProducto
     */
    public Float getPrecioProducto() {
        return precioProducto;
    }

    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }

}
