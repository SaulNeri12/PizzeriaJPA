/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao.interfaces;

import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Empleado;

/**
 *
 * @author neri
 */
public interface IEmpleadosDAO {
    
    /**
     * 
     * @param empleado
     * @throws DAOException 
     */
    public void agregarEmpleado(Empleado empleado) throws DAOException;
    
    /**
     * 
     * @param id
     * @return
     * @throws DAOException 
     */
    public Empleado obtenerEmpleado(Long id) throws DAOException;
}
