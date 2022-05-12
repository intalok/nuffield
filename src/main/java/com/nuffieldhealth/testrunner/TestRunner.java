package com.nuffieldhealth.testrunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import io.cucumber.junit.Cucumber; // cucumber.api.junit.Cucumber
//import io.cucumber.junit.CucumberOptions; //cucumber.api.CucumberOptions
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"com.nuffieldhealth.stepdef"},
        features = "src/main/java/com/nuffieldhealth/feature/",
        plugin = {"pretty", "html:target/cucumber/report.html"},
        junit = "--step-notifications",
        monochrome=true,
        tags = {"@smoke"},
        dryRun=false
    )
public class TestRunner {

}
