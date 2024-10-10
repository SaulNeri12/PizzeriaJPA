/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Ingrediente;
import com.mycompany.pizzeriajpa.persistencia.entidades.TipoIngrediente;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author neri
 */
public class IngredientesDAOTest {
    private IngredientesDAO ingredientes;
    private List<TipoIngrediente> tiposIngrediente;
    
    public IngredientesDAOTest() {
        this.ingredientes = IngredientesDAO.getInstance();
        try {
            this.tiposIngrediente = this.ingredientes.obtenerTiposIngrediente();
        } catch (DAOException ex) {
            Logger.getLogger(IngredientesDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarIngrediente method, of class IngredientesDAO.
     */
    @Test
    public void testAgregarIngrediente() throws Exception {
        List<TipoIngrediente> tipos = this.ingredientes.obtenerTiposIngrediente();
        
        Optional<TipoIngrediente> tipo = tipos.stream().filter(t -> t.getNombre().equalsIgnoreCase("especia")).findFirst();
        if (tipo.isPresent()) {
            System.out.println("agregarIngrediente");
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombre("Albahaca");
            ingrediente.setTipoIngrediente(tipo.get());
            this.ingredientes.agregarIngrediente(ingrediente);
            return;
        }
        
        fail("No se pudo realizar el test completo");
    }
    
    /**
     * Test of obtenerIngredientesConCaracter method, of class IngredientesDAO.
     */
    @Test
    public void testObtenerIngredientesConCaracter() throws Exception {
        System.out.println("obtenerIngredientesConCaracter");
        char caracter = 'a';
        List<Ingrediente> result = this.ingredientes.obtenerIngredientesConCaracter(caracter);
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
    }

    /**
     * Test of obtenerIngredientesTodos method, of class IngredientesDAO.
     */
    @Test
    public void testObtenerIngredientesTodos() throws Exception {
        System.out.println("obtenerIngredientesTodos");
        List<Ingrediente> result = this.ingredientes.obtenerIngredientesTodos();
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia ni ser null");
    }

    /**
     * Test of obtenerTiposIngrediente method, of class IngredientesDAO.
     */
    @Test
    public void testObtenerTiposIngrediente() throws Exception {
        System.out.println("obtenerTiposIngrediente");
        assertEquals(!this.tiposIngrediente.isEmpty(), "La lista no debe estar vacia");
    }

    /**
     * Test of agregarTipoIngrediente method, of class IngredientesDAO.
     */
    @Test
    public void testAgregarTipoIngrediente() throws Exception {
        System.out.println("agregarTipoIngrediente");
        TipoIngrediente tipo = new TipoIngrediente("Fruta");
        this.ingredientes.agregarTipoIngrediente(tipo);
    }
}
