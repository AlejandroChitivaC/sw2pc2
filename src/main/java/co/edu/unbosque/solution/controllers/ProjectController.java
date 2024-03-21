package co.edu.unbosque.solution.controllers;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.RegisterProject;
import co.edu.unbosque.solution.data.model.RegisterProject;
import co.edu.unbosque.solution.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Project controller.
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService _ProjectService;

    /**
     * Instantiates a new Project controller.
     *
     * @param projectService the project service
     */
    @Autowired
    public ProjectController(ProjectService projectService) {
        _ProjectService = projectService;
    }

    /**
     * Register project response base.
     *
     * @param projectData the project data
     * @return the response base
     */
    @PostMapping(path = "/register")
    public ResponseBase<RegisterProject> registerProject(@RequestBody RegisterProject registerProject) {
        var response = new ResponseBase<RegisterProject>();
        try {
            var data = _ProjectService.registrarProyecto(registerProject);
            response.setValid(data.isValid());
            response.setMessage("El proyecto se registró correctamente");
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error al registrar el proyecto");
        }
        return response;
    }
}
