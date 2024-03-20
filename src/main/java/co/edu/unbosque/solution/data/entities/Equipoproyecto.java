package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "equipoproyecto")
public class Equipoproyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipoProyecto", nullable = false)
    private Integer idEquipoProyecto;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "idEmpleado")
    private Integer idEmpleado;

    @ManyToMany
    @JoinTable(name = "proyectoequipo",
            joinColumns = @JoinColumn(name = "idEquipoProyecto"),
            inverseJoinColumns = @JoinColumn(name = "idProyecto"))
    private Set<Proyecto> proyectos = new LinkedHashSet<>();

}
