package com.github.johanbrorson.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features",
    plugin = {"pretty", "json:target/cucumber-report.json", "html:target/cucumber-report"})
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
