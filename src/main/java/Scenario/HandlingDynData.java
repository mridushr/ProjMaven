package Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingDynData {
	WebDriver driver;
	@Test
	public void dynData() throws InterruptedException
	{
	driver = new ChromeDriver();
	driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
	driver.manage().window().maximize();

//once you Inspect (What is 1 + 4)-> you do not have frame so select id as 'ebcaptchatext'
	WebElement ele = driver.findElement(By.id("ebcaptchatext"));

//Now I want to retrieve the text (What is 1 + 4)-> which is in "getText" that is outside the tag.
//Store it in String variables
	String str = ele.getText();

//You can either store in WebElement like above code or you can write below script
	//String str = driver.findElement(By.id("ebcaptchatext")).getText();
	
	System.out.println(str);

//Now, I need to find the location of this elements(What is 1 + 4)W starts with->'0' location and space also counts,1->8 location (starting point and as well endpoint.
//If it is getText we are allowed to use a substring
	String str1 = str.substring(8, 9);
	String str2 = str.substring(12, 13);
	System.out.println(str1+"\t"+str2);
	
//The Text box have a string now we need convert from String to Integer value
	Integer res = Integer.valueOf(str1) + Integer.valueOf(str2);

//sendkeys will only accept sequence of character so I need to convert Integer value into string->String.valuesOf(res)
	driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));

//'Submit' button Inspect->do not have id so I will go with xpath (Right click->Copy Xpath)
// If the properties 'isEnabled' you need to enter boolean value
	boolean chkSubmit = driver.findElement(By.xpath("/html//input[@id='ebcaptchainput']")).isEnabled();
	System.out.println(chkSubmit);
    if(chkSubmit==true)
    {
    	System.out.println("Button enabled and Calculation is correct");
    }
    else 
    { 
    	System.out.println("Button disabled and Calculation is incorrect");
    }
    Thread.sleep(2000); 
	driver.quit();
	}
}
