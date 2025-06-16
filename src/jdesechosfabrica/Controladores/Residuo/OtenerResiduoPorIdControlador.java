/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Controladores.Residuo;

import jdesechosfabrica.Modelo.CasosDeUso.Residuo.ObtenerResiduoPorIdCasoDeUso;
import jdesechosfabrica.Modelo.Dto.Residuo.ObtenerResiduoPorIdPeticionDto;
import jdesechosfabrica.Modelo.Dto.Residuo.ObtenerResiduoPorIdRespuestaDto;

/**
 *
 * @author HP
 */
public class OtenerResiduoPorIdControlador {
    private final ObtenerResiduoPorIdCasoDeUso casoDeUso;

    public OtenerResiduoPorIdControlador(ObtenerResiduoPorIdCasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }
    
    public ObtenerResiduoPorIdRespuestaDto ejecutarAccion(ObtenerResiduoPorIdPeticionDto peticion) throws Exception{
        return casoDeUso.procesar(peticion);
    }
}
