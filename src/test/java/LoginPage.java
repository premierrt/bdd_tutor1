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
	
	@FindBy (css="#LoginPage input[name=username]")
	private WebElement usernameInput;
	
	@FindBy (css="#LoginPage input[name=password]")
	private WebElement passwordInput;
	
	@FindBy (css="#LoginPage span[role='button']")
	private WebElement submitButton;
	
	@Autowired
	BrowserDriver browserDriver;
	
	
	public  void isDisplayedCheck(){
	    LOG.info("********************Checking login page is displayed*******************");
	    browserDriver.waitForElement(loginPageDiv, 10);
	    loginPageDiv.isDisplayed();
	}
	
	
	public void login(String userName, String password){
		LOG.info("Funkcja logujca");
		LOG.info("Logging in with username:"+userName+" password:"+password);
		usernameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		submitButton.click();
		LOG.info("Login submitted");

	}
	
	public void checkLoginSuccess(){
		LOG.info("Check login was successful");
		isDisplayedCheck();	
	}
	
}
