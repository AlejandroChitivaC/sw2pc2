package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "seguimientoproyecto")
public class Seguimientoproyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idSeguimiento", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeguimiento;

    @Column(name = "idProyecto")
    private Integer idProyecto;

    @Column(name = "fecha_seguimiento")
    private Date fechaSeguimiento;

    @Column(name = "observaciones")
    private String observaciones;

}
