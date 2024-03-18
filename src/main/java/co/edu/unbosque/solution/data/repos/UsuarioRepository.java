package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
        Usuario findUsuarioByEmailEquals(String email);

}