package com.StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature",
					glue="com.StepDefinition",
					monochrome=true,
					dryRun=false,
					plugin={"html:target/Reports.html","json:target/reports.json"})

public class TestRunner {

}
