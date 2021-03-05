package br.com.inmetrics.test.pages;

import java.util.Objects;

import br.com.inmetrics.test.core.DSL;

public class BasePage {

	private DSL dsl = new DSL();
	private String XPATH_DROPDOWN_MODAL = "//label[contains(text(),'%s')]/..//select";
	private String XPATH_ITEM_DROPDOWN = "//option[contains(text(),'%s')]";
	protected String XPATH_UIBLOCK = "//div[contains(@class,'ui-block')]";
	protected String X_PATH_TEXTBLOCK = "//span[contains(@class,'blocked-text')]";
	
	
	
	protected DSL getDSL() {
		return dsl;
	}
	
	public void fecharBrowser() {
		try {
			getDSL().fecharNavegador();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public BasePage selecionarOpcaoDropDownModal(String campo, String opcao) {
		if(!Objects.isNull(opcao) && !opcao.isEmpty()) {
			String xpathCampo = String.format(XPATH_DROPDOWN_MODAL, campo);
			getDSL().clicar(xpathCampo).clicar(String.format(XPATH_ITEM_DROPDOWN, opcao));
		}
		return this;
	}
	
	protected void esperarPaginaCarregar() {
		dsl.esperarAteInvisivel(XPATH_UIBLOCK);
		dsl.esperarAteInvisivel(X_PATH_TEXTBLOCK);
	}
}
