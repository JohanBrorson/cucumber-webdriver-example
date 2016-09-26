package com.github.johanbrorson.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
  private final WebDriver driver;
  private final By searchInput = By.cssSelector(".header-search-input");

  public Header(WebDriver driver) {
    this.driver = driver;
  }

  public SearchResultPage performSearch(String search) {
    WebElement searchBox = driver.findElement(searchInput);
    searchBox.sendKeys(search, Keys.ENTER);
    return new SearchResultPage(driver);
  }
}
