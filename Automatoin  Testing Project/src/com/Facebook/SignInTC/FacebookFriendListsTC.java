package com.Facebook.SignInTC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Facebook.SignInPageObjects.SignIn;
import com.FullContact.Utilities.BaseTest;
import com.FullContact.Utilities.Common_Methods;
import com.FullContact.Utilities.Xls_Reader;

public class FacebookFriendListsTC extends BaseTest {
    private static String suite = "Login";

    @Test
    public void verifyFacebookFriendListFunctionlity() throws Throwable {
        Xls_Reader x = new Xls_Reader(
                System.getProperty("user.dir") + "\\config\\data.xlsx");
        int rcount = x.getRowCount("Sheet1");
        for (int n = 2; n <= rcount; n++) {
            int p = n - 1;
            Reporter.log("iteration:-" + "" + p + ""
                    + "********************verifyFacebookFriendListFunctionlity********************");
            // Call 'NewUserLoginQA' Method
            SignIn.NewUserLoginQA(suite);
            // Click on 'Profile'
            Common_Methods.xpClickOnButtn(suite,
                    getValueFromData("xpClickProfile"));
            // Click on 'Friend' List
            Common_Methods.xpClickOnButtn(suite,
                    getValueFromData("xpClickOnFrndTab"));
            Common_Methods.idGetText(suite,
                    getValueFromData("xpClickOnFrndTab"));

            List<WebElement> friends = driver(suite)
                    .findElements(By.xpath(getValueFromData("xpWholeTable")));
            int newFriends = friends.size();
            Actions move = new Actions(driver(suite));

            int oldFriends = 0;
            while (newFriends != oldFriends) {
                oldFriends = newFriends;
                WebElement lastFriend = friends.get(friends.size() - 1);
                // move.moveToElement(lastFriend).build().perform();
                Thread.sleep(3000);
                friends = driver(suite).findElements(
                        By.xpath(getValueFromData("xpWholeTable")));
                newFriends = friends.size();

            }
            System.out.println("Final Total friends->" + "" + friends.size());
            Reporter.log("Passed:- Total Friends in your friend list are: "
                    + friends.size());
            for (int i = 0; i < friends.size(); i++) {
                System.out.println(friends.get(i).getText());
            }
        }
    }
}
