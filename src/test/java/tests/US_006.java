package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.SignUpPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_006 {
    String expectedText;
    String actualText;
    String expectedUrl = ConfigReader.getProperty("signUpVerificationUrl");
    String actualUrl = Driver.getDriver().getCurrentUrl();

    @Test
    public void TC_0001_TestNewRegister() throws InterruptedException, IOException {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        HeaderComp headerComp = new HeaderComp();
        SoftAssert softassert = new SoftAssert();
        headerComp.buttonSignUp.click();
        new CookiesComp().acceptCookies();
        headerComp.buttonSignUp.click();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldPassword.sendKeys(ConfigReader.getProperty("password"));
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldEmail.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.buttonNewSignUp.click();
        softassert.assertTrue(signUpPage.verificationPage.isDisplayed(), "Although the user has entered the correct values," +
                "verification page does not appear");
        ReusableMethods.bekle(3);
        String alertText = "";
        alertText = signUpPage.toastMessage.getText();
        String expectedNewUserText = ConfigReader.getProperty("signUpNewUserText");
        actualText = alertText;
        softassert.assertEquals(actualText, expectedNewUserText, "a green verification" +
                " message appears not in the corner");
        softassert.assertAll();

    }

    @Test
    public void TC_0002_LoginPage() {
        HeaderComp headerComp = new HeaderComp();
        SoftAssert softassert = new SoftAssert();
        new CookiesComp().acceptCookies();
        headerComp.buttonLogin.click();
        ReusableMethods.bekle(2);
        expectedText = Driver.getDriver().findElement(By.xpath("//*[text()='Provide your valid login credentials']")).getText();
        actualText = ConfigReader.getProperty("isLoginPage");
        softassert.assertEquals(actualText, expectedText, "the user cannot reach Login Page");
        softassert.assertAll();

    }

    @Test
    public void Tc_0003_NegativesForFieldFirstAndLastName() {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        HeaderComp headerComp = new HeaderComp();
        SoftAssert softassert = new SoftAssert();
        headerComp.buttonSignUp.click();
        signUpPage.fieldFirstName.sendKeys("a");
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldPassword.sendKeys(faker.internet().password());
        signUpPage.fieldPassword.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.buttonNewSignUp.click();

        softassert.assertNotEquals(actualUrl, expectedUrl, "when First Name field is filled" +
                " with less than 2 letters, user can reach verification page.");
        Driver.getDriver().navigate().refresh();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys("a");
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldPassword.sendKeys(faker.internet().password());
        signUpPage.fieldPassword.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.buttonNewSignUp.click();
        softassert.assertNotEquals(actualUrl, expectedUrl, "when Last Name field is filled" +
                "with less than 2 letters, user can reach verification page.");
        softassert.assertAll();

    }


    @Test
    public void Tc_0004_NegativesForPassword1() {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        HeaderComp headerComp = new HeaderComp();
        SoftAssert softassert = new SoftAssert();
        headerComp.buttonSignUp.click();
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldPassword.sendKeys("1*23");
        new CookiesComp().acceptCookies();
        signUpPage.fieldEmail.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.buttonNewSignUp.click();
        softassert.assertNotEquals(actualUrl, expectedUrl, "when password field is filled" +
                " without Uppercase, user can reach verification page.");

        Driver.getDriver().navigate().back();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldPassword.sendKeys("1*23");
        signUpPage.fieldFirstName.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.clickElementByJS(signUpPage.buttonNewSignUp);
        softassert.assertNotEquals(actualUrl, expectedUrl, "when password field is filled" +
                " without Lowercase, user can reach verification page.");

        Driver.getDriver().navigate().refresh();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldPassword.sendKeys("withoutNumbers,");
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        ReusableMethods.clickElementByJS(signUpPage.buttonNewSignUp);
        softassert.assertNotEquals(actualUrl, expectedUrl, "when password field is filled" +
                " without Numbers, user can reach verification page.");

        Driver.getDriver().navigate().back();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        signUpPage.fieldPassword.sendKeys("withoutCharacters");
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 10);
        ReusableMethods.clickElementByJS(signUpPage.buttonNewSignUp);
        softassert.assertNotEquals(actualUrl, expectedUrl, "when password field is filled" +
                " without characters, user can reach verification page.");
        softassert.assertAll();

    }


    @Test
    public void Tc_0005_NegativeForFieldEmail() {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        HeaderComp headerComp = new HeaderComp();
        SoftAssert softassert = new SoftAssert();
        headerComp.buttonSignUp.click();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldEmail.sendKeys("withoutatgmail.com");
        signUpPage.fieldPassword.sendKeys(faker.internet().password());
        signUpPage.fieldPassword.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.buttonNewSignUp.click();
        softassert.assertNotEquals(actualUrl, expectedUrl, "when Email field is not filled with " +
                "@ sign, the User is not succesfully registered");
        softassert.assertAll();

    }

    @Test
    public void Tc_0006_RegisteredMail() throws IOException {
        SignUpPage signUpPage = new SignUpPage();
        Faker faker = new Faker();
        HeaderComp headerComp = new HeaderComp();
        SoftAssert softassert = new SoftAssert();
        headerComp.buttonSignUp.click();
        signUpPage.fieldFirstName.sendKeys(faker.name().firstName());
        signUpPage.fieldLastName.sendKeys(faker.name().lastName());
        signUpPage.fieldPassword.sendKeys("registeredMail1,");
        signUpPage.fieldEmail.sendKeys("registeredMail@gmail.com");
        signUpPage.fieldEmail.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitForClickablility(signUpPage.buttonNewSignUp, 30);
        signUpPage.buttonNewSignUp.click();
        String expectedAlreadyUserText = ConfigReader.getProperty("signUpAlreadyRegistered");
        String actualAlreadyText = signUpPage.alreadyRegistered.getText();
        softassert.assertEquals(actualAlreadyText, expectedAlreadyUserText, "When already registered User"
                + "is sign up, a red warning message appears not in the corner");
        softassert.assertAll();
    }


    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
    }

}





