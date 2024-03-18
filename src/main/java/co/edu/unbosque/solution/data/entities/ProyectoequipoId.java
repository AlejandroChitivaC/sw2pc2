package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProyectoequipoId implements Serializable {
    private static final long serialVersionUID = -7316407982147855886L;
    @Column(name = "idProyecto", nullable = false)
    private Integer idProyecto;

    @Column(name = "idEquipoProyecto", nullable = false)
    private Integer idEquipoProyecto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProyectoequipoId entity = (ProyectoequipoId) o;
        return Objects.equals(this.idProyecto, entity.idProyecto) &&
                Objects.equals(this.idEquipoProyecto, entity.idEquipoProyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idEquipoProyecto);
    }

}