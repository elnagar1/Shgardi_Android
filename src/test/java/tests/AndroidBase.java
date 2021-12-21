package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import utilities.Helper;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBase {
    public static AndroidDriver driver ;

    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";



         @BeforeTest
        public void startDriver( ) throws MalformedURLException {

            DesiredCapabilities caps = new DesiredCapabilities(); // creating an object

            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
            //caps.setCapability("appPackage", "com.mnasat.nashmi");
            caps.setCapability(MobileCapabilityType.APP, "C:/Users/Lenovo/Downloads/Shgardi/src/main/java/Apk/shgardi_User_v1.84.apk");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        }


    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }


}
