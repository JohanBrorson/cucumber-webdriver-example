package com.github.johanbrorson.example;

import java.io.File;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {
  private static final Logger LOG = LogManager.getLogger(Configuration.class);
  private static Configuration instance;
  private CompositeConfiguration config;

  private Configuration() throws ConfigurationException {
    config = new CompositeConfiguration();
    config.addConfiguration(new SystemConfiguration());
    config.addConfiguration(getFileBasedConfiguration());
  }

  /**
   * Gets a instance of the WebDriverConfiguration class.
   *
   * @return The WebDriverConfiguration instance
   * @throws ConfigurationException Any exception that occurs while initializing
   *     WebDriverConfiguration
   */
  public static Configuration getInstance() throws ConfigurationException {
    if (Configuration.instance == null) {
      Configuration.instance = new Configuration();
    }
    return Configuration.instance;
  }

  private FileBasedConfiguration getFileBasedConfiguration() throws ConfigurationException {
    FileBasedBuilderParameters builderParams = getFileBasedBuilderParameters();

    FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
        new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
        .configure(builderParams);
    return builder.getConfiguration();
  }

  /**
   * Gets the properties file. The location is determined in the following order: <br>
   * 1. Set by system property <br>
   * 2. In current working directory <br>
   * 3. In the resources directory
   *
   * @return The properties file
   */
  private FileBasedBuilderParameters getFileBasedBuilderParameters() {
    final String configFileProperty = "test.configuration";
    final String propertiesFileName = "test.properties";
    Parameters params = new Parameters();
    FileBasedBuilderParameters builderParams;

    // Check if the properties file location has been set in system property
    if (isValidProperty(configFileProperty)) {
      String fileLocation = System.getProperty(configFileProperty);
      LOG.debug("Use properties file set by system property: {}", fileLocation);
      return params.fileBased().setFile(new File(fileLocation));
    }

    // Check if the properties file exist in working directory
    String workingDir = System.getProperty("user.dir");
    File file = new File(workingDir, propertiesFileName);
    if (file.exists()) {
      LOG.debug("Use properties file from working directory: {}", file.getAbsolutePath());
      builderParams = params.fileBased().setFile(file);
    } else {
      LOG.debug("Use properties file from JAR: {}", propertiesFileName);
      File resourcesDir = new File("src/test/resources");
      File propertiesFile = new File(resourcesDir, propertiesFileName);
      builderParams = params.fileBased().setFile(propertiesFile);
    }
    return builderParams;
  }

  private boolean isValidProperty(String key) {
    String value = System.getProperty(key);
    return !(null == value || value.isEmpty());
  }

  /**
   * Gets a string associated with the given configuration key. The default value is returned, if
   * the key doesn't map to an existing object.
   *
   * @param propertyKey The configuration key
   * @param defaultValue The default value
   * @return String with the value of the key
   */
  public String getString(final String propertyKey, String defaultValue) {
    return config.getString(propertyKey, defaultValue);
  }
}
