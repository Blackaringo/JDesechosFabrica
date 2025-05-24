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
import jdesechosfabrica.Modelo.Entidades.MedioTransporte;

/**
 *
 * @author HP
 */
public class MedioTransporteDao {
    private EntityManagerFactory conexion;

    public MedioTransporteDao() {
        conexion = ConexionBd.conectar();
    }
    
    public void guardar(MedioTransporte medioTransporte) throws Exception {
        EntityTransaction transaccion = null;
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
            entityManager.persist(medioTransporte);
            transaccion.commit();
            
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            String mesajeError = "Error al guardar el medioTransporte: " + medioTransporte.getId();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public MedioTransporte buscarPorId(int id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            MedioTransporte medioTransporte = entityManager.find(MedioTransporte.class, id);
            if (medioTransporte == null) {
                var mesajeError = "Error el medioTransporte: " + id + " no existe";
                throw new Exception(mesajeError);
            }
            return medioTransporte;
        } catch (Exception error) {
            throw error;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<MedioTransporte> obtenerTodos() {
        var entityManager = conexion.createEntityManager();
        var consulta = "SELECT m FROM MedioTransporte m";
        var listaDeMedioTransportees = entityManager.createQuery(consulta, MedioTransporte.class).getResultList();
        entityManager.close();
        return listaDeMedioTransportees;
    }

    public void actualizar(MedioTransporte medioTransporte) throws Exception {
        this.buscarPorId(medioTransporte.getId());
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
            entityManager.merge(medioTransporte);
            transaccion.commit();
            
            
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al actualizar el medioTransporte " + medioTransporte.getId();
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
            var medioTransporte = entityManager.find(MedioTransporte.class, id);
            if(medioTransporte == null){
                throw new Exception("El medioTransporte: "+ id + " no existe");
            }
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            // desasociar transportistas para evitar eliminarlos
            if(medioTransporte.getTransportista()!=null){
                medioTransporte.getTransportista().removeMedioTransporte(id);
                entityManager.merge(medioTransporte.getTransportista());
            }
            entityManager.remove(medioTransporte);
            transaccion.commit();
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al eliminar el medioTransporte: " + id +"\n"
                    +error.getMessage();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
