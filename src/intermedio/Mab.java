package intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.util.List;

public class Mab {

    private static String xPathCrome = System.getProperty("user.dir") + "\\drivers\\chromedriver80.exe";
    public static void main(String[] args) throws ParseException, InterruptedException {
        WebDriver wd;
        System.setProperty("webdriver.chrome.driver",xPathCrome);
        wd= new ChromeDriver();
        wd.get("http://demo.guru99.com/test/web-table-element.php");
        wd.manage().window().maximize();
        Thread.sleep(5000);
        //No.of Columns
        List col = wd.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List  rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());
        Thread.sleep(5000);
        wd.close();
    }
}
