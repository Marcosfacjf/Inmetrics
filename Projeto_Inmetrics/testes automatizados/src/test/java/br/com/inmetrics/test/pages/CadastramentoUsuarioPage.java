package br.com.inmetrics.test.pages;

public class CadastramentoUsuarioPage extends BasePage {
	
	private String XPATH_USUARIO = "//input[@name='username']";
	private String XPATH_SENHA = "//input[@name='pass']";
	private String XPATH_CONFIRMACAO_SENHA = "//input[@name='confirmpass']";
	private String XPATH_TITULO_CADASTRE = "//span[@class='login100-form-title']";

	public CadastramentoUsuarioPage() {
		super();
	}
	
	public CadastramentoUsuarioPage preencherDadosNovoUsuario(String usuario, String senha, String confirmacaoSenha) {
		getDSL().esperarAteExistente(XPATH_USUARIO, 2000)
				.digitar(XPATH_USUARIO, usuario)
				.digitar(XPATH_SENHA, senha)
				.digitar(XPATH_CONFIRMACAO_SENHA, confirmacaoSenha);
		return this;
	}
	
	public CadastramentoUsuarioPage validarUsuarioNaoCadastrado() {
		getDSL().validarConteudo(XPATH_TITULO_CADASTRE, "Cadastre-se");
		return this;
	}
}
