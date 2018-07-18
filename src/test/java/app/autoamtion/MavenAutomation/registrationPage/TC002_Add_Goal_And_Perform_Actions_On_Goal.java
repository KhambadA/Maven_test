package app.autoamtion.MavenAutomation.registrationPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.autoamtion.MavenAutomation.Goals.Goal_My_Profile_Resource;
import app.autoamtion.MavenAutomation.generateRandomData.GenerateData;
import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class TC002_Add_Goal_And_Perform_Actions_On_Goal extends TestBase{
	
	Goal_My_Profile_Resource goalmyprofileresource;
	GenerateData gendata=new GenerateData();
	HomePage homepage;
	String GoalName=gendata.generateRandomString(4);
	
	@BeforeTest
	public void setUp(){
		init();
		
	}
	
	@Test
	public void CreateNewGoal(){
	homepage = new HomePage(driver);
	homepage.LoginToApplication("uone", "welcome");
	goalmyprofileresource=new Goal_My_Profile_Resource(driver);
	homepage.ClickOnTab("Me");
	goalmyprofileresource.AddNewGoal(GoalName);
    
	}
	
	@Test
	public void VerifyAddedGoal() throws InterruptedException {
		System.out.println(GoalName);
		Thread.sleep(5000);
		//homepage.ClickOnTab("Me");
		goalmyprofileresource.ApplyStatusFilterForGoals();
		Thread.sleep(3000);
		goalmyprofileresource.verifyaddedGoals(GoalName);
		goalmyprofileresource.PerformActionsOnGoal(GoalName,"Delete");
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
