package com.Facebook.SignInPageObjects;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.FullContact.Utilities.BaseTest;
import com.FullContact.Utilities.Common_Methods;
import com.FullContact.Utilities.Xls_Reader;


public class SignIn extends BaseTest{

	public static void NewUserLoginQA(final String suite) throws Throwable{
		try {
			Reporter.log("***********Successfully Login with New User***********");
			Xls_Reader x=new Xls_Reader(System.getProperty("user.dir")+"\\config\\data.xlsx");
			int rowcount = x.getRowCount("data");
			
			
			for(int i=2 ;i<=2 ;i++){
				
		// for(int i =2 ; i<= rowcount; i++ ) 
		// {	
			//Clear User name Text field
			Common_Methods.idClearTextBox(suite, getValueFromData("idUserName"));
			//Enter user name
			Common_Methods.idWriteInputData(suite, getValueFromData("idUserName"),x.getCellData("Sheet1","newUsername", i));
			Reporter.log("Passed:- Successfully enter 'User Name'");
			//Enter Pwd
			Common_Methods.idWriteInputData(suite, getValueFromData("idPassword"),x.getCellData("Sheet1", "newPassword", i));
			Reporter.log("Passed:- Successfully enter 'Password'");
			//Click on Submit button
			Common_Methods.idClickOnButtn(suite, getValueFromData("idSignInButtonText"));
			}
		} catch (Exception e) {
			Reporter.log("Failed:- Login Page is Not Found");
		}
	}
}
