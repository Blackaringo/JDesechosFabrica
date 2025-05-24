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
import jdesechosfabrica.Modelo.Dao.MedioTransporteDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Destino;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;
import jdesechosfabrica.Modelo.Entidades.Transportista;
import jdesechosfabrica.Modelo.Entidades.MedioTransporte;
import jdesechosfabrica.Modelo.Entidades.Traslado;

/**
 *
 * @author HP
 */
public class MedioTransporteDaoTest {

    public static void crearMedioTransporteDebeCrearMedioTransporteSinError() {

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

        var transportesPerez = new Transportista("Transportadora perez y avolengo", mediosDeTransporte);
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
                residuo.getCantidadTotalKilos(),
                transportistas,
                residuo,
                destino
        );

        var medio2 = new MedioTransporte("Barco cargero", TipoTransporte.MARITIMO, 50000, 80000);
        try {
            MedioTransporteDao medioTransporteDao = new MedioTransporteDao();

            medioTransporteDao.guardar(medio2);
            System.out.println("MedioTransporte guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarMedioTransportePorIDDebemostrarLaInformacionDelMedioTransporte() {
        try {
            MedioTransporteDao medioTransporteDao = new MedioTransporteDao();
            MedioTransporte medioTransporte = medioTransporteDao.buscarPorId(1);

            System.out.println("--------------------------------");
            System.out.println("Datos del Medio de Transporte");
            System.out.println("--------------------------------");

            System.out.println(medioTransporte);

            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosMedioTransportesDebeMostrarTodosLosMedioTransportesEnElSistema() {
        MedioTransporteDao medioTransporteDao = new MedioTransporteDao();
        List<MedioTransporte> medioTransportes = medioTransporteDao.obtenerTodos();

        System.out.println("Lista de MedioTransportes en el sistema");
        for (MedioTransporte medioTransporte : medioTransportes) {
            System.out.println("--------------------------------");
            System.out.println(medioTransporte);
            System.out.println("--------------------------------");

        }

        if (medioTransportes.isEmpty()) {
            System.out.println("No hay MedioTransportes En El sistema");
        }
    }

    public static void actuaizarMedioTransporteDebeActualizarDatosDelMedioTransporteSinErrores() {
        Productor productor = new Productor(
                0,
                "Platanitos inc",
                "agropecuaria",
                new Direccion("Estados unidos", "florida", "bay beach", "elmo street", "30-17"),
                null
        );

        List<ConstituyenteQuimico> constituyentes = new ArrayList<>();
        constituyentes.add(new ConstituyenteQuimico(TipoConstituyente.METAL_PESADO, "bromuro"));
        Residuo residuo = new Residuo("RES7", TipoResiduo.TOXICO, 300, constituyentes, LocalDate.now(), productor);

        List<MedioTransporte> mediosDeTransporte = new ArrayList<>();
        mediosDeTransporte.add(new MedioTransporte("Tren bala", TipoTransporte.FERROVIARIO, 357, 1000));

        var transportesPerez = new Transportista("Transportadora perez y avolengo", mediosDeTransporte);
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
                residuo.getCantidadTotalKilos(),
                transportistas,
                residuo,
                destino
        );

        var medio2 = new MedioTransporte(1, "medio Modificado", TipoTransporte.MARITIMO, 50000, 80000, transportesPerez);

        MedioTransporteDao medioTransporteDao = new MedioTransporteDao();
        try {
            medioTransporteDao.actualizar(medio2);
            System.out.println("MedioTransporte actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void eliminarMedioTransporteDebeEliminarMedioTransporteSinError() {
        MedioTransporteDao medioTransporteDao = new MedioTransporteDao();
        try {
            medioTransporteDao.eliminarPorId(1);
            System.out.println("MedioTransporte elminado correctamente");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
