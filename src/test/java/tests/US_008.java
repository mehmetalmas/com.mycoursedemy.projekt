package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.ForgotPasswordPage;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.SignUpPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.time.Duration;


public class US_008 {

    //Email should be able to get entered on the forgot_password page and
    //the functions of the page must work correctly
    // 1- There must be an @ sign in the email.
    // 2- a valid email
    // 3- Clicking on the login link should redirect to the login page

    ForgotPasswordPage forgotPasswordPage= new ForgotPasswordPage();
    HeaderComp headerComp= new HeaderComp();
    SoftAssert softAssert= new SoftAssert();
    HomePage homePage= new HomePage();
    LoginPage loginPage = new LoginPage();
    Faker faker= new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    SignUpPage signUpPage= new SignUpPage();

    public String email=ConfigReader.getUser("student.349.bicer");
    public String directoryLogin = "/home/forgot_password";

    public String directory = "login";

    @BeforeTest
    public void beforeTest() {
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void test01(){
        // 1- There must be an @ sign in the email.
        homePage.buttonLogin.click();
        new CookiesComp().acceptCookies();
        loginPage.buttonForgotPassword.click();

        String expectedMail="@";
        String actualMail= faker.internet().emailAddress();

        forgotPasswordPage.fieldsMailForgotPassword.sendKeys(actualMail);
        softAssert.assertTrue(actualMail.contains(expectedMail),"Girilen mail @ içermektedir.");
        softAssert.assertAll();
    }
    @Test
    public void test02() throws IOException {
        // 2- a valid email.
        Driver.getDriver().get(ConfigReader.getProperty("myUrl")+directoryLogin);
        forgotPasswordPage.fieldsMailForgotPassword.sendKeys(email);
        forgotPasswordPage.buttonSendRequest.click();
        String alertText = "";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        ReusableMethods.getScreenshot("US_008 ");
        alertText = signUpPage.toastMessage.getText();
        String expectedNewUserText = "Check your inbox for the request";
        String actualText = alertText;
        softAssert.assertEquals(actualText, expectedNewUserText, "The mail is valid mail");
        softAssert.assertAll();
    }

    @Test
    public void test03(){
        // 3- Clicking on the login link should redirect to the login page.
        Driver.getDriver().get(ConfigReader.getProperty("myUrl")+directoryLogin);
        forgotPasswordPage.buttonLoginForgotPassword.click();
        ReusableMethods.bekle(2);
        String expectedUrl = ConfigReader.getProperty("myUrl") + directory;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        softAssert.assertEquals(actualUrl,expectedUrl,"This page is login page");
        softAssert.assertAll();
    }
}
