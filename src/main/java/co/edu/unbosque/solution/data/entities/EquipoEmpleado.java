package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Equipo empleado.
 */
@Getter
@Setter
@Entity
@Table(name = "equipo_empleados")
public class EquipoEmpleado {
    @EmbeddedId
    private EquipoEmpleadoId id;

    @MapsId("idEquipo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo idEquipo;

}