package org.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyfile {

    public static String propertyFile(String name) {
        String value = null;
        Properties prop= new Properties();
        String filepath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        File file = new File(filepath);
        System.out.println("File path is: " + filepath);
        try {
            FileInputStream fileInput = new FileInputStream(file);
            prop.load(fileInput);
            value= prop.getProperty(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    public static  void main(String[] args) {
        ReadPropertyfile readPropertyfile = new ReadPropertyfile();
        System.out.println(readPropertyfile.propertyFile("browser"));
    }
}
