package co.edu.unbosque.solution.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.solution.data.entities.Proyecto;
import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.RegisterProject;
import co.edu.unbosque.solution.data.repos.ProyectoRepository;


public class ProjectService {

    @Autowired
    ProyectoRepository proyectoRepository;

    /**
     * Registra un nuevo proyecto en la base de datos.
     *
     * @param registerProject los datos del proyecto a registrar
     * @return una respuesta indicando si se pudo registrar el proyecto o no
     */
    public ResponseBase<Proyecto> registrarProyecto(RegisterProject registerProject) {
        var response = new ResponseBase<Proyecto>();

        try {
            // Convertir RegisterProject a Proyecto
            Proyecto proyecto = convertirAProyecto(registerProject);

            // Guardar el nuevo proyecto en la base de datos
            proyectoRepository.save(proyecto);

            response.setValid(true);
            response.setData(proyecto);;
            response.setMessage("Proyecto registrado correctamente.");
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Error al registrar el proyecto: " + e.getMessage());
        }

        return response;
    }

    /**
     * Convierte un objeto RegisterProject a un objeto Proyecto.
     *
     * @param registerProject los datos del proyecto a convertir
     * @return un objeto Proyecto con los datos proporcionados
     */
    private Proyecto convertirAProyecto(RegisterProject registerProject) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(registerProject.getNombre());
        proyecto.setDescripcion(registerProject.getDescripcion());
        proyecto.setFechaInicio(registerProject.getFechaInicio());
        proyecto.setFechaFinPrevista(registerProject.getFechaFinPrevista());
        proyecto.setPresupuesto(registerProject.getPresupuesto());
        proyecto.setEstado(registerProject.getEstado());
        // Otros campos de Proyecto si es necesario

        return proyecto;
    }
    
}
