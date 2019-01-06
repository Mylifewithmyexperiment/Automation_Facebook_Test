package com.FullContact.Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class HandleModelDialog extends BaseTest {
	static WebDriver driver;
	
	public static void WindowHandle(final String suite) throws Throwable{
		 
		 Set<String> windowids = driver(suite).getWindowHandles();
			System.out.println("Total no. of window :- " +windowids.size());
			Iterator<String> iter= windowids.iterator();
				
			try {
				Xls_Reader x=new Xls_Reader(System.getProperty("user.dir")+"\\config\\data.xlsx");
				int rcount=x.getRowCount("Sheet1");
				for(int i=2 ;i<=rcount ;i++){
				String mainWindowId=iter.next();
				String childWindowId=iter.next();
				driver(suite).switchTo().window(childWindowId);
				Reporter.log("Successfully Switch on Child Window");
				//Enter Email id
				Common_Methods.idWriteInputData(suite, getValueFromData("idGoogleEmail"), x.getCellData("Sheet1", "validEmailID", i));
				//Click on Next Button
				Common_Methods.idClickOnButtn(suite, getValueFromData("idGoogleNext"));
				System.out.println(x.getCellData("Sheet1", "validPwd", i));
				//Enter Pwd
				Common_Methods.idWriteInputData(suite, getValueFromData("idGooglePwd"), x.getCellData("Sheet1", "validPwd", i));
				//Click on 'Sign In' Button
				Common_Methods.idClickOnButtn(suite, getValueFromData("idGoogleSingInButtn"));
				Thread.sleep(3000);
				//Click on 'Allow' Button
				Common_Methods.idClickOnButtn(suite, getValueFromData("idClickAllowButtn"));
				Thread.sleep(7000);
				driver(suite).switchTo().window(mainWindowId);
				} 
			} catch (Exception e) {
				Reporter.log("Unable to Switch on Main Window");
			}
	 }
	
	public static void ActionClassXpath(final String suite, String LocXpath) throws InterruptedException{
		Actions move= new Actions(driver(suite));
		WebElement ele1= driver(suite).findElement(By.xpath(LocXpath));
		move.moveToElement(ele1).build().perform();
	}
	
	
	public static void ActionClassId(final String suite, String LocId) throws InterruptedException{
		Thread.sleep(3000);
		Actions move= new Actions(driver(suite));
		WebElement ele1= driver(suite).findElement(By.id(LocId));
		move.moveToElement(ele1).build().perform();
	}

}

