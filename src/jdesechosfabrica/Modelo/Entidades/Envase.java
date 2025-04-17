/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import jdesechosfabrica.Constantes.EstadoUso;
import jdesechosfabrica.Constantes.TipoEnvase;

/**
 *
 * @author HP
 */
public class Envase {
        private String id;
        private TipoEnvase tipoEnvase;
        private EstadoUso estadoUso;
        private Residuo residuo;

    public Envase(String id, TipoEnvase tipoEnvase, EstadoUso estadoUso) {
         if (id== null || id.trim().isEmpty()){
            String mensaje = "Al crear un envase se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoEnvase== null ){
            String mensaje = "Al crear un envase se requiere un tipo de envase valido";
            throw new IllegalArgumentException(mensaje);
        }else if (estadoUso== null ){
            String mensaje = "Al crear un envase se requiere un estado de uso valido";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.tipoEnvase = tipoEnvase;
        this.estadoUso = estadoUso;
        residuo =null;
    }
    
        public Envase(String id, TipoEnvase tipoEnvase, Residuo residuo) {
         if (id== null || id.trim().isEmpty()){
            String mensaje = "Al crear un envase se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoEnvase== null ){
            String mensaje = "Al crear un envase se requiere un tipo de envase valido";
            throw new IllegalArgumentException(mensaje);
        }else if (residuo== null ){
            String mensaje = "el residuo no debe ser nulo";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.tipoEnvase = tipoEnvase;
        this.estadoUso = EstadoUso.EN_USO;
        this.residuo =residuo;
        residuo.setEnvase(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoEnvase getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(TipoEnvase tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public EstadoUso getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(EstadoUso estadoUso) {
        this.estadoUso = estadoUso;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
         if (residuo.getEnvase()!= this && residuo.getEnvase()!= null){
            throw new IllegalArgumentException("El residuo ya tiene otro envase asociado");
        }
        if(residuo.getEnvase()==null){
            residuo.setEnvase(this);
        }
        this.residuo = residuo;
    }

    @Override
    public String toString() {
        return tipoEnvase + " " + estadoUso;
    }
            
}
