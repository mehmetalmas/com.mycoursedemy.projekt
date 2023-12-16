package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_001 {

    HeaderComp headerComp = new HeaderComp();
    HomePage homePage = new HomePage();

    String email = ConfigReader.getUser("student.348.selman");
    String password = ConfigReader.getPassword("password.348.selman");
    LoginPage loginPage = new LoginPage();

    @Test
    public void Test01() {
        //Home Page is accessible as a user

        loginPage.login(email, password);

        Assert.assertTrue(headerComp.buttonMyCourses.isDisplayed());
    }

    @Test
    public void Test02() {
        //https://qualitydemy.com/home

        String expectedUrl = ("https://qualitydemy.com/home");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void Test03() {
        //The home page must be accessible when the URL is entered

        String expectedText = ("Learn on your schedule and get ahead in life with qualitydemy!");
        String actualText = homePage.homepageText.getText();

        Assert.assertEquals(actualText, expectedText);
    }
    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }
}