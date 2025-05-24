/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jdesechosfabrica.Constantes.TipoTraslado;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Traslados")
public class Traslado implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fechaTranslado;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoTraslado tipoTraslado;
    private boolean transladoSeguro;
    private double cantidad;

    // Relaciones
    @OneToMany(mappedBy = "traslado" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transportista> transportistas; 

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Residuo residuo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Destino destino;

    public Traslado(LocalDate fechaTranslado, TipoTraslado tipoTraslado, boolean transladoSeguro, double cantidad, List<Transportista> transportistas, Residuo residuo, Destino destino) {
        if (fechaTranslado == null) {
            String mensaje = "Al crear un translado se requiere una fecha de traslado";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoTraslado == null) {
            String mensaje = "Al crear un translado se requiere un tipo de  traslado valido";
            throw new IllegalArgumentException(mensaje);
        } else if (cantidad <= 0) {
            String mensaje = "la cantidad trasladada no debe ser menor o igual a cero";
            throw new IllegalArgumentException(mensaje);
        } else if (transportistas == null || transportistas.isEmpty()) {
            String mensaje = "los transportistas no pueden ser nulos ni vacios en el traslado";
            throw new IllegalArgumentException(mensaje);
        } else if (residuo == null) {
            String mensaje = "se requiere un residuo valido para crear el traslado";
            throw new IllegalArgumentException(mensaje);
        } else if (destino == null) {
            String mensaje = "se requiere un destino para el traslado";
            throw new IllegalArgumentException(mensaje);
        }


        this.fechaTranslado = fechaTranslado;
        this.tipoTraslado = tipoTraslado;
        this.transladoSeguro = transladoSeguro;
        this.cantidad = cantidad;
        this.destino = destino;
        this.residuo = residuo;

        for (Transportista transportista : transportistas) {
            transportista.setTraslado(this);
        }

        this.transportistas = transportistas;

        residuo.addTraslado(this);
        destino.setTraslado(this);
    }

    public Traslado() {
    }

    public Traslado(int id, LocalDate fechaTranslado, TipoTraslado tipoTraslado, boolean transladoSeguro, double cantidad, List<Transportista> transportistas, Residuo residuo, Destino destino) {
        this.id = id;
        this.fechaTranslado = fechaTranslado;
        this.tipoTraslado = tipoTraslado;
        this.transladoSeguro = transladoSeguro;
        this.cantidad = cantidad;
        this.transportistas = transportistas;
        this.residuo = residuo;
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaTranslado() {
        return fechaTranslado;
    }

    public void setFechaTranslado(LocalDate fechaTranslado) {
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

    public void addTransportista(Transportista transportista){
        if(!transportistas.contains(transportista)){
            transportistas.add(transportista);
        }
        if (transportista.getTraslado() != this){
            transportista.setTraslado(this);
        }
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
        if(destno==null){
        
            this.destino = destno;
            return;
        }
        if (destino.getTraslado() != this && destino.getTraslado() != null) {
            throw new IllegalArgumentException("El destino ya tiene otro traslado asociado");
        }
       
        if(destno!= this.destino){
            this.destino = destno;
        }
    }

    @Override
    public String toString() {
        String seguro = transladoSeguro ? "Si" : "No";
        return "Traslado " + "de tipo " + tipoTraslado + "Seguro " + seguro + " cantidad " + cantidad + "kg";
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Traslado other = (Traslado) obj;
        return this.id == other.id;
    }

}
