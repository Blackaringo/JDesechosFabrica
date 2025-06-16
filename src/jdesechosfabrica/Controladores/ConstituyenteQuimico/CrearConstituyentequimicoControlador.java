/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Controladores.ConstituyenteQuimico;

import jdesechosfabrica.Modelo.CasosDeUso.ConstituyenteQuimico.CrearConstituyenteQuimicoCasoDeUso;
import jdesechosfabrica.Modelo.Dto.ConstituyenteQuimico.CrearConstituyenteQuimicPeticionDto;
import jdesechosfabrica.Modelo.Dto.ConstituyenteQuimico.CrearConstituyenteQuimicoRespuestaDto;

/**
 *
 * @author HP
 */
public class CrearConstituyentequimicoControlador {
    private final CrearConstituyenteQuimicoCasoDeUso casoDeUso;

    public CrearConstituyentequimicoControlador(CrearConstituyenteQuimicoCasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }
    
    public CrearConstituyenteQuimicoRespuestaDto ejecutarAccion( CrearConstituyenteQuimicPeticionDto peticion) 
            throws Exception{
        return casoDeUso.procesar(peticion);
    }
}
