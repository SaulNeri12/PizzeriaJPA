/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao.interfaces;

import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Venta;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author neri
 */
public interface IVentasDAO {
    /**
     * 
     * @param fechaInicio
     * @param fechaFin
     * @return
     * @throws DAOException 
     */
    public List<Venta> obtenerVentasPorPeriodo(Date fechaInicio, Date fechaFin) throws DAOException;
    
    /**
     * 
     * @param venta
     * @throws DAOException 
     */
    public void agregarVenta(Venta venta) throws DAOException;
}
