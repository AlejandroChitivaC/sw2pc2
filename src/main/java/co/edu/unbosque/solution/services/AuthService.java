package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.model.SignUpData;
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
     * Auth user method that allowas auth a user
     *
     * @param loginData the login data
     * @return the response base
     */
    public ResponseBase<Usuario> authUser(LoginData loginData) {
        var response = new ResponseBase<Usuario>();
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

    public ResponseBase<Usuario> addUser(SignUpData signUpData) {
        var response = new ResponseBase<Usuario>();
        try {
            // Realizar la inserción en la base de datos utilizando una sentencia SQL directa
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuario(signUpData.usuario());
            nuevoUsuario.setEmail(signUpData.email());
            nuevoUsuario.setPassword(signUpData.password());

            Usuario usuarioGuardado = _userRepo.save(nuevoUsuario);

            if (usuarioGuardado != null) {
                response.setValid(true);
                response.setMessage("Usuario registrado exitosamente");
            } else {
                response.setValid(false);
                response.setMessage("Error al registrar el usuario");
            }
        } catch (Exception e) {
            response.setValid(false);
            response.setMessage("Oops, ha ocurrido un error intente nuevamente");
        }

        return response;
    }

}
