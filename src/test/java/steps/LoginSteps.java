package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;
import util.Utility;

public class LoginSteps {
    Utility utility;
    BasePage basePage;

    @Given("user is on home page")
    public void user_is_on_home_page() {basePage = new BasePage("home", "");
//       new Utility();
//        System.out.println(Utility.DRIVER);
        System.out.println("User on home page");
    }
    @When("user click on page name from list")
    public void user_click_on_page_name_from_list() {
//        basePage.clickElement("Selected Page From List");
        System.out.println("User click");
    }
    @Then("user is on selected pge")
    public void user_is_on_selected_pge() {
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
