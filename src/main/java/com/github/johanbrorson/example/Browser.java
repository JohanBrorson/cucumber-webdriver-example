package com.github.johanbrorson.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;


public class Browser {
  private final WebDriver driver;

  public Browser() {
    String browserType = ConfigurationHelper.getBrowserType().toLowerCase();

    switch (browserType) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "jbrowserdriver":
        driver = new JBrowserDriver();
        break;
      default:
        driver = new JBrowserDriver();
        break;
    }
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
