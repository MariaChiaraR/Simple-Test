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
            case "page 2" : return PROVA_PAGE_2;
            case "page 3" : return PROVA_PAGE_3;
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
                    By.xpath("//div[@id='content']//*[text()='Add/Remove Elements']")),
            entry("page 2",
                    By.xpath("//div[@id='content']//*[text()='File Upload']")),
            entry("page 3",
                    By.xpath("//div[@id='content']//*[text()='Forgot Password']"))
    );

    public static Map<String, By> ADD_PROVA_PAGE = Map.ofEntries(
            entry("Add Button",
                    By.xpath("//div[@id='content']//*[text()='Add Element']"))
    );

    public static Map<String, By> PROVA_PAGE_2 = Map.ofEntries(
            entry("item 2",
                    By.xpath("//div[@id='content']//*[text()='Upload']"))
    );

    public static Map<String, By> PROVA_PAGE_3 = Map.ofEntries(
            entry("item 3",
                    By.xpath("//div[@id='content']//*[text()='Retrieve password']"))
    );
}

