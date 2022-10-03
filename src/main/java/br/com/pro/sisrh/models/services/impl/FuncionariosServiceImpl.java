package br.com.pro.sisrh.models.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.pro.sisrh.exception.RegraSisRhException;
import br.com.pro.sisrh.models.entities.Funcionarios;
import br.com.pro.sisrh.models.enums.Licenca;
import br.com.pro.sisrh.models.enums.Sexo;
import br.com.pro.sisrh.models.enums.Status;
import br.com.pro.sisrh.models.enums.Vinculo;
import br.com.pro.sisrh.models.repositories.FuncionariosRepository;
import br.com.pro.sisrh.models.services.FuncionarioService;

@Service
public class FuncionariosServiceImpl implements FuncionarioService {

	private FuncionariosRepository repository;

	public FuncionariosServiceImpl(FuncionariosRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Funcionarios salvarFuncionarios(Funcionarios funcionarios) {
		validar(funcionarios);
		funcionarios.setAtivo(Status.ATIVO);
		funcionarios.setLicenca(Licenca.NAOPOSSUILICENCA);
		funcionarios.setVinculo(Vinculo.COMISSIONADO);
		funcionarios.setSexo(Sexo.OUTRO);
		return repository.save(funcionarios);
	}

	@Override
	@Transactional
	public Funcionarios atualizar(Funcionarios funcionarios) {
		// É o mesmo metodo de salvar, porém, a condição abaixo, indica que só vai
		// salvar, se já existi um ID
		Objects.requireNonNull(funcionarios.getId());
		validar(funcionarios);
		return repository.save(funcionarios);
	}

	@Override
	@Transactional
	public void deletar(Funcionarios funcionarios) {
		Objects.requireNonNull(funcionarios.getId());
		repository.delete(funcionarios);

	}

	@Override
	@Transactional // (readOnly = true)
	public List<Funcionarios> buscar(Funcionarios funcionariosFiltro) {
		Example example = Example.of(funcionariosFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(example);
	}

	@Override
	public void atualizarStatus(Funcionarios funcionarios, Status Status) {
		funcionarios.setAtivo(Status);
		atualizar(funcionarios);

	}

	@Override
	public void validar(Funcionarios funcionarios) {
		if (funcionarios.getCpf() == null || funcionarios.getCpf().trim().equals("")) {
			throw new RegraSisRhException("CPF precisa ser preenchido");
		}
		// Se o CPF estivesse como integer no banco, esse comando seria valido
		if (funcionarios.getCpf() == null || funcionarios.getCpf().length() != 11) {
			throw new RegraSisRhException("CPF invalido");
		}
		// Se o CPF estivesse como integer no banco, esse comando seria valido
		if (funcionarios.getPis() == null || funcionarios.getPis().length() != 12) {
			throw new RegraSisRhException("PIS invalido");
		}
		if (funcionarios.getUnidade() == null || funcionarios.getUnidade().getId() == 0) {
			throw new RegraSisRhException("Informe uma unidade");
		}
		if (funcionarios.getSalario() == null || funcionarios.getSalario().compareTo(BigDecimal.ZERO) < 1) {
			throw new RegraSisRhException("O Salario não pode ser negativo");
		}
		if (funcionarios.getVinculo() == null) {
			throw new RegraSisRhException("Por favor, indique o vinculo do funcionario");
		}
		if (funcionarios.getLicenca() == null) {
			throw new RegraSisRhException("Por favor, indique se o funcionario está de licença");
		}
	}

}
