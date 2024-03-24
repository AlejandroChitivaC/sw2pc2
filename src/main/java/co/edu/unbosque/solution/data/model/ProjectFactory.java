package co.edu.unbosque.solution.data.model;

import co.edu.unbosque.solution.data.entities.Proyecto;

/**
 * The interface Project factory.
 */
public interface ProjectFactory {
    /**
     * Create project proyecto.
     *
     * @param projectData the project data
     * @return the proyecto
     */
    Proyecto createProject(ProjectData projectData);
}
