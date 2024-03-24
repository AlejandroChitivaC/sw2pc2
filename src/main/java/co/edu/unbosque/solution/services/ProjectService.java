package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.ProjectData;
import co.edu.unbosque.solution.data.repos.ProjectRepository;
import org.springframework.stereotype.Service;

/**
 * The type Project service.
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    /**
     * Instantiates a new Project service.
     *
     * @param projectRepository the project repository
     */
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Register project response base.
     *
     * @param projectData the project data
     * @return the response base
     */
    public ResponseBase<ProjectData> registerProject(ProjectData projectData) {
        ResponseBase<ProjectData> response = new ResponseBase<>();
        try {
            // Guardar el proyecto en la base de datos
            projectRepository.save(projectData.toEntity());

            response.setValid(true);
            response.setMessage("Proyecto registrado exitosamente");
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error al registrar el proyecto");
        }
        return response;
    }
}
