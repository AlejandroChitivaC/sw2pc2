package co.edu.unbosque.solution.controllers;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.repos.UsuarioRepository;
import co.edu.unbosque.solution.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService _authService;
    private HttpSession httpSession;

    public AuthController(AuthService authService) {
        _authService = authService;
    }

    @PostMapping(path = "/login")
    public ResponseBase<LoginData> login(@RequestBody LoginData loginData) {

        var response = new ResponseBase<LoginData>();
        try {
            var data = _authService.authUser(loginData);
            response.setValid(data.isValid());
            response.setMessage(data.getMessage());

        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");
//            response.setDataSingle();
        }

        return response;
    }


}
