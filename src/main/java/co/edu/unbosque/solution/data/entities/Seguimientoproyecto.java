package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Seguimientoproyecto.
 */
@Getter
@Setter
@Entity
@Table(name = "seguimientoproyecto")
public class Seguimientoproyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeguimiento", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProyecto")
    private Proyecto idProyecto;

    @Column(name = "fecha_seguimiento")
    private LocalDate fechaSeguimiento;

    @Lob
    @Column(name = "observaciones")
    private String observaciones;

}