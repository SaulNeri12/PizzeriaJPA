
package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.conexion.Conexion;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.dao.interfaces.IVentasDAO;
import com.mycompany.pizzeriajpa.persistencia.entidades.ProductoVenta;
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
        this.em = Conexion.getInstance().crearConexion();
        TypedQuery<Venta> consulta = em.createQuery("SELECT v FROM Venta v WHERE v.fechaHora >= :fechaInicio AND v.fechaHora <= :fechaFin", Venta.class);
        consulta.setParameter("fechaInicio", fechaInicio);
        consulta.setParameter("fechaFin", fechaFin);
        List<Venta> ventas = consulta.getResultList();
        return ventas;
    }

    @Override
    public void agregarVenta(Venta venta) throws DAOException {
        
        if (venta == null) {
            throw new DAOException("La informacion de la venta esta incompleta, porfavor ingrese los datos faltantes...");
        }
        
        if (venta.getEmpleado() == null) {
            throw new DAOException("La informacion de la venta esta incompleta, falta la informacion del empleado responsable, porfavor ingrese los datos faltantes...");
        }
        
        if (venta.getNombreCliente() == null) {
            throw new DAOException("La informacion de la venta esta incompleta, falta el nombre del cliente, porfavor ingrese los datos faltantes...");
        }
        
        /*
        if (venta.getProductosVenta() == null || venta.getProductosVenta().isEmpty()) {
            throw new DAOException("La informacion de la venta esta incompleta, no se especificaron los productos para realizar la venta...");
        }*/
        
        if (venta.getTelCliente() == null || venta.getTelCliente().isBlank() || venta.getTelCliente().isEmpty()) {
            throw new DAOException("La informacion de la venta esta incompleta, falta el numero de telefono del cliente, porfavor ingrese los datos faltantes...");
        }
        
        //float totalVenta = 0.0f;
        
        /*
        for (ProductoVenta p: venta.getProductosVenta()) {
            totalVenta += p.getPrecioProducto() * p.getCantidad();
        }*/
        
        venta.setMontoTotal(0.f);
        
        this.em = Conexion.getInstance().crearConexion();
        
        try {
            // Iniciar transacción
            em.getTransaction().begin();

            em.persist(venta);

            // Finalizar transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // En caso de error, revertir la transacción
            }
            throw new DAOException("Error al guardar la venta: " + e.getMessage());
        } finally {
            if (em.isOpen()) {
                em.close(); // Cerrar el EntityManager solo cuando todas las operaciones hayan terminado
            }
        }
    }

    @Override
    public void actualizarVenta(Venta venta) throws DAOException {
        if (venta == null) {
            throw new DAOException("La información de la venta está incompleta, por favor ingrese los datos faltantes...");
        }

        if (venta.getId() == null) {
            throw new DAOException("La información de la venta es inválida, el ID no puede ser nulo.");
        }

        if (venta.getEmpleado() == null) {
            throw new DAOException("La información de la venta está incompleta, falta la información del empleado responsable, por favor ingrese los datos faltantes...");
        }

        if (venta.getNombreCliente() == null) {
            throw new DAOException("La información de la venta está incompleta, falta el nombre del cliente, por favor ingrese los datos faltantes...");
        }

        if (venta.getTelCliente() == null || venta.getTelCliente().isBlank() || venta.getTelCliente().isEmpty()) {
            throw new DAOException("La información de la venta está incompleta, falta el número de teléfono del cliente, por favor ingrese los datos faltantes...");
        }

        // Calcular el monto total de la venta
        float totalVenta = 0.0f;
        if (venta.getProductosVenta() != null) {
            for (ProductoVenta p : venta.getProductosVenta()) {
                totalVenta += p.getPrecioProducto() * p.getCantidad();
            }
        }

        venta.setMontoTotal(totalVenta); // Establecer el monto total de la venta

        this.em = Conexion.getInstance().crearConexion();
        
        try {
            // Iniciar transacción
            em.getTransaction().begin();

            // Actualizar la venta existente
            em.merge(venta);

            // Actualizar los productos de venta
            if (venta.getProductosVenta() != null) {
                for (ProductoVenta productoVenta : venta.getProductosVenta()) {
                    productoVenta.setVenta(venta); // Asegurar que cada ProductoVenta tenga la referencia a la Venta
                    em.merge(productoVenta); // Usar merge para actualizar ProductoVenta
                }
            }

            // Finalizar transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // En caso de error, revertir la transacción
            }
            System.out.println(e);
            throw new DAOException("Error al actualizar la venta: " + e.getMessage());
        } finally {
            if (em.isOpen()) {
                em.close(); // Cerrar el EntityManager solo cuando todas las operaciones hayan terminado
            }
        }
    }

    @Override
    public Venta obtenerVenta(Long id) throws DAOException {
        this.em = Conexion.getInstance().crearConexion();
        Venta v = em.find(Venta.class, id);
        return v;
    }
}
