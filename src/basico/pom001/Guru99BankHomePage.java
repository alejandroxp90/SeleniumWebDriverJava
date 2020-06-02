package basico.pom001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Guru99BankHomePage {
    WebDriver driver;
    By email = By.name("emailid");
    By btnSubmit = By.name("btnLogin");
    By userID = By.cssSelector("body > table > tbody > tr:nth-child(4) > td:nth-child(2)");
    By passUserID = By.cssSelector("body > table > tbody > tr:nth-child(5) > td:nth-child(2)");
    By usuarioIDText = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
    String varUserID, varPassID;

    public Guru99BankHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendEmail(){
        driver.findElement(email).sendKeys("alexdf08@hotmail.com");
        System.out.println("El correo ingresado es: " + driver.findElement(email).getAttribute("value"));
    }

    public void setBtnSubmit(){
        driver.findElement(btnSubmit).click();
    }

    public void getTitleHomePage(){
        varUserID = driver.findElement(userID).getText();
        varPassID = driver.findElement(passUserID).getText();
        System.out.println("userID: " + varUserID);
        System.out.println("pass: " + varPassID);
    }

    public void accessDemoSite() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://demo.guru99.com/V4/");
        driver.findElement(userID).sendKeys(varUserID);
        driver.findElement(passUserID).sendKeys(varPassID);
        Thread.sleep(5000);
        driver.findElement(btnSubmit).click();
        String welcomeUser = driver.findElement(usuarioIDText).getText();
        System.out.println("El texto obtenido es: " + welcomeUser);

    }




}
