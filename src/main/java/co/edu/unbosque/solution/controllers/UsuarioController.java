package co.edu.unbosque.solution.controllers;

import co.edu.unbosque.solution.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Usuario controller.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Instantiates a new Usuario controller.
     *
     * @param usuarioService the usuario service
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Gets all usernames.
     *
     * @return the all usernames
     */
    @GetMapping("/nombres")
    public List<String> getAllUsernames() {
        return usuarioService.getAllUsernames();
    }
}
