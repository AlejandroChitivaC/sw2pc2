package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 * The interface Usuario repository.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    /**
     * Find usuario by email and password usuario.
     *
     * @param email    the email
     * @param password the password
     * @return the usuario
     */
    Usuario findUsuarioByEmailAndPassword(String email, String password);

    @Procedure("registrar_usuario")
    Usuario spRegisterUser(String usuario, String email, String password, Integer idempleado);

}