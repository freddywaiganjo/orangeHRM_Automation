import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 4/23/2019.
 */
public class TestBase {

    WebDriver webDriver;
    String baseURL;


    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void beforeTest(){
        baseURL = "https://www.orangehrm.com/";
        String driverPath ="C:\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    static WebElement clientURL(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_subdomain"));
    }

    static WebElement clientURLerror(WebDriver driver){
        return driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/fieldset/div[1]/span[2]"));
    }

    static WebElement FirstName(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_FirstName"));
    }

    static WebElement LastName(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_LastName"));
    }

    static WebElement EmailAddress(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_Email"));
    }

    static WebElement JobTitle(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_JobTitle"));
    }

    static WebElement NoOfEmployees(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
    }



    static WebElement CompanyName(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_CompanyName"));
    }

    static WebElement Industry(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_Industry"));
    }

    static WebElement PhoneNumber(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_Contact"));
    }



    static WebElement SetDummyData(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_SetDummyData"));
    }

    static  WebElement SubmitButton(WebDriver driver){
        return driver.findElement(By.id("Form_submitForm_action_request"));
    }

    static  WebElement RobotCheckBox(WebDriver driver){
        return driver.findElement(By.id("recaptcha-anchor-label"));
    }

    static  WebElement PrivacyPolicy(WebDriver driver){
        return driver.findElement(By.linkText("Privacy Policy"));
    }

    static WebElement RegistrationMessage(WebDriver driver){
        return driver.findElement(By.id("tips-messages"));
    }

    @After
    public void afterTest(){
        webDriver.close();

    }



}
