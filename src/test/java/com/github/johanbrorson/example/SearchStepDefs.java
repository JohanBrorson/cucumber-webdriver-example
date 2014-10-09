package com.github.johanbrorson.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepDefs {
  private WebDriver driver;
  private Browser browser;
  private SearchResultPage searchResultPage;

  @Before
  public void setUp() {
    browser = new Browser();
    driver = browser.getWebDriver();
  }

  @Given("^I navigate to the start page$")
  public void navigateToStartPage() {
    HomePage homePage = new HomePage(driver);
    homePage.open();
  }

  @When("^I search for '(.+)'$")
  public void performSearch(String search) {
    Header header = new Header(driver);
    searchResultPage = header.performSearch(search);
  }

  @Then("^there are search results$")
  public void checkSearchResult() {
    String header = searchResultPage.getHeader();
    Assert.assertTrue(header.contains("We've found"));
  }

  @After
  public void teardDown() {
    browser.teardown();
  }

}
