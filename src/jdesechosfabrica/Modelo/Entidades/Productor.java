/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Productores")
public class Productor implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String TipoActividad;

    // relaciones
    @Embedded
    private Direccion direccion;

    @OneToMany(mappedBy = "productor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Residuo> residuos = new ArrayList<>();

    public Productor(String nombre, Direccion direccion, String TipoActividad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            String mensaje = "Al crear un productor se requiere un nombre valido";
            throw new IllegalArgumentException(mensaje);
        } else if (TipoActividad == null) {
            String mensaje = "Al crear un productor se requiere un tipo de actividad valido";
            throw new IllegalArgumentException(mensaje);
        } else if (direccion == null) {
            String mensaje = "Al crear un productor se requiere una direccion";
            throw new IllegalArgumentException(mensaje);
        }

        this.nombre = nombre;
        this.direccion = direccion;
        this.TipoActividad = TipoActividad;
        residuos = new ArrayList<>();
    }

    public Productor(int id, String nombre, String TipoActividad, Direccion direccion, List<Residuo> residuos) {
        this.id = id;
        this.nombre = nombre;
        this.TipoActividad = TipoActividad;
        this.direccion = direccion;
        this.residuos = residuos;
    }

    public Productor() {
    }

    public void producirResiduo(Residuo residuo) {
        if (residuos == null) {
            residuos = new ArrayList<>();
        }
        if (residuo == null) {
            throw new IllegalArgumentException("El residuo no puede ser nulo");
        }
        if (residuo.getProductor() != this) {
            throw new IllegalArgumentException("El residuo ya tiene un productor asociado");
        }
        if (!this.residuos.contains(residuo)) {
            this.residuos.add(residuo);
            residuo.setProductor(this); 
        }
    }

    public List<Residuo> getResiduos() {
        return new ArrayList<>(residuos);
    }

    public Residuo getResiduo(String id) {
        for (Residuo residuo : residuos) {
            if (residuo.getCodigo().equals(id)) {
                return residuo;
            }
        }
        return null;
    }

    public void removeResiduo(String id) {
        residuos.removeIf(residuo -> residuo.getCodigo().trim().equals(id.trim()));
    }

    public void removeResiduos(List<String> ids) {
        residuos.removeIf(residuo -> ids.contains(residuo.getCodigo().trim()));
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return TipoActividad;
    }

    public void setTipoActividad(String TipoActividad) {
        this.TipoActividad = TipoActividad;
    }

    @Override
    public String toString() {
        return "Productor{" + "id=" + id + ", nombre=" + nombre + ", TipoActividad=" + TipoActividad + ", direccion=" + direccion + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
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
        final Productor other = (Productor) obj;
        return this.id == other.id;
    }

}
