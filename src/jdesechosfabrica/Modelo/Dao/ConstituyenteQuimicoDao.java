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
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;

/**
 *
 * @author HP
 */
public class ConstituyenteQuimicoDao {
    private EntityManagerFactory conexion;

    public ConstituyenteQuimicoDao() {
        conexion = ConexionBd.conectar();
    }
    
    public void guardar(ConstituyenteQuimico constituyente) throws Exception {
        EntityTransaction transaccion = null;
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            
            transaccion.begin();
            entityManager.persist(constituyente);
            transaccion.commit();
            
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            String mesajeError = "Error al guardar el constituyente: " + constituyente.getId();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public ConstituyenteQuimico buscarPorId(int id) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.createEntityManager();
            ConstituyenteQuimico constituyente = entityManager.find(ConstituyenteQuimico.class, id);
            if (constituyente == null) {
                var mesajeError = "Error el constituyente: " + id + " no existe";
                throw new Exception(mesajeError);
            }
           
            return constituyente;
        } catch (Exception error) {
            throw error;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<ConstituyenteQuimico> obtenerTodos() {
        var entityManager = conexion.createEntityManager();
        var consulta = "SELECT c FROM ConstituyenteQuimico c";
        var listaDeConstituyenteQuimicoes = entityManager.createQuery(consulta, ConstituyenteQuimico.class).getResultList();
        entityManager.close();
        return listaDeConstituyenteQuimicoes;
    }

    public void actualizar(ConstituyenteQuimico constituyente) throws Exception {
        this.buscarPorId(constituyente.getId());
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;
        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();
            entityManager.merge(constituyente);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al actualizar el constituyente " + constituyente.getId();
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
            var constituyente = entityManager.find(ConstituyenteQuimico.class, id);
            if(constituyente == null){
                throw new Exception("El constituyente: "+ id + " no existe");
            }
            transaccion = entityManager.getTransaction();
            transaccion.begin();
             // desasociamos los resiuos para evitar eliminarlos si se elimina el constituyente
            if(constituyente.getResiduos()!=null && !constituyente.getResiduos().isEmpty()){
                for(var residuo :constituyente.getResiduos() ){
                    residuo.removeConstituyente(id);
                    entityManager.merge(residuo);
                }
            }
            entityManager.remove(constituyente);
            transaccion.commit();
        } catch (Exception error) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            var mesajeError = "Error al eliminar el constituyente: " + id +"\n"
                    +error.getMessage();
            throw new Exception(mesajeError);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
