package app.autoamtion.MavenAutomation.testBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	String url="http://10.15.21.164/Saba/Web/QA001";
	String browser="chrome";
	
	public void init() {
		selectBrowser(browser);
		getURL(url);
		String log4jconfigpath="log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);
		
	}
		
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
	}
	
	public void getURL(String url) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(url);
		
		
	}
}
