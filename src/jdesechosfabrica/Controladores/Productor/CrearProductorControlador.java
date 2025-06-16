/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Controladores.Productor;

import jdesechosfabrica.Modelo.CasosDeUso.Productor.CrearProductorCasoDeUso;
import jdesechosfabrica.Modelo.Dto.Productor.CrearProductorPeticionDto;
import jdesechosfabrica.Modelo.Dto.Productor.CrearProductorRespuestaDto;

/**
 *
 * @author HP
 */
public class CrearProductorControlador {
    private final CrearProductorCasoDeUso casoDeuso;

    public CrearProductorControlador(CrearProductorCasoDeUso casoDeuso) {
        this.casoDeuso = casoDeuso;
    }
    
    public CrearProductorRespuestaDto ejecutarAccion( CrearProductorPeticionDto peticion) throws Exception{
        return casoDeuso.procesar(peticion);
    }
}
