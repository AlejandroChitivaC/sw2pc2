package co.edu.unbosque.solution.controllers;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.RegisterEmpleado;
import co.edu.unbosque.solution.services.EmpleadoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping("/registro")
public class EmployeeController {

    private EmpleadoService _empleadoService;
    private HttpSession httpSession;

    /**
     * Instantiates a new Employee controller.
     *
     * @param empleadoService the empleado service
     */
    public EmployeeController(EmpleadoService empleadoService){
        _empleadoService = empleadoService;
    }

    /**
     * Empleado response base.
     *
     * @param registerEmpleado the register empleado
     * @return the response base
     */
    @PostMapping(path = "/addEmpleado")
    public ResponseBase<RegisterEmpleado> empleado(@RequestBody RegisterEmpleado registerEmpleado){

        var response = new ResponseBase<RegisterEmpleado>();
        try{
            var data = _empleadoService.addEmpleado(registerEmpleado);
            response.setValid(data.isValid());
            response.setMessage(data.getMessage());

        } catch (Exception e){

            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");

        }

        return response;

    }


}