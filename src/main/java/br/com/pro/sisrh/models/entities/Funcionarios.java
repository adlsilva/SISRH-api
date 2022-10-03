//A Deus seja toda honra e toda gloria

package br.com.pro.sisrh.models.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.convert.Jsr310Converters;

import br.com.pro.sisrh.models.enums.Licenca;
import br.com.pro.sisrh.models.enums.Sexo;
import br.com.pro.sisrh.models.enums.Status;
import br.com.pro.sisrh.models.enums.Vinculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 60)
	private String nomecompleto;
	@Column(length = 14)
	private String cpf;
	@Column(length = 12)
	private String rg;
	@Column // do RG
	private String dataexpedicao;
	@Column(length = 15)
	private String tituloeleitor;
	@Column(length = 15)
	private String pis;
	@Column(length = 16)
	private String telefone;
	@Column(length = 16)
	private String celular;
	@Column(length = 8)
	private String matricula;
	@Column(length = 50)
	private String email;
	@Column(length = 9)
	private String cep;
	@Column(length = 75)
	private String endereco;
	@Column(length = 16)
	private String cidade;
	@Column(length = 50) // Cargo
	private String funcao;
	@Column
	private String cargo;
	@Column(length = 8) // Se é Coren ou CRM, CRA, CRO, outros
	private String registro;
	@Column(length = 30)
	private String numeroConselho;
	@Column // Masculino, Feminino e Outro
	@Enumerated(value = EnumType.STRING)
	private Sexo sexo;
	@Column
	private String datanascimento;

	@Column
	private BigDecimal salario;

	@Column // Quando começou a trabalhar na prefeitura
	@Convert(converter = Jsr310Converters.LocalDateToDateConverter.class)
	private LocalDate dataadmissao;
	@Column // A ser incluido depois
	private String processo;
	@Column // Efetivo, contratado ou nomeado
	@Enumerated(value = EnumType.STRING) // Para converter o enum para String
	private Vinculo vinculo;
	@ManyToOne
	private Unidade unidade;
	@Column // Se ainda está trabalhand ou se foi exonerado
	@Enumerated(value = EnumType.STRING)
	private Status ativo;
	@Column(length = 1000)
	private String observacoes;
	@Column(length = 500)
	private String informacoesferias;

	@Column // Ferias, Ferias sem vencimentos, Bim, Licenca premium
	@Enumerated(value = EnumType.STRING)
	private Licenca licenca;
}
