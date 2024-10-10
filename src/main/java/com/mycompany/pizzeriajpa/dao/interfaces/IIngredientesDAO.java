/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao.interfaces;

import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Ingrediente;
import com.mycompany.pizzeriajpa.persistencia.entidades.TipoIngrediente;
import java.util.List;

/**
 *
 * @author neri
 */
public interface IIngredientesDAO {
    
    /**
     * 
     * @param caracter
     * @return 
     * @throws DAOException 
     */
    public List<Ingrediente> obtenerIngredientesConCaracter(char caracter) throws DAOException;
    
    /**
     * 
     * @param ingrediente
     * @throws DAOException 
     */
    public void agregarIngrediente(Ingrediente ingrediente) throws DAOException;
    
    /**
     * 
     * @return
     * @throws DAOException 
     */
    public List<Ingrediente> obtenerIngredientesTodos() throws DAOException;
    
    /**
     * 
     * @return
     * @throws DAOException 
     */
    public List<TipoIngrediente> obtenerTiposIngrediente() throws DAOException;
    
    /**
     * 
     * @param tipo
     * @throws DAOException 
     */
    public void agregarTipoIngrediente(TipoIngrediente tipo) throws DAOException;
    
}




