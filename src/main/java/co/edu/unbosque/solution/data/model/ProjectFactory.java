package co.edu.unbosque.solution.data.model;

import co.edu.unbosque.solution.data.entities.Proyecto;

public interface ProjectFactory {
    Proyecto createProject(ProjectData projectData);
}
