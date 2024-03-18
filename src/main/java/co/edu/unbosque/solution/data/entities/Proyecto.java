package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "proyecto", schema = "bd_sw2pc2")
public class Proyecto {
    @Id
    @Column(name = "id_proyecto", nullable = false)
    private Integer id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Lob
    @Column(name = "descripcion_proyecto", nullable = false)
    private String descripcionProyecto;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_finalizacion", nullable = false)
    private LocalDate fechaFinalizacion;

    @Column(name = "presupuesto", nullable = false, precision = 10, scale = 2)
    private BigDecimal presupuesto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lider", nullable = false)
    private Empleado idLider;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo idEquipo;

}