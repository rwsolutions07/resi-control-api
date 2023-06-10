package rw.solutions.api.resi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rw.solutions.api.resi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.username = :username")
	Usuario findByUsername(@Param("username") String username);

}
