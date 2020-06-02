package basico.pom001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestGuru99 {

    private WebDriver driver;
    private String xPath = System.getProperty("user.dir") + "\\drivers\\chromedriver83.exe";
    private String baseURL = "http://demo.guru99.com/";
    Guru99BankHomePage objEmailID;



    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", xPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);

    }
    @Test
    public void testPrincipal() throws InterruptedException {
        objEmailID = new Guru99BankHomePage(driver);
        objEmailID.sendEmail();
        objEmailID.setBtnSubmit();
        objEmailID.getTitleHomePage();
        objEmailID.accessDemoSite();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }



}
