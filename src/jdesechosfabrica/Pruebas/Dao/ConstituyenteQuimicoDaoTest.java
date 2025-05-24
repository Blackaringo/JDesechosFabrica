/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Pruebas.Dao;

import java.util.List;
import jdesechosfabrica.Constantes.TipoConstituyente;
import jdesechosfabrica.Modelo.Dao.ConstituyenteQuimicoDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;

/**
 *
 * @author HP
 */
public class ConstituyenteQuimicoDaoTest {

    public static void crearConstituyenteQuimicoDebeCrearConstituyenteQuimicoSinError() {

        ConstituyenteQuimico constituyente = new ConstituyenteQuimico(TipoConstituyente.DISOLVENTE_NO_HALOGENADO, "Tiner");

        try {
            ConstituyenteQuimicoDao constituyenteDao = new ConstituyenteQuimicoDao();

            constituyenteDao.guardar(constituyente);
            System.out.println("ConstituyenteQuimico guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarConstituyenteQuimicoPorIDDebemostrarLaInformacionDelConstituyenteQuimico() {
        try {
            ConstituyenteQuimicoDao constituyenteDao = new ConstituyenteQuimicoDao();
            ConstituyenteQuimico constituyente = constituyenteDao.buscarPorId(1);

            System.out.println("--------------------------------");
            System.out.println("Datos del Constituyente Quimico");
            System.out.println("--------------------------------");

            System.out.println(constituyente);

            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosConstituyenteQuimicosDebeMostrarTodosLosConstituyenteQuimicosEnElSistema() {
        ConstituyenteQuimicoDao constituyenteDao = new ConstituyenteQuimicoDao();
        List<ConstituyenteQuimico> constituyentes = constituyenteDao.obtenerTodos();

        System.out.println("Lista de ConstituyenteQuimicos en el sistema");
        for (ConstituyenteQuimico constituyente : constituyentes) {
            System.out.println("--------------------------------");
            System.out.println(constituyente);
            System.out.println("--------------------------------");

        }

        if (constituyentes.isEmpty()) {
            System.out.println("No hay ConstituyenteQuimicos En El sistema");
        }
    }

    public static void actuaizarConstituyenteQuimicoDebeActualizarDatosDelConstituyenteQuimicoSinErrores() {

        ConstituyenteQuimico constituyente = new ConstituyenteQuimico(1, TipoConstituyente.ACIDO, "acido nitrico");
        ConstituyenteQuimicoDao constituyenteDao = new ConstituyenteQuimicoDao();
        try {
            constituyenteDao.actualizar(constituyente);
            System.out.println("ConstituyenteQuimico actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void eliminarConstituyenteQuimicoDebeEliminarConstituyenteQuimicoSinError() {
        ConstituyenteQuimicoDao constituyenteDao = new ConstituyenteQuimicoDao();
        try {
            constituyenteDao.eliminarPorId(1);
            System.out.println("ConstituyenteQuimico elminado correctamente");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
