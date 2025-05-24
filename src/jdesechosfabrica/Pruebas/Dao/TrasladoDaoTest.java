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
import jdesechosfabrica.Constantes.TipoDestino;
import jdesechosfabrica.Constantes.TipoTraslado;
import jdesechosfabrica.Constantes.TipoResiduo;
import jdesechosfabrica.Constantes.TipoTransporte;
import jdesechosfabrica.Modelo.Dao.TrasladoDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Destino;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.MedioTransporte;
import jdesechosfabrica.Modelo.Entidades.Traslado;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;
import jdesechosfabrica.Modelo.Entidades.Transportista;

/**
 *
 * @author HP
 */
public class TrasladoDaoTest {

    public static void crearTrasladoDebeCrearTrasladoSinError() {

        Productor productor = new Productor(
                0,
                "Platanitos inc",
                "agropecuaria",
                new Direccion("Estados unidos", "florida", "bay beach", "elmo street", "30-17"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "galio"));
        Residuo residuo = new Residuo("RES7", TipoResiduo.TOXICO, 300, constituyentes, LocalDate.now(), productor);

        List<MedioTransporte> mediosDeTransporte = new ArrayList<>();
        mediosDeTransporte.add(new MedioTransporte("Tren bala", TipoTransporte.FERROVIARIO, 357, 1000));
        
        var transportesPerez= new Transportista("Transportadora perez y avolengo", mediosDeTransporte);
        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(transportesPerez);

        Destino destino = new Destino(
                TipoDestino.DESTINO_INTERNACIONAL, LocalDate.now(),
                new Direccion("Mexico", "juarez", "juanito perez", "lupita", "01-02")
        );

        Traslado traslado = new Traslado(0,
                LocalDate.now(),
                TipoTraslado.TOTAL,
                true,
                0,
                transportistas,
                residuo,
                destino
        );

        traslado.setResiduo(residuo);

        try {
            TrasladoDao trasladoDao = new TrasladoDao();

            trasladoDao.guardar(traslado);
            System.out.println("Traslado guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarTrasladoPorIDDebemostrarLaInformacionDelTraslado() {
        try {
            TrasladoDao trasladoDao = new TrasladoDao();
            Traslado traslado = trasladoDao.buscarPorId(1);

            System.out.println("--------------------------------");
            System.out.println("Datos del Traslado");
            System.out.println("--------------------------------");

            System.out.println(traslado);
            System.out.println("Con los transportistas");
            for (var transportista : traslado.getTransportistas()) {
                System.out.println(transportista);
                System.out.println("Con los medios de transporte");
                for (var medioTras : transportista.getMediosDeTrasporte()) {
                    System.out.println(medioTras);
                }
            }

            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosTrasladosDebeMostrarTodosLosTrasladosEnElSistema() {
        TrasladoDao trasladoDao = new TrasladoDao();
        List<Traslado> traslados = trasladoDao.obtenerTodos();

        for (Traslado traslado : traslados) {
            System.out.println("Lista de Traslados en el sistema");
            System.out.println("--------------------------------");
            System.out.println(traslado);
            System.out.println("--------------------------------");

        }

        if (traslados.isEmpty()) {
            System.out.println("No hay Traslados En El sistema");
        }
    }

    public static void actuaizarTrasladoDebeActualizarDatosDelTrasladoSinErrores() {
         Productor productor = new Productor(
                0,
                "Platanitos inc",
                "agropecuaria",
                new Direccion("Estados unidos", "florida", "bay beach", "elmo street", "30-17"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "galio"));
        Residuo residuo = new Residuo("RES7", TipoResiduo.TOXICO, 300, constituyentes, LocalDate.now(), productor);

        List<MedioTransporte> mediosDeTransporte = new ArrayList<>();
        mediosDeTransporte.add(new MedioTransporte("Tren bala", TipoTransporte.FERROVIARIO, 357, 1000));

        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(new Transportista("Transportadora perez y avolengo", mediosDeTransporte));

        Destino destino = new Destino(
                TipoDestino.DESTINO_INTERNACIONAL, LocalDate.now(),
                new Direccion("Mexico", "juarez", "juanito perez", "lupita", "01-02")
        );

        Traslado traslado = new Traslado(1,
                LocalDate.now(),
                TipoTraslado.PARCIAL,
                true,
                100,
                transportistas,
                residuo,
                destino
        );

        traslado.setResiduo(residuo);
        TrasladoDao trasladoDao = new TrasladoDao();
        try {
            trasladoDao.actualizar(traslado);
            System.out.println("Traslado actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void eliminarTrasladoDebeEliminarTrasladoSinError() {
        TrasladoDao trasladoDao = new TrasladoDao();
        try {
            trasladoDao.eliminarPorId(1);
            System.out.println("Traslado elminado correctamente");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
