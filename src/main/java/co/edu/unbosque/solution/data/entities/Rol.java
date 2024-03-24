package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Rol.
 */
@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idRol", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "idRol")
    private Set<EmpleadoRol> empleadoRols = new LinkedHashSet<>();

}
