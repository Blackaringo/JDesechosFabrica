/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.util.Date;
import jdesechosfabrica.Constantes.TipoDestino;

/**
 *
 * @author HP
 */
public class Destino {
    private String id;
    private TipoDestino tipoDestino;
    private Date fechaLLegada;
    private Direccion direcionDestino;
    private Traslado traslado;

    public Destino(String id, TipoDestino tipoDestino, Date fechaLLegada, Direccion direccionDestino){
            
         if (id== null || id.trim().isEmpty()){
            String mensaje = "el destino requiere un id valido";
            throw new IllegalArgumentException(mensaje);
        } else if (fechaLLegada== null ){
            String mensaje = "Al crear un destino se requiere una fecha de llegada";
            throw new IllegalArgumentException(mensaje);
        }else if (tipoDestino== null ){
            String mensaje = "Al crear un translado se requiere un tipo de  traslado valido";
            throw new IllegalArgumentException(mensaje);
        }else if(direcionDestino == null){
            String mensaje = "se requiere una direccion de destino valida  para crear el destino";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.tipoDestino = tipoDestino;
        this.fechaLLegada = fechaLLegada;
        this.direcionDestino = direccionDestino;
        this.traslado = null;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoDestino getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoDestino(TipoDestino tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    public Date getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(Date fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public Direccion getDirecionDestino() {
        return direcionDestino;
    }

    public void setDirecionDestino(Direccion direcionDestino) {
        this.direcionDestino = direcionDestino;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        if(traslado.getDestino() != this && traslado.getDestino() != null){
            throw new IllegalArgumentException("El traslado ya tiene otro destino asociado");
        }
        this.traslado = traslado;
    }
                
}
