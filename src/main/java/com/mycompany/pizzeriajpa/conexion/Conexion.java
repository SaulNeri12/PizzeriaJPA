/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.pizzeriajpa.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Saul Neri
 */
public class Conexion {
    private static Conexion instancia;
    private EntityManagerFactory emf;
            
    private Conexion() {
        this.emf =  Persistence.createEntityManagerFactory("pu_pizzeria");
    }
    
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        
        return instancia;
    }
    
    public EntityManager crearConexion() {
        return emf.createEntityManager();
    }
}
