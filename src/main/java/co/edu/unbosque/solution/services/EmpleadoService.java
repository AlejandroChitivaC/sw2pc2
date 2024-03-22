package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.entities.Empleado;
import co.edu.unbosque.solution.data.model.RegisterEmpleado;
import co.edu.unbosque.solution.data.repos.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    EmpleadoRepository _empleadoRepo;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        _empleadoRepo = empleadoRepository;
    }

    public ResponseBase<Empleado> addEmpleado(RegisterEmpleado registerEmpleado) {
        var response = new ResponseBase<Empleado>();
        try {
            // Realizar la inserción en la base de datos utilizando una sentencia SQL directa
            Empleado nuevoEmpleado = new Empleado();
//            nuevoEmpleado.setNombre();
//            nuevoEmpleado.setDireccion(registerEmpleado.direccion());
//            nuevoEmpleado.setSalario(registerEmpleado.salario());
//            nuevoEmpleado.setFecha_ingreso(registerEmpleado.fecha_ingreso());
//            nuevoEmpleado.setFecha_nacimiento(registerEmpleado.fecha_nacimiento());
//            nuevoEmpleado.setTipo_documento(registerEmpleado.tipo_documento_id());
//            nuevoEmpleado.setNumero_documento(registerEmpleado.numeroDocumento());
//            nuevoEmpleado.setTelefono(registerEmpleado.telefono());

            Empleado empleadoGuardado = _empleadoRepo.insertarEmpleado(registerEmpleado.nombre(), registerEmpleado.direccion(),registerEmpleado.salario(),registerEmpleado.fecha_ingreso(),registerEmpleado.fecha_nacimiento(),registerEmpleado.tipo_documento_id(),registerEmpleado.numero_documento(),registerEmpleado.telefono());

            if (empleadoGuardado != null) {
                response.setValid(true);
                response.setMessage("Empleado registrado exitosamente");
            } else {
                response.setValid(false);
                response.setMessage("Error al registrar el empleado");
            }
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");
        }

        return response;
    }
    
}