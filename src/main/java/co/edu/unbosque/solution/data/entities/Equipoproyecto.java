package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Equipoproyecto.
 */
@Getter
@Setter
@Entity
@Table(name = "equipoproyecto")
public class Equipoproyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipoProyecto", nullable = false)
    private Integer id;

    @Column(name = "nombre_equipo", length = 100)
    private String nombreEquipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado")
    private Empleado idEmpleado;

}