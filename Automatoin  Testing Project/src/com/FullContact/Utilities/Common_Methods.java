package com.FullContact.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class Common_Methods extends BaseTest {
    private static String suite = "Common_Methods";

    public static void xpClickOnButtn(final String suite, String LocXpath)
            throws Throwable {

        if (driver(suite).findElement(By.xpath(LocXpath)).getText() != null) {
            try {
                String GetText = driver(suite).findElement(By.xpath(LocXpath))
                        .getText();
                // Click on 'Submit' button
                driver(suite).findElement(By.xpath(LocXpath)).click();
                Reporter.log("Passed:- Successfully clicked on" + " " + GetText
                        + " Button");
            } catch (Exception e) {
                String GetText = driver(suite).findElement(By.xpath(LocXpath))
                        .getText();
                Reporter.log("Failed:- Unable to clicked on " + " " + GetText
                        + " Button");
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("value") != null) {
            try {
                String GetValueAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("value");
                // Click on 'Submit' button
                driver(suite).findElement(By.xpath(LocXpath)).click();
                Reporter.log("Passed:- Successfully clicked on" + " "
                        + GetValueAttribute + " Button");
            } catch (Exception e) {
                String GetValueAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("value");
                Reporter.log("Failed:- Unable to clicked on" + " "
                        + GetValueAttribute + " Button");
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name") != null) {
            try {
                String GetValueAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("value");
                // Click on 'Submit' button
                driver(suite).findElement(By.xpath(LocXpath)).click();
                Reporter.log("Passed:- Successfully clicked on" + " "
                        + GetValueAttribute + " Button");
            } catch (Exception e) {
                String GetValueAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("value");
                Reporter.log("Failed:- Unable to clicked on" + " "
                        + GetValueAttribute + " Button");
            }
        } else {
            driver(suite).findElement(By.xpath(LocXpath)).click();
            Reporter.log("Passed:- Successfully clicked on Button");
        }
    }

    public static void idClickOnButtn(final String suite, String LocId)
            throws Throwable {

        if (driver(suite).findElement(By.id(LocId)).getText() != null) {
            try {
                String GetText = driver(suite).findElement(By.id(LocId))
                        .getText();
                driver(suite).findElement(By.id(LocId)).click();
                Reporter.log("Passed:- Successfully clicked on" + " " + GetText
                        + " Button");
            } catch (Exception e) {
                String GetText = driver(suite).findElement(By.id(LocId))
                        .getText();
                Reporter.log("Failed:- Unable to clicked on " + " " + GetText
                        + " Button");
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("value") != null) {
            try {
                String GetValueAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("value");
                driver(suite).findElement(By.id(LocId)).click();
                Reporter.log("Passed:- Successfully clicked on" + " "
                        + GetValueAttribute + " Button");
            } catch (Exception e) {
                String GetValueAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("value");
                Reporter.log("Failed:- Unable to clicked on" + " "
                        + GetValueAttribute + " Button");
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("name") != null) {
            try {
                String GetnameAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("name");
                driver(suite).findElement(By.id(LocId)).click();
                Reporter.log("Passed:- Successfully clicked on" + " "
                        + GetnameAttribute + " Button");
            } catch (Exception e) {
                String GetnameAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("name");
                Reporter.log("Failed:- Unable to clicked on" + " "
                        + GetnameAttribute + " Button");
            }
        } else {
            driver(suite).findElement(By.id(LocId)).click();
            Reporter.log("Passed:- Successfully clicked on Button");
        }
    }

    public static void xpVerifyText(final String suite, String LocXpath,
            String LocContain) throws Throwable {
        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.xpath(LocXpath)).getText() != null
                && !driver(suite).findElement(By.xpath(LocXpath)).getText()
                        .equals("")) {
            try {

                String GetText = driver(suite).findElement(By.xpath(LocXpath))
                        .getText();
                Assert.assertTrue(
                        driver(suite).findElement(By.xpath(LocXpath)).getText()
                                .contains(LocContain),
                        "PageTitle:-" + PageTitle + "|" + "Text Name:-"
                                + GetText + "|" + " Text is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + "Text Name:-" + GetText + "|" + ""
                        + "Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }

        else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("value") != null) {
            try {
                String GetValue = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("value");
                Assert.assertTrue(
                        driver(suite).findElement(By.xpath(LocXpath))
                                .getAttribute("value").contains(LocContain),
                        "PageTitle:-" + PageTitle + "|" + "Text Name:-"
                                + GetValue + "|" + " Text is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + "Text Name:-" + GetValue + "|" + ""
                        + "Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }
    }

    public static void idVerifyText(final String suite, String LocId,
            String LocContain) throws Throwable {
        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.id(LocId)).getText() != null
                && !driver(suite).findElement(By.id(LocId)).getText()
                        .equals("")) {
            try {

                String GetText = driver(suite).findElement(By.id(LocId))
                        .getText();
                Assert.assertTrue(
                        driver(suite).findElement(By.id(LocId)).getText()
                                .contains(LocContain),
                        "PageTitle:-" + PageTitle + "|" + "Text Name:-"
                                + GetText + "|" + " Text is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + "Text Name:-" + GetText + "|" + ""
                        + "Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("value") != null) {
            try {
                String GetValue = driver(suite).findElement(By.id(LocId))
                        .getAttribute("value");
                Assert.assertTrue(
                        driver(suite).findElement(By.id(LocId))
                                .getAttribute("value").contains(LocContain),
                        "PageTitle:-" + PageTitle + "|" + "Text Name:-"
                                + GetValue + "|" + " Text is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + "Text Name:-" + GetValue + "|" + ""
                        + "Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }

    }

    public static void xpVerifyDisplayTextBox(final String suite,
            String LocXpath) throws Throwable {
        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name") != null) {
            try {
                String Name = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("name");
                Assert.assertTrue(
                        driver(suite).findElement(By.xpath(LocXpath))
                                .isDisplayed(),
                        "PageTitle:-" + PageTitle + "|" + Name
                                + " :- Text Box is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Name + ":-Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("value") != null) {
            try {
                String Value = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("value");
                Assert.assertTrue(
                        driver(suite).findElement(By.xpath(LocXpath))
                                .isDisplayed(),
                        "PageTitle:-" + PageTitle + "|" + Value
                                + " :- Text Box is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Value + ":-Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }

        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name") == null
                && driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("name") == null
                && driver(suite).findElement(By.xpath(LocXpath)).getText()
                        .equals("")) {

            try {
                Assert.assertTrue(
                        driver(suite).findElement(By.xpath(LocXpath))
                                .isDisplayed(),
                        "PageTitle:-" + PageTitle + "|" + ""
                                + " :- Text Box is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + " " + ":-Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }

    }

    public static void idVerifyDisplayTextBox(final String suite, String LocId)
            throws Throwable {
        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.id(LocId))
                .getAttribute("name") != null) {
            try {
                String Name = driver(suite).findElement(By.id(LocId))
                        .getAttribute("name");
                Assert.assertTrue(
                        driver(suite).findElement(By.id(LocId)).isDisplayed(),
                        "PageTitle:-" + PageTitle + "|" + Name
                                + " :- Text Box is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Name + ":- Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("value") != null) {
            try {
                String Value = driver(suite).findElement(By.id(LocId))
                        .getAttribute("value");
                Assert.assertTrue(
                        driver(suite).findElement(By.id(LocId)).isDisplayed(),
                        "PageTitle:-" + PageTitle + "|" + Value
                                + " :- Text Box is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Value + ":- Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("name") == null
                && driver(suite).findElement(By.id(LocId))
                        .getAttribute("value") == null
                && driver(suite).findElement(By.id(LocId)).getText()
                        .equals("")) {

            try {
                Assert.assertTrue(
                        driver(suite).findElement(By.id(LocId)).isDisplayed(),
                        "PageTitle:-" + PageTitle + "|" + ""
                                + " :- Text Box is Not displayed");
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + " " + ":-Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }

    }

    public static void idVerifySelectedTextBox(final String suite, String LocId)
            throws Throwable {

        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.id(LocId))
                .getAttribute("name") != null) {
            try {
                String Name = driver(suite).findElement(By.id(LocId))
                        .getAttribute("name");
                driver(suite).findElement(By.id(LocId)).isSelected();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Name + ":- Check Box is Selected");
            } catch (final Throwable t) {
                Reporter.log("Passed:-Check Box is Not Selected");
                System.out.println("Passed:-Check Box is Not Selected");
                throw t;
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("value") == null) {
            try {
                String Value = driver(suite).findElement(By.id(LocId))
                        .getAttribute("value");
                driver(suite).findElement(By.id(LocId)).isSelected();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Value + ":- Check Box is Selected");
            } catch (final Throwable t) {
                System.out.println("Passed:-Check Box is Not Selected");
                throw t;
            }
        }
    }

    public static void xpVerifySelectedTextBox(final String suite,
            String LocXpath) throws Throwable {

        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name") != null) {
            try {
                String Name = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("name");
                driver(suite).findElement(By.xpath(LocXpath)).isSelected();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Name + ":-Text is displayed");
            } catch (final Throwable t) {
                System.out.println("Passed:-Check Box is Not Selected");
                throw t;
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("value") == null) {
            try {
                String Value = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("value");
                driver(suite).findElement(By.xpath(LocXpath)).isSelected();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Value + ":-Text is displayed");
            } catch (final Throwable t) {
                System.out.println("Passed:-Check Box is Not Selected");
                throw t;
            }
        }
    }

    public static void xpVerifyEnabledTextBox(final String suite,
            String LocXpath) throws Throwable {
        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name") != null) {
            try {
                String Name = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("name");
                driver(suite).findElement(By.xpath(LocXpath)).isEnabled();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Name + ":-Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("value") != null) {
            try {
                String Value = driver(suite).findElement(By.xpath(LocXpath))
                        .getAttribute("value");
                driver(suite).findElement(By.xpath(LocXpath)).isEnabled();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Value + ":-Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }

    }

    public static void idVerifyEnabledTextBox(final String suite, String LocId)
            throws Throwable {
        String PageTitle = driver(suite).getTitle();
        if (driver(suite).findElement(By.id(LocId))
                .getAttribute("name") != null) {
            try {
                String Name = driver(suite).findElement(By.id(LocId))
                        .getAttribute("name");
                driver(suite).findElement(By.id(LocId)).isEnabled();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Name + ":- Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("value") != null) {
            try {
                String Value = driver(suite).findElement(By.id(LocId))
                        .getAttribute("value");
                driver(suite).findElement(By.id(LocId)).isEnabled();
                Reporter.log("Passed:-" + "" + "PageTitle:-" + PageTitle + "|"
                        + Value + ":- Text is displayed");
            } catch (final Throwable t) {
                Reporter.log("Failed:- " + t.getMessage());
                throw t;
            }
        }

    }

    public static void xpClearTextBox(final String suite, String LocXpath)
            throws Throwable {
        String getTextBoxName = driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name");
        driver(suite).findElement(By.xpath(LocXpath)).clear();
        Reporter.log("Passed:-" + "" + "Text Box Name:-" + getTextBoxName
                + ":- Text is displayed");
    }

    public static void idClearTextBox(final String suite, String LocId)
            throws Throwable {
        String getTextBoxName = driver(suite).findElement(By.id(LocId))
                .getAttribute("name");
        driver(suite).findElement(By.id(LocId)).clear();
        Reporter.log("Passed:-" + "" + "Text Box Name:-" + getTextBoxName
                + ":- Text is displayed");
    }

    public static void idGetDropDownList(final String suite, String tableid,
            String liid, int NumParam) throws Throwable {
        // Get id from table
        WebElement ele = driver(suite).findElement(By.id(tableid));
        List<WebElement> droplist = driver(suite)
                .findElements(By.tagName("li"));
        // id Till table (Click on Table)
        System.out.println(droplist.size());
        Thread.sleep(1000);
        ele.click();
        Thread.sleep(2000);
        String link = liid + "[" + NumParam + "]/a";
        System.out.println(driver(suite).findElement(By.xpath(link)).getText());
        Common_Methods.xpClickOnButtn(suite, link);
    }

    public static void xpGetDropDownList(final String suite, String tableXpath,
            String liid, int NumParam) throws Throwable {
        // Get id from table
        WebElement ele = driver(suite).findElement(By.xpath(tableXpath));
        List<WebElement> droplist = driver(suite)
                .findElements(By.tagName("li"));
        // id Till table (Click on Table)
        System.out.println(droplist.size());
        Thread.sleep(1000);
        ele.click();
        Thread.sleep(2000);
        String link = liid + "[" + NumParam + "]/a";
        System.out.println(driver(suite).findElement(By.xpath(link)).getText());
        Common_Methods.xpClickOnButtn(suite, link);
    }

    public static void idCheckBoxDropDownList(final String suite,
            String tableid, String ListXpath, String CheckBoXpath, int range)
            throws Throwable {
        // Get id from table for Click on Table
        WebElement ele = driver(suite).findElement(By.id(tableid));
        List<WebElement> checklist = ele.findElements(By.xpath(ListXpath));
        // id Till table (Click on Table)
        System.out.println(checklist.size());
        Thread.sleep(1000);
        ele.click();
        Thread.sleep(2000);
        for (int i = 1; i <= range; i++) {
            String link = CheckBoXpath + "[" + i + "]/div[1]";
            System.out.println(
                    driver(suite).findElement(By.xpath(link)).getText());
            Common_Methods.xpClickOnButtn(suite, link);
        }

    }

    public static void idDropDownList(final String suite, String tableid,
            String liid, int NumParam) throws Throwable {
        // Get id from table
        WebElement ele = driver(suite).findElement(By.id(tableid));
        List<WebElement> droplist = driver(suite)
                .findElements(By.tagName("li"));
        // id Till table (Click on Table)
        System.out.println(droplist.size());
        Thread.sleep(1000);
        ele.click();
        Thread.sleep(2000);
        String link = liid + "[" + NumParam + "]/div";
        System.out.println(driver(suite).findElement(By.xpath(link)).getText());
        Common_Methods.xpClickOnButtn(suite, link);
    }

    public static void xpDropDownList(final String suite, String tableXpath,
            String liid, int NumParam) throws Throwable {
        // Get id from table
        WebElement ele = driver(suite).findElement(By.xpath(tableXpath));
        List<WebElement> droplist = driver(suite)
                .findElements(By.tagName("li"));
        // id Till table (Click on Table)
        System.out.println(droplist.size());
        Thread.sleep(1000);
        ele.click();
        Thread.sleep(2000);
        String link = liid + "[" + NumParam + "]/div";
        System.out.println(driver(suite).findElement(By.xpath(link)).getText());
        Common_Methods.xpClickOnButtn(suite, link);
    }

    public static void xpCheckBoxDropDownList(final String suite,
            String tableid, String ListXpath, String CheckBoXpath, int range)
            throws Throwable {
        // Get id from table for Click on Table
        WebElement ele = driver(suite).findElement(By.id(tableid));
        List<WebElement> checklist = ele.findElements(By.xpath(ListXpath));
        // id Till table (Click on Table)
        System.out.println(checklist.size());
        Thread.sleep(1000);
        ele.click();
        Thread.sleep(2000);
        for (int i = 1; i <= range; i++) {
            String link = CheckBoXpath + "[" + i + "]/div[1]";
            System.out.println(
                    driver(suite).findElement(By.xpath(link)).getText());
            Common_Methods.xpClickOnButtn(suite, link);
        }
    }

    public static void ClickOnLinkText(final String suite, String LocId)
            throws Throwable {

        if (driver(suite).findElement(By.linkText(LocId)).getText() != null) {
            try {
                String GetText = driver(suite).findElement(By.linkText(LocId))
                        .getText();
                driver(suite).findElement(By.linkText(LocId)).click();
                Reporter.log("Passed:- Successfully clicked on" + " " + GetText
                        + " Button");
            } catch (Exception e) {
                String GetText = driver(suite).findElement(By.linkText(LocId))
                        .getText();
                Reporter.log("Failed:- Unable to clicked on " + " " + GetText
                        + " Button");
            }
        } else if (driver(suite).findElement(By.linkText(LocId))
                .getAttribute("value") != null) {
            try {
                String GetValueAttribute = driver(suite)
                        .findElement(By.linkText(LocId)).getAttribute("value");
                driver(suite).findElement(By.linkText(LocId)).click();
                Reporter.log("Passed:- Successfully clicked on" + " "
                        + GetValueAttribute + " Button");
            } catch (Exception e) {
                String GetValueAttribute = driver(suite)
                        .findElement(By.linkText(LocId)).getAttribute("value");
                Reporter.log("Failed:- Unable to clicked on" + " "
                        + GetValueAttribute + " Button");
            }
        } else if (driver(suite).findElement(By.linkText(LocId))
                .getAttribute("name") != null) {
            try {
                String GetnameAttribute = driver(suite)
                        .findElement(By.linkText(LocId)).getAttribute("name");
                driver(suite).findElement(By.linkText(LocId)).click();
                Reporter.log("Passed:- Successfully clicked on" + " "
                        + GetnameAttribute + " Button");
            } catch (Exception e) {
                String GetnameAttribute = driver(suite)
                        .findElement(By.linkText(LocId)).getAttribute("name");
                Reporter.log("Failed:- Unable to clicked on" + " "
                        + GetnameAttribute + " Button");
            }
        } else {
            driver(suite).findElement(By.linkText(LocId)).click();
            Reporter.log("Passed:- Successfully clicked on Button");
        }
    }

    public static void navigateBack(final String suite, String LocId)
            throws Throwable {
        driver(suite).navigate().back();
        Reporter.log("Successfully Navigate back browser");

    }

    public static void xpClickOnRadioButtn(final String suite, String LocXpath)
            throws Throwable {
        try {
            // Click on 'Radio' button
            driver(suite).findElement(By.xpath(LocXpath)).click();
            Reporter.log("Passed:- Successfully clicked on Radio Button");
        } catch (Exception e) {
            Reporter.log("Failed:- Unable to clicked on Radio Button");
        }
    }

    public static void idClickOnRadioButtn(final String suite, String LocId)
            throws Throwable {
        try {
            // Click on 'Radio' button
            driver(suite).findElement(By.id(LocId)).click();
            Reporter.log("Passed:- Successfully clicked on Radio Button");
        } catch (Exception e) {
            Reporter.log("Failed:- Unable to clicked on Radio Button");
        }
    }

    public static void idVerifySelectedRadioButton(final String suite,
            String LocId) throws Throwable {
        try {
            Assert.assertTrue(
                    driver(suite).findElement(By.id(LocId)).isSelected(),
                    "| Radio Button is Not Selected");
            Reporter.log("Passed:-" + "" + "PageTitle:-"
                    + "|Radio Button is Selected");
        } catch (final Throwable t) {
            Reporter.log("Failed:- " + t.getMessage());
            throw t;
        }
    }

    public static void xpVerifySelectedRadioButton(final String suite,
            String LocId) throws Throwable {
        try {
            Assert.assertTrue(
                    driver(suite).findElement(By.xpath(LocId)).isSelected(),
                    "| Radio Button is Not Selected");
            Reporter.log("Passed:-" + "" + "PageTitle:-"
                    + "|Radio Button is Selected");
        } catch (final Throwable t) {
            Reporter.log("Failed:- " + t.getMessage());
            throw t;
        }
    }

    public static void idWriteInputData(final String suite, String LocId,
            String data) throws Throwable {

        if (driver(suite).findElement(By.id(LocId)).getText() != null) {
            try {
                String GetText = driver(suite).findElement(By.id(LocId))
                        .getText();
                driver(suite).findElement(By.id(LocId)).sendKeys(data);
                Reporter.log("Passed:- Successfully Entered data in the " + " "
                        + GetText + " Text Field");
            } catch (Exception e) {
                String GetText = driver(suite).findElement(By.id(LocId))
                        .getText();
                Reporter.log("Failed:- Unable to Entered data in the " + " "
                        + GetText + " Text Field");
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("value") != null) {
            try {
                String GetValueAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("value");
                driver(suite).findElement(By.id(LocId)).sendKeys(data);
                Reporter.log("Passed:- Successfully Entered data in the " + " "
                        + GetValueAttribute + " Text Field");
            } catch (Exception e) {
                String GetValueAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("value");
                Reporter.log("Failed:- Entered data in the " + " "
                        + GetValueAttribute + " Text Field");
            }
        } else if (driver(suite).findElement(By.id(LocId))
                .getAttribute("name") != null) {
            try {
                String GetnameAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("name");
                driver(suite).findElement(By.id(LocId)).sendKeys(data);
                Reporter.log("Passed:- Successfully Entered data in the " + " "
                        + GetnameAttribute + " Text Field");
            } catch (Exception e) {
                String GetnameAttribute = driver(suite)
                        .findElement(By.id(LocId)).getAttribute("name");
                Reporter.log("Failed:- Entered data in the " + " "
                        + GetnameAttribute + " Text Field");
            }
        } else {
            driver(suite).findElement(By.id(LocId)).sendKeys(data);
            Reporter.log("Passed:- Successfully clicked on Button");
        }
    }

    public static void xpathWriteInputData(final String suite, String LocXpath,
            String data) throws Throwable {

        if (driver(suite).findElement(By.xpath(LocXpath)).getText() != null) {
            try {
                String GetText = driver(suite).findElement(By.xpath(LocXpath))
                        .getText();
                driver(suite).findElement(By.xpath(LocXpath)).sendKeys(data);
                Reporter.log("Passed:- Successfully Entered data in the " + " "
                        + GetText + " Text Field");
            } catch (Exception e) {
                String GetText = driver(suite).findElement(By.xpath(LocXpath))
                        .getText();
                Reporter.log("Failed:- Unable to Entered data in the " + " "
                        + GetText + " Text Field");
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("value") != null) {
            try {
                String GetValueAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("value");
                driver(suite).findElement(By.xpath(LocXpath)).sendKeys(data);
                Reporter.log("Passed:- Successfully Entered data in the " + " "
                        + GetValueAttribute + " Text Field");
            } catch (Exception e) {
                String GetValueAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("value");
                Reporter.log("Failed:- Entered data in the " + " "
                        + GetValueAttribute + " Text Field");
            }
        } else if (driver(suite).findElement(By.xpath(LocXpath))
                .getAttribute("name") != null) {
            try {
                String GetnameAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("name");
                driver(suite).findElement(By.xpath(LocXpath)).sendKeys(data);
                Reporter.log("Passed:- Successfully Entered data in the " + " "
                        + GetnameAttribute + " Text Field");
            } catch (Exception e) {
                String GetnameAttribute = driver(suite)
                        .findElement(By.xpath(LocXpath)).getAttribute("name");
                Reporter.log("Failed:- Entered data in the " + " "
                        + GetnameAttribute + " Text Field");
            }
        } else {
            driver(suite).findElement(By.xpath(LocXpath)).sendKeys(data);
            Reporter.log("Passed:- Successfully clicked on Button");
        }
    }

    public static String idGetText(final String suite, String LocId)
            throws Throwable {
        String text = "";
        try {
            text = driver(suite).findElement(By.xpath(LocId)).getText();

        } catch (Exception e) {
            Reporter.log("Failed:-Error while finding: " + LocId);
        }
        return text;
    }
}
