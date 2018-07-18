package app.autoamtion.MavenAutomation.registrationPage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.model.Log;

import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class TC001_Verify_Login_Page extends TestBase {
	
	@FindBy(xpath="//input[@id='search-input']")
	WebElement SearchIp;
	//private WebDriver driver;
	HomePage homePage;
	
	public static final Logger log=Logger.getLogger(TC001_Verify_Login_Page.class.getName());
	@BeforeTest
	public void setUp(){
		//System.out.println("before");
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		//System.out.println("Loading");
		//driver=new FirefoxDriver();
		//System.out.println("After");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//driver.get("http://10.15.21.164/Saba/Web/QA001");
		//driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("uone");
		//driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("welcome");
		//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		init();
	}
	
	@Test
	public void verifyLoginPage(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("=============Starting======================");
		homePage=new HomePage(driver);
		log.info("Calling Login Method");
		homePage.LoginToApplication("uone","welcome");
		log.info("==============Finished===================");
		//homePage.ClickOnTab(homePage.adminTab);
		//log.info("Clicked on NAvigation Menu");
		//homePage.navigationUnderAdminTab(homePage.Admin_Recruiting);
		//homePage.navigateTo(homePage.Recruiting_Job_Requisition);
		//SearchIp.sendKeys("WBT");
		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("WBT");
	}
	
	/*@AfterTest
	public void closeBrowser(){
		driver.quit();
	}*/
}
