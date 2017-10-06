package test.java;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
	
	public LoginPage(){
		//https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html
        PageFactory.initElements(browserDriver.getCurrentDriver(), this);

	}

    private static final Logger LOG = Logger.getLogger(LoginPage.class.getName());
	
	@FindBy (id="LoginPage")
	private WebElement loginPageDiv;
	
	@Autowired
	BrowserDriver browserDriver;
	
	
	public  void isDisplayedCheck(){
	    LOG.info("********************Checking login page is displayed*******************");
	    browserDriver.waitForElement(loginPageDiv, 10);
	    loginPageDiv.isDisplayed();
	}
	
}
