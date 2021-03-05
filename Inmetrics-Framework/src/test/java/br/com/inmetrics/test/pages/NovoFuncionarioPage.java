package br.com.inmetrics.test.pages;

import br.com.inmetrics.test.core.Utils;
import java.util.Objects;

public class NovoFuncionarioPage extends BasePage {
	
	private String XPATH_NOME = "//input[@id='inputNome']";
	private String XPATH_CPF = "//input[@id='cpf']";
	private String XPATH_SEXO = "//Select[@id='slctSexo']";
	private String XPATH_ADMISSAO = "//input[@id='inputAdmissao']";
	private String XPATH_CARGO = "//input[@id='inputCargo']";
	private String XPATH_SALARIO = "//input[@id='dinheiro']";
	private String XPATH_CONTRATO_CLT = "//input[@value='clt']";
	private String XPATH_DROPDOWN_MODAL_SEXO = "//select[@name='%s']";
	private String XPATH_ITEM_DROPDOWN = "//option[contains(text(),'%s')]";
	private String XPATH_TIPO_CONTRATACAO = "//input[@value='%s']";
	private String XPATH_BOTAO_ENTRAR = "//input[@class='cadastrar-form-btn']";
	
	
	public NovoFuncionarioPage() {
		super();
	}
	
	public void insiroDadosNovoFuncionario() {
		String nome = Utils.generateName();
		String cpf = Utils.generateCPF();
		String admissao = Utils.randomeNum();
		String cargo = Utils.generateName();
		String salario = Utils.randomeNum();
		getDSL().digitar(XPATH_NOME, nome);
		getDSL().digitar(XPATH_CPF, cpf);
		getDSL().selecionarCombo(XPATH_SEXO, "Masculino");
		getDSL().digitar(XPATH_ADMISSAO, admissao);
		getDSL().digitar(XPATH_CARGO, cargo);
		getDSL().digitar(XPATH_SALARIO, salario);
		getDSL().clicarRadio(XPATH_CONTRATO_CLT);
	}
	
	public NovoFuncionarioPage selecionarOpcaoDropDownModal(String campo, String opcao) {
		if(!Objects.isNull(opcao) && !opcao.isEmpty()) {
			String xpathCampo = String.format(XPATH_DROPDOWN_MODAL_SEXO, campo);
			getDSL().clicar(xpathCampo).clicar(String.format(XPATH_ITEM_DROPDOWN, opcao));
		}
		return this;
	}
	
	public NovoFuncionarioPage preencherDadosNovoFuncionario(String nome, String cargo, String cpf, 
			String salario, String sexo, String tipoContratacao, String admissao) {
		getDSL().esperarAteExistente(XPATH_NOME, 2000)
				.digitar(XPATH_NOME, nome)
				.digitar(XPATH_CARGO, cargo)
				.digitar(XPATH_CPF, cpf)
				.digitar(XPATH_SALARIO, salario);
		selecionarOpcaoDropDownModal("sexo", sexo);
		getDSL().clicar(String.format(XPATH_TIPO_CONTRATACAO, tipoContratacao))
				.digitar(XPATH_ADMISSAO, admissao);
		return this;
	}
	
	public NovoFuncionarioPage clicarEnviar() {
		getDSL().clicar(XPATH_BOTAO_ENTRAR);
		return this;
	}

}
