package com.github.johanbrorson.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
  private final WebDriver driver;
  private final By header = By.cssSelector(".sort-bar>h3");
  private final By repositories = By.cssSelector(".repo-list-item");

  public SearchResultPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeader() {
    return driver.findElement(header).getText();
  }

  public boolean hasRepositoryListItems() {
    return driver.findElements(repositories).size() != 0;
  }
}
