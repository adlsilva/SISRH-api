const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Imatricula = document.querySelector(".matricula");
const Icpf = document.querySelector(".cpf");
const Irg = document.querySelector(".rg");
const Idataexpedicao = document.querySelector(".dataexpedicao");
const Ipis = document.querySelector(".pis");
const Idatanascimento = document.querySelector(".datanascimento");
const Igenero = document.querySelector(".genero");
const Icep = document.querySelector(".cep");
const Iendereco = document.querySelector(".endereco");
const Inumero = document.querySelector(".numero");
const Icomplemento = document.querySelector(".complemento");
const Icidade = document.querySelector(".cidade");
const Imunicipio = document.querySelector(".municipio");
const Iunidade = document.querySelector(".unidade");
const Itelefone = document.querySelector(".telefone");
const Icelular = document.querySelector(".celular");

function cadastar(){
	
	fetch("http://localhost:8080/funcionarios",
	{
		headers:{
			'accept': 'application/json', 'Content-type': 'application/json'
		},
		method: "POST", 
		body: JSON.stringify({		
		nomecompleto: Inome.value,
		matricula: Imatricula.value,
		cpf: Icpf.value,
		rg: Irg.value,
		dataexpedicao: Idataexpedicao.value,
		pis: Ipis.value,
		datanascimento: Idatanascimento.value,
		genero: Igenero.value,
		cep: Icep.value,
		endereco: Iendereco.value,
		numero: Inumero.value,
		complemento: Icomplemento.value,
		cidade: Icidade.value,
		municipio: Imunicipio.value,
		unidade: Iunidade.value,
		telefone: Itelefone.value,
		celular: Icelular.value,})
	})
	.then(function (res) {console.log(res)})
	.catch(function(res) {console.log(res)})
};


formulario.addEventListener('submit', function(event){
	event.preventDefault();
	
	const dados ={
		
		nomecompleto: Inome.value,
		matricula: Imatricula.value,
		cpf: Icpf.value,
		rg: Irg.value,
		dataexpedicao: Idataexpedicao.value,
		pis: Ipis.value,
		datanascimento: Idatanascimento.value,
		genero: Igenero.value,
		cep: Icep.value,
		endereco: Iendereco.value,
		numero: Inumero.value,
		complemento: Icomplemento.value,
		cidade: Icidade.value,
		municipio: Imunicipio.value,
		unidade: Iunidade.value,
		telefone: Itelefone.value,
		celular: Icelular.value,

	};
	
});
