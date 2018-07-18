package app.autoamtion.MavenAutomation.registrationPage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.autoamtion.MavenAutomation.Skills.Skill_My_Profile;
import app.autoamtion.MavenAutomation.generateRandomData.GenerateData;
import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class TC004_Create_New_Skill extends TestBase{
	
	HomePage homePage;
	Skill_My_Profile skillmyprofile;
	static GenerateData gen=new GenerateData();
	//public static String skillName;
	static String skillName=gen.generateRandomString(5);
	
	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test(priority=0)
	public void CreateNewSKill() throws InterruptedException {
		homePage=new HomePage(driver);
		skillmyprofile=new Skill_My_Profile(driver);
		homePage.LoginToApplication("uone", "welcome");
		homePage.ClickOnTab("Admin");
		homePage.navigationUnderAdminTab(homePage.Admin_Hr);
		homePage.navigateTo("Manage Skills");
		//homePage.navigateTo("SKills");
		homePage.navigateTo("New Skill");
		skillmyprofile.CreateNewSkill(skillName);
		
	}
	
	@Test(priority=1)
	public void AssignSkill() throws InterruptedException {
		driver.switchTo().defaultContent();
		homePage.ClickOnTab("My Team");
		homePage.navigateTo("Assign Skills");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		skillmyprofile.AssignSkillFromMyTeam(skillName,"User Two");
		
	}
	
	/*@AfterTest
	public void CloseBrowser() {
		driver.close();
	}*/

}


