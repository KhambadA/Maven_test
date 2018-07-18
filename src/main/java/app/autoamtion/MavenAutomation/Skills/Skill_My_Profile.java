package app.autoamtion.MavenAutomation.Skills;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.autoamtion.MavenAutomation.generateRandomData.GenerateData;
import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class Skill_My_Profile extends TestBase{
	

	HomePage homepage=new HomePage(driver);
	GenerateData generatedata=new GenerateData();
	
	@FindBy(xpath="//input[@name='comp_name']")
	WebElement SkillNameInput;
	
	@FindBy(xpath="//textarea[@name='comp_description']")
	WebElement SkillDescription;
	
	@FindBy(xpath="//a[@title='Pick Domain']")
	WebElement PickerSearch;
	
	@FindBy(xpath="//span[text()='Save']/ancestor::a[1]")
	WebElement SaveBtn;
	
	@FindBy(xpath="//input[@placeholder='Search for a skill...']")
	WebElement SearchSkillInput;
	
	@FindBy(xpath="//span[text()='Next']/ancestor::a[1]")
	WebElement NextBtn;
	
	@FindBy(xpath="//span[text()='Clear all']/ancestor::a[1]")
	WebElement ClearAll;
	
	@FindBy(xpath="//input[@data-sabaid='comboboxinputel']")
	WebElement TeamMemberInput;
	
	public Skill_My_Profile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void CreateNewSkill(String skillName) {
		SkillNameInput.sendKeys(skillName);
		SkillDescription.sendKeys("Description");
		homepage.SelectFromPicker("world");
		homepage.switchToFrame();
		SaveBtn.click();
	}
	
	
	public void AssignSkillFromMyTeam(String SkillName,String MemeberName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchSkillInput.sendKeys(SkillName);
		Thread.sleep(1000);
		homepage.SelectCircularCheckbox(SkillName);
		NextBtn.click();
		ClearAll.click();
		TeamMemberInput.sendKeys(MemeberName);
		homepage.selectFromDropDown(SkillName);
		NextBtn.click();
		
	}

}
