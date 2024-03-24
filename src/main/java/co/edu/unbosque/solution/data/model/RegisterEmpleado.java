package co.edu.unbosque.solution.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.edu.unbosque.solution.data.entities.Tipodocumento;

/**
 * The type Register empleado.
 */
public record RegisterEmpleado(String nombre, String direccion, BigDecimal salario, LocalDate fecha_ingreso, LocalDate fecha_nacimiento, Tipodocumento tipo_documento_id, String numero_documento, String telefono ) {

    /**
     * Nombre string.
     *
     * @return the string
     */
// Método para acceder al nombre del empleado
    public String nombre() {
        return nombre;
    }

    /**
     * Direccion string.
     *
     * @return the string
     */
// Método para acceder a la dirección del empleado
    public String direccion() {
        return direccion;
    }

    /**
     * Salario big decimal.
     *
     * @return the big decimal
     */
    public BigDecimal salario(){
        return salario;
    }

    /**
     * Fecha ingreso local date.
     *
     * @return the local date
     */
    public LocalDate fecha_ingreso(){
        return fecha_ingreso;
    }

    /**
     * Fecha nacimiento local date.
     *
     * @return the local date
     */
    public LocalDate fecha_nacimiento(){
        return fecha_nacimiento;
    }

    /**
     * Tipo documento id tipodocumento.
     *
     * @return the tipodocumento
     */
    public Tipodocumento tipo_documento_id(){
        return tipo_documento_id;
    }

    /**
     * Numero documento string.
     *
     * @return the string
     */
// Método para acceder al número de documento del empleado
    public String numero_documento() {
        return numero_documento;
    }

    /**
     * Telefono string.
     *
     * @return the string
     */
// Método para acceder al teléfono del empleado
    public String telefono() {
        return telefono;
    } 
}
