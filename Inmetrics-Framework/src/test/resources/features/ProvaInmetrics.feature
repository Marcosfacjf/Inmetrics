@Inmetrics
Feature: Prova da Inmetrics

	Background:
		Given que acesso a página de login
	
	
	@Run
	Scenario: Cadastrar novo usuário
		And clico para cadastrar o novo usuário
		And insiro os dados do novo usuário
		When clico em cadastrar
		Then o site redireciona para a página de login
		
	@Run
	Scenario: Cadastrar novo usuário com nome curto
		And clico para cadastrar o novo usuário
		And insiro os dados do novo usuário com nome curto
		When clico em cadastrar
		Then valido que o usuário não foi cadastrado
		
	@Run
	Scenario: Cadastrar novo funcionário de forma randômica
		And efetuo o login
		And clico em novo funcionário
		And insiro os dados do novo funcionário
		When clico em enviar
		Then valido mensagem "SUCESSO! Usuário cadastrado com sucesso"
			
	@Run
	Scenario: Cadastrar Novo Funcionário
	And efetuo o login
	And clico em novo funcionário
	When preencho os dados do novo funcionário
	| Nome         | Cargo | CPF            | Salario | Sexo      | Tipo Contratacao | Admissao   |
	| Marcos Cunha | QA    | 095.890.147-39 | 650000  | Masculino | clt              | 17/08/2020 |
	Then valido mensagem "SUCESSO! Usuário cadastrado com sucesso"
	
	@Run
	Scenario: Alterar Informações Funcionário
	And efetuo o login
	And acesso tela de funcionários
	And pesquiso pelo usuário cadastrado "Marcos Cunha"
	And clico em editar o primeiro da lista
	When altero o cargo para "Analista de Qualidade"
	Then valido mensagem "SUCESSO! Informações atualizadas com sucesso"
	
	@Run
	Scenario: Remover Funcionário
	And efetuo o login
	And acesso tela de funcionários
	And pesquiso pelo usuário cadastrado "Marcos Cunha"
	When clico em excluir o primeiro funcionário da lista
	Then valido mensagem "SUCESSO! Funcionário removido com sucesso"
		