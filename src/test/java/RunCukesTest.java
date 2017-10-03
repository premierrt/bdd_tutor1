package test.java;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

/*
 * This is a very small class that only defines that it should be executed by a JUnit runner that invokes Cucumber, The class name ends with Test. This means that the Surefire plugin in Maven will be able to pick it up and execute it.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	    features={"src/test/resources"}
	)
public class RunCukesTest {
}

//https://www.stevefenton.co.uk/2015/01/getting-started-with-bdd-intellij/
//http://www.thinkcode.se/blog/2014/05/29/cucumberjvm-hello-world