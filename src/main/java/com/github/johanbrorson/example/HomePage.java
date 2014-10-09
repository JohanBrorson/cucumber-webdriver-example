package com.github.johanbrorson.example;

import org.openqa.selenium.WebDriver;

public class HomePage {
  private final WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("https://github.com/");
  }
}
