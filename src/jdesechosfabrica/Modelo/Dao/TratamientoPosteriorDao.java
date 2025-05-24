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
import jdesechosfabrica.Modelo.Entidades.Residuo;
import jdesechosfabrica.Modelo.Entidades.TratamientoPosterior;

/**
 *
 * @author HP
 */


public class TratamientoPosteriorDao {
    private final EntityManagerFactory conexion;

    public TratamientoPosteriorDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(TratamientoPosterior tratamiento) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.persist(tratamiento);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar el tratamiento: " + tratamiento.getId(), e);
        } finally {
            entityManager.close();
        }
    }

    public TratamientoPosterior buscarPorId(int id) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            TratamientoPosterior tratamiento = entityManager.find(TratamientoPosterior.class, id);
            if (tratamiento == null) {
                throw new Exception("Tratamiento con ID " + id + " no encontrado");
            }
            return tratamiento;
        } finally {
            entityManager.close();
        }
    }

    public List<TratamientoPosterior> obtenerTodos() {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            return entityManager.createQuery("SELECT t FROM TratamientoPosterior t", TratamientoPosterior.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void actualizar(TratamientoPosterior tratamiento) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(tratamiento);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar el tratamiento: " + tratamiento.getId(), e);
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
            TratamientoPosterior tratamiento = entityManager.find(TratamientoPosterior.class, id);
            
            if (tratamiento == null) {
                throw new Exception("Tratamiento con ID " + id + " no encontrado");
            }
            
            // si existen residuos asociados los desasociamos para evitar eliminarlos
            if (tratamiento.getResiduo() != null){
                Residuo residuo = tratamiento.getResiduo();
                residuo.setEnvase(null);
                entityManager.merge(residuo);
            }
            
            
            entityManager.remove(tratamiento);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar el tratamiento: " + id, e);
        } finally {
            entityManager.close();
        }
    }
}