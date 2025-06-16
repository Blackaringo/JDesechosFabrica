/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Dto.Productor;

/**
 *
 * @author HP
 */
public class CrearProductorRespuestaDto {

    private final int id;
    private final String nombre;
    private final String TipoActividad;
    private final String pais;
    private final String ciudad;
    private final String barrio;
    private final String calle;
    private final String numero;

    public CrearProductorRespuestaDto(int id, String nombre, String TipoActividad, String pais, String ciudad, String barrio, String calle, String numero) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es requerido.");
        } else if (TipoActividad == null || TipoActividad.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de actividad es requerido.");
        }

        this.id = id;
        this.nombre = nombre;
        this.TipoActividad = TipoActividad;
        this.pais = pais;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.calle = calle;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoActividad() {
        return TipoActividad;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

}
