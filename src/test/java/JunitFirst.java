import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class JunitFirst {
    WebDriver driver;

    @BeforeAll
    public void setup(){
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test

    public void getTitle(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        String titleActual=driver.getTitle();
        String titleExpected="Practice webform for learners | Digital Unite";
        Assertions.assertEquals(titleExpected,titleActual);
    }




    @Test
    public void automateRegistrationForm(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("edit-name")).sendKeys("MR Tahmid");
        driver.findElement(By.id("edit-email")).sendKeys("tahmid@gmail.com");
        String phoneNumber="01716122807";
        driver.findElement(By.id("edit-number")).sendKeys(phoneNumber);
        WebElement dateInput = driver.findElement(By.id("edit-date"));
        dateInput.clear();
        dateInput.sendKeys("12/31/2000");
        scroll();
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I am a passionate individual interested in technology and automation.");
        scroll();
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys("F:\\MyJava\\src\\test\\resources/download.jpg");
    }


    public void scroll(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,800)");
    }
    @AfterAll
    public void quitBrowser(){
       // driver.quit();
    }
}
