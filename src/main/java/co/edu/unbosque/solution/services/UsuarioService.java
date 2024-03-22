package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.repos.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<String> getAllUsernames() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(Usuario::getNombreUsuario)
                .collect(Collectors.toList());
    }
}

