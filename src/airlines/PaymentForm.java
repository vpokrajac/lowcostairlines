package airlines;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentForm extends BaseClass {
	
	public PaymentForm(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how=How.XPATH, using="//div[@class='title-flightinfo-btn']//button[contains(text(),'Flight and Hotel Info')]")
	WebElement flightInfo;
	
	@FindBy(how=How.XPATH, using="//*[@class='hotel-detail-package-lca']/ul/li[5]")
	WebElement selectedDepartingDate;
	
	@FindBy(how=How.XPATH, using="//*[@class='hotel-detail-package-lca']/ul/li[6]")
	WebElement selectedReturningDate;
	
	@FindBy(how=How.XPATH, using="(//*[@class='depart-return-line'])[1]/p[1]")
	WebElement firstFlight;
	
	@FindBy(how=How.XPATH, using="(//*[@class='depart-return-line'])[2]/p[1]")
	WebElement secondFlight;
	
	@FindBy(how=How.XPATH, using="//*[@class='hotel-detail-package-lca']/ul/li[1]")
	WebElement hotelName;
	
	
	public String selectedDepartingDate() {
		
		return selectedDepartingDate.getText().trim();
		
	}
	
	public String hotelName() {
		
		return hotelName.getText().trim();
		
	}
	
	public String selectedReturningDate() {
		
		return selectedReturningDate.getText().trim();
		
	}

	public String firstFlight() {
	
	return firstFlight.getText().trim();
	
}

	public String secondFlight() {
	
	return secondFlight.getText().trim();
	
}
	
	public void flightDetails() {
		flightInfo.click();
	}
}
