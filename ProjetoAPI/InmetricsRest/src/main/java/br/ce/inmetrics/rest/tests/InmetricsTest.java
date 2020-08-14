package br.ce.inmetrics.rest.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.inmetrics.rest.core.BaseTest;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InmetricsTest extends BaseTest {
	

	
	@Test
	public void listarTodosUsuariosCadastrados() {
		given()
		.when()
			.get("/acesso/list_all")
		.then()
			.statusCode(200)
	;
	}
	
	@Test
	public void listarUsuarioCadastrado() {
		given()
		.when()
			.get("/acesso/list/10")
		.then()
			.statusCode(202)
			.body("acessoId", Matchers.is(10))
	;
	}
	
	@Test
	public void cadastrarUsuario() {
			String myJson = "{\"email\": \"teste@teste.com\", \"empregadoId\": 506, \"password\": \"123\"}";
		given()
			.body(myJson)
		.when()
			.post("/acesso/cadastrar")
		.then()
			.statusCode(202)
	;
	}
	
	@Test
	public void alterarUsuario() {
			String myJson = "{\"email\": \"teste@teste.com\", \"empregadoId\": 375 \"password\": \"123\"}";
		given()
			.body(myJson)
		.when()
			.put("/acesso/alterar/503")
		.then()
			.statusCode(200)
	;
	}
	
}