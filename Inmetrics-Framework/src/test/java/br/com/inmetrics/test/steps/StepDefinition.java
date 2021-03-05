package br.com.inmetrics.test.steps;

import java.io.IOException;

import br.com.inmetrics.test.core.Properties;
import br.com.inmetrics.test.core.Report;
import br.com.inmetrics.test.pages.HomePage;
import br.com.inmetrics.test.pages.LoginPage;
import br.com.inmetrics.test.pages.FuncionariosPage;
import br.com.inmetrics.test.pages.NovoFuncionarioPage;
import br.com.inmetrics.test.pages.CadastrarPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import java.util.List;
import io.cucumber.datatable.DataTable;

public class StepDefinition {

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private CadastrarPage cadastrarPage = new CadastrarPage();
	private NovoFuncionarioPage novoFuncionarioPage = new NovoFuncionarioPage();
	private FuncionariosPage funcionariosPage = new FuncionariosPage();
	private Report report = new Report();
	private TestRule tr = new TestRule();
	private String usuario;
	private String usuarioRandomico;
	private String usuarioNomeCurtoRandomico;
	private String senhaRandomica;
	private String senha;

	public StepDefinition() {
		this.usuarioNomeCurtoRandomico = Properties.USER_LOGIN_SHORT_RANDOMICO;
		this.usuario = Properties.USER_LOGIN;
		this.senha = Properties.PASSWORD_LOGIN;
	}
	
	@Given("que acesso a página de login")
	public void acessoOpen() throws IOException {
		loginPage.acessarPaginaLogin();
		report.writeReport("Teste acessar pagina login...");
		report.getScreenShot("testeAcessarPaginaLogin");
	}
	
	@Given("clico para cadastrar o novo usuário")
	public void clicoCadastrarNovoUsuario() {
		loginPage.clicarLinkCadastrarUsuario();
		report.writeReport("Teste clicar link cadastrar usuario...");
		report.getScreenShot("testeClicarLinkCadastrarUsuario");
	}
	
	@Given("insiro os dados do novo usuário com nome curto")
	public void insiroCredenciaisNovoUsurioNomeCurto() {
		cadastrarPage.insiroCredenciaisNovoUsurioNomeCurto();
		report.writeReport("Teste inserir credenciais novo usuario...");
		report.getScreenShot("testeInserirCredenciaisNovoUsuario");
	}
	
	@Given("insiro os dados do novo usuário")
	public void insiroDadosNovoUsuario() {
		cadastrarPage.insiroCredenciaisNovoUsuario();
		report.writeReport("Teste inserir credenciais novo usuario...");
		report.getScreenShot("testeInserirCredenciaisNovoUsuario");
	}
	
	@When("clico em cadastrar")
	public void clicoCadastrar() {
		cadastrarPage.clicoCadastrar();
		report.writeReport("Teste clicar botao cadastrar...");
		report.getScreenShot("testeClicarbotaoCadastrar");
	}
	
	@When("clico em editar o primeiro da lista")
	public void clicoEditarPrimeiroLista() {
		funcionariosPage.clicarEditarPrimeiroLista();
	}
	
	@When("altero o cargo para {string}")
	public void alteroCargo(String cargo) {
		funcionariosPage.alterarCargo(cargo);
	}
	
	@When("pesquiso pelo usuário cadastrado {string}")
	public void pesquisoUsuarioCadastrado(String nome) {
		funcionariosPage.pesquisarUsuarioCadastrado(nome);
	}
	
	
	@When("acesso tela de funcionários")
	public void acessoTelaFuncionarios() {
		homePage.acessarTelaFuncionarios();
	}
	
	@When("efetuo o login")
	public void efetuoLogin() {
		loginPage.efetuarLogin(usuario, senha);
		report.writeReport("Teste efetuar login...");
		report.getScreenShot("testeEfetuarLogin");
	}
	
	@When("preencho os dados do novo funcionário")
	public void preenchoDadosNovoFuncionario(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		String nome = list.get(0).get("Nome");
		String cargo = list.get(0).get("Cargo");
		String cpf = list.get(0).get("CPF");
		String salario = list.get(0).get("Salario");
		String sexo = list.get(0).get("Sexo");
		String tipoContratacao = list.get(0).get("Tipo Contratacao");
		String admissao = list.get(0).get("Admissao");
		novoFuncionarioPage.preencherDadosNovoFuncionario(nome, cargo, cpf, salario, sexo, tipoContratacao, admissao);
	}
	
	@When("clico em novo funcionário")
	public void clicoNovoFuncionario() {
		loginPage.clicoNovoFuncionario();
		report.writeReport("Teste clicar novo funcionario...");
		report.getScreenShot("testeClicarNovoFuncionario");
	}
	
	@When("insiro os dados do novo funcionário")
	public void insiroDadosNovoFuncionario() {
		novoFuncionarioPage.insiroDadosNovoFuncionario();
	}
	
	@Then("clico em enviar")
	public void clicoEnviar() {
		novoFuncionarioPage.clicarEnviar();
	}
	
	@Then("o site redireciona para a página de login")
	public void siteRedirecionadoPaginaLogin() {
		loginPage.redirecionamentoPagina();
	}
	
	@Then("valido que o usuário não foi cadastrado")
	public void validoUsuarioNaoCadastrado() {
		cadastrarPage.validarUsuarioNaoCadastrado();
	}
	
	@Then("valido mensagem {string}")
	public void validoMensagemUsuarioCadastrado(String mensagem) {
		homePage.validarMensagem(mensagem);
	}
}
