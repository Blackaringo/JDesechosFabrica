/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Pruebas.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jdesechosfabrica.Constantes.TipoConstituyente;
import jdesechosfabrica.Constantes.TipoResiduo;
import jdesechosfabrica.Constantes.TipoTratamiento;
import jdesechosfabrica.Modelo.Dao.TratamientoPosteriorDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.TratamientoPosterior;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;

/**
 *
 * @author HP
 */
public class TratamientoPosteriorDaoTest {
     public static void crearTratamientoPosteriorDebeCrearTratamientoPosteriorSinError() {

        Productor productor = new Productor(
                0,
                "Patatas corp",
                "agropecuaria",
                new Direccion("Estados unidos", "florida", "bay beach", "elmo street", "10-57"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "galio"));
        Residuo residuo = new Residuo("RES5", TipoResiduo.TOXICO, 900, constituyentes, LocalDate.now(), productor);
        
        TratamientoPosterior tratamiento = new TratamientoPosterior(0, TipoTratamiento.TERMICO, LocalDate.now(), residuo);

        try {
            TratamientoPosteriorDao tratamientoDao = new TratamientoPosteriorDao();

            tratamientoDao.guardar(tratamiento);
            System.out.println("Tratamiento Posterior guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarTratamientoPosteriorPorIDDebemostrarLaInformacionDelTratamientoPosterior() {
        try {
            TratamientoPosteriorDao tratamientoDao = new TratamientoPosteriorDao();
            TratamientoPosterior tratamiento = tratamientoDao.buscarPorId(1);
            
            System.out.println("--------------------------------");
            System.out.println("Datos del Tratamiento Posterior");
            System.out.println("--------------------------------");
        
            System.out.println(tratamiento);
            
            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosTratamientoPosteriorsDebeMostrarTodosLosTratamientoPosteriorsEnElSistema() {
        TratamientoPosteriorDao tratamientoDao = new TratamientoPosteriorDao();
        List<TratamientoPosterior> tratamientos = tratamientoDao.obtenerTodos();

        System.out.println("Lista de Tratamiento Posterior en el sistema");
        for (TratamientoPosterior tratamiento : tratamientos) {
            System.out.println("--------------------------------");
            System.out.println(tratamiento);
            System.out.println("--------------------------------");

        }
        
        if(tratamientos.isEmpty()){
            System.out.println("No hay Tratamiento Posterior En El sistema");
        }
    }

    public static void actuaizarTratamientoPosteriorDebeActualizarDatosDelTratamientoPosteriorSinErrores() {
              Productor productor = new Productor(
                0,
                "Custom motors",
                "automobilistica",
                new Direccion("Estados unidos", "florida", "bay beach", "coconut street", "10-57"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "galio"));
        Residuo residuo = new Residuo("RES5", TipoResiduo.TOXICO, 900, constituyentes, LocalDate.now(), productor);
        
        TratamientoPosterior tratamiento = new TratamientoPosterior(1, TipoTratamiento.QUIMICO, LocalDate.now(), residuo);

         TratamientoPosteriorDao tratamientoDao = new TratamientoPosteriorDao();
        try {
            tratamientoDao.actualizar(tratamiento);
            System.out.println("Tratamiento Posterior actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void eliminarTratamientoPosteriorDebeEliminarTratamientoPosteriorSinError(){
        TratamientoPosteriorDao tratamientoDao = new TratamientoPosteriorDao();
        try{
            tratamientoDao.eliminarPorId(1);
            System.out.println("Tratamiento Posterior elminado correctamente");
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
