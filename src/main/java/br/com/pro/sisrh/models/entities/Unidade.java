//A Deus seja dada toda honra e toda a gloria

package br.com.pro.sisrh.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 25)
	private String nomeunidade;
	@Column(length = 50)
	private String endereço;
	@Column(length = 10)
	private String cep;
	@Column(length = 25)
	private String cidade;
	@Column(length = 15)
	private String telefone;
	@Column(length = 40)
	private String coordenador;

}
