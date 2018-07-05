package airlines;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;


public class Hotel extends BaseClass{
	
	public Hotel(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//strong[text()='BOOK NOW']/..")
	WebElement book;
	
	public void chooseRoom(String typeOfRoom) throws InterruptedException{
	
    WebElement selectRoom=driver.findElement(By.xpath("//h5[text()='"+typeOfRoom+"']/ancestor::*[@class='list-group-item  ']//button[text()='Select This Room']"));
    Utility.WaitUntilElementVisible(selectRoom);
    selectRoom.click();
    Thread.sleep(2000);
   
	}
	
	public PaymentForm book() throws InterruptedException{
	
		 book.click();
		    Utility.WaitUntilPageLoaded();
		    return new PaymentForm();	
	}
	

	public void chooseHotel(String nameOfHotel)  throws InterruptedException{
		
	WebElement selectHotel=driver.findElement(By.xpath("//*[@class='hotel-name'][text()='"+nameOfHotel+"']/ancestor::*[@class='row']//button[text()='Select']"));	
	selectHotel.click();
	Utility.WaitUntilPageLoaded();

	}
	
	

	
	
	
	
}
	

	
	
	
	

