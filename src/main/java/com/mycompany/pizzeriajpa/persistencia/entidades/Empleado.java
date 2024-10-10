/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.pizzeriajpa.persistencia.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Saul Neri
 */
@Entity
@Table(name="empleado")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public enum Puesto {
        CAJERO,
        COCINERO,
        ENCARGADO,
        ADMINISTRADOR,
        GERENTE,
        LIMPIEZA
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    //@Enumerated(EnumType.STRING)
    @Column(name = "puesto", nullable = false)
    private String puesto;

    @Column(name = "fecha_contratacion", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaContratacion;

    @Column(name = "fecha_nac", nullable = false)
    private Date fechaNac;

    @Column(name = "telefono", unique = true, nullable = false, length = 50)
    private String telefono;
    
    public Empleado() {
        this.fechaContratacion = new Timestamp(System.currentTimeMillis());
    }
    
    public Empleado(Long id) {
        this.id=id;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado[ id=" + id + " ]";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puesto
     */
    public Puesto getPuesto() {
        return Puesto.valueOf(puesto.toUpperCase());
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto.name().toLowerCase();
    }

    /**
     * @return the fechaContratacion
     */
    public Timestamp getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * @param fechaContratacion the fechaContratacion to set
     */
    public void setFechaContratacion(Timestamp fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
