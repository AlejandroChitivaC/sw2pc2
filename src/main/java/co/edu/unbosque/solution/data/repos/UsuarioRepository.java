package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.model.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

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

}