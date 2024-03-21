package co.edu.unbosque.solution.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Login data.
 */
public record RegisterProject(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinPrevista, BigDecimal presupuesto, String estado) {
   
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinPrevista() {
        return fechaFinPrevista;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public String getEstado() {
        return estado;
    }
}