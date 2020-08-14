$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Inmetrics.feature");
formatter.feature({
  "name": "Prova Inmetrics",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Cadastrar Novo Funcionário",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@Run"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que acesso o sistema",
  "keyword": "Dado "
});
formatter.match({
  "location": "StepDefinition.acessoSistema()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "acesso tela de cadastramento de novos funcionários",
  "keyword": "Quando "
});
formatter.match({
  "location": "StepDefinition.acessoTelaCadastramentoNovosFuncionarios()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho os dados do novo funcionário",
  "rows": [
    {
      "cells": [
        "Nome",
        "Cargo",
        "CPF",
        "Salario",
        "Sexo",
        "Tipo Contratacao",
        "Admissao"
      ]
    },
    {
      "cells": [
        "Marcos Cunha",
        "QA",
        "095.890.147-39",
        "650000",
        "Masculino",
        "clt",
        "17/08/2020"
      ]
    }
  ],
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.preenchoDadosNovoFuncionario(DataTable)"
});
