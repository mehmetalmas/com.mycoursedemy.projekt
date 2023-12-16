package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.MyWishListPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_011 {
    HeaderComp headerComp = new HeaderComp();
    LoginPage loginPage = new LoginPage();
    SoftAssert softAssert = new SoftAssert();
    MyWishListPage myWishListPage = new MyWishListPage();
    String user = ConfigReader.getUser("student.350.muhammet");
    String password = ConfigReader.getPassword("password.350.muhammet");

    @BeforeMethod
    public void beforeMethod() {
        loginPage.login(user, password);
        ReusableMethods.bekle(6);
        ReusableMethods.hover(headerComp.iconWishList);
        headerComp.dropDownGoToWishList.click();
    }

    @Test(priority = 1)
    public void test_1_myWishListClickability() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qualitydemy.com/home/my_wishlist";
        softAssert.assertEquals(actualUrl, expectedUrl);
        softAssert.assertTrue(myWishListPage.textMyList.isDisplayed());
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void test_2_compareIsEnabled() throws IOException {
        myWishListPage.buttonCompare.sendKeys(Keys.PAGE_DOWN);
        myWishListPage.buttonCompare.click();
        ReusableMethods.bekle(3);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qualitydemy.com/home/compare";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        Select select1 = new Select(myWishListPage.dropDownMyWishList_1);
        select1.selectByVisibleText("English Speaking Course");
        Select select2 = new Select(myWishListPage.dropDownMyWishList_2);
        select2.selectByVisibleText("Java");
        Select select3 = new Select(myWishListPage.dropDownMyWishList_3);
        select3.selectByVisibleText("Qa Kursu");
        ReusableMethods.getScreenshot("US_011 ");
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_3_courseSelected() {
        myWishListPage.searchMyWishList.sendKeys("Web Design for PHP");
        ReusableMethods.bekle(2);
        softAssert.assertTrue(myWishListPage.webDesignForPHP.isEnabled());
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_4_courseNameClickability() {
        myWishListPage.buttonCompare.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(1);
        myWishListPage.webDesignForPHP.click();
        ReusableMethods.bekle(2);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qualitydemy.com/home/course/web-design-for-php/1";
        softAssert.assertEquals(actualUrl, expectedUrl, "failed");
        softAssert.assertAll();
    }

    @AfterClass
    public void teardown() {
        ReusableMethods.bekle(5);
        Driver.getDriver().close();
    }
}