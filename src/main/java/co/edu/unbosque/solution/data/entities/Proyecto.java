package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Proyecto.
 */
@Data
@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idProyecto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyecto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin_prevista")
    private Date fechaFinPrevista;

    @Column(name = "presupuesto")
    private BigDecimal presupuesto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "idLiderProyecto")
    private Integer idLiderProyecto;

    @OneToMany(mappedBy = "idProyecto")
    private Set<Historialcambios> historialcambios = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "proyectoequipo",
            joinColumns = @JoinColumn(name = "idProyecto"),
            inverseJoinColumns = @JoinColumn(name = "idEquipoProyecto"))
    private Set<Equipoproyecto> equipoproyectos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProyecto")
    private Set<Seguimientoproyecto> seguimientoproyectos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProyecto")
    private Set<Seguimientotiempo> seguimientotiempos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProyecto")
    private Set<Tarea> tareas = new LinkedHashSet<>();

}
