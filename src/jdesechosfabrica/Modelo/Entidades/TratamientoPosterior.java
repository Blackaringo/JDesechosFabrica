/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jdesechosfabrica.Constantes.TipoTratamiento;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Tratamientos_Posteriores")
public class TratamientoPosterior implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoTratamiento tipoTratamiento;

    private LocalDate fechaTratamiento;

    @OneToOne(mappedBy = "tratamientoPosterior", cascade = CascadeType.PERSIST )
    private Residuo residuo;

    public TratamientoPosterior(TipoTratamiento tipoTratamiento, LocalDate fechaTratamiento, Residuo residuo) {
        if (tipoTratamiento == null) {
            String mensaje = "Al crear un tratamiento posterior se requiere un tipo de tratamiento  valido";
            throw new IllegalArgumentException(mensaje);
        } else if (fechaTratamiento == null) {
            String mensaje = "Al crear un tratamiento posterior se requiere una fecha valida";
            throw new IllegalArgumentException(mensaje);
        } else if (residuo == null) {
            String mensaje = "Al crear un tratamiento posterior se requiere un productor";
            throw new IllegalArgumentException(mensaje);
        }

        this.tipoTratamiento = tipoTratamiento;
        this.fechaTratamiento = fechaTratamiento;
        this.residuo = residuo;
        residuo.setTratamientoPosterior(this);
    }

    public TratamientoPosterior() {
    }

    public TratamientoPosterior(int id, TipoTratamiento tipoTratamiento, LocalDate fechaTratamiento, Residuo residuo) {
        this.id = id;
        this.tipoTratamiento = tipoTratamiento;
        this.fechaTratamiento = fechaTratamiento;
        this.residuo = residuo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoTratamiento getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(TipoTratamiento tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public LocalDate getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(LocalDate fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        if (this.residuo != residuo) {
            this.residuo = residuo;
        }
        if(residuo.getTratamientoPosterior()!= this){
            residuo.setTratamientoPosterior(this);
        }
    }

    @Override
    public String toString() {
        return "Tratamiento Posterior " + id + " de tipo " + tipoTratamiento + " en la fecha " + fechaTratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final TratamientoPosterior other = (TratamientoPosterior) obj;
        return this.id == other.id;
    }

}
