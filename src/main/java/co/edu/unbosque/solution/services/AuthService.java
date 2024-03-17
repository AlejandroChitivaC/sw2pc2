package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    UsuarioRepository _userRepo;

    public AuthService(UsuarioRepository usuarioRepository) {
        _userRepo = usuarioRepository;
    }

    public ResponseBase<LoginData> authUser(LoginData loginData) {

        var response = new ResponseBase<LoginData>();
        try {
//            var data = new LoginData(email, password);
            var data = _userRepo.findUsuarioByEmailAndPassword(loginData.getEmail(), loginData.getPassword());
            if (data != null) {
                response.setValid(true);
                response.setMessage("Bienvenido " +
                        data.getEmail());
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
