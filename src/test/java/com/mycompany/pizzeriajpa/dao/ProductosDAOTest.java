/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.persistencia.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
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
public class ProductosDAOTest {
    private ProductosDAO productos;
    
    public ProductosDAOTest() {
        this.productos = ProductosDAO.getInstance();
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
     * Test of obtenerProductosConPrecioMaximo method, of class ProductosDAO.
     */
    @Test
    public void testObtenerProductosConPrecioMaximo() throws Exception {
        System.out.println("obtenerProductosConPrecioMaximo");
        float precioMaximo = 250;
        List<Producto> listaVacia = new ArrayList<>();
        
        List<Producto> result = this.productos.obtenerProductosConPrecioMaximo(precioMaximo);
        
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
    }

    /**
     * Test of agregarProducto method, of class ProductosDAO.
     */
    @Test
    public void testAgregarProducto() throws Exception {
        System.out.println("agregarProducto");
        //Producto producto = new Producto("Fanta 500ml", "Refresco de la marca fanta de 500ml", 20.f);
        Producto producto = new Producto("Fanta 500ml", "Refresco de la marca fanta de 500ml", 20.f);
        this.productos.agregarProducto(producto);
    }

    /**
     * Test of obtenerProducto method, of class ProductosDAO.
     */
    @Test
    public void testObtenerProducto() throws Exception {
        System.out.println("obtenerProducto");
        Long id = 1l;
        Producto result = this.productos.obtenerProducto(id);
        assertNotNull(result);
    }

    /**
     * Test of obtenerProductosConPrecioMayorA method, of class ProductosDAO.
     */
    @Test
    public void testObtenerProductosConPrecioMayorA() throws Exception {
        System.out.println("obtenerProductosConPrecioMayorA");
        float precio = 250.F;
        List<Producto> result = this.productos.obtenerProductosConPrecioMayorA(precio);
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
    }
}
