package co.edu.unbosque.solution.data.model;

import co.edu.unbosque.solution.data.entities.Proyecto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Project data.
 */
public record ProjectData(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinPrevista, BigDecimal presupuesto, String estado, Integer idLiderProyecto) {

    /**
     * Método para convertir ProjectData en una instancia de Proyecto.
     *
     * @return La instancia de Proyecto correspondiente a los datos de ProjectData.
     */
    public Proyecto toEntity() {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(this.nombre());
        proyecto.setDescripcion(this.descripcion());
        proyecto.setFechaInicio(java.sql.Date.valueOf(this.fechaInicio()));
        proyecto.setFechaFinPrevista(java.sql.Date.valueOf(this.fechaFinPrevista()));
        proyecto.setPresupuesto(this.presupuesto());
        proyecto.setEstado(this.estado());
        proyecto.setIdLiderProyecto(this.idLiderProyecto());
        return proyecto;
    }
}
