package app.autoamtion.MavenAutomation.Impression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.autoamtion.MavenAutomation.testBase.TestBase;
import app.autoamtion.MavenAutomation.uiActions.HomePage;

public class Impression_My_Team extends TestBase{
	
	HomePage homepage = new HomePage(driver);
	
	@FindBy(xpath="//textarea[contains(@id,'public_commentsimpression')]")
	WebElement PublicCommentInput;
	
	@FindBy(xpath="//textarea[contains(@id,'private_commentsimpression')]")
	WebElement PrivateCommentInput;
	
	@FindBy(xpath="//span[text()='Next']/ancestor::a[1]")
	WebElement NextBtn;
	
	@FindBy(xpath="//span[text()='Clear all']/ancestor::a[1]")
	WebElement ClearAll;
	
	@FindBy(xpath="//input[@data-sabaid='comboboxinputel']")
	WebElement TeamMemberInput;
	
	@FindBy(xpath="//span[text()='Post']/ancestor::a[1]")
	WebElement PostBtn;
	
	
	
	public Impression_My_Team(WebDriver driver) {
			PageFactory.initElements(driver, this);
	}



	public void LeaveAnImpressionForMyTeam(String publiccomment,String privatecomment,String TeamMemberName) {
		PrivateCommentInput.sendKeys(privatecomment);
		PublicCommentInput.sendKeys(publiccomment);
		NextBtn.click();
		ClearAll.click();
		TeamMemberInput.sendKeys(TeamMemberName);
		homepage.selectFromDropDown(TeamMemberName);
		PostBtn.click();
		
	}

}
