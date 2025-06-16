/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Dto.Residuo;

import java.time.LocalDate;
import java.util.List;
import jdesechosfabrica.Constantes.TipoResiduo;

/**
 *
 * @author HP
 */
public class ObtenerResiduoPorIdRespuestaDto {
    private final int id;
    private final String codigo;
    private final TipoResiduo tipoResiduo;
    private final LocalDate FechaGeneracion;
    private final double cantidadTotalKilos;
    private final List<Integer> constituyentesIds;
    private final int productorId;
    private final int  envaseId;
    private final List<Integer> trasladosIds;
    private final int tratamientoPosteriorId;
    private final boolean huboIncidenteSeguridad;

    public ObtenerResiduoPorIdRespuestaDto(
            int id, 
            String codigo, 
            TipoResiduo tipoResiduo, 
            LocalDate FechaGeneracion, 
            double cantidadTotalKilos, 
            List<Integer> constituyentesIds, 
            int productorId, 
            int envaseId, 
            List<Integer> trasladosIds, 
            int tratamientoPosteriorId, 
            boolean huboIncidenteSeguridad) {
        
        
        this.id = id;
        this.codigo = codigo;
        this.tipoResiduo = tipoResiduo;
        this.FechaGeneracion = FechaGeneracion;
        this.cantidadTotalKilos = cantidadTotalKilos;
        this.constituyentesIds = constituyentesIds;
        this.productorId = productorId;
        this.envaseId = envaseId;
        this.trasladosIds = trasladosIds;
        this.tratamientoPosteriorId = tratamientoPosteriorId;
        this.huboIncidenteSeguridad = huboIncidenteSeguridad;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoResiduo getTipoResiduo() {
        return tipoResiduo;
    }

    public LocalDate getFechaGeneracion() {
        return FechaGeneracion;
    }

    public double getCantidadTotalKilos() {
        return cantidadTotalKilos;
    }

    public List<Integer> getConstituyentesIds() {
        return constituyentesIds;
    }

    public int getProductorId() {
        return productorId;
    }

    public int getEnvaseId() {
        return envaseId;
    }

    public List<Integer> getTrasladosIds() {
        return trasladosIds;
    }

    public int getTratamientoPosteriorId() {
        return tratamientoPosteriorId;
    }

    public boolean isHuboIncidenteSeguridad() {
        return huboIncidenteSeguridad;
    }
    
    
}
