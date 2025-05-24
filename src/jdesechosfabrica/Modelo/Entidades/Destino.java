/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jdesechosfabrica.Constantes.TipoDestino;

/**
 *
 * @author HP
 */

@Entity
@Table(name = "Destinos")
public class Destino implements Serializable{
    private static final long serialVersionUID = 0L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private TipoDestino tipoDestino;
    
    private LocalDate fechaLLegada;
    
    @Embedded
    private Direccion direcionDestino;
    
    @OneToOne(mappedBy = "destino")
    private Traslado traslado;

    public Destino(TipoDestino tipoDestino, LocalDate fechaLLegada, Direccion direccionDestino){
            
        if (fechaLLegada== null ){
            String mensaje = "Al crear un destino se requiere una fecha de llegada";
            throw new IllegalArgumentException(mensaje);
        }else if (tipoDestino== null ){
            String mensaje = "Al crear un translado se requiere un tipo de  traslado valido";
            throw new IllegalArgumentException(mensaje);
        }else if(direccionDestino == null){
            String mensaje = "se requiere una direccion de destino valida  para crear el destino";
            throw new IllegalArgumentException(mensaje);
        }
        

        this.tipoDestino = tipoDestino;
        this.fechaLLegada = fechaLLegada;
        this.direcionDestino = direccionDestino;
        this.traslado = null;

    }

    public Destino() {
    }

    public Destino(int id, TipoDestino tipoDestino, LocalDate fechaLLegada, Direccion direcionDestino, Traslado traslado) {
        this.id = id;
        this.tipoDestino = tipoDestino;
        this.fechaLLegada = fechaLLegada;
        this.direcionDestino = direcionDestino;
        this.traslado = traslado;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public TipoDestino getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoDestino(TipoDestino tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    public LocalDate getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(LocalDate fechaLLegada) {
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
        if(this.traslado!=traslado){
            this.traslado = traslado;
        }
        if(traslado.getDestino()!=this){
            traslado.setDestino(this);
        }
    }

    @Override
    public String toString() {
        return "Destino " +  id + " de tipo " + tipoDestino + " rumbo a "  + direcionDestino + " Con fecha de llegada " + fechaLLegada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Destino other = (Destino) obj;
        return this.id == other.id;
    }
                
    
}
