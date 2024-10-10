

package com.mycompany.pizzeriajpa.dao;

import com.mycompany.pizzeriajpa.conexion.Conexion;
import com.mycompany.pizzeriajpa.dao.excepciones.DAOException;
import com.mycompany.pizzeriajpa.dao.interfaces.IEmpleadosDAO;
import com.mycompany.pizzeriajpa.persistencia.entidades.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saul Neri
 */
public class EmpleadosDAO implements IEmpleadosDAO {

    private static EmpleadosDAO instancia;
    
    @PersistenceContext
    private EntityManager em;
    
    private EmpleadosDAO() {
        this.em = Conexion.getInstance().crearConexion();
    }
    
    public static EmpleadosDAO getInstance() {
        if (instancia == null) {
            instancia = new EmpleadosDAO();
        }
        
        return instancia;
    }
    
    @Override
    public void agregarEmpleado(Empleado empleado) throws DAOException {
        if (empleado == null) {
            throw new DAOException("La informacion del empleado esta imcompleta, porfavor ingrese los datos faltantes...");
        }
        
        this.em = Conexion.getInstance().crearConexion();
        
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Empleado obtenerEmpleado(Long id) throws DAOException {
        //TypedQuery<Empleado>  consulta = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
        this.em = Conexion.getInstance().crearConexion();
        Empleado empleado = em.find(Empleado.class, id);
        return empleado;
    }
}
