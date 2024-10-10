
package com.mycompany.pizzeriajpa.persistencia.entidades;

import com.mycompany.pizzeriajpa.persistencia.entidades.Ingrediente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Saul Neri
 */
@Entity
@Table(name="tipo_ingrediente")
public class TipoIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false, length = 100)
    private String nombre;
    
    @OneToMany(cascade= CascadeType.PERSIST, mappedBy="tipoIngrediente")
    private List<Ingrediente> ingredientes;

    public TipoIngrediente() {
    
    }
    
    public TipoIngrediente(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof TipoIngrediente)) {
            return false;
        }
        TipoIngrediente other = (TipoIngrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoIngrediente[ id=" + id + ", nombre=" + nombre + " ]";
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
     * @return the ingredientes
     */
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
