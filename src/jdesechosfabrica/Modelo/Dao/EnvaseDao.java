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
import jdesechosfabrica.Modelo.Entidades.Envase;
import jdesechosfabrica.Modelo.Entidades.Residuo;
/**
 *
 * @author HP
 */


public class EnvaseDao {
    private final EntityManagerFactory conexion;

    public EnvaseDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(Envase envase) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(envase);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar el envase: " + envase.getId(), e);
        } finally {
            entityManager.close();
        }
    }

    public Envase buscarPorId(int id) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            Envase envase = entityManager.find(Envase.class, id);
            if (envase == null) {
                throw new Exception("Envase con ID " + id + " no encontrado");
            }
            return envase;
        } finally {
            entityManager.close();
        }
    }

    public List<Envase> obtenerTodos() {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Envase e", Envase.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void actualizar(Envase envase) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
            entityManager.merge(envase);
            transaccion.commit();
            
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar el envase: " + envase.getId(), e);
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
            Envase envase = entityManager.find(Envase.class, id);
            
            if (envase == null) {
                throw new Exception("Envase con ID " + id + " no encontrado");
            }
            
            // si existen residuos asociados los desasociamos para evitar eliminarlos
            if (envase.getResiduo() != null){
                Residuo residuo = envase.getResiduo();
                residuo.setEnvase(null);
                entityManager.merge(residuo);
            }
            
            
            entityManager.remove(envase);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar el envase: " + id, e);
        } finally {
            entityManager.close();
        }
    }
}