/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdesechosfabrica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import jdesechosfabrica.Constantes.TipoConstituyente;
import jdesechosfabrica.Constantes.TipoDestino;
import jdesechosfabrica.Constantes.TipoEnvase;
import jdesechosfabrica.Constantes.TipoResiduo;
import jdesechosfabrica.Constantes.TipoTransporte;
import jdesechosfabrica.Constantes.TipoTraslado;
import jdesechosfabrica.Constantes.TipoTratamiento;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;
import jdesechosfabrica.Modelo.Entidades.Destino;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Envase;
import jdesechosfabrica.Modelo.Entidades.MedioTransporte;
import jdesechosfabrica.Modelo.Entidades.Productor;
import jdesechosfabrica.Modelo.Entidades.Residuo;
import jdesechosfabrica.Modelo.Entidades.Transportista;
import jdesechosfabrica.Modelo.Entidades.Traslado;
import jdesechosfabrica.Modelo.Entidades.TratamientoPosterior;

/**
 *
 * @author HP
 */
public class JDesechosFabrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Direccion dirProductor1 = new Direccion("Colombia","Cartagena","Mamonal","lomba","18-32");
        Productor productor1 = new Productor("Quimicos SAS",dirProductor1,"Quimicos");
        
        // creamos los constituyentes quimicos de nuestro residuo
        ConstituyenteQuimico mercurio = new ConstituyenteQuimico("CQ1",TipoConstituyente.METAL_PESADO,"Mercurio");       
        ConstituyenteQuimico plomo = new ConstituyenteQuimico("CQ2",TipoConstituyente.METAL_PESADO,"Plomo");
        ConstituyenteQuimico niquel = new ConstituyenteQuimico("CQ3",TipoConstituyente.METAL_PESADO,"Niquel");

        List<ConstituyenteQuimico> constituyentesRes1= new ArrayList<>();
       
        constituyentesRes1.add(mercurio);        
        constituyentesRes1.add(plomo);
        constituyentesRes1.add(niquel);

        
        // creamos residuos y estos los asociamos al productor1
        Residuo residuo1= new Residuo("res1", TipoResiduo.TOXICO, 50,constituyentesRes1, new Date(),productor1);
        
        
        // creamos el envase donde se transportara el residuo y le pasamos el residuo
        Envase envase1 = new Envase("env1",TipoEnvase.RECIPIENTE,  residuo1);
        
        // creamos los medios de transporte que participaran en el traslado
        List<MedioTransporte> mediosTrasporte = new ArrayList<>();
        
        // agregamos los medios de trasporte y la distancia que van a recorrer y el costo
        mediosTrasporte.add(new MedioTransporte(
                "MT1",
                "Camion de carga",
                TipoTransporte.TERRESTRE,
                50,
                350000
        ));
        
        
        // creamos las empresas transportistas que participaran en el traslado
        List<Transportista> trasportistas = new ArrayList<>();
        
        trasportistas.add(new Transportista(
                "TRA1",
                "Secure Transportator",
                mediosTrasporte
        ));
        
    
        
        Direccion direccionPlanta = new Direccion("Colombia","Cartagena","pozon","larga","23-45");
        
        Calendar cal = Calendar.getInstance();
        cal.set(2025, 4, 17);
        Destino plantaDeTrataiento = new Destino("DES1", TipoDestino.PLANTA_DE_TRATAMIENTO_FISICO_QUIMCO, cal.getTime(), direccionPlanta);
        
        
        // relizamos el traslado del residuo
        Traslado trasladoAPlanta = new Traslado("TRASL1",new Date(),TipoTraslado.TOTAL,true, residuo1.getCantidadTotalKilos(),trasportistas, residuo1, plantaDeTrataiento);
        
        // lealizamos un tratamiento posterior
        cal = Calendar.getInstance();
        cal.set(2025, 4, 19);
        TratamientoPosterior tratamientoQuimico = new TratamientoPosterior("TP1",TipoTratamiento.QUIMICO, cal.getTime(), residuo1);
        
        System.out.println("##################################");
        System.out.println("## Ejemplo De manejo de Residuo ##");
        System.out.println("##################################");
        
        System.out.println("El Productor: "+productor1);
        System.out.println("Ha generado los residuos");
        
        for (Residuo residuo : productor1.getResiduos()){
            System.out.println("Residuo: "+residuo);
            
            System.out.println("esta compuesto Por:");
            for(ConstituyenteQuimico constituyente: residuo.getConstituyentes()){
                System.out.println(constituyente);
            }
            
            System.out.println("Fue trasladado por: ");
            for (Transportista transportista: residuo.getTraslado().getTransportistas()){
                System.out.println(transportista);
                System.out.println("Usando los medios de Transporte: ");
                for (MedioTransporte medio : transportista.getMediosDeTrasporte()){
                    System.out.println(medio);
                    System.out.println("Con un coste de: ");
                    System.out.println(medio.getCoste());
                    System.out.println("Una distancia de: ");
                    System.out.println(medio.getDistancia()+" km");
                }
                System.out.println("Los datos del traslado son:");
                System.out.println("fecha: ");
                System.out.println(residuo.getTraslado().getFechaTranslado());
                System.out.println("Tipo Traslado: ");
                System.out.println(residuo.getTraslado().getTipoTraslado());
                System.out.println("Cantidad trasladada: ");
                System.out.println(residuo.getTraslado().getCantidad());
                System.out.println("Traslado seguro:");
                String seguro = residuo.getTraslado().isTransladoSeguro()?"Si":"No";
                System.out.println(seguro);
                System.out.println("Los datos del destino son: ");
                System.out.println( residuo.getTraslado().getDestino());



            }
            
            System.out.println("el residuo fue transportado en el envase");
            System.out.println(residuo.getEnvase());
            
            System.out.println("Recibio un tratamiento  de tipo");
            System.out.println(residuo.getTratamientoPosterior().getTipoTratamiento());
            
            System.out.println("en la fecha:");
            System.out.println(residuo.getTratamientoPosterior().getFechaTratamiento());

        }
        

    }
    
}
