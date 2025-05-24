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
import jdesechosfabrica.Modelo.Entidades.Traslado;

/**
 *
 * @author HP
 */
public class TrasladoDao {
    private final EntityManagerFactory conexion;

    public TrasladoDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(Traslado traslado) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(traslado);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar el traslado: " + traslado.getId(), e);
        } finally {
            entityManager.close();
        }
    }

    public Traslado buscarPorId(int id) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            Traslado traslado = entityManager.find(Traslado.class, id);
            if (traslado == null) {
                throw new Exception("Traslado con ID " + id + " no encontrado");
            }
            return traslado;
        } finally {
            entityManager.close();
        }
    }

    public List<Traslado> obtenerTodos() {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t FROM Traslado t", Traslado.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void actualizar(Traslado traslado) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(traslado);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar el traslado: " + traslado.getId(), e);
        } finally {
            entityManager.close();
        }
    }

    public void eliminarPorId(int id) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            Traslado traslado = entityManager.find(Traslado.class, id);
            if (traslado == null) {
                throw new Exception("Traslado con ID " + id + " no encontrado");
            }
            
            entityManager.remove(traslado);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar el traslado: " + id, e);
        } finally {
            entityManager.close();
        }
    }
}
