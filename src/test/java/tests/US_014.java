package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.MyCoursesPage;
import pages.mycoursedemy.PurchaseHistoryPage;
import pages.mycoursedemy.SignUpPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_014 {

    @BeforeMethod
    public void beforeMethod() {

        LoginPage loginPage = new LoginPage();
        String userEmail = ConfigReader.getUser("student.342.esra");
        String userPassword = ConfigReader.getPassword("password.342.esra");
        loginPage.login(userEmail, userPassword);
        ReusableMethods.bekle(5);
        HeaderComp headerComp = new HeaderComp();
        PurchaseHistoryPage purchaseHistoryPage = headerComp.goToPurchaseHistory();

    }

    @Test
    public void test01_invoiceButton() throws InterruptedException {

        PurchaseHistoryPage purchaseHistoryPage = new PurchaseHistoryPage();
        purchaseHistoryPage.goToInvoicePage();

        SoftAssert softAssert = new SoftAssert();
        String actualResult = Driver.getDriver().getTitle();
        String expectedResult = purchaseHistoryPage.title;
        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();

    }

    @Test
    public void test02_courseName() {

        PurchaseHistoryPage purchaseHistoryPage = new PurchaseHistoryPage();
        String actualResult = purchaseHistoryPage.fieldCourseTitle.getText();

        ReusableMethods.waitForVisibility(purchaseHistoryPage.fieldCourseTitle, 5);
        purchaseHistoryPage.fieldCourseTitle.click();
        String courseTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(courseTitle.contains(actualResult));
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        ReusableMethods.bekle(2);
        HeaderComp headerComp = new HeaderComp();
        headerComp.logout();
    }

    @AfterClass
    public void afterClass() {
        Driver.getDriver().close();

    }


}
