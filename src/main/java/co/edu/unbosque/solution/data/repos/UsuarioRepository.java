package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query(value = "INSERT INTO proyectoabc.usuario (nombre_usuario, email, password) VALUES (:nombreUsuario, :email, :password)", nativeQuery = true)
    void insertUsuario(String nombreUsuario, String email, String password);




}