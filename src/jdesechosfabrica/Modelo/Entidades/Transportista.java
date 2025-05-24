/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Transportistas")
public class Transportista implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String nombre;

    @ManyToOne
    private Traslado traslado;

    @OneToMany(mappedBy = "transportista" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedioTransporte> mediosDeTrasporte =new ArrayList<>();

    public Transportista(String nombre, List<MedioTransporte> mediosDeTrasporte) {

        if (nombre == null || nombre.trim().isEmpty()) {
            String mensaje = "el transportista requiere un nombre valido";
            throw new IllegalArgumentException(mensaje);
        } else if (mediosDeTrasporte == null || mediosDeTrasporte.isEmpty()) {
            String mensaje = "los medios de trasporte no pueden ser vacion ni nulos";
            throw new IllegalArgumentException(mensaje);
        }

        this.nombre = nombre;
        if(mediosDeTrasporte != null){        
            for (MedioTransporte medioTransporte : mediosDeTrasporte) {
                medioTransporte.setTransportista(this);
            }
        }
        this.mediosDeTrasporte = mediosDeTrasporte;
    }

    public Transportista() {
    }

    public Transportista(int id, String nombre, Traslado traslado, List<MedioTransporte> mediosDeTrasporte) {
        this.id = id;
        this.nombre = nombre;
        this.traslado = traslado;
        this.mediosDeTrasporte = mediosDeTrasporte;
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

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        if (this.traslado != traslado) {
            this.traslado = traslado;
        }
        if (traslado != null && !traslado.getTransportistas().contains(this)) {
            traslado.addTransportista(this);
        }
    }

    public List<MedioTransporte> getMediosDeTrasporte() {
        return mediosDeTrasporte;
    }

    public void setMediosDeTrasporte(List<MedioTransporte> mediosDeTrasporte) {
        this.mediosDeTrasporte = mediosDeTrasporte;
    }

    public void addMedioTransporte(MedioTransporte medioTransporte) {
        if (!this.mediosDeTrasporte.contains(medioTransporte)) {
            this.mediosDeTrasporte.add(medioTransporte);
        }
        if (medioTransporte.getTransportista() != this) {
            medioTransporte.setTransportista(this);
        }
    }

     public void removeMedioTransporte(int id) {
        mediosDeTrasporte.removeIf(medio -> medio.getId() == id);
    }
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
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
        final Transportista other = (Transportista) obj;
        return this.id == other.id;
    }

}
