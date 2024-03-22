package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Empleado;
import co.edu.unbosque.solution.data.entities.Proyecto;
import co.edu.unbosque.solution.data.entities.Tipodocumento;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Project repository.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Proyecto, Long> {

     @Modifying
    @Transactional
    @Query(value = "INSERT INTO proyectoabc.proyecto( nombre, descripcion, fecha_inicio, fecha_fin_prevista, presupuesto, estado, idLiderProyecto) VALUES (:nombre, :descripcion, :fecha_inicio, :fecha_fin_prevista, :presupuesto, :estado, :idLiderProyecto)", nativeQuery = true)
    Proyecto insertarProyecto(String nombre, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin_prevista, BigDecimal presupuesto, String estado, Integer idLiderProyecto);

}
