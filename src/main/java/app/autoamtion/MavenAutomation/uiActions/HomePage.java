package app.autoamtion.MavenAutomation.uiActions;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.autoamtion.MavenAutomation.testBase.TestBase;


public class HomePage extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement element ;
	//= wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
		
		public final String meTab="Me";
		public final String peopleTab="People";
		public final String adminTab="Admin";
		public final String	Admin_People="People";
		public final String	Admin_Hr="HR";
		public final String Admin_Performance="Performance";
		public final String Admin_Recruiting="Recruiting";
		public final String Admin_System="System";
		
		
		public final String Recruiting_Job_Requisition="Manage Job Requisitions";
		public final String Job_Requisition_Templates="Job Requisition Templates";
		public final String New_Job_Requisition_Template="New Job Requisition Template";
		
		public final String Recruiting_New_Job_Requisition="New Job Requisition";
		public static final Logger log=Logger.getLogger(HomePage.class.getName());
		
		//WebDriver driver;
		
		@FindBy(xpath="//input[@name='j_username']")
		WebElement userName;
		
		@FindBy(xpath="//input[@name='j_password']")
		WebElement passwords;
		
		@FindBy(xpath="//a[text()='Sign in']")
		WebElement signInBtn;
		
		@FindBy(xpath="//iframe[@class='spf-getting-started-iframe']")
		WebElement adminIframe;
		
		@FindBy(xpath="//div[@class='x-grid-row-checker']/ancestor::tr[1]//label")
		List<WebElement> selectjobfamilyradio;
		
		@FindBy(xpath="//div[@class='x-form-radio']/ancestor::tr[1]//label")
		List<WebElement> selectHrRadio;
		
		@FindBy(xpath="//body//div[contains(@class,'x-boundlist-floating')][last()]")
		WebElement dropDown;
		
		@FindBy(xpath="//body/div[contains(@class,'x-datepicker')][last()]//a[@data-qtip='Choose a month (Control+Up/Down to move years)']")
		WebElement ExpandMonthDropDown;
		
		@FindBy(xpath="//body/div[contains(@id,'datepicker')][last()]//span[contains(text(),'OK')]/ancestor::a[1]")
		WebElement DatePickerOkBtn;
		
		@FindBy(xpath="//a[@title='Pick Domain']")
		WebElement PickerSearch;
		
		@FindBy(xpath="//input[@name='pickerTargetAttr']")
		WebElement PickerNameInput;
		
		@FindBy(xpath="//span[text()='Search']/ancestor::a[1]")
		WebElement PickerSearchBtn; 
		
		@FindBy(xpath="//div[@class='x-form-radio']/ancestor::tr[1]")
		List<WebElement> CircularChcekbox;
		
		public HomePage(WebDriver driver) {
			//System.out.println("Initialization");
			PageFactory.initElements(driver,this);
			
		}
		
		
		public void LoginToApplication(String uName,String password){
			System.out.println("In Login");
			userName.sendKeys(uName);
			//System.out.println("UserName Entered");
			passwords.sendKeys(password);
			//System.out.println("Password Entered");
			signInBtn.click();
		}
		
		
		public void ClickOnTab(String TabName) {
			driver.findElement(By.xpath("//span[text()='"+TabName+"']/ancestor::a[1]")).click();
			//Log("Clicked On : "+menuName+" Navigation Bar");
		}
		
		public void navigationUnderAdminTab(String UnderAdminTab) throws InterruptedException {
			//driver.switchTo().frame(adminIframe);		
			switchToFrame();
			Thread.sleep(100);
			driver.findElement(By.xpath("//a[text()='"+UnderAdminTab+"']")).click();
		}
		
		public void navigateTo(String NavigateToLink) {
			driver.findElement(By.xpath("//a[@title='"+NavigateToLink+"']")).click();
		}
		
		
		public void switchToFrame(){
			driver.switchTo().frame(adminIframe);
		}
		
		public void switchToDefaultContent(){
			driver.switchTo().defaultContent();
		}
		
	
	public void selectCheckBox(String DefaultValueToSelect) {
		for(int i=0;i<selectjobfamilyradio.size();i++) {
			WebElement ele=selectjobfamilyradio.get(i);
			String jobfamilyname=ele.getText();
			//System.out.println(jobfamilyname);
			if(jobfamilyname.equalsIgnoreCase(DefaultValueToSelect))
				{
				System.out.println(DefaultValueToSelect); 
				driver.findElement(By.xpath("//label[contains(text(),'"+DefaultValueToSelect+"')]/ancestor::tr[1]//div[@class='x-grid-row-checker']")).click();
				//break;
			}
		}
	}
		
	
	public void selectHrPartnerRadio(String ValueToSelect) {
		//int hrpartnersize=selectHrPartnerRadio.size();
		
		for(int i=0;i<selectHrRadio.size();i++) {
			WebElement ele=selectHrRadio.get(i);
			String HrName=ele.getText();
			if(HrName.equalsIgnoreCase(ValueToSelect))
				{
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'"+ValueToSelect+"')]/ancestor::tr[1]//div[@class='x-form-radio']")));
				driver.findElement(By.xpath("//label[contains(text(),'"+ValueToSelect+"')]/ancestor::tr[1]//div[@class='x-form-radio']")).click();
				//break;
			}
		}
		
		/*for(WebElement ele : selectHrPartnerRadio ) {
			String HrName=ele.getText();
			System.out.println(HrName);
			
			if(HrName.equalsIgnoreCase(ValueToSelect)) {
				System.out.println("in if");
				driver.findElement(By.xpath("//label[contains(text(),'"+ValueToSelect+"')]/ancestor::tr[1]//div[@class='x-form-radio']")).click();
			}
		}*/
		
		}
	
	   public void selectFromDropDown(String DropDownActualValue) {
		   List<WebElement> options=dropDown.findElements(By.tagName("li"));
		   	  for(WebElement option: options) {
		   		 //System.out.println("option "+option);
			   if(DropDownActualValue.equals(option.getText())) {
				   option.click();
			   }
		   }
		   
	   }
	   
	   public void selectDatePicker(String CurrnetMon) {
		   DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
		   Date date= new Date();
		   String date1=dateformat.format(date);
		   System.out.println("date "+date1);
		   
		   ExpandMonthDropDown.click();
		   List<WebElement> months=driver.findElements(By.xpath("//body/div[contains(@id,'datepicker')][last()]//a[contains(@class,'x-monthpicker-item-inner')]"));
		    	for(WebElement month: months) {
					   if(CurrnetMon.equals(month.getText())) {
						   System.out.println("Month "+month);
						   month.click();
					   }
					   
					   DatePickerOkBtn.click();
				   }
				   
	   }
	
	   public void SelectFromPicker(String DomainName) {
		  String ParnetWindow=driver.getWindowHandle();
		  PickerSearch.click();
		  Set<String> handles=driver.getWindowHandles();
		  //System.out.println(handles);
		  for(String WindowHandle : handles ) {
			  if(!WindowHandle.equals(ParnetWindow)) {
				  driver.switchTo().window(WindowHandle);
				  PickerSearchBtn.click();
				  WebElement Domain=driver.findElement(By.xpath("//span[text()='"+DomainName+"']/ancestor::tr[1]//img[@alt='Select']"));
				  Domain.click();
				  //driver.close();
				  driver.switchTo().window(ParnetWindow);
			  }
		  }
	   }
	
	
	   public void SelectCircularCheckbox(String CircularCheckBoxName) {
		   int size=CircularChcekbox.size();
		   for(int i=0;i<size;i++) {
			  WebElement ele1=CircularChcekbox.get(i);
			  System.out.println("elemnt "+ele1);
			  String name=ele1.getText();
			  if(name.equals(CircularCheckBoxName)) {
				  driver.findElement(By.xpath("//div[contains(text(),'"+CircularCheckBoxName+"')]/ancestor::tr[1]//div[@class='x-form-radio']")).click();
				  break;
				  
			  }
		   }
	   }
	
		/*public void clickCheckboxFromList(String xpathOfElement,String valueToSelect) {
			System.out.println("In Select Check Box");
			List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
			System.out.println("driver"+driver);
			System.out.println(xpathOfElement);
			for (int i = 0; i < lst.size(); i++) {
				System.out.println(i);
				List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
				for (WebElement f : dr) {
					System.out.println("value in the list : " + f.getText());
					if (valueToSelect.equals(f.getText())) {
						f.click();
						break;
					}
				}
			}
		}*/

		
		
}
