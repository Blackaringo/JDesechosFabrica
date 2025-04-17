/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

/**
 *
 * @author HP
 */
public class Direccion {
    private String pais;
    private String ciudad;
    private String barrio;
    private String calle;
    private String numero;

    public Direccion(String pais, String ciudad, String barrio, String calle, String numero) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.calle = calle;
        this.numero = numero;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return ciudad+ " " + pais + " Barrio "+ barrio+ " calle " + calle+ " #"+ numero;
    }
    
    
}
