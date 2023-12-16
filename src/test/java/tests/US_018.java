package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class US_018 {


    @BeforeMethod
    public void beforeMethod() {

        String userEmail = ConfigReader.getUser("teacher.291.esra");
        String userPassword = ConfigReader.getPassword("password.291.esra");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userEmail, userPassword);
        HeaderComp headerComp = new HeaderComp();
        headerComp.buttonInstructor.click();

    }

    @Test
    public void test01_numberOfCourses() {

        InstructorPage instructorPage = new InstructorPage();
        instructorPage.numberOfCourses.click();

        SoftAssert softAssert = new SoftAssert();
        String actualResult = Driver.getDriver().getCurrentUrl();
        String expectedResult = ConfigReader.getProperty("userCoursesUrl");
        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();

    }

    @Test
    public void test02_numberOfEnrolment() {

        InstructorPage instructorPage = new InstructorPage();
        instructorPage.numberOfEnrolment.click();

        SoftAssert softAssert = new SoftAssert();
        String actualResult = Driver.getDriver().getCurrentUrl();
        String expectedResult = ConfigReader.getProperty("salesReportUrl");
        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();

    }


    @Test
    public void test03_pendingBalance() {

        InstructorPage instructorPage = new InstructorPage();
        instructorPage.pendingBalance.click();

        SoftAssert softAssert = new SoftAssert();
        String actualResult = Driver.getDriver().getCurrentUrl();
        String expectedResult = ConfigReader.getProperty("payoutReportUrl");
        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();

    }

    @Test
    public void test04_requestedWithdrawalAmount() {

        InstructorPage instructorPage = new InstructorPage();
        instructorPage.requestedWithdrawalAmount.click();

        SoftAssert softAssert = new SoftAssert();
        String actualResult = Driver.getDriver().getCurrentUrl();
        String expectedResult = ConfigReader.getProperty("payoutReportUrl");

        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();

    }

    @AfterMethod
    public void afterMethod() {

        InstructorPage instructorPage = new InstructorPage();
        instructorPage.testUserInstructorLogout();


    }

    @AfterClass
    public void afterClass() {

        Driver.getDriver().close();
    }

}
