package app.autoamtion.MavenAutomation.JobTemplateLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.autoamtion.MavenAutomation.testBase.TestBase;

public class JobRequisitionTemplateLocators extends TestBase {
		
	@FindBy(xpath="//input[@data-sabaid='title']")
	WebElement TemplateInput;
	
	
	public JobRequisitionTemplateLocators(WebDriver driver) {
		System.out.println("Initialization");
		PageFactory.initElements(driver,this);
		
	}
	
}
