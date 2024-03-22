package co.edu.unbosque.solution.data.model;

import co.edu.unbosque.solution.data.entities.Proyecto;

import java.math.BigDecimal;
import java.sql.Date;


public record ProjectData(String nombre, String descripcion, Date fechaInicio, Date fechaFinPrevista, BigDecimal presupuesto, String estado, Integer idLiderProyecto) {

    /**
     * Método para convertir ProjectData en una instancia de Proyecto.
     *
     * @return La instancia de Proyecto correspondiente a los datos de ProjectData.
     */
    public Proyecto toEntity() {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(this.nombre());
        proyecto.setDescripcion(this.descripcion());
        proyecto.setFechaInicio(this.fechaInicio());
        proyecto.setFechaFinPrevista(this.fechaFinPrevista());
        proyecto.setPresupuesto(this.presupuesto());
        proyecto.setEstado(this.estado());
        proyecto.setIdLiderProyecto(this.idLiderProyecto());
        return proyecto;
    }
}
