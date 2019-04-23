import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Alex on 4/23/2019.
 */
public class RegistrationTest extends TestBase {


//empty and invalid url results to the same message. so only one testcase to implement here
    @Test
    public void emptyClientURL() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        assertTrue(webDriver.getCurrentUrl().endsWith("orangehrm-30-day-trial/"));
        String expectedError = "You must supply a valid URL.";
        System.out.println("clientURLerror: " +clientURLerror(webDriver).getText());
        assertEquals(String.valueOf(clientURLerror(webDriver).getText()),expectedError);
//        collector.checkThat(String.valueOf(clientURLerror(webDriver).getText()),equalTo(expectedError));


    }

//tests valid url and empty firstname
    @Test
    public void validClientUrl() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        String expectedMessage = "Requested name is available.";
        System.out.println("clientURLerror: " +clientURLerror(webDriver).getText());
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        assertEquals(String.valueOf(clientURLerror(webDriver).getText()),expectedMessage);
        assertEquals(String.valueOf(clientURLerror(webDriver).getText()),expectedMessage);
        if(FirstName(webDriver).equals(webDriver.switchTo().activeElement())==true){
           System.out.println("URL successfully validated");
       }else
           fail();
    }



    @Test
    public void validFirstName() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        FirstName(webDriver).sendKeys("alex");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(LastName(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("FirstName successfully validated");
        }else
            fail();
    }


    @Test
    public void validLastName() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(JobTitle(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("LastNam successfully validated");
        }else
            fail();
    }



    @Test
    public void JobTitle() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        JobTitle(webDriver).sendKeys("Quality Assurance");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(EmailAddress(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("JobTitle and email check for null successfully validated");
        }else
            fail();
    }

    @Test
    public void invalidEmail() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(EmailAddress(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("Email must have @ and data after");
        }else
            fail();
    }

    @Test
    public void validEmailAddress() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex@gmail.com");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(CompanyName(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("Email successfully validated");
        }else
            fail();
    }

    @Test
    public void validCompany() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex@gmail.com");
        CompanyName(webDriver).sendKeys("alexcompany");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(NoOfEmployees(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("Company successfully validated");
        }else
            fail();
    }

    @Test
    public void selectedNoOfEmployees() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex@gmail.com");
        CompanyName(webDriver).sendKeys("alexcompany");
        Select NoOfEmployees = new Select(webDriver.findElement(By.id("Form_submitForm_NoOfEmployees")));
        NoOfEmployees.selectByVisibleText("11 - 15");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if(PhoneNumber(webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("No of Employees successfully validated");
        }else
            fail();
    }

    @Test
    public void validPhoneNo() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex@gmail.com");
        CompanyName(webDriver).sendKeys("alexcompany");
        Select NoOfEmployees = new Select(webDriver.findElement(By.id("Form_submitForm_NoOfEmployees")));
        NoOfEmployees.selectByVisibleText("11 - 15");
        PhoneNumber(webDriver).sendKeys("0722334455");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        if (Industry (webDriver).equals(webDriver.switchTo().activeElement())==true){
            System.out.println("Phone Number successfully validated");
        }else
            fail();
    }

    @Test
    public void validJobTitle() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex@gmail.com");
        CompanyName(webDriver).sendKeys("alexcompany");
        Select NoOfEmployees = new Select(webDriver.findElement(By.id("Form_submitForm_NoOfEmployees")));
        NoOfEmployees.selectByVisibleText("11 - 15");
        PhoneNumber(webDriver).sendKeys("0722334455");
        Select Country = new Select(webDriver.findElement(By.id("Form_submitForm_Country")));
        Country.selectByVisibleText("Kenya");

        RegistrationMessage(webDriver).getText();
        String registrationSuccess = "Failed to validate recaptcha.";
        collector.checkThat(RegistrationMessage(webDriver).getText(),equalTo(registrationSuccess));
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        SubmitButton(webDriver).click();
        System.out.println("######Country successfully validated");
    }

    //This is an overall positive test and an account should be created here
    @Test
    public void allValidFormData() throws Exception{
        webDriver.get(baseURL+"orangehrm-30-day-trial/");
        Thread.sleep(3000);
        clientURL(webDriver).sendKeys("alextesturl");
        FirstName(webDriver).sendKeys("alex");
        LastName(webDriver).sendKeys("waiganjo");
        EmailAddress(webDriver).sendKeys("alex@gmail.com");
        JobTitle(webDriver).sendKeys("Quality Assurance");
        Select NoOfEmployees = new Select(webDriver.findElement(By.id("Form_submitForm_NoOfEmployees")));
        NoOfEmployees.selectByVisibleText("11 - 15");
        CompanyName(webDriver).sendKeys("alexcompany");
        Select Industry = new Select(webDriver.findElement(By.id("Form_submitForm_Industry")));
        Industry.selectByVisibleText("Automotive");
        PhoneNumber(webDriver).sendKeys("0722445577");

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,300)");

        Select Country = new Select(webDriver.findElement(By.id("Form_submitForm_Country")));
        Country.selectByVisibleText("Kenya");

        //Manual intervention for 'I am not a robot is required thus more thread sleep time is required
//        RobotCheckBox(webDriver).click();
        Thread.sleep(10000);
        SubmitButton(webDriver).click();
        Thread.sleep(5000);
        RegistrationMessage(webDriver).getText();
        String registrationSuccess = "We have successfully received your request and we will get back to you shortly.";
        collector.checkThat(RegistrationMessage(webDriver).getText(),equalTo(registrationSuccess));
    }




}
