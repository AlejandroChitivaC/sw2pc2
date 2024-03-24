package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.repos.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Usuario service.
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Instantiates a new Usuario service.
     *
     * @param usuarioRepository the usuario repository
     */
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Gets all usernames.
     *
     * @return the all usernames
     */
    public List<String> getAllUsernames() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(Usuario::getNombreUsuario)
                .collect(Collectors.toList());
    }
}

