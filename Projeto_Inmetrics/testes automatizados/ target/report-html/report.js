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
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido mensagem \"SUCESSO! Usuário cadastrado com sucesso\"",
  "keyword": "Então "
});
formatter.match({
  "location": "StepDefinition.validoMensagemUsuarioCadastrado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Alterar Informações Funcionário",
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
  "name": "acesso tela de funcionários",
  "keyword": "Quando "
});
formatter.match({
  "location": "StepDefinition.acessoTelaFuncionarios()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pesquiso pelo usuário cadastrado \"Marcos Cunha\"",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.pesquisoUsuarioCadastrado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em editar o primeiro da lista",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.clicoEditarPrimeiroLista()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "altero o cargo para \"Analista de Qualidade\"",
  "keyword": "Então "
});
formatter.match({
  "location": "StepDefinition.alteroCargo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido mensagem \"SUCESSO! Informações atualizadas com sucesso\"",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.validoMensagemUsuarioCadastrado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Remover Funcionário",
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
  "name": "acesso tela de funcionários",
  "keyword": "Quando "
});
formatter.match({
  "location": "StepDefinition.acessoTelaFuncionarios()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pesquiso pelo usuário cadastrado \"Marcos Cunha\"",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.pesquisoUsuarioCadastrado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico em excluir o primeiro funcionário da lista",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.clicoExcluirPrimeiroLista()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido mensagem \"SUCESSO! Funcionário removido com sucesso\"",
  "keyword": "Então "
});
formatter.match({
  "location": "StepDefinition.validoMensagemUsuarioCadastrado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cadastrar Usuário",
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
  "name": "que acesso o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "StepDefinition.acessarSite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico para cadastrar usuário",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.clicoCadastrarUsuario()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho os dados do novo usuário",
  "rows": [
    {
      "cells": [
        "Usuario",
        "Senha",
        "Confirme a Senha"
      ]
    },
    {
      "cells": [
        "AmaralJF",
        "123456",
        "123456"
      ]
    }
  ],
  "keyword": "Quando "
});
formatter.match({
  "location": "StepDefinition.preenchoDadosNovoUsuario(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido que estou na tela de login",
  "keyword": "Então "
});
formatter.match({
  "location": "StepDefinition.validoTelaLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cadastrar Usuário com menos de oito caracteres",
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
  "name": "que acesso o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "StepDefinition.acessarSite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico para cadastrar usuário",
  "keyword": "E "
});
formatter.match({
  "location": "StepDefinition.clicoCadastrarUsuario()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho os dados do novo usuário",
  "rows": [
    {
      "cells": [
        "Usuario",
        "Senha",
        "Confirme a Senha"
      ]
    },
    {
      "cells": [
        "abcdefg",
        "123456",
        "123456"
      ]
    }
  ],
  "keyword": "Quando "
});
formatter.match({
  "location": "StepDefinition.preenchoDadosNovoUsuario(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido que o usuário não foi cadastrado",
  "keyword": "Então "
});
formatter.match({
  "location": "StepDefinition.validoUsuarioNaoCadastrado()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});