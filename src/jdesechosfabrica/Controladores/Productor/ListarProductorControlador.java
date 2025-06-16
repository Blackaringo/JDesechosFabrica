/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Controladores.Productor;

import jdesechosfabrica.Modelo.CasosDeUso.Productor.ListarProductoresCasoDeUso;
import jdesechosfabrica.Modelo.Dto.Productor.ListarProductorResponseDto;

/**
 *
 * @author HP
 */
public class ListarProductorControlador {
    private final ListarProductoresCasoDeUso casoDeUso;

    public ListarProductorControlador(ListarProductoresCasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }
    
    public ListarProductorResponseDto ejecutarAccion(){
        return casoDeUso.procesar();
    }
}
