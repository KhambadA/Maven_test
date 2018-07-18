package app.autoamtion.MavenAutomation.Recruiting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class Test_Job_Requisition_Template extends TestBase{
	HomePage homePage;	
	Job_Requisition_Template_Resource jobrequisitiontemplateresource;
	
	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test
	public void Template() throws InterruptedException{
		homePage=new HomePage(driver);
		System.out.println("driver"+driver);
		jobrequisitiontemplateresource=new Job_Requisition_Template_Resource(driver);
		homePage.LoginToApplication("uone","welcome");
		/*homePage.ClickOnTab(homePage.adminTab);
		//homePage.navigationUnderAdminTab(homePage.Admin_Performance);
		homePage.navigationUnderAdminTab(homePage.Admin_Recruiting);
		homePage.navigateTo(homePage.Recruiting_Job_Requisition);
		homePage.navigateTo(homePage.Job_Requisition_Templates);
		homePage.navigateTo(homePage.New_Job_Requisition_Template);
		jobrequisitiontemplateresource.createJobRequisition();*/
	
		
	}
	
/*@AfterTest
	public void closeBrowser(){
		driver.quit();
	}*/
}
