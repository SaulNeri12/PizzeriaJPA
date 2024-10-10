
package com.mycompany.pizzeriajpa;

import com.mycompany.pizzeriajpa.dao.ProductosDAO;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.persistencia.entidades.Producto;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public class PizzeriaJPA {

    public static void main(String[] args) {
        
        // MUESTRA TODOS LOS PRODUCTOS EN EL SISTEMA
        try {
            List<Producto> productos = ProductosDAO.getInstance().obtenerProductosConPrecioMaximo(250);
             
            for (Producto p: productos) {
                System.out.println(p);
            }
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
        
        Producto p = new Producto("Pizza con Champinones", "Pizza sencilla con base de tomate, queso y cubierta de champinones", 95.0f);
        /*
        
        // NOTE: AGREGA una pizza
        try {
            ProductosDAO.getInstance().agregarProducto(p);
            System.out.println("Se agrego la pizza al sistema...");
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        */
        
        System.out.println("Pizza guardada");
    }
    
    
}
