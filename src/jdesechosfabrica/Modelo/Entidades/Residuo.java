/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivatedefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jdesechosfabrica.Constantes.TipoResiduo;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Residuos")
public class Residuo implements Serializable {

    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, nullable = false)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private TipoResiduo tipoResiduo;
    private LocalDate FechaGeneracion;
    private double cantidadTotalKilos;

    // relaciones
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Residuo_Constituyentes",
            joinColumns = @JoinColumn(name = "RESIDUO_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONSTITUYENTE_ID")
    )
    private List<ConstituyenteQuimico> constituyentes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Productor productor;

    @OneToOne
    @JoinColumn(name = "ENVASE_ID")
    private Envase envase;

    @OneToMany(mappedBy = "residuo", cascade = CascadeType.PERSIST)
    private List<Traslado> traslados = new ArrayList<>();

    @OneToOne
    private TratamientoPosterior tratamientoPosterior;
    private boolean huboIncidenteSeguridad;

    public Residuo(String codigo, TipoResiduo tipoResiduo, double cantidadTotalKilos, List<ConstituyenteQuimico> constituyentes, LocalDate FechaGeneracion, Productor productor) {

        if (codigo == null || codigo.trim().isEmpty()) {
            String mensaje = "Al crear un residuo se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoResiduo == null) {
            String mensaje = "Al crear un residuo se requiere un tipo de residuo valido";
            throw new IllegalArgumentException(mensaje);
        } else if (constituyentes == null || constituyentes.isEmpty()) {
            String mensaje = "Al crear un residuo se requiere constituyentes quimicos validos";
            throw new IllegalArgumentException(mensaje);
        } else if (productor == null) {
            String mensaje = "Al crear un residuo se requiere un productor";
            throw new IllegalArgumentException(mensaje);
        }

        this.codigo = codigo;
        this.tipoResiduo = tipoResiduo;
        this.cantidadTotalKilos = cantidadTotalKilos;
        this.constituyentes = constituyentes;
        this.FechaGeneracion = FechaGeneracion;
        this.productor = productor;
        envase = null;
        tratamientoPosterior = null;
        huboIncidenteSeguridad = false;
        productor.producirResiduo(this);
    }

    public Residuo(int id, String codigo, TipoResiduo tipoResiduo, LocalDate FechaGeneracion, double cantidadTotalKilos, List<ConstituyenteQuimico> constituyentes, Productor productor, Envase envase, List<Traslado> traslados, TratamientoPosterior tratamientoPosterior, boolean huboIncidenteSeguridad) {

        if (codigo == null || codigo.trim().isEmpty()) {
            String mensaje = "Al crear un residuo se requiere un identificador valido";
            throw new IllegalArgumentException(mensaje);
        } else if (tipoResiduo == null) {
            String mensaje = "Al crear un residuo se requiere un tipo de residuo valido";
            throw new IllegalArgumentException(mensaje);
        } else if (constituyentes == null || constituyentes.isEmpty()) {
            String mensaje = "Al crear un residuo se requiere constituyentes quimicos validos";
            throw new IllegalArgumentException(mensaje);
        } else if (productor == null) {
            String mensaje = "Al crear un residuo se requiere un productor";
            throw new IllegalArgumentException(mensaje);
        }

        this.id = id;
        this.codigo = codigo;
        this.tipoResiduo = tipoResiduo;
        this.FechaGeneracion = FechaGeneracion;
        this.cantidadTotalKilos = cantidadTotalKilos;
        this.constituyentes = constituyentes;
        this.productor = productor;
        this.envase = envase;
        this.traslados = traslados;
        this.tratamientoPosterior = tratamientoPosterior;
        this.huboIncidenteSeguridad = huboIncidenteSeguridad;

        for (var constituyente : constituyentes) {
            constituyente.addResiduo(this);
        }
        productor.producirResiduo(this);

        if (envase != null) {
            envase.setResiduo(this);
        }
        if (traslados != null) {
            for (var traslado : traslados) {
                traslado.setResiduo(this);
            }
        }
    }

    public Residuo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void addConstituyente(ConstituyenteQuimico constituyente) {
        if (!constituyentes.contains(constituyente)) {
            constituyentes.add(constituyente);
        }
        if (!constituyente.getResiduos().contains(this)) {
            constituyente.addResiduo(this);
        }
    }

    public void addConstituyentes(List<ConstituyenteQuimico> constituyentes) {
        if (constituyentes == null || constituyentes.isEmpty()) {
            throw new IllegalArgumentException("No se puede agregar un constituyentes nulos.");
        }
        this.constituyentes.addAll(constituyentes);
    }

    public ConstituyenteQuimico getConstituyente(int id) {
        for (ConstituyenteQuimico constituyente : constituyentes) {
            if (constituyente.getId() == id) {
                return constituyente;
            }
        }
        return null;
    }

    public List<ConstituyenteQuimico> getConstituyentes() {
        return new ArrayList<>(constituyentes);
    }

    public void removeConstituyente(int id) {
        if (constituyentes.size() <= 1) {
            throw new IllegalStateException("Un residuo debe tener al menos un Constituyente quimico.");
        }
        constituyentes.removeIf(constituyente -> constituyente.getId() == id);
    }

    public void removeConstituyentes(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacia");
        }

        if (constituyentes.size() <= ids.size()) {
            throw new IllegalStateException("Un residuo debe tener al menos un constituyente quimico.");
        }
        constituyentes.removeIf(constituyente -> ids.contains(constituyente.getId()));

    }

    public LocalDate getFechaGeneracion() {
        return FechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate FechaGeneracion) {
        this.FechaGeneracion = FechaGeneracion;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        if (productor != this.productor) {
            this.productor = productor;
        }

        if (productor != null && !productor.getResiduos().contains(this)) {
            productor.producirResiduo(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Traslado> getTraslados() {
        return traslados;
    }

    public void setTraslados(List<Traslado> traslados) {
        this.traslados = traslados;
    }

    void addTraslado(Traslado traslado) {
        if (!traslados.contains(traslado)) {
            traslados.add(traslado);
        }
        if (traslado.getResiduo() != this) {
            traslado.setResiduo(this);
        }
    }

    public TratamientoPosterior getTratamientoPosterior() {
        return tratamientoPosterior;
    }

    public void setTratamientoPosterior(TratamientoPosterior tratamientoPosterior) {
        if (tratamientoPosterior.getResiduo() != this) {
            throw new IllegalArgumentException("El tratamiento posterior tiene otro residuo asociado");
        }
        if (this.tratamientoPosterior != tratamientoPosterior) {

            this.tratamientoPosterior = tratamientoPosterior;
        }
        if (tratamientoPosterior.getResiduo() != this) {
            tratamientoPosterior.setResiduo(this);
        }
    }

    public boolean isHuboIncidenteSeguridad() {
        return huboIncidenteSeguridad;
    }

    public void setHuboIncidenteSeguridad(boolean huboIncidenteSeguridad) {
        this.huboIncidenteSeguridad = huboIncidenteSeguridad;
    }

    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        if(envase==null){
            this.envase = null;
            return;
        }
        if (envase != null && envase.getResiduo() != this && envase.getResiduo() != null) {
            throw new IllegalArgumentException("El envase ya tiene otro residuo asociado");
        }
        if (this.envase == envase) {
        return;
        }
        if (envase.getResiduo() == null) {
            envase.setResiduo(this);
        }
        if (this.envase != envase) {
            this.envase = envase;
        }
        if (envase.getResiduo() != this) {
            envase.setResiduo(this);
        }
    }

    @Override
    public String toString() {
        return "Residuo{" + "id=" + codigo + ", tipoResiduo=" + tipoResiduo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Residuo other = (Residuo) obj;
        return this.id == other.id;
    }

}
