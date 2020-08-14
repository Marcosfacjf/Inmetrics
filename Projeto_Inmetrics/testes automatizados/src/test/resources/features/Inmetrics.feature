#language:pt


Funcionalidade: Prova Inmetrics

	
	@Run
	Cenário: Cadastrar Novo Funcionário
	Dado que acesso o sistema
	Quando acesso tela de cadastramento de novos funcionários
	E preencho os dados do novo funcionário
	| Nome         | Cargo | CPF            | Salario | Sexo      | Tipo Contratacao | Admissao   |
	| Marcos Cunha | QA    | 095.890.147-39 | 650000  | Masculino | clt              | 17/08/2020 |
	Então valido mensagem "SUCESSO! Usuário cadastrado com sucesso"
	
	@Run
	Cenário: Alterar Informações Funcionário
	Dado que acesso o sistema
	Quando acesso tela de funcionários
	E pesquiso pelo usuário cadastrado "Marcos Cunha"
	E clico em editar o primeiro da lista
	Então altero o cargo para "Analista de Qualidade"
	E valido mensagem "SUCESSO! Informações atualizadas com sucesso"
	
	@Run
	Cenário: Remover Funcionário
	Dado que acesso o sistema
	Quando acesso tela de funcionários
	E pesquiso pelo usuário cadastrado "Marcos Cunha"
	E clico em excluir o primeiro funcionário da lista
	Então valido mensagem "SUCESSO! Funcionário removido com sucesso"
	
	@Run
	Cenário: Cadastrar Usuário
	Dado que acesso o site
	E clico para cadastrar usuário
	Quando preencho os dados do novo usuário
	| Usuario  | Senha  | Confirme a Senha |
	| AmaralJF | 123456 | 123456           |
	Então valido que estou na tela de login
	
	@Run
	Cenário: Cadastrar Usuário com menos de oito caracteres
	Dado que acesso o site
	E clico para cadastrar usuário
	Quando preencho os dados do novo usuário
	| Usuario | Senha  | Confirme a Senha |
	| abcdefg | 123456 | 123456           |
	Então valido que o usuário não foi cadastrado