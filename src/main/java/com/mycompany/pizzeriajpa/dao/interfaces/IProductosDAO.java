/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao.interfaces;

import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Producto;
import java.util.List;

/**
 *
 * @author neri
 */
public interface IProductosDAO {
    /**
     * 
     * @param precioMaximo
     * @return 
     * @throws com.mycompany.pizzeriajpa.dao.excepciones.DAOException 
     */
    public List<Producto> obtenerProductosConPrecioMaximo(float precioMaximo) throws DAOException;
    
    /**
     * 
     * @param precio
     * @return 
     * @throws com.mycompany.pizzeriajpa.dao.excepciones.DAOException 
     */
    public List<Producto> obtenerProductosConPrecioMayorA(float precio) throws DAOException;
    
    /**
     * 
     * @param producto
     * @throws DAOException 
     */
    public void agregarProducto(Producto producto) throws DAOException;
    
    /**
     * 
     * @param id
     * @return
     * @throws DAOException 
     */
    public Producto obtenerProducto(Long id) throws DAOException;
    
}
