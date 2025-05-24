/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdesechosfabrica;

import jdesechosfabrica.Pruebas.Dao.ConstituyenteQuimicoDaoTest;
import jdesechosfabrica.Pruebas.Dao.DestinoDaoTest;
import jdesechosfabrica.Pruebas.Dao.EnvaseDaoTest;
import jdesechosfabrica.Pruebas.Dao.MedioTransporteDaoTest;
import jdesechosfabrica.Pruebas.Dao.ProductorDaoTest;
import jdesechosfabrica.Pruebas.Dao.ResiduoDaoTest;
import jdesechosfabrica.Pruebas.Dao.TransportistaDaoTest;
import jdesechosfabrica.Pruebas.Dao.TrasladoDaoTest;
import jdesechosfabrica.Pruebas.Dao.TratamientoPosteriorDaoTest;

/**
 *
 * @author HP
 */
public class JDesechosFabrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Prueba del proyecto");
        System.out.println("###############################");
        System.out.println("Prueba Productor");
        ProductorDaoTest.crearProductorDebeCrearProductorSinError();
        ProductorDaoTest.buscarProductorPorIDDebemostrarLaInformacionDelProductor();
        ProductorDaoTest.mostrarTodosLosProductoresDebeMostrarTodosLosProductoresEnElSistema();
        ProductorDaoTest.actuaizarProductorDebeActualizarDatosProductorSinErrores();
        ProductorDaoTest.buscarProductorPorIDDebemostrarLaInformacionDelProductor();
        ProductorDaoTest.eliminarProductorDebeEliminaProductorSinError();
        ProductorDaoTest.mostrarTodosLosProductoresDebeMostrarTodosLosProductoresEnElSistema();

        System.out.println("###############################");
        System.out.println("Prueba Residuo");
        ResiduoDaoTest.crearResiduoDebeCrearResiduoSinError();
        ResiduoDaoTest.buscarResiduoPorIDDebemostrarLaInformacionDelResiduo();
        ResiduoDaoTest.mostrarTodosLosResiduosesDebeMostrarTodosLosResiduosEnElSistema();
        ResiduoDaoTest.actuaizarResiduoDebeActualizarDatosDelResiduoSinErrores();
        ResiduoDaoTest.buscarResiduoPorIDDebemostrarLaInformacionDelResiduo();
        ResiduoDaoTest.eliminarResiduoDebeEliminarResiduoSinError();
        ResiduoDaoTest.mostrarTodosLosResiduosesDebeMostrarTodosLosResiduosEnElSistema();

        System.out.println("###############################");
        System.out.println("Prueba Envase");
        EnvaseDaoTest.crearEnvaseDebeCrearEnvaseSinError();
        EnvaseDaoTest.buscarEnvasePorIDDebemostrarLaInformacionDelEnvase();
        EnvaseDaoTest.mostrarTodosLosEnvasesDebeMostrarTodosLosEnvasesEnElSistema();
        EnvaseDaoTest.actuaizarEnvaseDebeActualizarDatosDelEnvaseSinErrores();
        EnvaseDaoTest.buscarEnvasePorIDDebemostrarLaInformacionDelEnvase();
        EnvaseDaoTest.eliminarEnvaseDebeEliminarEnvaseSinError();
        EnvaseDaoTest.mostrarTodosLosEnvasesDebeMostrarTodosLosEnvasesEnElSistema();

        System.out.println("###############################");
        System.out.println("Prueba Tratamiento Posterior");
        TratamientoPosteriorDaoTest.crearTratamientoPosteriorDebeCrearTratamientoPosteriorSinError();
        TratamientoPosteriorDaoTest.buscarTratamientoPosteriorPorIDDebemostrarLaInformacionDelTratamientoPosterior();
        TratamientoPosteriorDaoTest.mostrarTodosLosTratamientoPosteriorsDebeMostrarTodosLosTratamientoPosteriorsEnElSistema();
        TratamientoPosteriorDaoTest.actuaizarTratamientoPosteriorDebeActualizarDatosDelTratamientoPosteriorSinErrores();
        TratamientoPosteriorDaoTest.buscarTratamientoPosteriorPorIDDebemostrarLaInformacionDelTratamientoPosterior();
        TratamientoPosteriorDaoTest.eliminarTratamientoPosteriorDebeEliminarTratamientoPosteriorSinError();
        TratamientoPosteriorDaoTest.mostrarTodosLosTratamientoPosteriorsDebeMostrarTodosLosTratamientoPosteriorsEnElSistema();

        System.out.println("###############################");
        System.out.println("Prueba Constituyente Quimico");
        ConstituyenteQuimicoDaoTest.crearConstituyenteQuimicoDebeCrearConstituyenteQuimicoSinError();
        ConstituyenteQuimicoDaoTest.buscarConstituyenteQuimicoPorIDDebemostrarLaInformacionDelConstituyenteQuimico();
        ConstituyenteQuimicoDaoTest.mostrarTodosLosConstituyenteQuimicosDebeMostrarTodosLosConstituyenteQuimicosEnElSistema();
        ConstituyenteQuimicoDaoTest.actuaizarConstituyenteQuimicoDebeActualizarDatosDelConstituyenteQuimicoSinErrores();
        ConstituyenteQuimicoDaoTest.buscarConstituyenteQuimicoPorIDDebemostrarLaInformacionDelConstituyenteQuimico();
        ConstituyenteQuimicoDaoTest.eliminarConstituyenteQuimicoDebeEliminarConstituyenteQuimicoSinError();
        ConstituyenteQuimicoDaoTest.mostrarTodosLosConstituyenteQuimicosDebeMostrarTodosLosConstituyenteQuimicosEnElSistema();

        System.out.println("###############################");
        System.out.println("Prueba traslado");
        TrasladoDaoTest.crearTrasladoDebeCrearTrasladoSinError();
        TrasladoDaoTest.buscarTrasladoPorIDDebemostrarLaInformacionDelTraslado();
        TrasladoDaoTest.mostrarTodosLosTrasladosDebeMostrarTodosLosTrasladosEnElSistema();
        TrasladoDaoTest.actuaizarTrasladoDebeActualizarDatosDelTrasladoSinErrores();
        TrasladoDaoTest.buscarTrasladoPorIDDebemostrarLaInformacionDelTraslado();
        TrasladoDaoTest.eliminarTrasladoDebeEliminarTrasladoSinError();
        TrasladoDaoTest.mostrarTodosLosTrasladosDebeMostrarTodosLosTrasladosEnElSistema();
        
        System.out.println("###############################");
        System.out.println("Prueba Transportista");
        TransportistaDaoTest.crearTransportistaDebeCrearTransportistaSinError();
        TransportistaDaoTest.buscarTransportistaPorIDDebemostrarLaInformacionDelTransportista();
        TransportistaDaoTest.mostrarTodosLosTransportistasDebeMostrarTodosLosTransportistasEnElSistema();
        TransportistaDaoTest.actuaizarTransportistaDebeActualizarDatosDelTransportistaSinErrores();
        TransportistaDaoTest.buscarTransportistaPorIDDebemostrarLaInformacionDelTransportista();
        TransportistaDaoTest.eliminarTransportistaDebeEliminarTransportistaSinError();
        TransportistaDaoTest.mostrarTodosLosTransportistasDebeMostrarTodosLosTransportistasEnElSistema();

        System.out.println("###############################");
        System.out.println("Prueba Medio Transporte");
        MedioTransporteDaoTest.crearMedioTransporteDebeCrearMedioTransporteSinError();
        MedioTransporteDaoTest.buscarMedioTransportePorIDDebemostrarLaInformacionDelMedioTransporte();
        MedioTransporteDaoTest.mostrarTodosLosMedioTransportesDebeMostrarTodosLosMedioTransportesEnElSistema();
        MedioTransporteDaoTest.actuaizarMedioTransporteDebeActualizarDatosDelMedioTransporteSinErrores();
        MedioTransporteDaoTest.buscarMedioTransportePorIDDebemostrarLaInformacionDelMedioTransporte();
        MedioTransporteDaoTest.eliminarMedioTransporteDebeEliminarMedioTransporteSinError();
        MedioTransporteDaoTest.mostrarTodosLosMedioTransportesDebeMostrarTodosLosMedioTransportesEnElSistema();
        
        
        System.out.println("###############################");
        System.out.println("Prueba Destino");
        DestinoDaoTest.crearDestinoDebeCrearDestinoSinError();
        DestinoDaoTest.buscarDestinoPorIDDebemostrarLaInformacionDelDestino();
        DestinoDaoTest.mostrarTodosLosDestinosDebeMostrarTodosLosDestinosEnElSistema();
        DestinoDaoTest.actuaizarDestinoDebeActualizarDatosDelDestinoSinErrores();
        DestinoDaoTest.buscarDestinoPorIDDebemostrarLaInformacionDelDestino();
        DestinoDaoTest.eliminarDestinoDebeEliminarDestinoSinError();
        DestinoDaoTest.mostrarTodosLosDestinosDebeMostrarTodosLosDestinosEnElSistema();
        
    }
}
