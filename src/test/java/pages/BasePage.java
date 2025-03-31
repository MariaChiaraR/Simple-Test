package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import util.DriverManager;
import util.Utility;
import util.WaitCondition;

import java.util.HashMap;
import java.util.Map;

public class BasePage {

    private DriverManager driver;
    //private Wait<WebDriver> wait;
    private Map<String, By> locatorMap;

    public BasePage(String mapName, String loadCheckerKeyword) {
        driver = Utility.getDriverManager();
        //wait = DriverManager.WAIT;
        locatorMap = Locators.getLocatorMap(mapName);

    }

    public By getLocatorByKeyword(String keyword){
        try{
            if (keyword==null){
                throw new InvalidArgumentException("Keyword per il locator non può essere null");
            }

            By locator = locatorMap.get(keyword);

            if (locator==null){
                throw new InvalidArgumentException("Nessun locator trovato per la keyword : " + keyword);
            }
            return locator;
        } catch (InvalidArgumentException e){
            throw e;
        }

    }

    public By getPageLoadChecker(){return getLocatorByKeyword("");}

    public boolean pageIsVisible(){

        WebElement element = driver.findElementWithCondition(getPageLoadChecker(),WaitCondition.IS_VISIBLE);
        return element!= null && element.isDisplayed();
    }

    public boolean popupIsVisible(String popupName) {
        return false;
    }

    public boolean closePage() {
        return false;
    }

    public boolean closePopup(String popupName) {
        return false;
    }

    public boolean clickElement(String keyword){
        try{
            By locator = getLocatorByKeyword(keyword);

            return driver.clickElement(locator);

        } catch (Exception e){
            throw e;
            // return false;
        }

    }

}
