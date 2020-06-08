package basico.pom002;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test99GuruLogin {
    String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver83.exe";
    WebDriver driver;
    Guru99Login objetoLogin;
    Guru99HomePage objHomePage;

    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");

    }

    @Test(priority = 0)

    public void test_Home_Page_Appear_Correct() {
        //Create Login Page object
        objetoLogin = new Guru99Login(driver);
        //Verify login page title
        String loginPageTitle = objetoLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        //login to application
        objetoLogin.loginToGuru99("mgr123", "mgr!23");
        // go the next page
        objHomePage = new Guru99HomePage(driver);
        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();

    }
}
