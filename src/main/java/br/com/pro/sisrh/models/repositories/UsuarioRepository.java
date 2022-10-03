//DEus Seja Louvado
package br.com.pro.sisrh.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pro.sisrh.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	boolean existsByLogin(String login);

	Optional<Usuario> findByLogin(String login);//Query Metod

}
