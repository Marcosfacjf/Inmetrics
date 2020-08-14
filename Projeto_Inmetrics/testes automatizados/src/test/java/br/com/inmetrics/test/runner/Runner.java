package br.com.inmetrics.test.runner;

import org.junit.runner.RunWith;

import br.com.inmetrics.test.pages.BasePage;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features/",
		glue = {"br.com.inmetrics.test.steps"},
		tags = {"@Run"},
		plugin = {"pretty", "html: target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class Runner extends BasePage {

	
}