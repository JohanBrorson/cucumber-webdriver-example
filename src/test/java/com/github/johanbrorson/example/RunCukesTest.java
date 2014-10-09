package com.github.johanbrorson.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features")
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
