/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Dto.ConstituyenteQuimico;

import java.util.List;
import jdesechosfabrica.Constantes.TipoConstituyente;

/**
 *
 * @author HP
 */
public class CrearConstituyenteQuimicoRespuestaDto {

    private final int id;
    private final TipoConstituyente tipoConstituyente;
    private final String nombre;
    private final List<Integer> residuosIds;

    public CrearConstituyenteQuimicoRespuestaDto(
            int id,
            TipoConstituyente tipoConstituyente,
            String nombre,
            List<Integer> residuosIds) {
        
        if (tipoConstituyente == null) {
            throw new IllegalArgumentException("El tipo de constituyente es requerido");
        } else if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es requerido");
        }

        this.id = id;
        this.tipoConstituyente = tipoConstituyente;
        this.nombre = nombre;
        this.residuosIds = residuosIds;
    }

    public int getId() {
        return id;
    }

    public TipoConstituyente getTipoConstituyente() {
        return tipoConstituyente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getResiduosIds() {
        return residuosIds;
    }

}
