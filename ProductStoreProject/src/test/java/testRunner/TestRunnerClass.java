package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(	features="src/main/java/feature/feature.feature",
	
	plugin = {"pretty", "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport",
			"com.cucumber.listener.ExtentCucumberFormatter:reports/Extentreports/Extentreport.html"},	
	glue = {"stepDefinition"},
			tags= {"@TC_01_Login,@TC_02_Add_Cart,@TC_03_contact,@TC_04_nextpage"},
			monochrome = true
	)

public class TestRunnerClass
{

}
