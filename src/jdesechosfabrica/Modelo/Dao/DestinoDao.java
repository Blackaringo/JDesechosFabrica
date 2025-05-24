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
import jdesechosfabrica.Modelo.Entidades.Destino;

/**
 *
 * @author HP
 */
public class DestinoDao {

    private EntityManagerFactory conexion;

    public DestinoDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(Destino destino) throws Exception {
        EntityTransaction transaccion = null;
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();

            transaccion.begin();
            entityManager.persist(destino);
            transaccion.commit();

        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            String mesajeError = "Error al guardar el destino: " + destino.getId();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Destino buscarPorId(int id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            Destino destino = entityManager.find(Destino.class, id);
            if (destino == null) {
                var mesajeError = "Error el destino: " + id + " no existe";
                throw new Exception(mesajeError);
            }
            return destino;
        } catch (Exception error) {
            throw error;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Destino> obtenerTodos() {
        var entityManager = conexion.createEntityManager();
        var consulta = "SELECT d FROM Destino d";
        var listaDeDestinoes = entityManager.createQuery(consulta, Destino.class).getResultList();
        entityManager.close();
        return listaDeDestinoes;
    }

    public void actualizar(Destino destino) throws Exception {
        this.buscarPorId(destino.getId());
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
            entityManager.merge(destino);
            transaccion.commit();
            
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al actualizar el destino " + destino.getId();
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
            var destino = entityManager.find(Destino.class, id);
            if (destino == null) {
                throw new Exception("El destino: " + id + " no existe");
            }
            
          
            
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
              // desacociamos traslado para evitar eliminarlo
            if(destino.getTraslado()!=null){
                var traslado = destino.getTraslado();
                traslado.setDestino(null);
                entityManager.merge(traslado);
                
            }
            entityManager.remove(destino);
            transaccion.commit();
            
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al eliminar el destino: " + id + "\n"
                    + error.getMessage();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    
}
