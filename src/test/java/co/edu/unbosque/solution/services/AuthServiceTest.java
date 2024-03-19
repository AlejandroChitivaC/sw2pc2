package co.edu.unbosque.solution.services;

import co.edu.unbosque.solution.data.entities.ResponseBase;
import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.repos.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

/**
 * The type Auth service test.
 */
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    private AuthService authServiceUnderTest;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        authServiceUnderTest = new AuthService(usuarioRepository);
    }

    /**
     * Test auth user.
     */
    @Test
    void testAuthUser() {
        // Setup
        final LoginData loginData = new LoginData("email", "password");

        // Configure UsuarioRepository.findUsuarioByEmailAndPassword(...).
        final Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setEmail("email");
        usuario.setPassword("password");
        when(usuarioRepository.findUsuarioByEmailAndPassword("email", "password")).thenReturn(usuario);

        // Run the test
        final ResponseBase<LoginData> result = authServiceUnderTest.authUser(loginData);

        // Verify the results
    }

    /**
     * Test auth user usuario repository returns null.
     */
    @Test
    void testAuthUser_UsuarioRepositoryReturnsNull() {
        // Setup
        final LoginData loginData = new LoginData("email", "password");
        when(usuarioRepository.findUsuarioByEmailAndPassword("email", "password")).thenReturn(null);

        // Run the test
        final ResponseBase<LoginData> result = authServiceUnderTest.authUser(loginData);

        // Verify the results
    }
}
