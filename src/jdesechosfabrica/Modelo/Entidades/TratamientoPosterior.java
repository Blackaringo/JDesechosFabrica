/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.util.Date;
import jdesechosfabrica.Constantes.TipoTratamiento;

/**
 *
 * @author HP
 */
public class TratamientoPosterior {
    private String id;
    private TipoTratamiento tipoTratamiento;
    private Date fechaTratamiento;
    private Residuo residuo;

    public TratamientoPosterior(String id, TipoTratamiento tipoTratamiento, Date fechaTratamiento, Residuo residuo) {
         if (id== null || id.trim().isEmpty()){
            String mensaje = "Al crear un tratamientoPosterior se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoTratamiento== null ){
            String mensaje = "Al crear un tratamiento posterior se requiere un tipo de tratamiento  valido";
            throw new IllegalArgumentException(mensaje);
        }else if (fechaTratamiento == null){
            String mensaje = "Al crear un tratamiento posterior se requiere una fecha valida";
            throw new IllegalArgumentException(mensaje);
        }else if (residuo == null ){
            String mensaje = "Al crear un tratamiento posterior se requiere un productor";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.tipoTratamiento = tipoTratamiento;
        this.fechaTratamiento = fechaTratamiento;
        this.residuo = residuo;
        residuo.setTratamientoPosterior(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoTratamiento getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(TipoTratamiento tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }


    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    @Override
    public String toString() {
        return "Tratamiento Posterior "  + id + " de tipo " + tipoTratamiento + " en la fecha " + fechaTratamiento;
    }
    
    
}
