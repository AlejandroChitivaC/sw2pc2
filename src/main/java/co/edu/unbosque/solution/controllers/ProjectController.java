package co.edu.unbosque.solution.controllers;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.ProjectData;
import co.edu.unbosque.solution.services.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Project controller.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Instantiates a new Project controller.
     *
     * @param projectService the project service
     */
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Register response base.
     *
     * @param projectData the project data
     * @return the response base
     */
    @PostMapping("/register")
    public ResponseBase<ProjectData> register(@RequestBody ProjectData projectData) {
        ResponseBase<ProjectData> response = new ResponseBase<>();
        try {
            // Llamar al servicio para registrar el proyecto
            var data = projectService.registerProject(projectData);
            response.setValid(data.isValid());
            response.setMessage(data.getMessage());
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");
        }
        return response;
    }
}
