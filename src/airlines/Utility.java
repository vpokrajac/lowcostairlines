package airlines;

import org.openqa.selenium.support.ui.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Utility {

	
	
	
	public static void WaitUntilElementVisible(WebElement element) {
		WebDriverWait wait= new WebDriverWait(BaseClass.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void WaitUntilElementClickable(WebElement element) {
		WebDriverWait wait= new WebDriverWait(BaseClass.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void WaitUntilPageLoaded() throws InterruptedException{
		Thread.sleep(2000);
		new WebDriverWait(BaseClass.driver, 30).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	
	
	public static void SwitchToFrame(String frameId)
	{
		BaseClass.driver.switchTo().frame(frameId);
	}
	
	public static void SwitchToFrame(int frameIndex)
	{
		BaseClass.driver.switchTo().frame(frameIndex);
	}
	
	public static void SwitchToWindow(String window)
	{
		BaseClass.driver.switchTo().window(window);
	}
	
	public static void switchToWindowsPopup() throws InterruptedException {
 	String parentWindow=BaseClass.driver.getWindowHandle();
 	Set<String> s1=BaseClass.driver.getWindowHandles();
 	Iterator<String> i1=s1.iterator();
   	while(i1.hasNext()) {
   		String childWindow=i1.next();
   		if(!parentWindow.equalsIgnoreCase(childWindow)) {
   			BaseClass.driver.switchTo().window(childWindow);    			
   			Thread.sleep(50000);
   		
   		}
    	}
    	
	}

	
	
	
	public static void SwitchToDefaultContent()
	{
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static void SwitchToActiveElement()
	{
		BaseClass.driver.switchTo().activeElement();
	}
	
	
	public static void HoverOver(WebElement element) {
		Actions actions= new Actions(BaseClass.driver);
		actions.moveToElement(element).perform();
	}
}

