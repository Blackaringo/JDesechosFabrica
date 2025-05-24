/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import jdesechosfabrica.Constantes.TipoTransporte;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Medios_de_Trasporte")
public class MedioTransporte implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoTransporte tipo;

    private double distancia;
    private double coste;

    @ManyToOne
    private Transportista transportista;

    public MedioTransporte(String nombre, TipoTransporte tipo, double distancia, double coste) {
        if (nombre == null || nombre.trim().isEmpty()) {
            String mensaje = "el medio de trasporte requiere un nombre valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipo == null) {
            String mensaje = "el medio de transporte requiere un tipo valido";
            throw new IllegalArgumentException(mensaje);
        }

        this.nombre = nombre;
        this.tipo = tipo;
        this.distancia = distancia;
        this.coste = coste;
    }

    public MedioTransporte() {
    }

    public MedioTransporte(int id, String nombre, TipoTransporte tipo, double distancia, double coste, Transportista transportista) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.distancia = distancia;
        this.coste = coste;
        this.transportista = transportista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        
        if (transportista == null){
            this.transportista = null;
            return;
        }
        if (transportista != this.transportista) {
            this.transportista = transportista;
        }
        
        if (transportista != null && !transportista.getMediosDeTrasporte().contains(this)){
            transportista.addMedioTransporte(this);
        }
    }

    @Override
    public String toString() {
        return tipo + " " + nombre;
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
        final MedioTransporte other = (MedioTransporte) obj;
        return this.id == other.id;
    }

}
