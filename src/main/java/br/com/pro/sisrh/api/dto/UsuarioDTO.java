package br.com.pro.sisrh.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
	
	private String nome;
	private String login;
	private String matricula;
	private String senha;
	private String nascimento;
	private String cargo;
}
 