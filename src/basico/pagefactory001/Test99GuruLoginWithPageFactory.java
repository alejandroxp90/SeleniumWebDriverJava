package basico.pagefactory001;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import basico.pagefactory001.Guru99HomePagePF;
import basico.pagefactory001.Guru99LoginPF;

public class Test99GuruLoginWithPageFactory {
    String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver83.exe";

    WebDriver driver;

    Guru99LoginPF objLogin;
    Guru99HomePagePF objHomePage;

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");

    }

    /*** This test go to http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message**/

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
        //Create Login Page object
        objLogin = new Guru99LoginPF(driver);
        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        //login to application
        objLogin.loginToGuru99("mgr123", "mgr!23");
        // go the next page
        objHomePage = new Guru99HomePagePF(driver);
        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
}
