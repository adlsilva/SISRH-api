package br.com.pro.sisrh.models.repositories.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pro.sisrh.models.entities.Usuario;
import br.com.pro.sisrh.models.repositories.UsuarioRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void deveVerificarAExistenciaDeUmLogin() {
		// Cenario
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		// repository.save(usuario);

		// Ação e Execução
		boolean result = repository.existsByLogin("usuario");

		// Verificação
		Assertions.assertThat(result).isTrue();

	}

	@Test
	public void deveRetornarFalsoQuandoNaoTiverUsuarioCadastradoComLogin() {
		// Cenario
		// repository.deleteAll();

		// Ação
		boolean result = repository.existsByLogin("usuario1");

		// Verificação
		Assertions.assertThat(result).isFalse();

	}

	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		// cenario

		Usuario usuario = criarUsuario();

		// Ação
		Usuario usuarioSalvo = repository.save(usuario);

		// Verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
	}

	@Test
	public void deveBuscarUmUsuarioPorLogin() {
		// Cenario
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);

		// Verificação
		Optional<Usuario> result = repository.findByLogin("usuario2");

		Assertions.assertThat(result.isPresent()).isTrue();// Toda vez que coloco isTrue, da falha no JUnit
	}

	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorLoginQuandoNaoExisteNaBase() {
		// Verificação
		Optional<Usuario> result = repository.findByLogin("usuario2");

		Assertions.assertThat(result.isPresent()).isFalse();
	}

	public static Usuario criarUsuario() {
		return Usuario.builder().nome("teste").login("usuario").senha("senha").matricula("12345").build();
	}

}
