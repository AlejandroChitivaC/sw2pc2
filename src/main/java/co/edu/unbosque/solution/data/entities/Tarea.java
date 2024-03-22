package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "tarea")
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idTarea", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;

    @Column(name = "idProyecto")
    private Integer idProyecto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin_prevista")
    private Date fechaFinPrevista;

    @Column(name = "estado")
    private String estado;

}
