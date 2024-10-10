/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.persistencia.entidades.Empleado;
import java.sql.Date;
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
public class EmpleadosDAOTest {
    private EmpleadosDAO empleados;
    
    public EmpleadosDAOTest() {
        this.empleados = EmpleadosDAO.getInstance();
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
     * Test of agregarEmpleado method, of class EmpleadosDAO.
     */
    @Test
    public void testAgregarEmpleado() throws Exception {
        System.out.println("agregarEmpleado");
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan Perez Perez rodriguez");
        empleado.setFechaNac(Date.valueOf("2004-04-10"));
        empleado.setPuesto(Empleado.Puesto.ADMINISTRADOR);
        empleado.setTelefono("6444001122");
        
        //this.empleados.agregarEmpleado(empleado);
    }

    /**
     * Test of obtenerEmpleado method, of class EmpleadosDAO.
     */
    @Test
    public void testObtenerEmpleado() throws Exception {
        System.out.println("obtenerEmpleado");
        Long id = 104l;
        Empleado result = this.empleados.obtenerEmpleado(id);
        assertNotNull(result);
    }
    
}
