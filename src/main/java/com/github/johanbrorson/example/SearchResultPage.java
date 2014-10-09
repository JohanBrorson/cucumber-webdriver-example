package com.github.johanbrorson.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
  private final WebDriver driver;
  private final By header = By.cssSelector(".sort-bar>h3");

  public SearchResultPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeader() {
    return driver.findElement(header).getText();
  }
}
