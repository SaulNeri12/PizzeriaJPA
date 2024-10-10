/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.conexion.Conexion;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.dao.interfaces.IProductosDAO;
import com.mycompany.pizzeriajpa.persistencia.entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Saul Neri
 */
public class ProductosDAO implements IProductosDAO {
    private static ProductosDAO instancia;
    
    @PersistenceContext
    private EntityManager em;
    
    private ProductosDAO() {
        this.em = Conexion.getInstance().crearConexion();
    }
    
    public static ProductosDAO getInstance() {
        if (instancia == null) {
            instancia = new ProductosDAO();
        }
        
        return instancia;
    }

    @Override
    public List<Producto> obtenerProductosConPrecioMaximo(float precioMaximo) throws DAOException {
        TypedQuery<Producto>  consulta = em.createQuery("SELECT p FROM Producto p WHERE p.precio < :precioMaximo", Producto.class);
        consulta.setParameter("precioMaximo", precioMaximo);
        List<Producto> productos = consulta.getResultList();
        return productos;
    }

    @Override
    public void agregarProducto(Producto producto) throws DAOException {
        
        if (producto == null) {
            throw new DAOException("La informacion del producto esta imcompleta, porfavor ingrese los datos faltantes...");
        }
        
        this.em = Conexion.getInstance().crearConexion();
        
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Producto obtenerProducto(Long id) throws DAOException {
        //TypedQuery<Producto>  consulta = em.createQuery("SELECT p FROM Producto p WHERE p.id = :id", Producto.class);
        //consulta.setParameter("id", id);
        //return consulta.getSingleResult();
        Producto producto = em.find(Producto.class, id);
        return producto;
    }

    @Override
    public List<Producto> obtenerProductosConPrecioMayorA(float precio) throws DAOException {
        TypedQuery<Producto>  consulta = em.createQuery("SELECT p FROM Producto p WHERE p.precio >= :precioMaximo", Producto.class);
        consulta.setParameter("precioMaximo", precio);
        List<Producto> productos = consulta.getResultList();
        return productos;
    }
}
