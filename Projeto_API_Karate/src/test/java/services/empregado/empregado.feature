# language:en
# encoding UTF-8

@empregado
Feature: Empregado

  Background:
    * def data = read('classpath:services/empregado/data/'+ env +'.yaml')
    * def support_config = read('classpath:services/support/config/path.yaml')
    * def support_data = read('classpath:services/support/data/data.yaml')
    * def authorization = support_data.empregado.authorization

   @get_all_employee
  Scenario Outline: Verify get all on /empregado/list_all with status code <status_code> and type scenery <expected_response>
    Given url inm_api_test
    And path '/empregado/list_all'
    And header authorization = authorization
    And request {}
    When method get
    Then status <status_code>
    And match responseType == 'json'
    And match each response contains data.empregado_get.expected_response.<expected_response>

    Examples:
      | status_code | expected_response |
      | 200         | all_empregado     |


   @post_register_employee
  Scenario Outline: Verify post on /empregado/cadastrar and status code <status_code>
    * def cpf = Java.type('br.com.inmetrics.utils.Utils').generateCPF()
    * def name = Java.type('br.com.inmetrics.utils.Utils').generateName()
    * def empregadoId = Java.type('br.com.inmetrics.utils.Utils').randomeNum()
    * def email = Java.type('br.com.inmetrics.utils.Utils').generateEmail()
    * def password = Java.type('br.com.inmetrics.utils.Utils').randomeNum()
    * def body = read('classpath:services/empregado/payload/'+ env +'/post.json')
    Given url inm_api_test
    And path '/empregado/cadastrar'
    And header authorization = authorization
    And request body
     * print body
    When method post
    * print response
    Then status <status_code>
    And match response == { "empregadoId": "#notnull","nome": "#string","sexo": "#string","cpf": "#notnull","cargo": "#string","admissao": "#string","salario": "#string","comissao": "#string","tipoContratacao": "#string" }

    Examples:
      | status_code |
      | 202         |


  @post_register_employee_With_CPF_Invalid
  Scenario Outline: Verify post on /empregado/cadastrar with CPF invalid and status code <status_code>
    * def cpf = data.empregado_post.cpf_invalid
    * def name = Java.type('br.com.inmetrics.utils.Utils').generateName()
    * def empregadoId = Java.type('br.com.inmetrics.utils.Utils').randomeNum()
    * def email = Java.type('br.com.inmetrics.utils.Utils').generateEmail()
    * def password = Java.type('br.com.inmetrics.utils.Utils').randomeNum()
    * def body = read('classpath:services/empregado/payload/'+ env +'/post.json')
    Given url inm_api_test
    And path '/empregado/cadastrar'
    And header authorization = authorization
    And request body
    * print body
    When method post
    * print response
    Then status <status_code>
    And match response == ["cpf: deve estar no padrão 111.222.333-00"]

    Examples:
      | status_code |
      | 400         |


  @get_employee_Registered
  Scenario Outline: Verify get all on /empregado/list/<empregado_id> with status code <status_code> and type scenery <expected_response>
    * def employee = callonce read('classpath:services/empregado/empregado.feature@post_register_employee')
    Given url inm_api_test
    And path '/empregado/list/' + <empregadoId>
    And header authorization = authorization
    And request {}
    When method get
    Then status <status_code>
    * print response
    And match responseType == 'json'
    And match response contains {admissao: '#notnull',cpf: '#string', empregadoId: '#notnull'}

    Examples:
      | status_code | empregadoId                   |
      | 202         | employee.response.empregadoId |



  @put_register_employee
  Scenario Outline: Verify put on /empregado/alterar/<empregadoId> and status code <status_code>
    * def employee = callonce read('classpath:services/empregado/empregado.feature@post_register_employee')
    * def cpf = Java.type('br.com.inmetrics.utils.Utils').generateCPF()
    * def name = Java.type('br.com.inmetrics.utils.Utils').generateName()
    * def empregadoId = <empregadoId>
    * def email = Java.type('br.com.inmetrics.utils.Utils').generateEmail()
    * def password = Java.type('br.com.inmetrics.utils.Utils').randomeNum()
    * def body = read('classpath:services/empregado/payload/'+ env +'/put.json')
    Given url inm_api_test
    And path '/empregado/alterar/' + <empregadoId>
    And header authorization = authorization
    And request body
    * print body
    When method put
    * print response
    Then status <status_code>
    And match response == { "empregadoId": "#notnull","nome": "#string","sexo": "#string","cpf": "#notnull","cargo": "#string","admissao": "#string","salario": "#string","comissao": "#string","tipoContratacao": "#string" }

    Examples:
      | status_code | empregadoId                   |
      | 202         | employee.response.empregadoId |


  @delete_employee_Registered
  Scenario Outline: Verify delete employee on /empregado/deletar/<empregado_id> with status code <status_code> and type scenery <expected_response>
    * def employee = callonce read('classpath:services/empregado/empregado.feature@post_register_employee')
    Given url inm_api_test
    And path '/empregado/deletar/' + <empregadoId>
    And header authorization = authorization
    And request {}
    When method delete
    Then status <status_code>

    Examples:
      | status_code | empregadoId                   |
      | 202         | employee.response.empregadoId |