package com.github.johanbrorson.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {
  private final WebDriver driver;

  public Browser() {
    driver = new FirefoxDriver();
  }

  public WebDriver getWebDriver() {
    return driver;
  }

  public void teardown() {
    driver.quit();
  }

  public byte[] captureScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
