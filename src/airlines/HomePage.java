package airlines;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class HomePage extends BaseClass{ 
	 
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
   
 	
	
	@FindBy(how=How.XPATH,using="//button[text()='Got it!']")
	WebElement acceptcookie;  

	@FindBy(how=How.XPATH,using="//*[@class='modal-backdrop fade in'][last()]")
	WebElement closeAd;
	
	@FindBy(how=How.XPATH,using="//input[@class='form-control required drop-airport dept-txt ui-autocomplete-input']")
	WebElement departing;
	
	@FindBy(how=How.XPATH, using="//input[@class='form-control required drop-airport ret-txt ui-autocomplete-input']")
	WebElement traveling;
	
	@FindBy(how=How.XPATH,using="//input[@class='form-control datepk depdate hasDatepicker']")
	
	WebElement departDate;
	
	@FindBy(how=How.CLASS_NAME,using="//div[contains(@class,'return-date')]//input[contains(@name,'ReturnDate')]")
	WebElement returnDate;
	
	@FindBy(how=How.ID,using="flight-home-btn")
	WebElement searchFlight;
	
	@FindBy(how=How.ID,using="flight-and-hotel-home-btn")
	WebElement hotelAndFlight;
	
	@FindBy(how=How.XPATH,using="//span[@id='depart-form']/ancestor::*[@class='form-group has-feedback mar-bott-0']//label[text()='This field is required.']")
	WebElement requiredFieldFirst;
	
	@FindBy(how=How.XPATH,using="//div[@class='input-group has-error']/ancestor::*[@class='form-group has-feedback mar-bott-0']//label[text()='This field is required.']")
	WebElement requiredFieldSecond;
	
	@FindBy(how=How.XPATH,using="//select[@data-handler='selectMonth']")
	WebElement selectMonth;
	
	@FindBy(how=How.CSS,using=".floatL.text-number")
	WebElement textUs;
	
	////*[@class='ui-menu-item'][contains(text(),'Mil')]
	

	public void hoverOverTextUs() {
		Utility.HoverOver(textUs);
	}
	
	public void showModalPopup() throws InterruptedException {
		Utility.WaitUntilElementVisible(textUs);
		textUs.click();
		Thread.sleep(7000);
	}
	
	public void closePopup() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("$(\"[id='call-modal'] button:contains('Close')\").click()");
	}
	

	
	public void acceptCookie() throws InterruptedException{
		acceptcookie.click();
	}
	
	public void requiredFieldsAreNotPopulated() {
		acceptcookie.click();
		hotelAndFlight.click();
		Assert.assertEquals("This field is required.", requiredFieldFirst.getText());
	}
	
	
	
	
   public void closeAdvertisement() {
	  Utility.WaitUntilElementVisible(closeAd);
	   closeAd.click();
	   
   }
	
	public void departingFrom(String nameOfCity) throws InterruptedException {
		departing.sendKeys(nameOfCity); 
		Thread.sleep(3000);
		departing.sendKeys(Keys.DOWN);
		departing.sendKeys(Keys.DOWN);
		departing.sendKeys(Keys.TAB);
		//departing.click();
	}
	public void travelingTo(String nameOfCity) {
		traveling.click();
		traveling.sendKeys(nameOfCity);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		traveling.sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//*[@class='ui-menu-item'][contains(text(),'"+nameOfCity+"')]")).click();
        //action.sendKeys(Keys.TAB).click();
		traveling.click();
		traveling.click();
		
	}
	
	public void setDepartDate(String month, String dayOfMonth) throws InterruptedException {
		departDate.click();
		Thread.sleep(2000);
		Select select=new Select(this.selectMonth);
		select.selectByVisibleText(month);
		WebElement selectDay=driver.findElement(By.xpath("//a[@class='ui-state-default'][text()="+dayOfMonth+"]"));
		selectDay.click();
		
				
			}
		
		
	public void setReturnDate( String month, String dayOfMonth) throws InterruptedException {
		//returnDate.click();
		WebElement dateSelect=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		dateSelect.click();
		Thread.sleep(500);
        Select select=new Select(dateSelect);
       
		select.selectByVisibleText(month);
		//select.selectByVisibleText(month);
		WebElement selectDay=driver.findElement(By.xpath("//a[@class='ui-state-default'][text()="+dayOfMonth+"]"));
		selectDay.click();

	}
	

	public Hotel goToHotelAndRooms() {
		
		Utility.WaitUntilElementClickable(hotelAndFlight);
		hotelAndFlight.click();
		return new Hotel();
		
	}
	
	public void waitForListItems() throws InterruptedException{
		try {
			WebElement element=driver.findElement(By.xpath("//*[@class='ui-menu-item']"));
			Utility.WaitUntilElementVisible(element);
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			Thread.sleep(3000);
			WebElement element=driver.findElement(By.xpath("//*[@class='ui-menu-item']"));
			Utility.WaitUntilElementVisible(element);
		}
	}
	
	public void waitCookie(){
		Utility.WaitUntilElementVisible(acceptcookie);
	
	}


	
}
	
