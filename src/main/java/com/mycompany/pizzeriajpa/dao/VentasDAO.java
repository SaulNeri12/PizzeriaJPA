
package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.conexion.Conexion;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.dao.interfaces.IVentasDAO;
import com.mycompany.pizzeriajpa.persistencia.entidades.Venta;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Saul Neri
 */
public class VentasDAO implements IVentasDAO {

    private static VentasDAO instancia;
    
    @PersistenceContext
    private EntityManager em;
    
    private VentasDAO() {
        this.em = Conexion.getInstance().crearConexion();
    }
    
    public static VentasDAO getInstance() {
        if (instancia == null) {
            instancia = new VentasDAO();
        }
        
        return instancia;
    }
    
    @Override
    public List<Venta> obtenerVentasPorPeriodo(Date fechaInicio, Date fechaFin) throws DAOException {
        TypedQuery<Venta> consulta = em.createQuery("SELECT v FROM Venta v", Venta.class);
        List<Venta> ventas = consulta.getResultList();
        return ventas;
    }

    @Override
    public void agregarVenta(Venta venta) throws DAOException {
        if (venta == null) {
            throw new DAOException("La informacion de la venta esta imcompleta, porfavor ingrese los datos faltantes...");
        }
        
        em.getTransaction().begin();
        em.persist(venta);
        em.getTransaction().commit();
        em.close();
    }
}
