package airlines;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.rmi.CORBA.Util;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicTests extends BaseClass{
    
	@Test
	public void requiredFieldsNotPopulated() throws InterruptedException {
		HomePage homepage=new HomePage();
		homepage.waitCookie();
		homepage.acceptCookie();
		Thread.sleep(2000);
		Hotel hotel = homepage.goToHotelAndRooms();
		Assert.assertEquals("This field is required.", homepage.requiredFieldFirst.getText());
		Assert.assertEquals("This field is required.", homepage.requiredFieldSecond.getText());
	}
	
	@Test
	public void departingFromNotFilled() throws InterruptedException {
		HomePage homepage=new HomePage();
    	homepage.waitCookie();
    	/*homepage.showModalPopup();
    	homepage.closePopup();*/
    	homepage.acceptCookie();
    	Thread.sleep(1000);
    	homepage.travelingTo("Vie");
    	Hotel hotel = homepage.goToHotelAndRooms();
		Assert.assertEquals("This field is required.", homepage.requiredFieldFirst.getText());
		
	}
	
	@Test
	public void travelngToNotFilled() throws InterruptedException {
		HomePage homepage=new HomePage();
		homepage.waitCookie();
		homepage.acceptCookie();
		homepage.departingFrom("Mil");
		homepage.traveling.click();
		homepage.traveling.click();
		Hotel hotel = homepage.goToHotelAndRooms();
		Assert.assertEquals("This field is required.", homepage.requiredFieldSecond.getText());
	}
	
	@Test
	
	public void goToNextPage() throws InterruptedException {
		HomePage homepage=new HomePage();
    	homepage.waitCookie();
    	/*homepage.showModalPopup();
    	homepage.closePopup();*/
    	homepage.acceptCookie();
    	homepage.departingFrom("Mil");
    	homepage.setDepartDate("Jul", "22");
    	homepage.setReturnDate("Jul", "29");
    	homepage.travelingTo("Vie");
    	Hotel hotel = homepage.goToHotelAndRooms();
    	Utility.WaitUntilPageLoaded();
	}
     
    @Test
    public void travel() throws InterruptedException {
    	HomePage homepage=new HomePage();
    	homepage.waitCookie();
    	homepage.acceptCookie();
    	homepage.departingFrom("Mil");
    	homepage.setDepartDate("Jul", "22");
    	homepage.setReturnDate("Jul", "29");
    	homepage.travelingTo("Vie");
    	Hotel hotel = homepage.goToHotelAndRooms();
    	Utility.WaitUntilPageLoaded();
    	hotel.chooseHotel("Red Carpet Hostels Vienna");
    	hotel.chooseRoom("Shared room Dorm");
    	PaymentForm payment = hotel.book();
    	payment.flightDetails();
    	Utility.WaitUntilPageLoaded();   
    	Assert.assertEquals("Departure : MXP  VIE",payment.firstFlight());
    	Assert.assertEquals("Departure : VIE  MXP",payment.secondFlight());
    	Assert.assertEquals("Hotel : Red Carpet Hostels Vienna",payment.hotelName());
    	Assert.assertEquals("Check-in : 22 Jul 2018",payment.selectedDepartingDate());
    	Assert.assertEquals("Check-out : 29 Jul 2018",payment.selectedReturningDate());
    }
	
	
}
	
	

