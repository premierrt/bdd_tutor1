package test.java;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    private static final Logger LOG = Logger.getLogger(LoginPage.class.getName());
	
	//@FindBy (id="LoginPage")
	//private WebElement loginPageDiv;
	
//	@Autowired
//	BrowserDriver browserDriver;
	
	
	public  void isDisplayedCheck(){
	    LOG.info("********************Checking login page is displayed*******************");
//	    browserDriver.waitForElement(loginPageDiv);
	  //  loginPageDiv.isDisplayed();
	}
	
}
