package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties preader;

    static {
        // System.getProperty("user.dir") ="C:\learnjava\NavFramework";
        preader=new Properties();

        try {

            FileInputStream file=new FileInputStream("config.properties");
            preader.load(file);
            file.close();
        }catch(IOException e) {

            System.out.println("File is not found");
            e.printStackTrace();
        }
    }
    public static String getValue(String key) {
        return preader.getProperty(key);
    }
}
