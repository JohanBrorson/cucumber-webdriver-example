package com.github.johanbrorson.example.pageobjects;

import org.openqa.selenium.WebDriver;

import com.github.johanbrorson.example.ConfigurationHelper;

public class HomePage {
  private final WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get(ConfigurationHelper.getBaseUrl());
    driver.manage().window().maximize();
  }
}
