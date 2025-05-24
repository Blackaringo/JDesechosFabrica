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
import jdesechosfabrica.Modelo.Entidades.Transportista;

/**
 *
 * @author HP
 */


public class TransportistaDao {
    private final EntityManagerFactory conexion;

    public TransportistaDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(Transportista transportista) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(transportista);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar el transportista: " + transportista.getId(), e);
        } finally {
            entityManager.close();
        }
    }

    public Transportista buscarPorId(int id) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            Transportista transportista = entityManager.find(Transportista.class, id);
            if (transportista == null) {
                throw new Exception("Transportista con ID " + id + " no encontrado");
            }
            return transportista;
        } finally {
            entityManager.close();
        }
    }

    public List<Transportista> obtenerTodos() {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t FROM Transportista t", Transportista.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void actualizar(Transportista transportista) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(transportista);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar el transportista: " + transportista.getId(), e);
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
            Transportista transportista = entityManager.find(Transportista.class, id);
            if (transportista == null) {
                throw new Exception("Transportista con ID " + id + " no encontrado");
            }
            entityManager.remove(transportista);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar el transportista: " + id, e);
        } finally {
            entityManager.close();
        }
    }
}