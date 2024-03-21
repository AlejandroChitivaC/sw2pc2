package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.model.LoginData;
import co.edu.unbosque.solution.data.model.SignUpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "INSERT INTO proyectoabc.usuario (nombre_usuario, email, password, idEmpleado) VALUES (:nombreUsuario, :email, :password, :idEmpleado)", nativeQuery = true)
    void insertUsuario(String nombreUsuario, String email, String password, Integer idEmpleado);

}