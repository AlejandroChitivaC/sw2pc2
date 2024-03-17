package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "bd_sw2pc2")
public class Usuario {
    @Id
    private Integer id;
    private String usuario;
    private String email;
    private String password;

}