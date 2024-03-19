package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Usuario.
 */
@Getter
@Setter
@Entity
public class Usuario {
    @Id
    private Integer idUsuario;
    private String email;
    private String password;
}