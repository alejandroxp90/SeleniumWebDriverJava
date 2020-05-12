package reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class  BaseClass {

    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";


    /**** Método que regresa el objeto WebDriver ****/
    public static WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    /****** Método para crear screenShots cuando exista algun error ******/

    public static void takeScreenShot(WebDriver driver, String fileWithPath) throws IOException {
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(scrFile, destFile);
    }

    /********Método donde reporte PDF será enviado por email*********/

    public void sendPdfReportByEmail(String from, String pass, String to, String subject, String body){
        Properties props = System.getProperties();
        String host = "smtp.live.com";
        props.put("mail.smtp.starttls.enable","true");
        //props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user",from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587"); //Los puertos pueden ser 25, 465, 587
        props.put("mail.smtp.auth", "true"); //checar smt por smtp
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        /**** Se manda mensaje con message *****/
        try {
            message.setFrom(new InternetAddress(from));// Se manda llamar el objeto message (destinatario)
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));//dirigido (a)

            message.setSubject(subject);//Marcamos el asunto
            message.setText(body);//MArcamos el cuerpo del mail
            BodyPart objMessageBodyPart = new MimeBodyPart();
            objMessageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(objMessageBodyPart);//a multipart agregamos el objeto
            objMessageBodyPart = new MimeBodyPart();

            //Creamos una variable String para guardar el nombre del archivo que se va a generar
            String fileName = System.getProperty("user.dir") + "\\SeleniumIntermedio.pdf";
            //Ahora se crea un objeto de tipo dataSource para hacer un attachment del PDF
            DataSource source = new FileDataSource(fileName);
            //Al objeto bodyPart hay que hacerle un DataHandler
            objMessageBodyPart.setDataHandler(new DataHandler(source));
            //Se agrega el fileName
            objMessageBodyPart.setFileName(fileName);
            //Y eso se agrega al objeto multiPart
            multipart.addBodyPart(objMessageBodyPart);
            //Se debe unir para que el mail se envie
            message.setContent(multipart);
            //Se crea un objeto de tipo transport
            Transport transport = session.getTransport("smtp");
            //Se conecta el host con la cuenta de donde se enviara el correo
            transport.connect(host, from, pass);
            //Se envia el mensaje
            transport.sendMessage(message, message.getAllRecipients());
            //Se cierra la conexion
            transport.close();
        }catch (AddressException ae){//Error de direccion de correo
            System.err.println("Problema con la direccion de correo " + ae.getMessage());

        } catch (MessagingException e) {//Error con la comunicacion
            System.err.println("Error de comunicacion SMTP, checar... puerto " + e.getMessage());
        }
    }
}
