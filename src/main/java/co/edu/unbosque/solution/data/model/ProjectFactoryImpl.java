package co.edu.unbosque.solution.data.model;

import co.edu.unbosque.solution.data.entities.Proyecto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Component
public class ProjectFactoryImpl implements ProjectFactory {
    @Override
    public Proyecto createProject(ProjectData projectData) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(projectData.nombre());
        proyecto.setDescripcion(projectData.descripcion());
        proyecto.setFechaInicio(Date.valueOf(projectData.fechaInicio()));
        proyecto.setFechaFinPrevista(Date.valueOf(projectData.fechaFinPrevista()));
        proyecto.setPresupuesto(projectData.presupuesto());
        proyecto.setEstado(projectData.estado());
        proyecto.setIdLiderProyecto(projectData.idLiderProyecto());
        return proyecto;
    }
}

