package br.com.inmetrics.test.pages;

public class HomePage extends BasePage {
	
	private String URL_SITE = "http://www.inmrobo.tk/accounts/login/";
	private String XPATH_MENU_SAIR = "//a[text()='Sair']";
	private String XPATH_MENU_NOVO_FUNCIONARIO = "//a[text()='Novo Funcionário']";
	private String XPATH_MENU_FUNCIONARIOS = "//a[text()='Funcionários']";
	private String XPATH_MENSAGEM_SUCESSO = "//div[@class='alert alert-success alert-dismissible fade show']";
	private String XPATH_TITULO_LOGIN = "//span[@class='login100-form-title p-b-1']";

	
	public HomePage() {
		super();
	}
	
	public void acessarSiteInmetrics() {
		getDSL().visitarPagina(URL_SITE);
	}
	
	public void acessarNovoFuncionario() {
		esperarPaginaCarregar();
		getDSL().clicar(XPATH_MENU_NOVO_FUNCIONARIO);
	}
	
	public void acessarTelaFuncionarios() {
		esperarPaginaCarregar();
		getDSL().clicar(XPATH_MENU_FUNCIONARIOS);
	}
	
	public void validarMensagem(String mensagem) {
		getDSL().validarConteudoMensagem(XPATH_MENSAGEM_SUCESSO, mensagem);
	}
	
	public void validarTelaLogin() {
		getDSL().validarConteudo(XPATH_TITULO_LOGIN, "Login");
	}
}
