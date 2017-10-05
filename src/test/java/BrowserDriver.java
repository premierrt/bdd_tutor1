package test.java;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.stereotype.Component;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


@Component
public class BrowserDriver {

	private static WebDriver mDriver;
	private static final Logger LOG = Logger.getLogger(BrowserDriver.class.getName());

	
	
	public synchronized static WebDriver getCurrentDriver() {
	    if (mDriver==null) {
	        try {
	        	//FirefoxProfile profile = new FirefoxProfile();
	              //      mDriver = new FirefoxDriver(profile);
	        	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

	        	  mDriver = new ChromeDriver();
	            } finally{
	                Runtime.getRuntime().addShutdownHook(
	                    new Thread(new BrowserCleanup()));
	            }
	    }
	    return mDriver;
	}
	 
	private static class BrowserCleanup implements Runnable {
	    public void run() {
	    	LOG.info("Closing the browser");
	        close();
	    }
	}
	 
	public static void close() {
	    try {
	        getCurrentDriver().quit();
	        mDriver = null;
	        LOG.info("closing the browser");
	    } catch (UnreachableBrowserException e) {
	    	LOG.info("cannot close browser: unreachable browser");
	       
	    }
	}
	
	
	public static void loadPage(String url){;
    LOG.info("Directing browser to:" + url);
    getCurrentDriver().get(url);
}
	
}
