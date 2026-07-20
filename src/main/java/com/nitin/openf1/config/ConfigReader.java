package com.nitin.openf1.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();
    private static final String CONFIG_FILE = "config.properties";

    static {
        loadProperties();
    }
    private ConfigReader(){}

    private static void loadProperties(){
        try(InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)){
            if(inputStream == null){
                throw new IllegalStateException("Config file not found: " + CONFIG_FILE);
            }
            PROPERTIES.load(inputStream);
        }catch (IOException ex) {
            throw new IllegalStateException("Failed to load the config file" + CONFIG_FILE, ex);
        }
    }

    public static String getProperty(String key){
        String value = PROPERTIES.getProperty(key);
        return value.trim();
    }

    public static String getBaseUrl(){
        return getProperty("base.url");
    }
}
