package com.Facebook.SignInTC;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.FullContact.Utilities.BaseTest;
import com.FullContact.Utilities.Common_Methods;
import com.FullContact.Utilities.Xls_Reader;

public class FacebookLoginTC extends BaseTest {
    private static String suite = "Login";

    /**
     * @throws Throwable
     * 
     */
    @Test
    public void verifyFacebookLoginLogout() throws Throwable {
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
                    x.getCellData("Sheet1", "newUsername", n));
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
            Common_Methods.idVerifyText(suite, getValueFromData("idHomeText"),
                    getValueFromData("ContainHomeText"));
            // Click on LogOut drop down tab
            Common_Methods.idClickOnButtn(suite,
                    getValueFromData("idUserNavigateLabel"));
            Thread.sleep(2000);
            // Click on LogOut Button
            Common_Methods.xpClickOnButtn(suite,
                    getValueFromData("xpLogOutButton"));
            //Common_Methods.xpClickOnButtn(suite,
                    //getValueFromData("xpLogOutButtonPopUp"));
            // Verify Login screen
            Common_Methods.idVerifyDisplayTextBox(suite,
                    getValueFromData("idPassword"));

        }
    }
}