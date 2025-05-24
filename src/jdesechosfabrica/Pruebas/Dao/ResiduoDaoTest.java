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
import jdesechosfabrica.Modelo.Dao.ResiduoDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;

/**
 *
 * @author HP
 */

public class ResiduoDaoTest {
    
    public static void crearResiduoDebeCrearResiduoSinError() {

        Productor productor = new Productor(
                0,
                "Evil corp",
                "tecnologia",
                new Direccion("Estados unidos", "new york", "manhatan", "wall street", "30-17"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "Litio"));
        Residuo residuo = new Residuo("RES3", TipoResiduo.REACTIVO, 300, constituyentes, LocalDate.now(), productor);

        try {
            ResiduoDao residuoDao = new ResiduoDao();

            residuoDao.guardar(residuo);
            System.out.println("Residuo guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarResiduoPorIDDebemostrarLaInformacionDelResiduo() {
        try {
            ResiduoDao residuoDao = new ResiduoDao();
            Residuo residuo = residuoDao.buscarPorId(3);
            
            System.out.println("--------------------------------");
            System.out.println("Datos del Residuo");
            System.out.println("--------------------------------");
        
            System.out.println(residuo);
            System.out.println("con los contituyentes");
            for (var constituyente : residuo.getConstituyentes()) {
                    System.out.println(constituyente);
                }
            
            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosResiduosesDebeMostrarTodosLosResiduosEnElSistema() {
         ResiduoDao residuoDao = new ResiduoDao();
        List<Residuo> residuos = residuoDao.obtenerTodos();

            System.out.println("Lista de Residuos en el sistema");
        for (Residuo residuo : residuos) {
            System.out.println("--------------------------------");
            System.out.println(residuo);
            System.out.println("--------------------------------");

        }
        
        if(residuos.isEmpty()){
            System.out.println("No hay Residuos En El sistema");
        }
    }

    public static void actuaizarResiduoDebeActualizarDatosDelResiduoSinErrores() {
        Productor productor = new Productor(
                0,
                "Clinica san buenaventura",
                "agropecuaria",
                new Direccion("Colomba", "Buenaventura", "olimpica", "nueva", "12-24"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.MATERIAL_CONTAMINADO, "agujas clinicas"));
        Residuo residuo = new Residuo(3, "RES3", TipoResiduo.INFECCIOSO, LocalDate.now(), 500, constituyentes, productor, null, null, null, true);


         ResiduoDao residuoDao = new ResiduoDao();
        try {
            residuoDao.actualizar(residuo);
            System.out.println("Residuo actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void eliminarResiduoDebeEliminarResiduoSinError(){
        ResiduoDao residuoDao = new ResiduoDao();
        try{
            residuoDao.eliminarPorId(3);
            System.out.println("Residuo elminado correctamente");
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
