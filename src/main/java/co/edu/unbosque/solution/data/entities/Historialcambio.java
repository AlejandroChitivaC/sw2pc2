package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Historialcambio.
 */
@Getter
@Setter
@Entity
@Table(name = "historialcambios")
public class Historialcambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorial", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProyecto")
    private Proyecto idProyecto;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    @Lob
    @Column(name = "descripcion_cambio")
    private String descripcionCambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado")
    private Empleado idEmpleado;

}