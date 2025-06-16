/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Dto.ConstituyenteQuimico;

import jdesechosfabrica.Constantes.TipoConstituyente;

/**
 *
 * @author HP
 */
public class CrearConstituyenteQuimicPeticionDto {
    private final TipoConstituyente tipoConstituyente;
    private final String nombre;

    public CrearConstituyenteQuimicPeticionDto(TipoConstituyente tipoConstituyente, String nombre) {
       
        if(tipoConstituyente == null){
            throw new IllegalArgumentException("El tipo de constituyente es requerido");
        }else if(nombre==null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre es requerido");
        }
        
        this.tipoConstituyente = tipoConstituyente;
        this.nombre = nombre;
    }

    public TipoConstituyente getTipoConstituyente() {
        return tipoConstituyente;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
