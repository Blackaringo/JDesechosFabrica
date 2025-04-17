/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import jdesechosfabrica.Constantes.TipoTransporte;

/**
 *
 * @author HP
 */
public class MedioTransporte {
    private String id;
    private String nombre;
    private TipoTransporte tipo;
    private double distancia;
    private double coste;
    private Transportista transportista;

    public MedioTransporte(String id, String nombre, TipoTransporte tipo, double distancia, double coste) {
        if (id== null || id.trim().isEmpty()){
            String mensaje = "el medio de trasporte requiere un id valido";
            throw new IllegalArgumentException(mensaje);
        } else if (nombre== null || nombre.trim().isEmpty()){
            String mensaje = "el medio de trasporte requiere un nombre valido";
            throw new IllegalArgumentException(mensaje);
        }else if (tipo== null ){
            String mensaje = "el medio de transporte requiere un tipo valido";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.distancia = distancia;
        this.coste = coste;
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
        this.transportista = transportista;
    }
    
    
}
