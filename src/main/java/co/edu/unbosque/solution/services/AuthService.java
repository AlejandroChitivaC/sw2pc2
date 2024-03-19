package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Auth service.
 */
@Service
public class AuthService {

    /**
     * The User repo.
     */
    UsuarioRepository _userRepo;

    /**
     * Instantiates a new Auth service.
     *
     * @param usuarioRepository the usuario repository
     */
    public AuthService(UsuarioRepository usuarioRepository) {
        _userRepo = usuarioRepository;
    }

    /**
     * Auth user response base.
     *
     * @param loginData the login data
     * @return the response base
     */
    public ResponseBase<LoginData> authUser(LoginData loginData) {
        var response = new ResponseBase<LoginData>();
        if (loginData == null || loginData.getEmail() == null || loginData.getPassword() == null) {
            response.setValid(false);
            response.setMessage("Los datos de inicio de sesión no pueden ser nulos");
            return response;
        }

        try {
            var data = _userRepo.findUsuarioByEmailAndPassword(loginData.getEmail(), loginData.getPassword());
            if (data != null) {
                response.setValid(true);
                response.setMessage("Bienvenido " + data.getEmail());
            } else {
                response.setValid(false);
                response.setMessage("Usuario no encontrado, verifique las credenciales");
            }
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");
        }

        return response;
    }

}
