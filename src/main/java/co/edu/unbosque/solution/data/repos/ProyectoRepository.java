package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Proyecto;
import co.edu.unbosque.solution.data.model.RegisterProject;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.solution.data.entities.Proyecto;

import java.math.BigDecimal;
import java.time.LocalDate; 

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    

    Proyecto registerProject(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFinPrevista, BigDecimal presupuesto, String estado);
}
