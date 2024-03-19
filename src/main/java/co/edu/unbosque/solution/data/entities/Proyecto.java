package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Proyecto.
 */
@Getter
@Setter
@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProyecto", nullable = false)
    private Integer idProyecto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin_prevista")
    private LocalDate fechaFinPrevista;

    @Column(name = "presupuesto", precision = 10, scale = 2)
    private BigDecimal presupuesto;

    @Column(name = "estado", length = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLiderProyecto")
    private Empleado idLiderProyecto;

    @Lob
    @Column(name = "descripcion_proyecto", nullable = false)
    private String descripcionProyecto;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;

    @Column(name = "id_lider", nullable = false)
    private Integer idLider;

}