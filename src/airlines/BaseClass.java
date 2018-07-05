package airlines;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Converter;

import java.awt.Dimension;
import java.io.Console;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.After;

public class BaseClass {
	
	public static WebDriver driver = null;


	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpokraja\\eclipse-workspace\\SeleniumAirlines\\chromedriver.exe");
		
	    driver=new ChromeDriver();
	    System.out.println("Browser width:");
	   
		
		Scanner scan = new Scanner(System.in);
		String width= scan.nextLine();
		org.openqa.selenium.Dimension dimension= new org.openqa.selenium.Dimension(Integer.parseInt(width), 1000);
		driver.manage().window().setSize(dimension);
	    driver.manage().window().maximize();
		    
		    driver.get("https://lowcostairlines.com/");
		
	}

	@After
	public void close() {
		driver.quit();
	}
}