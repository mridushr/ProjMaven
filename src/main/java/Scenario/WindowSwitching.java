package Scenario;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowSwitching {

	WebDriver driver;
	@Test
	public void switchWin()
{
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		// finding a 'try it' button (https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open) and click
		driver.findElement(By.xpath("/html/body/button")).click();
		
//getWindowHandles() will get browser session id to find all opened browser tabs
//Set- removes the duplicate values 
		Set<String> allWinIds = driver.getWindowHandles(); 
		System.out.println("Total windows=" +allWinIds.size()); 
//String win 1 and win 2 is to store the webID of each browser tab.
		String win1 = null; 
		String win2 = null;
		
//iterator is just like a pointer that will let you know if there is next list is available for not. For e.g checking if it has next win opened-win1,win 2 
		Iterator<String> itr = allWinIds.iterator(); 
		if(itr.hasNext())
		{
			win1 = itr.next();
			win2 = itr.next();
			}
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Window1 title= "+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title = "+driver.getTitle());

// here you are trying to find the link that has text "Log in" and checking if that is enabled or disabled. 
//Enabled/Disabled check method will always return boolean value 
		boolean chkLogin = driver.findElement(By.linkText("Log in")).isEnabled(); 
		System.out.println(chkLogin);
		if(chkLogin==true)
		{
			System.out.println("Login is Enabled");
		}
		else
		{
			System.out.println("Login is Disabled");

		}
		//driver.quit() will close all the browser tabs
		//driver.close() will only close the current browser tabs
        driver.quit();
}
}
