/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import jdesechosfabrica.Infraestructura.Config.Bd.ConexionBd;
import jdesechosfabrica.Modelo.Entidades.Productor;


/**
 *
 * @author HP
 */
public class ProductorDao {
     private EntityManagerFactory conexion;

    public ProductorDao() {
        conexion = ConexionBd.conectar();
    }
    
    public void guardar(Productor productor) throws Exception {
        EntityTransaction transaccion = null;
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
            entityManager.persist(productor);
            transaccion.commit();
            
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            String mesajeError = "Error al guardar el productor: " + productor.getId();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Productor buscarPorId(int id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            Productor productor = entityManager.find(Productor.class, id);
            if (productor == null) {
                var mesajeError = "Error el productor: " + id + " no existe";
                throw new Exception(mesajeError);
            }
            return productor;
        } catch (Exception error) {
            throw error;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Productor> obtenerTodos() {
        var entityManager = conexion.createEntityManager();
        var consulta = "SELECT p FROM Productor p";
        var listaDeProductores = entityManager.createQuery(consulta, Productor.class).getResultList();
        entityManager.close();
        return listaDeProductores;
    }

    public void actualizar(Productor productor) throws Exception {
        this.buscarPorId(productor.getId());
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
          
            transaccion.begin();
            entityManager.merge(productor);
            transaccion.commit();
            
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al actualizar el productor " + productor.getId();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void eliminarPorId(int id) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            var productor = entityManager.find(Productor.class, id);
            if(productor == null){
                throw new Exception("El productor: "+ id + " no existe");
            }
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.remove(productor);
            transaccion.commit();
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al eliminar el productor: " + id +"\n"
                    +error.getMessage();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
