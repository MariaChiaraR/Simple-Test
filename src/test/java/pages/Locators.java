package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Locators {

    public static Map<String, By> getLocatorMap(String page){

        switch(page.toLowerCase()){
            case "base" : return new HashMap<>();
            case "login" : return LOGIN_PAGE_LOCATORS;
            case "home" : return HOME_PROVA_PAGE;
            case "add" : return ADD_PROVA_PAGE;
        }

        System.out.println("Nessun set di locator associato alla parola chiave " + page);
        return new HashMap<String, By>();
    }

    public static Map<String, By> LOGIN_PAGE_LOCATORS = Map.ofEntries(
            entry("Bottone Login",
                    By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']")),
            entry("Username Text Area",
                    By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']")),
            entry("Password Text Area",
                    By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']"))
            );

    public static Map<String, By> ELENCO_REPORTS_LOCATORS = Map.ofEntries(
            entry("Bottone Login", By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']")),
            entry("Username Text Area", By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']")),
            entry("Password Text Area", By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']"))
    );

    public static Map<String, By> HOME_PAGE_LOCATORS = Map.ofEntries(
            entry("Bottone Login", By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']")),
            entry("Username Text Area", By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']")),
            entry("Password Text Area", By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']"))
    );

    public static Map<String, By> HOME_PROVA_PAGE = Map.ofEntries(
            entry("Selected Page From List",
                    By.xpath("//div[@id='content']//*[text()='Add/Remove Elements']"))
    );

    public static Map<String, By> ADD_PROVA_PAGE = Map.ofEntries(
            entry("Add Button",
                    By.xpath("//div[@id='content']//*[text()='Add Element']"))
    );
}

