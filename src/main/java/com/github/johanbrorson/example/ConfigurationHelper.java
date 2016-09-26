package com.github.johanbrorson.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigurationHelper {
  private static final Logger LOG = LogManager.getLogger(ConfigurationHelper.class);

  public static String getBrowserType() {
    String browserTypeKey = ConfigurationKeys.BROWSER_TYPE.getKey();
    String browserTypeDefault = (String) ConfigurationKeys.BROWSER_TYPE.getDefaultValue();
    return getStringProperty(browserTypeKey, browserTypeDefault);
  }

  public static String getBaseUrl() {
    String baseUrlKey = ConfigurationKeys.SITE_URL_BASE.getKey();
    String baseUrlDefault = (String) ConfigurationKeys.SITE_URL_BASE.getDefaultValue();
    return getStringProperty(baseUrlKey, baseUrlDefault);
  }

  private static String getStringProperty(String key, String defaultValue) {
    String value;
    try {
      value = Configuration.getInstance().getString(key, defaultValue);
    } catch (Exception e) {
      e.printStackTrace();
      value = defaultValue;
    }

    LOG.debug("Key: {}, Value: {}", key, value);
    return value;
  }
}
