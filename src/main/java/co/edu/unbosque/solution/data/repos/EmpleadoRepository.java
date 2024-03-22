package co.edu.unbosque.solution.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.edu.unbosque.solution.data.entities.Tipodocumento;
import co.edu.unbosque.solution.data.entities.Empleado;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proyectoabc.empleado (nombre, direccion, salario, fecha_ingreso, fecha_nacimiento, tipo_documento, numero_documento, telefono) VALUES (:nombre, :direccion, :salario, :fecha_ingreso, :fecha_nacimiento, :tipo_documento, :numero_documento, :telefono)", nativeQuery = true)
    Empleado insertarEmpleado(String nombre, String direccion, BigDecimal salario, LocalDate fecha_ingreso, LocalDate fecha_nacimiento, Tipodocumento tipo_documento, String numero_documento, String telefono);
}

