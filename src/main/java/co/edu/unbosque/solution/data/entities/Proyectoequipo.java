package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Proyectoequipo.
 */
@Getter
@Setter
@Entity
@Table(name = "proyectoequipo")
public class Proyectoequipo {
    @EmbeddedId
    private ProyectoequipoId id;

    @MapsId("idProyecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProyecto", nullable = false)
    private Proyecto idProyecto;

    @MapsId("idEquipoProyecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEquipoProyecto", nullable = false)
    private Equipoproyecto idEquipoProyecto;

}