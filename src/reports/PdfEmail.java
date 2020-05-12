package reports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Clase que utiliza JyperionListener para generar PDF y ScreenShots
@Listeners(JyperionListener.class)
public class PdfEmail extends BaseClass {

    //Cuenta de correo electronico titaniumsoltest@gmail.com
    WebDriver driver = getDriver();

    @Test
    public void TestOne(){
        driver.get("https://www.google.com.mx");
        Assert.assertTrue(false);
    }
    @Test
    public void TestTwo(){
        driver.get("https://www.facebook.com");
        Assert.assertTrue(true);
    }

    @Test
    public void testThree(){
        driver.get("https://titaniumsolutions.org/");
        Assert.assertTrue(false);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @AfterSuite
    public void sendEmail(){
        sendPdfReportByEmail("alexdf08@hotmail.com","juhaa20061911", "alexdf08@hotmail.com", "Alex PDF Report", "Incorporar el Attachment...!!");
        System.out.println("Email enviado... check your email!");
    }
}
