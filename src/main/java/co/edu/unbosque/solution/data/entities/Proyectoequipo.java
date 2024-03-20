package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "proyectoequipo")
public class Proyectoequipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idProyecto", nullable = false)
    private Integer idProyecto;

    @Id
    @Column(name = "idEquipoProyecto", nullable = false)
    private Integer idEquipoProyecto;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProyecto", nullable = false)
    private Proyecto idProyecto1;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEquipoProyecto", nullable = false)
    private Equipoproyecto idEquipoProyecto1;

}
