package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * The type Empleado rol.
 */
@Data
@Entity
@Table(name = "empleado_rol")
public class EmpleadoRol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idEmpleadoRol", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleadoRol;

    @Column(name = "idEmpleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "idRol", nullable = false)
    private Integer idRol;

}
