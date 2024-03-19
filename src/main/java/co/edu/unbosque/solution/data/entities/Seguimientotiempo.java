package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Seguimientotiempo.
 */
@Getter
@Setter
@Entity
@Table(name = "seguimientotiempo")
public class Seguimientotiempo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeguimientoTiempo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProyecto")
    private Proyecto idProyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado")
    private Empleado idEmpleado;

    @Column(name = "horas_trabajadas", precision = 10, scale = 2)
    private BigDecimal horasTrabajadas;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

}