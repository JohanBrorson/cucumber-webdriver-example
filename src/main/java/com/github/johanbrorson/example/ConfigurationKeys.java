package com.github.johanbrorson.example;

public enum ConfigurationKeys {

  BROWSER_TYPE("browser.type", "jbrowserdriver"),
  SITE_URL_BASE("site.url", "https://github.com/");

  private final String key;
  private final Object defaultValue;

  ConfigurationKeys(String key, Object defaultValue) {
    this.key = key;
    this.defaultValue = defaultValue;
  }

  public String getKey() {
    return key;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

}
