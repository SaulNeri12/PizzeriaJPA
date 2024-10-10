
package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Empleado;
import com.mycompany.pizzeriajpa.persistencia.entidades.Producto;
import com.mycompany.pizzeriajpa.persistencia.entidades.ProductoVenta;
import com.mycompany.pizzeriajpa.persistencia.entidades.Venta;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
public class VentasDAOTest {
    private VentasDAO ventas;
    private Empleado empleado;
    private List<Producto> productos;
    
    public VentasDAOTest() {
        this.ventas = VentasDAO.getInstance();
        
        try {
            this.empleado = EmpleadosDAO.getInstance().obtenerEmpleado(103l);
        } catch (DAOException ex) {
            Logger.getLogger(VentasDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.productos = ProductosDAO.getInstance().obtenerProductosConPrecioMaximo(1000.f);
        } catch (DAOException ex) {
            Logger.getLogger(VentasDAOTest.class.getName()).log(Level.SEVERE, null, ex);
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
     * Test of obtenerVentasPorPeriodo method, of class VentasDAO.
     */
    @Test
    public void testObtenerVentasPorPeriodo() throws Exception {
        System.out.println("obtenerVentasPorPeriodo");
        Date fechaInicio = Date.valueOf("2024-09-10");
        Date fechaFin = Date.valueOf("2024-12-20");
        List<Venta> result = this.ventas.obtenerVentasPorPeriodo(fechaInicio, fechaFin);
        assertTrue(!result.isEmpty(), "La lista no deberia estar vacia");
    }

    /**
     * Test of agregarVenta method, of class VentasDAO.
     */
    @Test
    public void testAgregarVenta() throws Exception {
        System.out.println("agregarVenta");
        Venta venta = new Venta();
        venta.setEmpleado(this.empleado);
        venta.setNombreCliente("Miguel Chairez");
        venta.setTelCliente("6443311111");
        
        this.ventas.agregarVenta(venta);
    }
    
    /**
     * Test of agregarVenta method, of class VentasDAO.
     */
    @Test
    public void testActualizarVenta() throws Exception {
        System.out.println("agregarVenta");
        Venta venta = this.ventas.obtenerVenta(16l);
        
        List<ProductoVenta> productos = new ArrayList<>();
        productos.add(new ProductoVenta(this.productos.get(0), 2));
        productos.add(new ProductoVenta(this.productos.get(3), 2));
        productos.add(new ProductoVenta(this.productos.get(4), 2));
        
        venta.setProductosVenta(productos);
        
        this.ventas.actualizarVenta(venta);
    }
}
