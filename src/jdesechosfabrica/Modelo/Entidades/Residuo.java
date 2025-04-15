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
public class Residuo {
        private String  id;
        private TipoResiduo tipoResiduo;
        private double cantidadTotalKilos;
        private List<ConstituyenteQuimico> constituyentes;
        private Date FechaGeneracion;
        private Envase envase;
        private Productor productor;
        private Traslado traslado;
        private TratamientoPosterior tratamientoPosterior;
        private boolean huboIncidenteSeguridad;
        

    public Residuo(String id, TipoResiduo tipoResiduo, double cantidadTotalKilos, List<ConstituyenteQuimico> constituyentes, Date FechaGeneracion, Productor productor) {
        
        if (id== null || id.trim().isEmpty()){
            String mensaje = "Al crear un residuo se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoResiduo== null ){
            String mensaje = "Al crear un residuo se requiere un tipo de residuo valido";
            throw new IllegalArgumentException(mensaje);
        }else if (constituyentes == null || constituyentes.isEmpty()){
            String mensaje = "Al crear un residuo se requiere constituyentes quimicos validos";
            throw new IllegalArgumentException(mensaje);
        }else if (productor == null ){
            String mensaje = "Al crear un residuo se requiere un productor";
            throw new IllegalArgumentException(mensaje);
        }
        
        this.id = id;
        this.tipoResiduo = tipoResiduo;
        this.cantidadTotalKilos = cantidadTotalKilos;
        this.constituyentes = constituyentes;
        this.FechaGeneracion = FechaGeneracion;
        this.productor = productor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoResiduo getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(TipoResiduo tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public double getCantidadTotalKilos() {
        return cantidadTotalKilos;
    }

    public void setCantidadTotalKilos(double cantidadTotalKilos) {
        this.cantidadTotalKilos = cantidadTotalKilos;
    }


   public void addConstituyente(ConstituyenteQuimico constituyente){
       constituyentes.add(constituyente);
   }
   
    public void addConstituyentes(List<ConstituyenteQuimico> constituyentes) {
        if (constituyentes == null || constituyentes.isEmpty()){
            throw new IllegalArgumentException("No se puede agregar un constituyentes nulos.");
        }
        this.constituyentes.addAll(constituyentes);
    }
    
   
    public ConstituyenteQuimico getConstituyente(String id){
         for(ConstituyenteQuimico constituyente : constituyentes){
            if(constituyente.getId().trim().equals(id.trim())){
                return constituyente;
            }
        }
        return null;
    }

    public List<ConstituyenteQuimico> getConstituyentes() {
        return new ArrayList<>(constituyentes);
    }
   
   public void removeConstituyente(String id){
       if (constituyentes.size() <=1){
           throw new IllegalStateException("Un residuo debe tener al menos un Constituyente quimico.");
       }
       constituyentes.removeIf(constituyente -> constituyente.getId().trim().equals(id.trim()));
   }
   
   public void removeConstituyentes(List<String> ids){
       if(ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacia");
        }
       
       if(constituyentes.size() <= ids.size()){
           throw new IllegalStateException("Un residuo debe tener al menos un constituyente quimico.");
       }
       constituyentes.removeIf(constituyente -> ids.contains(constituyente.getId().trim()));

   }
   
    public Date getFechaGeneracion() {
        return FechaGeneracion;
    }

    public void setFechaGeneracion(Date FechaGeneracion) {
        this.FechaGeneracion = FechaGeneracion;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    public TratamientoPosterior getTratamientoPosterior() {
        return tratamientoPosterior;
    }

    public void setTratamientoPosterior(TratamientoPosterior tratamientoPosterior) {
        this.tratamientoPosterior = tratamientoPosterior;
    }

    public boolean isHuboIncidenteSeguridad() {
        return huboIncidenteSeguridad;
    }

    public void setHuboIncidenteSeguridad(boolean huboIncidenteSeguridad) {
        this.huboIncidenteSeguridad = huboIncidenteSeguridad;
    }
        
        
}
