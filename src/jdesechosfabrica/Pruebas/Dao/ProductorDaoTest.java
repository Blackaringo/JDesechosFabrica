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
import jdesechosfabrica.Modelo.Dao.ProductorDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;

/**
 *
 * @author HP
 */
public class ProductorDaoTest {

    public static void crearProductorDebeCrearProductorSinError() {

        Productor productor = new Productor(
                0,
                "Producciones SAS",
                "inmobiliaria",
                new Direccion("Colomba", "Cartagena", "Mamonal", "principal", "45-30"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.ACIDO, "Acido sulfurico"));
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.BASE, "Bicarbonato de calcio"));
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "Plomo"));
        Residuo residuo = new Residuo("RES1", TipoResiduo.CORROSIVO, 500, constituyentes, LocalDate.now(), productor);

        try {
            ProductorDao productorDao = new ProductorDao();

            productorDao.guardar(productor);
            System.out.println("Productor guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarProductorPorIDDebemostrarLaInformacionDelProductor() {
        try {
            ProductorDao productorDao = new ProductorDao();
            Productor productor = productorDao.buscarPorId(1);
            System.out.println("--------------------------------");
            System.out.println("Datos del productor");
            System.out.println("--------------------------------");
            System.out.println(productor);
            System.out.println("Produjo los residuos");
            for (var res : productor.getResiduos()) {
                System.out.println(res);
                System.out.println("con los contituyentes");
                for (var constituyente : res.getConstituyentes()) {
                    System.out.println(constituyente);
                }
            }
            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosProductoresDebeMostrarTodosLosProductoresEnElSistema() {
        ProductorDao productorDao = new ProductorDao();
        List<Productor> productores = productorDao.obtenerTodos();

            System.out.println("Lista de Productores en el sistema");
        for (Productor productor : productores) {
            System.out.println("--------------------------------");
            System.out.println(productor);
            System.out.println("--------------------------------");

        }
        
        if(productores.isEmpty()){
            System.out.println("No hay productores en el Sistema");
        }
    }

    public static void actuaizarProductorDebeActualizarDatosProductorSinErrores() {
        Productor productor = new Productor(
                1,
                "Producciones SAS incorporated",
                "agropecuaria",
                new Direccion("Colomba", "Cartagena", "Mamonal", "principal", "45-30"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.ACIDO, "Acido daltoaconico"));
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.BASE, "Bicarbonato de sulfurosa"));
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "mercurio"));
        Residuo residuo = new Residuo("RES2", TipoResiduo.INFECCIOSO, 500, constituyentes, LocalDate.now(), productor);

        ProductorDao productorDao = new ProductorDao();
        try {
            productorDao.actualizar(productor);
            System.out.println("Productor actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void eliminarProductorDebeEliminaProductorSinError(){
        ProductorDao productorDao = new ProductorDao();
        try{
            productorDao.eliminarPorId(1);
            System.out.println("Productor elminado correctamente");
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
