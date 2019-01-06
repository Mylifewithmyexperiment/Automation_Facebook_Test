package com.Facebook.SignInTC;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.FullContact.Utilities.BaseTest;
import com.FullContact.Utilities.Common_Methods;
import com.FullContact.Utilities.Xls_Reader;

public class FacebookInvalidSignIn extends BaseTest {
    private static String suite = "Login";

    /**
     * @throws Throwable
     * 
     */
    @Test
    public void verifyFacebookLoginWithInvalidUserName() throws Throwable {
        Xls_Reader x = new Xls_Reader(
                System.getProperty("user.dir") + "\\config\\data.xlsx");
        int rcount = x.getRowCount("Sheet1");
        for (int n = 2; n <= rcount; n++) {
            int p = n - 1;
            Reporter.log("iteration:-" + "" + p + ""
                    + "********************Successfully Login with New User********************");

            // Clear User name Text field
            Common_Methods.idClearTextBox(suite,
                    getValueFromData("idUserName"));
            // Type User Name in the username text field
            Common_Methods.idWriteInputData(suite,
                    getValueFromData("idUserName"),
                    x.getCellData("Sheet1", "inValidUserName", n));
            Reporter.log("Passed:- Successfully type 'User Name'");
            // Type Pwd in the pwd field
            Common_Methods.idWriteInputData(suite,
                    getValueFromData("idPassword"),
                    x.getCellData("Sheet1", "newPassword", n));
            Reporter.log("Passed:- Successfully type 'Password'");
            // Click on Submit button
            Common_Methods.idClickOnButtn(suite,
                    getValueFromData("idSignInButtonText"));
            // Verify Home Text
            // Thread.sleep(5000);
            Common_Methods.xpVerifyText(suite,
                    getValueFromData("LoginErrorUserName"),
                    getValueFromData("LoginErrorTextUserName"));

        }
    }
}

