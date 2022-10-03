const formulario = document.querySelector("form");

const Inome = document.querySelector(".nome");
const Iendereço = document.querySelector(".endereço");
const Icep = document.querySelector(".cep");
const Icidade = document.querySelector(".cidade");
const Itel = document.querySelector(".tel");

function cadastrar() {
	fetch("http://localhost:8080/unidade",
		{
			headers: {
				'accept': 'application/json',
				'Content-Type': 'application/json'
			},
			method: "POST",
			body: JSON.stringify({

				nomeunidade: Inome.value,
				endereço: Iendereço.value,
				cep: Icep.value,
				cidade: Icidade.value,
				telefone: Itel.value

			})
		}
	)
};
function limpar() {
	Inome.value = "";
	Iendereço.value = "";
	Icep.value = "";
	Icidade.value = "";
	Itel.value = "";
};

formulario.addEventListener('submit', function(event) {
	event.preventDefault();

	cadastrar();
	limpar();

});