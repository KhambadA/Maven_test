package app.autoamtion.MavenAutomation.registrationPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.autoamtion.MavenAutomation.Impression.Impression_My_Team;
import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class TC003_Leave_An_Impression extends TestBase {
	
	HomePage homePage;
	Impression_My_Team impressionmyteam;
	
	@BeforeTest
	public void setUp(){
		init();
		
	}
	
	@Test
	public void LeaveImpression() throws InterruptedException{
		homePage=new HomePage(driver);
		impressionmyteam=new Impression_My_Team(driver);
		homePage.LoginToApplication("salmeida", "welcome");
		homePage.ClickOnTab("My Team");
		Thread.sleep(2000);
		homePage.navigateTo("Leave an Impression");
		impressionmyteam.LeaveAnImpressionForMyTeam("Better", "Good","Sandeep Thorat");
		
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}


}
