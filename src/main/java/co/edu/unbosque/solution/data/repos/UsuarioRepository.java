package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Query(value = "INSERT INTO usuario (nombre_usuario, email, password, idEmpleado) VALUES (:usuario, :email, :password, :idEmpleado)", nativeQuery = true)
    @Modifying
    @Transactional
    void registerUser(@Param("usuario") String usuario, @Param("email") String email, @Param("password") String password, @Param("idEmpleado") Integer idEmpleado);


}