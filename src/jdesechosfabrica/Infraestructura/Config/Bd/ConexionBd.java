/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Infraestructura.Config.Bd;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HP
 */
public class ConexionBd {
    private static EntityManagerFactory conexion;
    
    public static EntityManagerFactory conectar(){
        if (conexion== null){
            conexion = Persistence.createEntityManagerFactory("ConfiguracionBd");
        }
        return conexion;
    }
    
    public static void desconectar(){
        if(conexion!= null && conexion.isOpen()){
            conexion.close();
        }
        conexion=null;
    }
}
