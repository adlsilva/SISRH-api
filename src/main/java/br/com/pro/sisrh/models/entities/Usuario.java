// Deus Acima de tudo
package br.com.pro.sisrh.models.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.pro.sisrh.util.ConverterData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String nome;
	@Column (length = 15)
	private String nascimento;
	@Column(length = 20)
	private String login;
	@Column(length = 8)
	private String senha;
	@Column(length = 10)
	private String matricula;
	@Column(length = 35)
	private String cargo;
	

}
