/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdesechosfabrica.Constantes.TipoResiduo;

/**
 *
 * @author HP
 */
public class Productor {
        private String nombre;
        private Direccion direccion;
        private List<Residuo> residuos;
        private String TipoActividad;

    public Productor(String nombre, Direccion direccion, String TipoActividad) {
         if (nombre== null  || nombre.trim().isEmpty()){
            String mensaje = "Al crear un productor se requiere un nombre valido";
            throw new IllegalArgumentException(mensaje);
        }else if (TipoActividad == null ){
            String mensaje = "Al crear un productor se requiere un tipo de actividad valido";
            throw new IllegalArgumentException(mensaje);
        }else if (direccion == null ){
            String mensaje = "Al crear un productor se requiere una direccion";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.TipoActividad = TipoActividad;
        residuos = new ArrayList<>();
    }


    public void producirResiduo(Residuo residuo){
        if(residuo == null ){
            throw new IllegalArgumentException("El residuo no puede ser nulo");
        }
         if(residuo.getProductor() != this){
              throw new IllegalArgumentException("El residuo ya tiene un productor asociado");
         }
          this.residuos.add(residuo);
    }
    
    public List<Residuo> getResiduos() {
        return new ArrayList<>(residuos);
    }
    
    public Residuo getResiduo(String id){
        for(Residuo residuo : residuos){
            if(residuo.getId().equals(id)){
                return residuo;
            }
        }
        return null;
    }
    
    public void removeResiduo(String id){
        residuos.removeIf(residuo -> residuo.getId().trim().equals(id.trim()));
    }
    
    public void removeResiduos(List<String> ids){
        residuos.removeIf(residuo -> ids.contains(residuo.getId().trim()));
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTipoActividad() {
        return TipoActividad;
    }

    public void setTipoActividad(String TipoActividad) {
        this.TipoActividad = TipoActividad;
    }
        
        
}
