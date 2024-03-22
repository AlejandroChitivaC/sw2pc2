package co.edu.unbosque.solution.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.edu.unbosque.solution.data.entities.Tipodocumento;

public record RegisterEmpleado(String nombre, String direccion, BigDecimal salario, LocalDate fecha_ingreso, LocalDate fecha_nacimiento, Tipodocumento tipo_documento_id, String numero_documento, String telefono ) {
    
    // Método para acceder al nombre del empleado
    public String nombre() {
        return nombre;
    }

    // Método para acceder a la dirección del empleado
    public String direccion() {
        return direccion;
    }

    public BigDecimal salario(){
        return salario;
    }

    public LocalDate fecha_ingreso(){
        return fecha_ingreso;
    }

    public LocalDate fecha_nacimiento(){
        return fecha_nacimiento;
    }

    public Tipodocumento tipo_documento_id(){
        return tipo_documento_id;
    }

    // Método para acceder al número de documento del empleado
    public String numero_documento() {
        return numero_documento;
    }

    // Método para acceder al teléfono del empleado
    public String telefono() {
        return telefono;
    } 
}
