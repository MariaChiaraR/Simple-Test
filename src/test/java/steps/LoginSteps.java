package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import util.Utility;

public class LoginSteps {
    Utility utility;
    BasePage homePage;
    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        homePage = new HomePage("home", "Selected Page From List");
        //       new Utility();
//        System.out.println(Utility.DRIVER);
        System.out.println("User on home page");
    }
    @When("user click on page name from list")
    public void user_click_on_page_name_from_list() {
        homePage.clickElement("Selected Page From List");
//        basePage.clickElement("Selected Page From List");

        //Assert.fail();
        System.out.println("User click");
    }

    @Then("user is on selected pge")
    public void user_is_on_selected_pge() {
        homePage = new HomePage("add", "Add Button");

        if (true) {
            byte[] screenshot = homePage.screenshot();
            scenario.attach(screenshot, "image/png", "Errore nella homepage");
        }
        //Assert.fail();
        //Assert.assertTrue(true);
        System.out.println("User on selected page");
    }

    @When("user click on {string} name from list")
    public void user_click_on_page_3_name_from_list(String page) {
        homePage.clickElement(page);
//        basePage.clickElement("Selected Page From List");

        //Assert.fail();
        System.out.println("User click");
    }

    @Then("user is on selected {string} with {string}")
    public void user_is_on_selected_page_2(String page, String item) {
        homePage = new HomePage(page, item);

        //Assert.fail();
        //Assert.assertTrue(true);
        System.out.println("User on selected page");
    }


//    @Given("user is on login page")
//    public void userIsOnLoginPage(){
//        utility = new Utility("Fire fox", "Fluent");
//        utility.windowMaxSize();
//
//        utility.getPage("http://localhost:4200/auth");
//
//        loginPage = new LoginPage(utility);
//
//        loginPage.metodoVerifica();
//
//        utility.close();
//    }
}
