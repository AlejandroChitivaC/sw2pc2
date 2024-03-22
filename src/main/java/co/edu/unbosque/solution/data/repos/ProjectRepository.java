package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Project repository.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Proyecto, Long> {

}