package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Empleado.
 */
@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "idEmpleado", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_documento_id")
    private Tipodocumento tipo_documento;

    @Column(name = "numero_documento", length = 50)
    private String numero_documento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "id_tipo_documento", nullable = false)
    private Integer idTipoDocumento;

}
