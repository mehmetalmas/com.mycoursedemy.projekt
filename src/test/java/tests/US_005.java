package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.ForgotPasswordPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.SignUpPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.time.Duration;

public class US_005 {
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    HeaderComp headerComp = new HeaderComp();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    SoftAssert softAssert = new SoftAssert();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    Faker faker = new Faker();
    public String directoryLogin = "login";
    String user = ConfigReader.getUser("teacher.299.muhammet");
    String password = ConfigReader.getPassword("password.299.muhammet");


    @Test(priority = 1)
    public void test_1_forgotPasswordClickability() {
        Driver.getDriver().get(ConfigReader.getProperty("myUrl") + directoryLogin);
        new CookiesComp().acceptCookies();
        loginPage.forgotPassword.isDisplayed();
        ReusableMethods.bekle(2);
        loginPage.forgotPassword.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qualitydemy.com/home/forgot_password";
        softAssert.assertEquals(actualUrl, expectedUrl);
        softAssert.assertTrue(forgotPasswordPage.TextForgotPassword.isDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void test_2_signUpClickability() {
        headerComp.buttonSignUp.isDisplayed();
        headerComp.buttonSignUp.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qualitydemy.com/sign_up";
        softAssert.assertEquals(actualUrl, expectedUrl);
        softAssert.assertTrue(signUpPage.textSignUpAndStartLearning.isDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_3_welcomeMessageIsDisplayed() throws IOException {
        loginPage.login(user, password);
        String alertText = "";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        ReusableMethods.getScreenshot("US_005 ");
        alertText = signUpPage.toastMessage.getText();
        String expectedNewUserText = "Welcome Test User";
        String actualText = alertText;
        softAssert.assertEquals(actualText, expectedNewUserText, "a green verification" +
                " message appears not in the corner");
        ReusableMethods.bekle(6);
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_4_provideYourValidLoginCredentialsIsDisplayed() throws IOException {
        loginPage.login(user, password);
        ReusableMethods.bekle(6);
        headerComp.logout();
        headerComp.buttonLogin.click();
        loginPage.fieldEmail.sendKeys(faker.internet().emailAddress());
        loginPage.fieldPassword.sendKeys(faker.internet().password());
        loginPage.buttonLogin.click();
        String alertText = "";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        ReusableMethods.getScreenshot("US_005 ");
        alertText = signUpPage.toastMessage.getText();
        String expectedNewUserText = "Invalid login credentials";
        String actualText = alertText;
        softAssert.assertEquals(actualText, expectedNewUserText, "a red verification" +
                " message appears not in the corner");
        loginPage.textProvideYourValidLoginCredentials.isDisplayed();
        softAssert.assertAll();
    }

    @Test(priority = 5, dataProvider = "userDataProvider", dependsOnMethods = "test_4_provideYourValidLoginCredentialsIsDisplayed")
    public void test_5_incorrectEMailFormat(String eMail, String password) {
        loginPage.fieldEmail.sendKeys(eMail);
        loginPage.fieldPassword.sendKeys(password);
        loginPage.buttonLogin.click();
        loginPage.fieldEmail.clear();
        loginPage.fieldPassword.clear();
        Assert.assertTrue(loginPage.buttonLogin.isEnabled());
    }

    @DataProvider
    public static Object[][] userDataProvider() {
        Object[][] eMailAndPassword = {{"", ""}, {"user_1106180login.com", "75462932"},
                {"user_1106180logincom", "7r32wA3"},
                {"user_1106180login", "754kg93A"},
                {"user_1106180logincom", "2c"},
                {"user_1106180@", "24kg93c"}};
        return eMailAndPassword;
    }

    @AfterClass
    public void teardown() {
        ReusableMethods.bekle(5);
        Driver.getDriver().close();
    }
}