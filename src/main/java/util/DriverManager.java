package util;

import dev.failsafe.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

import static util.Utility.URL_SITE;

public class DriverManager {

    private static WebDriver driver;
    private static Wait<WebDriver> WAIT;
    //private Actions actions;

    public DriverManager(){
        new Utility();
        setDriver(Utility.DRIVER);
        driver.get(URL_SITE);
        setDefaultWait();
        windowMaxSize();
        //this.actions = setActions();
    }

    public byte[] screenshot () {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private static void setDriver (String driverType){
        if (driverType.equalsIgnoreCase("Fire Fox")) {
            String projectPath = System.getProperty("user.dir");

            System.setProperty("webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver");

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // importante!
            driver = new FirefoxDriver(options);
        }
    }

    public static void setDefaultWait(){
        switch(Utility.WAIT_TYPE.toLowerCase()){
            case "fluent" : setCustomFluentWait(Utility.WAIT_TYPE, Utility.WAIT_TIME, Utility.PULL_TIME);
            default : System.out.println("Invalid wait parameters in properties");
        }
    }

    public void setCustomWait(String waitType, int waitTime, Integer pullTime){
    }

    public static void setCustomFluentWait(String waitType, Integer waitTime, Integer pullTime){
        WAIT = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(Math.max(waitTime, 0))).
                pollingEvery(Duration.ofSeconds(Math.max(pullTime, 0)))
                .ignoring(NoSuchElementException.class);
    }

    public void close(){
        driver.close();
    }

    public void windowMaxSize(){
        driver.manage().window().maximize();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public WebElement findElementWithCondition (By locator, WaitCondition waitCondition){
        try{
            if (locator == null){
                throw new IllegalArgumentException("Il locator inserito è null");
            }

            ExpectedCondition<WebElement> condition;

            switch (waitCondition){
                case IS_PRESENT: condition = ExpectedConditions.presenceOfElementLocated(locator); break;
                case IS_CLICCABLE: condition = ExpectedConditions.elementToBeClickable(locator); break;
                case IS_VISIBLE: condition = ExpectedConditions.visibilityOfElementLocated(locator); break;
                default: condition = ExpectedConditions.visibilityOfElementLocated(locator); break;
            }

            return WAIT.until(condition);

        } catch(IllegalArgumentException e){
            throw e;
        }
        catch(NoSuchElementException| TimeoutException
            /*| StaleElementReferenceException | ElementNotInteractableException*/ e){
            throw e;
        }
    }

    public List<WebElement> findElementsWithCondition (By locator, WaitCondition waitCondition){
        try{
            if (locator == null){
                throw new IllegalArgumentException("Il locator inserito è null");
            }

            ExpectedCondition<List<WebElement>> condition;

            switch (waitCondition){
                case IS_PRESENT: condition = ExpectedConditions.presenceOfAllElementsLocatedBy(locator); break;
                case IS_VISIBLE: condition = ExpectedConditions.visibilityOfAllElementsLocatedBy(locator); break;
                default: condition = ExpectedConditions.visibilityOfAllElementsLocatedBy(locator); break;
            }

            return WAIT.until(condition);

        } catch(IllegalArgumentException e){
            throw e;
        }
        catch(NoSuchElementException| TimeoutException
                /*| StaleElementReferenceException | ElementNotInteractableException*/ e){
            throw e;
        }
    }

    public boolean clickElement(By locator){
        try{
            if (locator == null){
                throw new IllegalArgumentException("Il locator inserito è null");
            }

            WebElement element = findElementWithCondition(locator, WaitCondition.IS_CLICCABLE);

            if(element == null){
                throw new ElementNotInteractableException("Nessun elemento trovato per il locator : " + locator);
            }

            element.click();
            return true;

        } catch (Exception e){
            throw e;
            //return false;
        }
    }

    public String getText(By locator){
        try{
            if (locator == null){
                throw new IllegalArgumentException("Il locator inserito è null");
            }

            WebElement element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
            if (element.getText() != null && !element.getText().isBlank()){
                return element.getText();
            }
            if (element.getAttribute("text") != null){
                return element.getAttribute("text");
            }
            if (element.getAttribute("value") != null){
                return element.getAttribute("value");
            }
            /*if (element.getDomProperty("value") != null){
                return element.getDomProperty("value");
            }*/
            return "";

        } catch (Exception e){
            throw e;
        }
    }

    public boolean writeText(By locator, String text){
        try{
            if (locator == null){
                throw new IllegalArgumentException("Il locator inserito è null");
            }

            //controllare lo stato dell'elemento?
            WebElement element = findElementWithCondition(locator, WaitCondition.IS_CLICCABLE);

            if(element.isSelected()){
                element.sendKeys(text);
                return true;
            }

            element.sendKeys(text); // magari va uguale
            return false;

        } catch (Exception e){
            throw e;
            //return false;
        }
    }

    public boolean checkElementState(By locator, ElementState expectedState){
        try{
            if (locator == null){
                throw new IllegalArgumentException("Il locator inserito è null");
            }

            WebElement element;
            switch(expectedState){
                case ENABLED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con locator : " + locator);}
                    return element.isEnabled();

                case DISABLED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con locator : " + locator);}
                    return !element.isEnabled();

                case EXISTS: return findElementWithCondition(locator, WaitCondition.IS_PRESENT)!=null;

                case VISIBLE: return findElementWithCondition(locator, WaitCondition.IS_VISIBLE)!=null;

                case DISPLAYED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con locator : " + locator);}
                    return element.isDisplayed();

                case HIDDEN: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con cocator : " + locator);}
                    return !element.isDisplayed();

                case CHECKED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con cocator : " + locator);}
                    return element.getAttribute("checked").equals("true");

                case UNCHECKED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con cocator : " + locator);}
                    return element.getAttribute("checked").equals("false");

                case SELECTED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con cocator : " + locator);}
                    return element.isSelected();

                case UNSELECTED: element = findElementWithCondition(locator, WaitCondition.IS_PRESENT);
                    if (element == null) { throw new ElementNotInteractableException("Nessun web element trovato con cocator : " + locator);}
                    return !element.isSelected();
                //case VALID:
                //case FOCUSED:
            }
            throw new InvalidArgumentException("Stato dell'elemento non valido");
        } catch (Exception e){  // to-do
            throw e;
            //return false;
        }
    }





    /*public void checkElement(By byElement){


    public boolean checkIfElementValueTrue(By byElement){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).isEnabled();
    }

    public void clickElement(By byElement){
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void enterKeys(By by, String text){
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public List<WebElement> retrieveListOfElements(By by){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public String retrieveElementText(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public void getPage(String url){
        driver.get(url);
    }*/
}