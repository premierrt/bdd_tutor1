package test.java;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:applicationContext.xml")
public class LoginSteps {
    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());
     

    @Autowired
   private BrowserDriver browserDriver;
    

    
    @Autowired
    private LoginPage loginPage;
    
    @Given("^I navigate to the mock application$")
    public void given_I_navigate_to_the_mock_application(){
        LOGGER.info("Entering: I navigate to the mock application");
   
        browserDriver.loadPage(
                "http://localhost:8080/html/MockApplication.html");
        
        LOGGER.info("-------Exiting: I navigate to the mock application");
       loginPage.isDisplayedCheck();
    }
     
    @When("^I try to login with '(.+)' credentials$")
    public void when_I_try_to_login(String credentialsType){
        LOGGER.info("Entering: I try to login with " + 
            credentialsType + " credentials");
    }
     
    @Then("^I should see that I logged in '(.+)'$")
    public void then_I_login(String outcome){
        LOGGER.info("Entering: I should see that I logged in " + outcome);
    }
}