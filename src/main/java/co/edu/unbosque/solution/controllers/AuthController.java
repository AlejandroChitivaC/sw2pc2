package co.edu.unbosque.solution.controllers;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.model.SignUpData;
import co.edu.unbosque.solution.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService _authService;
    private HttpSession httpSession;

    /**
     * Instantiates a new Auth controller.
     *
     * @param authService the auth service
     */
    public AuthController(AuthService authService) {
        _authService = authService;
    }

    /**
     * Login response base.
     *
     * @param loginData the login data
     * @return the response base
     */
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
        }

        return response;
    }

    @PostMapping(path = "/register")
    public ResponseBase<SignUpData> register(@RequestBody SignUpData signUpData) {

        var response = new ResponseBase<SignUpData>();
        try {
            System.out.println(signUpData);

            var data = _authService.addUser(signUpData);
            response.setValid(data.isValid());
            response.setMessage(data.getMessage());

        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");
        }

        return response;
    }


}
