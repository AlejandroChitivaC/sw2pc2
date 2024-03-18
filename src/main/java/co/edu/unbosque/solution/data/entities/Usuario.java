package co.edu.unbosque.solution.data.entities;

import co.edu.unbosque.solution.data.entities.Empleado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "bd_sw2pc2")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado idEmpleado;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

}