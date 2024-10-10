
package com.mycompany.pizzeriajpa;

import com.mycompany.pizzeriajpa.dao.EmpleadosDAO;
import com.mycompany.pizzeriajpa.dao.IngredientesDAO;
import com.mycompany.pizzeriajpa.dao.ProductosDAO;
import com.mycompany.pizzeriajpa.dao.VentasDAO;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Empleado;
import com.mycompany.pizzeriajpa.persistencia.entidades.Producto;
import com.mycompany.pizzeriajpa.persistencia.entidades.ProductoVenta;
import com.mycompany.pizzeriajpa.persistencia.entidades.TipoIngrediente;
import com.mycompany.pizzeriajpa.persistencia.entidades.Venta;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laboratorios
 */
public class PizzeriaJPA {

    public static void main(String[] args) {
        
        // MUESTRA TODOS LOS PRODUCTOS EN EL SISTEMA
        /*
               
        List<Producto> productos = null;
        
        try {
            productos = ProductosDAO.getInstance().obtenerProductosConPrecioMaximo(250);
             
            for (Producto p: productos) {
                System.out.println(p);
            }
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            productos = ProductosDAO.getInstance().obtenerProductosConPrecioMaximo(250);
             
            for (Producto p: productos) {
                System.out.println(p);
            }
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
        
        //Producto p = new Producto("Pizza con Champinones", "Pizza sencilla con base de tomate, queso y cubierta de champinones", 95.0f);
        
        Producto p = new Producto("Coca Cola 600ml", "Refresco de la marca coca cola de 600ml", 20.f);

        // NOTE: AGREGA una pizza
        try {
            ProductosDAO.getInstance().agregarProducto(p);
            System.out.println("Se agrego el refresco al sistema...");
            
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        
        p = new Producto("Coca Cola 500ml", "Refresco de la marca coca cola de 500ml", 20.f);
        
        try {
            ProductosDAO.getInstance().agregarProducto(p);
            System.out.println("Se agrego el refresco al sistema...");
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        
        p = new Producto("Pizza Boneless Suprema", "Pizza boneless jumbo con triple porcion de boneless + 1 refresco de 500ml gratis", 279.f);
        
        try {
            ProductosDAO.getInstance().agregarProducto(p);
            System.out.println("Se agrego la pizza al sistema...");
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        
        p = new Producto("Pizza Carnes Frias", "Pizza con base de tomate y queso, cubierta con salchicha, jamon, tocino y chorizo", 249.f);
        
        try {
            ProductosDAO.getInstance().agregarProducto(p);
            System.out.println("Se agrego la pizza al sistema al sistema...");
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        /*
        Empleado empleado = new Empleado();
        empleado.setNombre("Pedro Lopez Perez");
        empleado.setFechaNac(Date.valueOf("2004-04-06"));
        empleado.setPuesto(Empleado.Puesto.CAJERO);
        empleado.setTelefono("6444001199");
        
        try {
            EmpleadosDAO.getInstance().agregarEmpleado(empleado);
            System.out.println("Se agrego un empleado al sistema");
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        

        Empleado empleado = null;
        
        try {
            empleado = EmpleadosDAO.getInstance().obtenerEmpleado(103l);
            
            
        } catch (DAOException ex) {
            Logger.getLogger(PizzeriaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Venta venta = new Venta();
        venta.setEmpleado(empleado);
        venta.setNombreCliente("Juan Murrieta");
        venta.setTelCliente("6443300000");

        try {
            VentasDAO.getInstance().agregarVenta(venta);
                       
            List<ProductoVenta> productosVenta = new ArrayList<>();
            productosVenta.add(new ProductoVenta(productos.getFirst(), 3));
            productosVenta.add(new ProductoVenta(productos.getLast(), 4));
            venta.setProductosVenta(productosVenta);
            
            VentasDAO.getInstance().actualizarVenta(venta);
            
            System.out.println("Se agrego la venta al sistema...");
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Pizza guardada");
        
        TipoIngrediente tipo = new TipoIngrediente("Especia");
        try {
            IngredientesDAO.getInstance().agregarTipoIngrediente(tipo);
        } catch (DAOException ex) {
            Logger.getLogger(PizzeriaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tipo = new TipoIngrediente("Verdura");
        try {
            IngredientesDAO.getInstance().agregarTipoIngrediente(tipo);
        } catch (DAOException ex) {
            Logger.getLogger(PizzeriaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tipo = new TipoIngrediente("Carnes Frias");
        try {
            IngredientesDAO.getInstance().agregarTipoIngrediente(tipo);
        } catch (DAOException ex) {
            Logger.getLogger(PizzeriaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    
}
