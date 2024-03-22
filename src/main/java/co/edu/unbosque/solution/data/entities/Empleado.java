package co.edu.unbosque.solution.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

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

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "salario", precision = 10, scale = 2)
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

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Empleado empleado = (Empleado) o;
        return getNumero_documento() != null && Objects.equals(getNumero_documento(), empleado.getNumero_documento());
    }


}