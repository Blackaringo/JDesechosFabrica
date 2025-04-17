/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.util.List;

/**
 *
 * @author HP
 */
public class Transportista {
    private String id;
    private String nombre;
    private Traslado traslado;
    private List<MedioTransporte> mediosDeTrasporte;

    public Transportista(String id, String nombre, List<MedioTransporte> mediosDeTrasporte) {
        
         if (id== null || id.trim().isEmpty()){
            String mensaje = "el transportista requiere un id valido";
            throw new IllegalArgumentException(mensaje);
        } else if (nombre== null || nombre.trim().isEmpty()){
            String mensaje = "el transportista requiere un nombre valido";
            throw new IllegalArgumentException(mensaje);
        }else if(mediosDeTrasporte==null || mediosDeTrasporte.isEmpty()){
            String mensaje = "los medios de trasporte no pueden ser vacion ni nulos";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.nombre = nombre;
        for(MedioTransporte medioTransporte: mediosDeTrasporte){
            medioTransporte.setTransportista(this);
        }
        this.mediosDeTrasporte = mediosDeTrasporte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        this.traslado = traslado;
    }

    public List<MedioTransporte> getMediosDeTrasporte() {
        return mediosDeTrasporte;
    }

    public void setMediosDeTrasporte(List<MedioTransporte> mediosDeTrasporte) {
        this.mediosDeTrasporte = mediosDeTrasporte;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
