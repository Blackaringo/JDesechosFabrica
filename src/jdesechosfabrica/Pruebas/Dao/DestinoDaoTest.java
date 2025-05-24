/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Pruebas.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jdesechosfabrica.Constantes.TipoConstituyente;
import jdesechosfabrica.Constantes.TipoDestino;
import jdesechosfabrica.Constantes.TipoResiduo;
import jdesechosfabrica.Constantes.TipoTransporte;
import jdesechosfabrica.Constantes.TipoTraslado;
import jdesechosfabrica.Modelo.Dao.DestinoDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Destino;
import jdesechosfabrica.Modelo.Entidades.MedioTransporte;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;
import jdesechosfabrica.Modelo.Entidades.Transportista;
import jdesechosfabrica.Modelo.Entidades.Traslado;

/**
 *
 * @author HP
 */
public class DestinoDaoTest {

    public static void crearDestinoDebeCrearDestinoSinError() {

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
        List<MedioTransporte> mediosDeTransporte = new ArrayList<>();
        mediosDeTransporte.add(new MedioTransporte("Tren bala", TipoTransporte.FERROVIARIO, 357, 1000));

        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(new Transportista("Transportadora perez y avolengo", mediosDeTransporte));

        Traslado traslado = new Traslado(6,
                LocalDate.now(),
                TipoTraslado.PARCIAL,
                true,
                100,
                transportistas,
                residuo,
                null
        );

        Destino destino = new Destino(0, TipoDestino.PLANTA_INCINERADORA, LocalDate.now(), new Direccion("Colombia", "medellin", "olaya herrera", "nueva", "36-12"), traslado);

        try {
            DestinoDao destinoDao = new DestinoDao();

            destinoDao.guardar(destino);
            System.out.println("Destino guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarDestinoPorIDDebemostrarLaInformacionDelDestino() {
        try {
            DestinoDao destinoDao = new DestinoDao();
            Destino destino = destinoDao.buscarPorId(3);

            System.out.println("--------------------------------");
            System.out.println("Datos del Destino");
            System.out.println("--------------------------------");

            System.out.println(destino);

            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosDestinosDebeMostrarTodosLosDestinosEnElSistema() {
        DestinoDao destinoDao = new DestinoDao();
        List<Destino> destinos = destinoDao.obtenerTodos();

        System.out.println("Lista de Destinos en el sistema");
        for (Destino destino : destinos) {
            System.out.println("--------------------------------");
            System.out.println(destino);
            System.out.println("--------------------------------");

        }

        if (destinos.isEmpty()) {
            System.out.println("No hay Destinos En El sistema");
        }
    }

    public static void actuaizarDestinoDebeActualizarDatosDelDestinoSinErrores() {
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

        List<MedioTransporte> mediosDeTransporte = new ArrayList<>();
        mediosDeTransporte.add(new MedioTransporte("Tren bala", TipoTransporte.FERROVIARIO, 357, 1000));

        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(new Transportista("Transportadora perez y avolengo", mediosDeTransporte));

        Traslado traslado = new Traslado(6,
                LocalDate.now(),
                TipoTraslado.PARCIAL,
                true,
                100,
                transportistas,
                residuo,
                null
        );

        Destino destino = new Destino(3, TipoDestino.ALMACEN_TEMPORAL, LocalDate.now(), new Direccion("Colombia", "medellin", "olaya herrera", "nueva", "36-12"), null);

        DestinoDao destinoDao = new DestinoDao();
        try {
            destinoDao.actualizar(destino);
            System.out.println("Destino actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void eliminarDestinoDebeEliminarDestinoSinError() {
        DestinoDao destinoDao = new DestinoDao();
        try {
            destinoDao.eliminarPorId(3);
            System.out.println("Destino elminado correctamente");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
