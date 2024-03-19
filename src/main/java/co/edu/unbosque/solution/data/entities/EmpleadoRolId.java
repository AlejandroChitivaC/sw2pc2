package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Empleado rol id.
 */
@Getter
@Setter
@Embeddable
public class EmpleadoRolId implements Serializable {
    private static final long serialVersionUID = 4361847294630287764L;
    @Column(name = "idEmpleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "idRol", nullable = false)
    private Integer idRol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmpleadoRolId entity = (EmpleadoRolId) o;
        return Objects.equals(this.idRol, entity.idRol) &&
                Objects.equals(this.idEmpleado, entity.idEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, idEmpleado);
    }

}