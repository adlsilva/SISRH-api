//Grandes coisas fez o Senhor, por isso estamos alegres
package br.com.pro.sisrh.models.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pro.sisrh.exception.ErroAutenticacao;
import br.com.pro.sisrh.exception.RegraSisRhException;
import br.com.pro.sisrh.models.entities.Usuario;
import br.com.pro.sisrh.models.repositories.UsuarioRepository;
import br.com.pro.sisrh.models.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;

	}

	@Override
	public Usuario autenticar(String login, String senha) {
		Optional<Usuario> usuario = repository.findByLogin(login);
		if (!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuario não encontrado para esse login");
		}
		if (!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha invalida");
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarLogin(usuario.getLogin());
		return repository.save(usuario);
	}

	@Override
	public void validarLogin(String login) {
		boolean existe = repository.existsByLogin(login);
		if (existe) {
			throw new RegraSisRhException("Já existe um usuário cadastrado com esse Login.");
		}

	}

}
