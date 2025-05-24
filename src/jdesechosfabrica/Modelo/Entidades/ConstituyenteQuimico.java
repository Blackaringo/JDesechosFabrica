/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import jdesechosfabrica.Constantes.TipoConstituyente;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Constituyentes_Quimicos")
public class ConstituyenteQuimico implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private TipoConstituyente tipoConstituyente;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "constituyentes")
    private List<Residuo> residuos = new ArrayList<>();

    public ConstituyenteQuimico(TipoConstituyente tipoConstituyente, String nombre) {

        if (tipoConstituyente == null) {
            String mensaje = "Al crear un constituyente quimico se requiere un tipo de constituyente valido";
            throw new IllegalArgumentException(mensaje);
        } else if (nombre == null || nombre.trim().isEmpty()) {
            String mensaje = "Al crear un constituyente quimico se requiere nombre valido";
            throw new IllegalArgumentException(mensaje);
        }

        this.tipoConstituyente = tipoConstituyente;
        this.nombre = nombre;
    }

    public ConstituyenteQuimico(int id, TipoConstituyente tipoConstituyente, String nombre) {
        this.id = id;
        this.tipoConstituyente = tipoConstituyente;
        this.nombre = nombre;
    }

    public ConstituyenteQuimico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Residuo> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<Residuo> residuos) {
        this.residuos = residuos;
    }

    public void addResiduo(Residuo residuo) {
        if (!this.residuos.contains(residuo)) {
            this.residuos.add(residuo);
            if (!residuo.getConstituyentes().contains(this)) {
                residuo.addConstituyente(this);
            }
        }

    }

    public void removeResiduo(Residuo residuo) {
        if (this.residuos.contains(residuo)) {
            this.residuos.remove(residuo);
            if (residuo.getConstituyentes().contains(this)) {
                residuo.removeConstituyente(this.getId());
            }
        }
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

    @Override
    public String toString() {
        return tipoConstituyente + " " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final ConstituyenteQuimico other = (ConstituyenteQuimico) obj;
        return this.id == other.id;
    }

}
