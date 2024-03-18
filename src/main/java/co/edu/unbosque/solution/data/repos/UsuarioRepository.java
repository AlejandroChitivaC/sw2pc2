package co.edu.unbosque.solution.data.repos;

import co.edu.unbosque.solution.data.entities.Usuario;
import co.edu.unbosque.solution.data.model.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
        Usuario findUsuarioByEmailAndPassword(String email, String password);

}