package app.autoamtion.MavenAutomation.Goals;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
/*import org.testng.Assert;
import org.testng.asserts.SoftAssert;*/

import app.autoamtion.MavenAutomation.generateRandomData.GenerateData;
import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class Goal_My_Profile_Resource extends TestBase{
	
	GenerateData gendata=new GenerateData();
	HomePage homepage = new HomePage(driver);
	String GoalSuccessMsg="Goal created successfully";
	
	@FindBy(xpath="//span[text()='Actions']/ancestor::a[1]")
	WebElement ActionsDropdown;
	
	@FindBy(xpath="//span[text()='Add Goal']/ancestor::a[1]")
	WebElement AddGoalOnActions;
	
	@FindBy(xpath="//input[@data-sabaid='title']")
	WebElement GoalInput;
	
	@FindBy(xpath="//iframe[contains(@id,'sjstinymce')]")
	WebElement GoalDescriptionIframe;
	
	@FindBy(xpath="//body")
	WebElement GoalDescriptionInput;
	
	@FindBy(xpath="//*[text()='CATEGORY']/ancestor::tr[1]//div[contains(@class,'x-form-arrow-trigger')]")
	WebElement CategoryArrow;
	
	@FindBy(xpath="//*[text()='VISIBLE TO']/ancestor::tr[1]//div[contains(@class,'x-form-arrow-trigger')]")
	WebElement VisibleToArrow;
	
	@FindBy(xpath="//span[text()='Save']/ancestor::a[1]")
	WebElement SavaBtn;
	
	@FindBy(xpath="//div[@data-sabaid='startdate-trigger']")
	WebElement StartDatePicker;
	
	@FindBy(xpath="//div[contains(@class,'message-container')]")
	WebElement GetSuccessMsg;
	
	@FindBy(xpath="//*[text()='Type']/ancestor::tr[1]//div[contains(@class,'x-form-arrow-trigger')]")
	WebElement TypeFilterArrow;
	
	@FindBy(xpath="//*[text()='Status']/ancestor::tr[1]//div[contains(@class,'x-form-arrow-trigger')]")
	WebElement StatusFilterArrow;
	
	@FindBy(xpath="//span[text()='Apply filters']/ancestor::a[1]")
	WebElement ApplyFilterBtn;
	
	@FindBy(xpath="//div[@id='planGrid']//*[text()='BnqJ']/ancestor::tr[1]/td[last()]//a")
	WebElement DropDownActionForSelectionOfNewGoal;
	
	@FindBy(xpath="//span[text()='Filters']/ancestor::a[1]")
	WebElement FilterLink;
	
	@FindBy(xpath="//a[text()='Goal21022']")
	WebElement VerifyText;
	
	//@FindBy(xpath="//div[@id='planGrid']//*[text()='\"+Title+\"']/ancestor::tr[1]/td[last()]//a")
	//	@FindBy(how = How.XPATH,using="//div[@id='planGrid']//*[text()='\"+Title+\"']/ancestor::tr[1]/td[last()]//a")
	
	private String Requiredxpath="//div[@id='planGrid']//*[text()='Title']/ancestor::tr[1]/td[last()]//a";
	private WebElement DropDownActionForGoal(String xpathvalue,String requiredsubstitution) {
		return driver.findElement(By.xpath(xpathvalue.replace("Title", requiredsubstitution)));
	}
	
	
	@FindBy(xpath="//span[text()='Yes']/ancestor::a[1]")
	WebElement YesBtn;
	
	public Goal_My_Profile_Resource(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void AddNewGoal(String GoalName) {
		
		try {
			ActionsDropdown.click();
			AddGoalOnActions.click();
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//String GoalName=gendata.generateRandomString(4);
			//GoalInput.sendKeys(gendata.generateRandomString(4));
			GoalInput.sendKeys(GoalName);
			driver.switchTo().frame(GoalDescriptionIframe);
			GoalDescriptionInput.sendKeys("Goal Description Input");
			driver.switchTo().parentFrame();
			CategoryArrow.click();
			homepage.selectFromDropDown("Personal Goal");
			VisibleToArrow.click();
			homepage.selectFromDropDown("Everyone");
			//StartDatePicker.click();
			//homepage.selectDatePicker("Mar");	
			SavaBtn.click();
			//SoftAssert soft=new SoftAssert();
			//System.out.println(GetSuccessMsg.getText()+"Here is null");
			/*String getsuccessmsg=GetSuccessMsg.getText();
			if(getsuccessmsg!=null)
			{
			System.out.println(getsuccessmsg);
			Assert.assertEquals(GetSuccessMsg, getsuccessmsg);
			}*/
		//	soft.assertAll();
				
				
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	
	public void ApplyStatusFilterForGoals() {
		FilterLink.click();
		TypeFilterArrow.click();
		homepage.selectFromDropDown("Personal Goal");
		StatusFilterArrow.click();
		homepage.selectFromDropDown("Active");
		ApplyFilterBtn.click();
		
	}
	
	
	public void PerformActionsOnGoal(String Title,String Action) {
		//WebElement ele=driver.findElement(By.xpath("//div[@id='planGrid']//*[text()='"+Title+"']/ancestor::tr[1]/td[last()]//a"));
		if(Action=="Mark Complete") {
			//ele.click();
			WebElement requirednmae=DropDownActionForGoal(Requiredxpath,Title);
			requirednmae.click();
			//DropDownActionForGoal.click();
			YesBtn.click();
		}
		
		else if(Action=="On Hold") {
		//ele.sendKeys(Keys.DOWN);
		//WebElement ele1=driver.findElement(By.xpath("//body/div[contains(@id,'sjsmenu')][last()]//*[contains(text(),'"+Action+"')]/ancestor::a"));
		//ele1.click();
		//DropDownActionForGoal.click();
			WebElement requirednmae=DropDownActionForGoal(Requiredxpath,Title);
			requirednmae.click();
		}
		
		else if(Action=="Delete") {
			/*ele.sendKeys(Keys.DOWN);
			WebElement ele1=driver.findElement(By.xpath("//body/div[contains(@id,'sjsmenu')][last()]//*[contains(text(),'"+Action+"')]/ancestor::a"));
			ele1.click();*/
			//DropDownActionForGoal.click();
			WebElement requirednmae=DropDownActionForGoal(Requiredxpath,Title);
			requirednmae.click();
			YesBtn.click();
		}
		
	}
	
	public void verifyaddedGoals(String GoalName) {
		WebElement VerifyText=driver.findElement(By.xpath("//a[text()='"+GoalName+"']"));
		String VerifyGoalName=VerifyText.getText();
		if(VerifyGoalName.contains(GoalName)) {
			System.out.println(GoalName+" Is Present On Page");
		}
		else {
			System.out.println(GoalName+" Goal Is Not Present On Page");
		}
		
	}
}
