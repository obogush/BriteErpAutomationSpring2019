package com.BriteErp.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    //      X:/AppHangar/BriteErpAutomationSpring2019
    private static Properties configFile;

    static {

        try {
            //path to .properties file
            String path = "X:/AppHangar/BriteErpAutomationSpring2019/configuration.properties";
            //String path = "X:/AppHangar/firstmavenapp/configuration.properties";
            //create object of inputs stream to access file
            FileInputStream input = new FileInputStream(path);
            //initialize config file
            configFile = new Properties();
            //load properties file
            configFile.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

}