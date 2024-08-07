package Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadiCheckBox {
	WebDriver driver;
	@Test
	public void ChekRadAndChkBox() throws InterruptedException
{
		driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();

//storing an element in webelement
		WebElement radBtn = driver.findElement(By.id("bmwradio"));
		radBtn.click();

//I want to check whether it got selected or not
		boolean chkradBMW = radBtn.isSelected();
		System.out.println("Radio Button-BMW="+chkradBMW);

//Now, you can directly use the "CheckBox" you do not have to store in WebElement
		WebElement chkBoxBenz = driver.findElement(By.id("benzcheck"));
		chkBoxBenz.click();
		boolean chkBoxchkBenz = chkBoxBenz.isSelected();
		Thread.sleep(3000);
		System.out.println("Check Box-Benz="+chkBoxchkBenz);
		
		WebElement chkBoxBMW = driver.findElement(By.id("bmwcheck"));
		chkBoxBMW.click();
		boolean chkBoxchkBMW = chkBoxBMW.isSelected();
		Thread.sleep(3000);
		System.out.println("Check Box-BMW="+chkBoxchkBMW);
		
		WebElement chkBoxHonda = driver.findElement(By.id("hondacheck"));
		chkBoxHonda.click();
		boolean chkBoxchkHonda = chkBoxHonda.isSelected();
		Thread.sleep(3000);
		System.out.println("Check Box-Honda="+chkBoxchkHonda);
		
		driver.quit();
		
}
}
