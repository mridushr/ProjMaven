package Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	@Test
	public void dragAndDrop() throws InterruptedException
	{
	driver = new ChromeDriver();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();

//Drag me to my target->inspect->has frame->there is only one iframe that starts with 0.
	driver.switchTo().frame(0);
//we have source->draggable element as id and destination->droppable element as id
	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement drop = driver.findElement(By.id("droppable"));
	
//Now we need to create an object for action class so I can use the method inside the class.
	Actions actions=new Actions (driver);
	//actions.dragAndDrop(drag, drop).build().perform();
	Thread.sleep(2000);
//If direct method (dragAndDrop) doesn't work make use of multiple methods(ClickAndHold)
	actions.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	driver.close();
	}
    
}
