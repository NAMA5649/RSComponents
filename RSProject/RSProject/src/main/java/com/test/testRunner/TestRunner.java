package com.test.testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty" ,"html:target/cucumber.html" , "json:target/cucumber-report.json" , "junit:target/cucumber.xml",},
        features = "src/main/resources/rscomponents"
        ,glue={"com/test/StepDefs"}
)

public class TestRunner {

}


