/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Pruebas.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jdesechosfabrica.Constantes.EstadoUso;
import jdesechosfabrica.Constantes.TipoConstituyente;
import jdesechosfabrica.Constantes.TipoEnvase;
import jdesechosfabrica.Constantes.TipoResiduo;
import jdesechosfabrica.Modelo.Dao.EnvaseDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Envase;
import jdesechosfabrica.Modelo.Entidades.Residuo;

/**
 *
 * @author HP
 */
public class EnvaseDaoTest {
    public static void crearEnvaseDebeCrearEnvaseSinError() {

        Productor productor = new Productor(
                0,
                "Platanitos inc",
                "agropecuaria",
                new Direccion("Estados unidos", "florida", "bay beach", "elmo street", "30-17"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "galio"));
        Residuo residuo = new Residuo("RES4", TipoResiduo.TOXICO, 300, constituyentes, LocalDate.now(), productor);
        
        Envase envase = new Envase(TipoEnvase.RECIPIENTE, EstadoUso.EN_USO);
        envase.setResiduo(residuo);

        try {
            EnvaseDao envaseDao = new EnvaseDao();

            envaseDao.guardar(envase);
            System.out.println("Envase guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarEnvasePorIDDebemostrarLaInformacionDelEnvase() {
        try {
            EnvaseDao envaseDao = new EnvaseDao();
            Envase envase = envaseDao.buscarPorId(1);
            
            System.out.println("--------------------------------");
            System.out.println("Datos del Envase");
            System.out.println("--------------------------------");
        
            System.out.println(envase);
            
            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosEnvasesDebeMostrarTodosLosEnvasesEnElSistema() {
         EnvaseDao envaseDao = new EnvaseDao();
        List<Envase> envases = envaseDao.obtenerTodos();

            System.out.println("Lista de Envases en el sistema");
        for (Envase envase : envases) {
            System.out.println("--------------------------------");
            System.out.println(envase);
            System.out.println("--------------------------------");

        }
        
        if(envases.isEmpty()){
            System.out.println("No hay Envases En El sistema");
        }
    }

    public static void actuaizarEnvaseDebeActualizarDatosDelEnvaseSinErrores() {
        Productor productor = new Productor(
                0,
                "Drogueria la nuestra",
                "agropecuaria",
                new Direccion("Colomba", "cali", "vlla rica", "hercules", "52-14"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.MATERIAL_CONTAMINADO, "envolturas de medicamento"));
        Residuo residuo = new Residuo(4, "RES4", TipoResiduo.INFECCIOSO, LocalDate.now(), 500, constituyentes, productor, null, null, null, true);

         Envase envase = new Envase(1, TipoEnvase.CAJA, EstadoUso.EN_USO, residuo);
         EnvaseDao envaseDao = new EnvaseDao();
        try {
            envaseDao.actualizar(envase);
            System.out.println("Envase actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void eliminarEnvaseDebeEliminarEnvaseSinError(){
        EnvaseDao envaseDao = new EnvaseDao();
        try{
            envaseDao.eliminarPorId(1);
            System.out.println("Envase elminado correctamente");
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
