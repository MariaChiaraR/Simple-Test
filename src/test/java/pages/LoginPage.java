package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import util.Utility;

import java.util.Map;

import static java.util.Map.entry;

public class LoginPage extends BasePage{
    public LoginPage(String mapName, String loadCheckerKeyword) {
        super(mapName, loadCheckerKeyword);
    }

    // private By btnLogin = By.xpath("//div[@id='pn_id_4_content']//*[text()='Login']");

//    public LoginPage(Utility utility){
//        super();
//
//        if(!utility.getPageTitle().equals("SiProject")){
//            throw new IllegalStateException(("this is not login page. The current page is " + utility.getPageTitle()));
//        }
//    }
//
//    public void verificaLoadPagina (){
//            Assert.assertTrue("Login button disponibile prima che i campi siano rispettati", utility.checkIfElementValueTrue(btnLogin));
//    }

}
