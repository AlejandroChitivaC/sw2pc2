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
public class EquipoEmpleadoId implements Serializable {
    private static final long serialVersionUID = -7262726417750146567L;
    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EquipoEmpleadoId entity = (EquipoEmpleadoId) o;
        return Objects.equals(this.idEquipo, entity.idEquipo) &&
                Objects.equals(this.idEmpleado, entity.idEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, idEmpleado);
    }

}