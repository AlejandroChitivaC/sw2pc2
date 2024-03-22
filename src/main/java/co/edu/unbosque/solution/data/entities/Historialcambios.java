package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "historialcambios")
public class Historialcambios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idHistorial", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorial;

    @Column(name = "idProyecto")
    private Integer idProyecto;

    @Column(name = "fecha_cambio")
    private Date fechaCambio;

    @Column(name = "descripcion_cambio")
    private String descripcionCambio;

    @Column(name = "idEmpleado")
    private Integer idEmpleado;

}
