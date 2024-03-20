package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idEmpleado", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "tipo_documento_id")
    private Integer tipoDocumentoId;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "idEmpleado")
    private Set<EmpleadoRol> empleadoRols = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEmpleado")
    private Set<Equipoproyecto> equipoproyectos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEmpleado")
    private Set<Historialcambios> historialcambios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idLiderProyecto")
    private Set<Proyecto> proyectos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEmpleado")
    private Set<Seguimientotiempo> seguimientotiempos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEmpleado")
    private Set<Usuario> usuarios = new LinkedHashSet<>();

}
