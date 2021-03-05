package br.com.inmetrics.test.pages;

import br.com.inmetrics.test.core.Utils;

public class CadastrarPage extends BasePage {
	
	private String XPATH_USUARIO = "//input[@name='username']";
	private String XPATH_PASS = "//input[@name='pass']";
	private String XPATH_CONFIRMPASS = "//input[@name='confirmpass']";
	private String BOTAO_CADASTRAR = "//button[@class='login100-form-btn']";
	private String XPATH_TITULO_CADASTRE = "//span[@class='login100-form-title']";
	protected static String USUARIO_RANDOMICO = gerarNome();
	protected static String USUARIO_PEQUENO_RANDOMICO = gerarNomePequeno();
	protected static String SENHA_RANDOMICA = gerarsenha(); 
	
	public CadastrarPage() {
		super();
	}
	
	public static String gerarsenha() {
		String senha = Utils.randomeNum();
		return senha;
	}
	
	public static String gerarNomePequeno() {
		String usuario = Utils.generateNameWithFourCaracters();
		return usuario;
	}
	
	public static String gerarNome() {
		String usuario = Utils.generateName();
		return usuario;
	}
	
	public void insiroCredenciaisNovoUsuario() {
		getDSL().digitar(XPATH_USUARIO, USUARIO_RANDOMICO);
		getDSL().digitar(XPATH_PASS, SENHA_RANDOMICA);
		getDSL().digitar(XPATH_CONFIRMPASS, SENHA_RANDOMICA);
	}
	
	public void insiroCredenciaisNovoUsurioNomeCurto() {
		getDSL().digitar(XPATH_USUARIO, USUARIO_PEQUENO_RANDOMICO);
		getDSL().digitar(XPATH_PASS, SENHA_RANDOMICA);
		getDSL().digitar(XPATH_CONFIRMPASS, SENHA_RANDOMICA);
	}
	
	public void validarUsuarioNaoCadastrado() {
		getDSL().validarConteudo(XPATH_TITULO_CADASTRE, "Cadastre-se");
	}
	
	public void clicoCadastrar() {
		getDSL().clicar(BOTAO_CADASTRAR);
	}
	
}
