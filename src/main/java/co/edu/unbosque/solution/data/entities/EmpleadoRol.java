package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Empleado rol.
 */
@Getter
@Setter
@Entity
@Table(name = "empleado_rol")
public class EmpleadoRol {
    @EmbeddedId
    private EmpleadoRolId id;

    @MapsId("idEmpleado")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmpleado", nullable = false)
    private Empleado idEmpleado;

    @MapsId("idRol")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRol", nullable = false)
    private Rol idRol;

}