# Avaliação Inmetrics

## Dependencies

* Maven
* Java 8 (Open SDK)
## Setup

* Clone project: '$ git clone https://github.com/MarcosCunhaQA/avaliacao_inmetrics.git'

## Test Execution

### Environments

* dev
* prod

### Run all tests

`$ mvn clean test -DargLine="-Dkarate.env=dev"`

### Run tests by tag

`$ mvn clean test -DargLine="-Dkarate.env=dev" "-Dkarate.options=--tags=@inm_test --tags=~@ignore"`

## Test Report

* Karate Report: `curso-api-karate/target/surefire-reports/karate-summary.html`
* Cucumber: `curso-api-karate/target/cucumber-html-reports`

> After pointing the image and the tag you would like to use on the container, just type the exact same command you would run if you were executing the tests locally. On the above example, the command was **mvn clean test**

## Launch Parameters

| Parameter                      | Possible Values      | Default Value                       |
|--------------------------------|----------------------|-------------------------------------|
| -Dkarate.env=`env`             | dev / prod / uat     | dev                                 |
| -Dkarate.options=--tags=`@tag` | any tag              | no tag (all tests are executed)     |