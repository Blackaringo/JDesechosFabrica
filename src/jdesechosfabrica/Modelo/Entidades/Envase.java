/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jdesechosfabrica.Constantes.EstadoUso;
import jdesechosfabrica.Constantes.TipoEnvase;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Envases")
public class Envase implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated
    @Column(length = 20, nullable = false)
    private TipoEnvase tipoEnvase;

    @Enumerated
    @Column(length = 20, nullable = false)
    private EstadoUso estadoUso;

    @OneToOne(mappedBy = "envase", cascade = CascadeType.PERSIST)
    private Residuo residuo;

    public Envase(TipoEnvase tipoEnvase, EstadoUso estadoUso) {
        if (tipoEnvase == null) {
            String mensaje = "Al crear un envase se requiere un tipo de envase valido";
            throw new IllegalArgumentException(mensaje);
        } else if (estadoUso == null) {
            String mensaje = "Al crear un envase se requiere un estado de uso valido";
            throw new IllegalArgumentException(mensaje);
        }

        this.tipoEnvase = tipoEnvase;
        this.estadoUso = estadoUso;
        residuo = null;
    }

    public Envase(String id, TipoEnvase tipoEnvase, Residuo residuo) {
        if (id == null || id.trim().isEmpty()) {
            String mensaje = "Al crear un envase se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoEnvase == null) {
            String mensaje = "Al crear un envase se requiere un tipo de envase valido";
            throw new IllegalArgumentException(mensaje);
        } else if (residuo == null) {
            String mensaje = "el residuo no debe ser nulo";
            throw new IllegalArgumentException(mensaje);
        }

        this.tipoEnvase = tipoEnvase;
        this.estadoUso = EstadoUso.EN_USO;
        this.residuo = residuo;
        residuo.setEnvase(this);
    }

    public Envase() {
    }

    public Envase(int id, TipoEnvase tipoEnvase, EstadoUso estadoUso, Residuo residuo) {
        this.id = id;
        this.tipoEnvase = tipoEnvase;
        this.estadoUso = estadoUso;
        this.residuo = residuo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        if (residuo.getEnvase() != this && residuo.getEnvase() != null) {
            throw new IllegalArgumentException("El residuo ya tiene otro envase asociado");
        }
        if(this.residuo != residuo) {
            this.residuo = residuo;
        }
        
        if (residuo.getEnvase() != this) {
            residuo.setEnvase(this);
        }
       
    }

    @Override
    public String toString() {
        return tipoEnvase + " " + estadoUso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Envase other = (Envase) obj;
        return this.id == other.id;
    }

}
