package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@Table(name = "seguimientotiempo")
public class Seguimientotiempo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeguimientoTiempo", nullable = false)
    private Integer idSeguimientoTiempo;

    @Column(name = "idProyecto")
    private Integer idProyecto;

    @Column(name = "idEmpleado")
    private Integer idEmpleado;

    @Column(name = "horas_trabajadas")
    private BigDecimal horasTrabajadas;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

}
