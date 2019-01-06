package com.FullContact.Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;


public class CheckAlert extends BaseTest{
	private static String suite="CheckAlert";
	public static void handleAlert(final String suite){

		if(isAlertPresent(suite)){

			Alert alert = driver(suite).switchTo().alert();
			Reporter.log(alert.getText());

			alert.accept();

		}
	}
	
	public static boolean isAlertPresent(final String suite){

		try{
		driver(suite).switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}

	}
	
	public static void dragAndDrop() throws InterruptedException{
		 Thread.sleep(1000);
		 Actions move= new Actions(driver(suite));
			WebElement src= driver(suite).findElement(By.xpath(getValueFromData("")));
			WebElement tgt= driver(suite).findElement(By.id(getValueFromData("")));
			move.clickAndHold(src).moveToElement(tgt).release(tgt).build().perform();
			Thread.sleep(2000);
			try {
				//Click on Submit Button
				driver(suite).findElement(By.xpath(getValueFromData(""))).click();
				Reporter.log("Passed- Successfully Click on Submit Button");
				
			} catch (Exception e) {
				Reporter.log("Failed- Unable to Click on Submit Button");
			}
			
	}
	
}
