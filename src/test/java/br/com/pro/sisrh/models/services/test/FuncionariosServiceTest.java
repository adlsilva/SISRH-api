package br.com.pro.sisrh.models.services.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pro.sisrh.exception.RegraSisRhException;
import br.com.pro.sisrh.models.entities.Funcionarios;
import br.com.pro.sisrh.models.entities.Unidade;
import br.com.pro.sisrh.models.enums.Licenca;
import br.com.pro.sisrh.models.enums.Status;
import br.com.pro.sisrh.models.enums.Vinculo;
import br.com.pro.sisrh.models.repositories.FuncionariosRepository;
import br.com.pro.sisrh.models.services.FuncionarioService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("teste")
public class FuncionariosServiceTest {

	@Autowired
	@SpyBean
	FuncionarioService service;

	@Autowired
	@MockBean
	FuncionariosRepository repository;

//	@Test
//	public void deveSalvarFuncionario() {
//		// Cenario
//		Mockito.doNothing().when(service).salvarFuncionarios(Mockito.anyString());
//		Funcionarios funcionarios = Funcionarios.builder().id(1).nomecompleto("Almir Junior").cpf("123456789")
//				.rg("913419761").dataexpedicao("10/10/2010").tituloeleitor("881092699").pis("654984984")
//				.telefone("2191234123").celular("21123412345").matricula("12387645").email("email@email.com")
//				.cep("946132587").endereco("Avenida Itaguai").cidade("Rio de Janeiro").funcao("adm")
//				.cargo("administrador").registro("83147652").numeroConselho("44115522366").sexo("Macho")
//				.datanascimento("01/01/2001").dataadmissao("11/11/2011").processo("467941").vinculo(Vinculo.EFETIVO)
//				.ativo(StatusFuncionarios.ATIVO).observacoes("Lindo demais").informacoesferias("Gozou de Ferias")
//				.licenca(Licenca.NAOPOSSUILICENCA).build();
//		Mockito.when(repository.save(Mockito.any(Funcionarios.class))).thenReturn(funcionarios);
//
//		// Ação
//		Funcionarios funcionarioSalvo = service.salvarFuncionarios(new Funcionarios());
//
//		// Verificação
//		Assertions.assertThat(funcionarioSalvo).isNotNull();
//		
//		Assertions.assertThat(funcionarioSalvo.getId()).isEqualTo(1);
//		
//		Assertions.assertThat(funcionarioSalvo.getNomecompleto()).isEqualTo("Almir Junior");
//
//		Assertions.assertThat(funcionarioSalvo.getCpf()).isEqualTo("123456789");
//
//		Assertions.assertThat(funcionarioSalvo.getRg()).isEqualTo("913419761");
//
//		Assertions.assertThat(funcionarioSalvo.getDataexpedicao()).isEqualTo("10/10/2010");
//
//		Assertions.assertThat(funcionarioSalvo.getTituloeleitor()).isEqualTo("881092699");
//
//		Assertions.assertThat(funcionarioSalvo.getEmail()).isEqualTo("email@email.com");
//
//		Assertions.assertThat(funcionarioSalvo.getCep()).isEqualTo("946132587");
//
//		Assertions.assertThat(funcionarioSalvo.getEndereco()).isEqualTo("Avenida Itaguai");
//
//		Assertions.assertThat(funcionarioSalvo.getCidade()).isEqualTo("Rio de Janeiro");
//
//		Assertions.assertThat(funcionarioSalvo.getCargo()).isEqualTo("administrador");
//		Assertions.assertThat(funcionarioSalvo.getRegistro()).isEqualTo("83147652");
//		Assertions.assertThat(funcionarioSalvo.getNumeroConselho()).isEqualTo("44115522366");
//		Assertions.assertThat(funcionarioSalvo.getSexo()).isEqualTo("Macho");
//		Assertions.assertThat(funcionarioSalvo.getDatanascimento()).isEqualTo("01/01/2001");
//		Assertions.assertThat(funcionarioSalvo.getDataadmissao()).isEqualTo("11/11/2011");
//		Assertions.assertThat(funcionarioSalvo.getProcesso()).isEqualTo("467941");
//		Assertions.assertThat(funcionarioSalvo.getVinculo()).isEqualTo(Vinculo.EFETIVO);
//		Assertions.assertThat(funcionarioSalvo.getAtivo()).isEqualTo(StatusFuncionarios.ATIVO);
//
//		Assertions.assertThat(funcionarioSalvo.getObservacoes()).isEqualTo("Lindo demais");
//		Assertions.assertThat(funcionarioSalvo.getInformacoesferias()).isEqualTo("Gozou de Ferias");
//		Assertions.assertThat(funcionarioSalvo.getLicenca()).isEqualTo(Licenca.NAOPOSSUILICENCA);
//
//		
//		
//
//	}
	


}
