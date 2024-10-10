/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.conexion.Conexion;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.dao.interfaces.IIngredientesDAO;
import com.mycompany.pizzeriajpa.persistencia.entidades.Ingrediente;
import com.mycompany.pizzeriajpa.persistencia.entidades.TipoIngrediente;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Saul Neri
 */
public class IngredientesDAO implements IIngredientesDAO {

    private static IngredientesDAO instancia;
    
    @PersistenceContext
    private EntityManager em;
    
    private IngredientesDAO() {
        this.em = Conexion.getInstance().crearConexion();
    }
    
    public static IngredientesDAO getInstance() {
        if (instancia == null) {
            instancia = new IngredientesDAO();
        }
        
        return instancia;
    }
 
    @Override
    public List<Ingrediente> obtenerIngredientesConCaracter(char caracter) throws DAOException {
        this.em = Conexion.getInstance().crearConexion();
        String jpql = "SELECT i FROM Ingrediente i WHERE i.nombre LIKE :inicio AND i.nombre LIKE :fin";
        TypedQuery<Ingrediente> query = em.createQuery(jpql, Ingrediente.class);
        
        query.setParameter("inicio", caracter + "%");
        query.setParameter("fin", "%" + caracter);

        return query.getResultList();
    }

    @Override
    public void agregarIngrediente(Ingrediente ingrediente) throws DAOException {
        if (ingrediente == null) {
            throw new DAOException("La informacion del ingrediente esta imcompleta, porfavor ingrese los datos faltantes...");
        }
        
        this.em = Conexion.getInstance().crearConexion();
        
        em.getTransaction().begin();
        em.persist(ingrediente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Ingrediente> obtenerIngredientesTodos() throws DAOException {
        this.em = Conexion.getInstance().crearConexion();
        TypedQuery<Ingrediente> consulta = em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class);
        return consulta.getResultList();
    }

    @Override
    public List<TipoIngrediente> obtenerTiposIngrediente() throws DAOException {
        this.em = Conexion.getInstance().crearConexion();
        TypedQuery<TipoIngrediente> consulta = em.createQuery("SELECT t FROM TipoIngrediente t", TipoIngrediente.class);
        return consulta.getResultList();
    }

    @Override
    public void agregarTipoIngrediente(TipoIngrediente tipo) throws DAOException {
        if (tipo == null) {
            throw new DAOException("La informacion del tipo de ingrediente esta imcompleta, porfavor ingrese los datos faltantes...");
        }
        
        this.em = Conexion.getInstance().crearConexion();
        
        em.getTransaction().begin();
        em.persist(tipo);
        em.getTransaction().commit();
        em.close();
    }
}
