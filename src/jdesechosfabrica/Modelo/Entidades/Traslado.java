/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.util.Date;
import java.util.List;
import jdesechosfabrica.Constantes.TipoTraslado;

/**
 *
 * @author HP
 */
public class Traslado {
    private String id;
    private Date fechaTranslado;
    private TipoTraslado tipoTraslado;
    private boolean transladoSeguro;
    private double  cantidad;
    private List<Transportista> transportistas;
    private Residuo residuo;
    private Destino destino;    

    public Traslado(String id, Date fechaTranslado, TipoTraslado tipoTraslado, boolean transladoSeguro, double cantidad, List<Transportista> transportistas, Residuo residuo, Destino destino) {
         if (id== null || id.trim().isEmpty()){
            String mensaje = "el traslado requiere un id valido";
            throw new IllegalArgumentException(mensaje);
        } else if (fechaTranslado== null ){
            String mensaje = "Al crear un translado se requiere una fecha de traslado";
            throw new IllegalArgumentException(mensaje);
        }else if (tipoTraslado== null ){
            String mensaje = "Al crear un translado se requiere un tipo de  traslado valido";
            throw new IllegalArgumentException(mensaje);
        }else if (cantidad <= 0 ){
            String mensaje = "la cantidad trasladada no debe ser menor o igual a cero";
            throw new IllegalArgumentException(mensaje);
        }else if(transportistas == null || transportistas.isEmpty()){
            String mensaje = "los transportistas no pueden ser nulos ni vacios en el traslado";
            throw new IllegalArgumentException(mensaje);
        }else if(residuo == null){
            String mensaje = "se requiere un residuo valido para crear el traslado";
            throw new IllegalArgumentException(mensaje);
        }else if (destino == null){
            String mensaje = "se requiere un destino para el traslado";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.fechaTranslado = fechaTranslado;
        this.tipoTraslado = tipoTraslado;
        this.transladoSeguro = transladoSeguro;
        this.cantidad = cantidad;
        this.destino = destino;
        this.residuo = residuo;
        
        for(Transportista transportista: transportistas){
            transportista.setTraslado(this);
        }
        
        this.transportistas = transportistas;
        
        residuo.setTraslado(this);
        destino.setTraslado(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaTranslado() {
        return fechaTranslado;
    }

    public void setFechaTranslado(Date fechaTranslado) {
        this.fechaTranslado = fechaTranslado;
    }

    public TipoTraslado getTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(TipoTraslado tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public boolean isTransladoSeguro() {
        return transladoSeguro;
    }

    public void setTransladoSeguro(boolean transladoSeguro) {
        this.transladoSeguro = transladoSeguro;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Transportista> getTransportistas() {
        return transportistas;
    }

    public void setTransportistas(List<Transportista> transportistas) {
        this.transportistas = transportistas;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destno) {
        if (destino.getTraslado() != this && destino.getTraslado() != null){
            throw new IllegalArgumentException("El destino ya tiene otro traslado asociado");
        }
        this.destino = destno;
    }
    
    
}
