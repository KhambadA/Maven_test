package app.autoamtion.MavenAutomation.Recruiting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.autoamtion.MavenAutomation.JobTemplateLocators.JobRequisitionTemplateLocators;
import app.autoamtion.MavenAutomation.generateRandomData.GenerateData;
import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class Job_Requisition_Template_Resource extends TestBase{
	
	//HomePage homePage;
	JobRequisitionTemplateLocators jobrequisitiontemplateloc;
	GenerateData gendata=new GenerateData();
	HomePage homepage=new HomePage(driver);
	
	@FindBy(xpath="//a[text()='New Job Requisition Template']")
	WebElement NewJobRequisitionTemplate;
	
	//@FindBy(xpath="//iframe[@class='saba-recruiting-requisition-wizards-iframe']")
	@FindBy(id="wizardwrapper")
	WebElement RequisitionIframe;
	
	@FindBy(xpath="//input[@data-sabaid='title']")
	private WebElement TemplateInput;
	
	@FindBy(xpath="//*[contains(text(),'Job Family')]/ancestor::tr[1]//a[contains(@class,'sjs-picker-field-image')]")
	WebElement JobFamilySearch;
	
	@FindBy(xpath="//a[@title='Show filters']")
	WebElement ShowFilter;
	
	@FindBy(xpath="//input[@name='name_kLike']")
	WebElement FilterNameInput;
	
	@FindBy(xpath="//a[@data-qtip='Apply filters']")
	WebElement ApplyFilter;
	
	@FindBy(xpath="//span[text()='Done']/ancestor::a[1]")
	WebElement DoneBtn;
	
	//@FindBy(xpath="//*[contains(text(),'Company Description')]/ancestor::td[2]//iframe")
	@FindBy(xpath="//iframe[contains(@id,'sjstinymce')]")
	WebElement TemplateDescriptionIframe;
	
	@FindBy(xpath="//body")
	WebElement CompanyDescriptionInput;
	
	@FindBy(xpath="//span[text()='Save and Next']/ancestor::a[1]")
	WebElement SaveAndNextBtn;
	
	
	@FindBy(xpath="//*[text()='Job Description']/ancestor::td[2]//iframe")
	WebElement JobDescriptionFrame;

	@FindBy(xpath="//body")
	WebElement JobDescriptionInput;
	
	@FindBy(xpath="//*[text()='Internal Job Description']/ancestor::td[2]//iframe")
	WebElement InternalJobDescriptionFrame;
	
	@FindBy(xpath="//body")
	WebElement InternalJobDescriptionInput;
	
	@FindBy(xpath="//*[text()='Qualification']/ancestor::td[2]//iframe")
	WebElement QualificationFrame;
	
	@FindBy(xpath="//body")
	WebElement QualificationInput;
	
	@FindBy(xpath="//label[text()='HR Partner']/ancestor::tr[1]//div[contains(@id,'sjspickerfield')]//a[contains(@class,'sjs-picker-field-image')]")
	WebElement HrPartnerSearch;
	
	@FindBy(xpath="//label[text()='Recruiter']/ancestor::tr[1]//div[contains(@id,'sjspickerfield')]//a[contains(@class,'sjs-picker-field-image')]")
	WebElement RecruiterSearch;
	
	@FindBy(xpath="//span[contains(text(),'Select Recruiter')]/ancestor::div[6]//input[@name='name_kLike']")
	WebElement RecruiterNameInput;
	
	@FindBy(xpath="//span[contains(text(),'Select Recruiter')]/ancestor::div[6]//a[@data-sabaid='kI18nCMSjsWgtFilterApplyLabel']")
	WebElement RecruiterApplyFilter;
	
	@FindBy(xpath="//span[contains(text(),'Select Recruiter')]/ancestor::div[6]//a[@data-sabaid='kI18nDone']")
	WebElement RecruiterDoneBtn;
	
	@FindBy(xpath="//label[text()='Interviewers']/ancestor::tr[1]//div[contains(@id,'sjspickerfield')]//a[contains(@class,'sjs-picker-field-image')]")
	WebElement InterviewerSearch;
	
	@FindBy(xpath="//*[contains(text(),'Interviewers')]/ancestor::tr[1]//input")
	WebElement InterviewerInput;
	
	@FindBy(xpath="//span[contains(text(),'Select Person')]/ancestor::div[6]//a[@data-sabaid='kI18nCMSjsWgtFilterApplyLabel']")
	WebElement InterviewerApplyFilter;
	
	@FindBy(xpath="//span[contains(text(),'Select Person')]/ancestor::div[6]//a[@data-sabaid='kI18nDone']")
	WebElement InterviewerDoneBtn;
	
	@FindBy(xpath="//span[text()='Activate']/ancestor::a[1]")
	WebElement TemplateActivate;

	
	
	
	
	public Job_Requisition_Template_Resource(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createJobRequisition() {
		driver.switchTo().frame(RequisitionIframe);
		TemplateInput.sendKeys(gendata.generateRandomString(4));
		JobFamilySearch.click();
		ShowFilter.click();
		FilterNameInput.sendKeys("Default Job Family");
		ApplyFilter.click();
		homepage.selectCheckBox("Default Job Family (Job Family)");
		DoneBtn.click();
		driver.switchTo().frame(TemplateDescriptionIframe);
		CompanyDescriptionInput.sendKeys("company description");
		driver.switchTo().parentFrame();
		//driver.switchTo().defaultContent();
		System.out.println("Switched to parent frame");
		/*List<WebElement> totalFrames1=driver.findElements(By.tagName("iframe"));
		
		for(WebElement iframe: totalFrames1) {
			
			System.out.println("ID Of frame1: "+iframe.getAttribute("id"));
		}	*/	
		
		SaveAndNextBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(JobDescriptionFrame);
		JobDescriptionInput.sendKeys("JobDescription");
		System.out.println("Job description entered");
		//driver.switchTo().parentFrame();
		/*driver.switchTo().frame(InternalJobDescriptionFrame);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		InternalJobDescriptionInput.sendKeys("Internal Job Description");
		System.out.println("Internal JOb description Entered");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().parentFrame();
		driver.switchTo().frame(QualificationFrame);
		QualificationInput.sendKeys("Qualification");
		System.out.println("Qualification Entered");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();*/
		
		driver.switchTo().parentFrame();
		SaveAndNextBtn.click();
		HrPartnerSearch.click();
		ShowFilter.click();
		FilterNameInput.sendKeys("User Two");
		ApplyFilter.click();
		homepage.selectHrPartnerRadio("User Two");
		DoneBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		RecruiterSearch.click();
		ShowFilter.click();
		RecruiterNameInput.sendKeys("User Two");
		RecruiterApplyFilter.click();
		homepage.selectCheckBox("User Two");
		RecruiterDoneBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		InterviewerSearch.click();
		ShowFilter.click();
		InterviewerInput.sendKeys("Sandeep Thorat");
		InterviewerApplyFilter.click();
		homepage.selectCheckBox("Sandeep Thorat");
		InterviewerDoneBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SaveAndNextBtn.click();
		SaveAndNextBtn.click();
		TemplateActivate.click();
		
		
		}
	
	
	
	

}
