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
/**
 *
 * @author HP
 */
public class ResiduoDao {
    private final EntityManagerFactory conexion;

    public ResiduoDao() {
        conexion = ConexionBd.conectar();
    }

    public void guardar(Residuo residuo) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
          
            transaccion.begin();
            entityManager.persist(residuo);
            transaccion.commit();
            
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar el residuo: " + residuo.getId(), e);
        } finally {
            entityManager.close();
        }
    }

    public Residuo buscarPorId(int id) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            Residuo residuo = entityManager.find(Residuo.class, id);
            if (residuo == null) {
                throw new Exception("Residuo con ID " + id + " no encontrado");
            }
            return residuo;
        } finally {
            entityManager.close();
        }
    }

    public List<Residuo> obtenerTodos() {
        EntityManager entityManager = conexion.createEntityManager();
        try {
            return entityManager.createQuery("SELECT r FROM Residuo r", Residuo.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void actualizar(Residuo residuo) throws Exception {
        EntityManager entityManager = conexion.createEntityManager();
        EntityTransaction transaccion = null;
        try {
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(residuo);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar el residuo: " + residuo.getId(), e);
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
            Residuo residuo = entityManager.find(Residuo.class, id);
            if (residuo == null) {
                throw new Exception("Residuo con ID " + id + " no encontrado");
            }
            entityManager.remove(residuo);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar el residuo: " + id, e);
        } finally {
            entityManager.close();
        }
    }
}