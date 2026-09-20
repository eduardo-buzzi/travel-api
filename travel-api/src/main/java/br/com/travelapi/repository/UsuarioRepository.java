package br.com.travelapi.repository;

import br.com.travelapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

Optional<Usuario> findByUsername(String username);


}
