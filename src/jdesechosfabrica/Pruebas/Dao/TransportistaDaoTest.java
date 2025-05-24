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
import jdesechosfabrica.Constantes.TipoResiduo;
import jdesechosfabrica.Constantes.TipoTransporte;
import jdesechosfabrica.Constantes.TipoTraslado;
import jdesechosfabrica.Modelo.Dao.TransportistaDao;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Destino;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.MedioTransporte;
import jdesechosfabrica.Modelo.Entidades.Transportista;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;
import jdesechosfabrica.Modelo.Entidades.Traslado;

/**
 *
 * @author HP
 */
public class TransportistaDaoTest {
         public static void crearTransportistaDebeCrearTransportistaSinError() {

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
        
        // creamos un nuevo trasportista
        List<MedioTransporte> medios2 = new ArrayList<>();
        medios2.add(new MedioTransporte("Avion de carga",TipoTransporte.AEREO, 3000, 500000));
        Transportista transportista2 = new Transportista("Transportadora 2", medios2);
        
        
        try {
            TransportistaDao transportistaDao = new TransportistaDao();
            transportistaDao.guardar(transportista2);
            System.out.println("Transportista guardado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void buscarTransportistaPorIDDebemostrarLaInformacionDelTransportista() {
        try {
            TransportistaDao transportistaDao = new TransportistaDao();
            Transportista transportista = transportistaDao.buscarPorId(3);
            
            System.out.println("--------------------------------");
            System.out.println("Datos del Transportista");
            System.out.println("--------------------------------");
        
            System.out.println(transportista);
            System.out.println("Con los medios de transporte");
            for (var medio: transportista.getMediosDeTrasporte()){
                    System.out.println("----------------------------------------------");
                    System.out.println(medio);
                    System.out.println("----------------------------------------------");

            }
            
            System.out.println("--------------------------------");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void mostrarTodosLosTransportistasDebeMostrarTodosLosTransportistasEnElSistema() {
         TransportistaDao transportistaDao = new TransportistaDao();
        List<Transportista> transportistas = transportistaDao.obtenerTodos();

            System.out.println("Lista de Transportistas en el sistema");
        for (Transportista transportista : transportistas) {
            System.out.println("--------------------------------");
            System.out.println(transportista);
            System.out.println("--------------------------------");

        }
        
        if(transportistas.isEmpty()){
            System.out.println("No hay Transportistas En El sistema");
        }
    }

    public static void actuaizarTransportistaDebeActualizarDatosDelTransportistaSinErrores() {
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
        
        // creamos un nuevo trasportista
        List<MedioTransporte> medios2 = new ArrayList<>();
        medios2.add(new MedioTransporte("Furgoneta de carga",TipoTransporte.TERRESTRE, 30, 80000));
        Transportista transportista2 = new Transportista(3, "Transportadora MODIFICADA", traslado, medios2);
        
         TransportistaDao transportistaDao = new TransportistaDao();
        try {
            transportistaDao.actualizar(transportista2);
            System.out.println("Transportista actualizado correctamente");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void eliminarTransportistaDebeEliminarTransportistaSinError(){
        TransportistaDao transportistaDao = new TransportistaDao();
        try{
            transportistaDao.eliminarPorId(3);
            System.out.println("Transportista elminado correctamente");
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
}
