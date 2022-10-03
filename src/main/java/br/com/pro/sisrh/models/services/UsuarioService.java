//Salmos 126:3 Grandes coisas fez o SENHOR por nós, e, por isso, estamos alegres.
package br.com.pro.sisrh.models.services;

import br.com.pro.sisrh.models.entities.Usuario;

public interface UsuarioService {

	Usuario autenticar(String login, String senha);

	Usuario salvarUsuario(Usuario usuario);

	void validarLogin(String login);

}
