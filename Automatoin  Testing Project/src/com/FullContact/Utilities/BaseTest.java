package com.FullContact.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




/**
 * @author 
 * 
 */
public class BaseTest {
	

    public static WebDriver driver = null;
    protected static Properties prop = null;
    protected static String propertiesPath1 = TestConstants.OR_DIR + "/FBOR.properties";
    

    @BeforeMethod
    public void browserLaunch() throws Throwable {

    	//System.setProperty("webdriver.chrome.driver", "E:\\automation testing\\chromedriver.exe");     
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "E:\\\\automation testing\\\\chromedriver.exe");
        driver = new ChromeDriver(options);

        final FileInputStream fis1 = new FileInputStream(propertiesPath1);
        prop = new Properties();
        prop.load(fis1);

        final String baseUrl = prop
                .getProperty(TestConstants.TARGET_ENV + ".url");
        Reporter.log("Using application URL " + baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if (null != fis1) {
            fis1.close();
        }
    }


    protected static WebDriver driver(final String suite) {
        return BaseTest.driver;
    }

        @AfterMethod
        public void firefoxBrowserClose(ITestResult testResult) throws Exception {
        	
	             propertiesPath1 = TestConstants.OR_DIR + "/FBOR.properties";
            
            
            if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
        
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String Path = "./Errorscreenshot/" +testResult.getName()+ new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss").format(new GregorianCalendar().getTime()) + ".jpg";
            FileUtils.copyFile(scrFile, new File(Path));
            }
            if (null != driver) {
                driver.close();
//                driver.quit();
            }
            }

    protected static void pause() throws InterruptedException {
        Thread.sleep(TestConstants.PAUSE_MILLIS);
    }

    public static String getValueFromData(final String key) {
        return prop.getProperty(key);
    }
}






