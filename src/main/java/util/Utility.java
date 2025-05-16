package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Utility {
    private Properties prop;
    public static String WAIT_TYPE; ;
    public static Integer WAIT_TIME;
    public static Integer PULL_TIME;
    public static String URL_SITE;
    public static String DRIVER;
    public static DriverManager DRIVER_MANAGER;

    public Utility() {
        setProperties("src/test/resources/project.properties");

        WAIT_TYPE = prop.getProperty("base_wait_type");
        URL_SITE = prop.getProperty("url_site");

        try{
            String waitTime = prop.getProperty("base_wait_time");
            if (!waitTime.isBlank()){
                WAIT_TIME = Integer.parseInt(waitTime);
            }

            String pullTime = prop.getProperty("base_pull_time");
            if (!waitTime.isBlank()){
                PULL_TIME = Integer.parseInt(pullTime);
            }

        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        DRIVER = prop.getProperty("driver");
    }

    public static DriverManager getDriverManager(){
        if (DRIVER_MANAGER == null) {

            DRIVER_MANAGER = new DriverManager();
        }
            return DRIVER_MANAGER;
    }

    private void setProperties(String propertiesPath){
        prop = new Properties();
        try{
            prop.load(new FileInputStream(new File(propertiesPath)));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//public DriverManager get

}
