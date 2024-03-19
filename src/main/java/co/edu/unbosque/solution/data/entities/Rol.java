package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Rol.
 */
@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", nullable = false)
    private Integer id;

    @Column(name = "rol", length = 100)
    private String rol;

}