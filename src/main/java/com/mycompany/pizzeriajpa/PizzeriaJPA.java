/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pizzeriajpa;

import com.mycompany.pizzeriajpa.persistencia.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laboratorios
 */
public class PizzeriaJPA {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        /*

        Producto p = new Producto("Pizza Peperoni", "Pizza sencilla con base de tomate, queso y cubierta de peperonis", 99.9f);
        em.persist(p);
*/
        // NOTE: SE TIENE QUE BUSCAR PRIMERO LA ENTIDAD
        em.remove(new Producto(1l));
        em.getTransaction().commit();
        em.close();
        
        System.out.println("Pizza guardada");
    }
}
