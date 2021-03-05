package br.com.inmetrics.test.pages;

public class LoginPage extends BasePage{
	
	private String URL_LOGIN = "http://www.inmrobo.tk/accounts/login/";
	private String CAMPO_USUARIO = "//input[@name='username']";          
	private String CAMPO_SENHA =  "//input[@name='pass']";                           
	private String BOTAO_ENTRAR = "//button[@class='login100-form-btn']";
	private String XPATH_LINK_CADASTRAR = "//div[@id='navbarSupportedContent']//ul//li//a";
	private String XPATH_LINK_NOVO_FUNCIONARIO = "//a[text()='%s']";
	private String XPATH_TITULO_LOGIN = "//span[@class='login100-form-title p-b-1']";

	
	public LoginPage() {
		super();
	}
	
	public void redirecionamentoPagina() {
		
		getDSL().validarConteudo(XPATH_TITULO_LOGIN, "Login");
	}

	public void acessarPaginaLogin() {
		getDSL().visitarPagina(URL_LOGIN);
	}
	
	public void clicarLinkCadastrarUsuario() {
		getDSL().clicar(XPATH_LINK_CADASTRAR);
	}
	
	public void clicoNovoFuncionario() {
		getDSL().clicar(String.format(XPATH_LINK_NOVO_FUNCIONARIO, "Novo Funcionário"));
	}
	
	private void setUsuario(String usuario) {
		getDSL().inserirCampo(CAMPO_USUARIO, usuario);
	}
	
	private void setSenha(String senha) {
		getDSL().inserirCampo(CAMPO_SENHA, senha);
	}
	
	public void efetuarLogin(String usuario, String senha) {
		if (!estaEmLogin()) {
			getDSL().visitarPagina(URL_LOGIN);
		}
		setUsuario(usuario);
		setSenha(senha);
		getDSL().clicarBotao(BOTAO_ENTRAR);
	}
	
	public boolean estaEmLogin() {
		return getDSL().getEndereco().equals(URL_LOGIN);
	}

}
