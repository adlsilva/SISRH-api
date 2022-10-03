//Hosana nas alturas
package br.com.pro.sisrh.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pro.sisrh.api.dto.UsuarioDTO;
import br.com.pro.sisrh.exception.ErroAutenticacao;
import br.com.pro.sisrh.exception.RegraSisRhException;
import br.com.pro.sisrh.models.entities.Usuario;
import br.com.pro.sisrh.models.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	private UsuarioService service;

	public UsuarioResource(UsuarioService service) {
		this.service = service;
	}

	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {
		try {
			Usuario usuarioAutenticado = service.autenticar(dto.getLogin(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		} catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {

		Usuario usuario = Usuario.builder().nome(dto.getNome()).login(dto.getLogin()).matricula(dto.getMatricula())
				.senha(dto.getSenha()).nascimento(dto.getNascimento()).cargo(dto.getCargo()).build();

		try {
			Usuario usuarioSalvo = service.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		} catch (RegraSisRhException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
