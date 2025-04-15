/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import jdesechosfabrica.Constantes.TipoConstituyente;

/**
 *
 * @author HP
 */
public class ConstituyenteQuimico {
        private String id;
        private TipoConstituyente tipoConstituyente;
        private String nombre;

    public ConstituyenteQuimico(String id, TipoConstituyente tipoConstituyente, String nombre) {
        
         if (id== null || id.trim().isEmpty()){
            String mensaje = "Al crear un constituyente quimico se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoConstituyente== null ){
            String mensaje = "Al crear un constituyente quimico se requiere un tipo de constituyente valido";
            throw new IllegalArgumentException(mensaje);
        }else if (nombre == null || nombre.trim().isEmpty()){
            String mensaje = "Al crear un constituyente quimico se requiere nombre valido";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.tipoConstituyente = tipoConstituyente;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoConstituyente getTipoConstituyente() {
        return tipoConstituyente;
    }

    public void setTipoConstituyente(TipoConstituyente tipoConstituyente) {
        this.tipoConstituyente = tipoConstituyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
            
            
}
