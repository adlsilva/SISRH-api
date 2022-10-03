package br.com.pro.sisrh.models.services;

import java.util.List;

import br.com.pro.sisrh.models.entities.Funcionarios;
import br.com.pro.sisrh.models.enums.Status;

public interface FuncionarioService {

	Funcionarios salvarFuncionarios(Funcionarios funcionarios);

	Funcionarios atualizar(Funcionarios funcionarios);

	void deletar(Funcionarios funcionarios);

	List<Funcionarios> buscar(Funcionarios funcionariosFiltro);

	void atualizarStatus(Funcionarios funcionarios, Status Status);

//	void salvarFuncionarios(String anyString);

	void validar(Funcionarios funcionarios);
}
