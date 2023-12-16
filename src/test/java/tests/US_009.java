package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.ShoppingCartPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_009 {
    //The functions of the shopping_cart page should work correctly
    LoginPage loginPage = new LoginPage();
    String user = ConfigReader.getUser("student.345.ilhan");
    String password = ConfigReader.getPassword("password.345.ilhan");
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void login() {
        loginPage.login(user, password);
        addCourseToCart("Wordpress");
        addCourseToCart("English Course Learn To Speak");
        shoppingCartPage.shoppingCartButton.click();
    }

    @AfterClass
    public static void tearDown() {

        Driver.closeDriver();
    }

    @Test
    public void TC_0001() throws IOException {
        //The course in the cart should be able to get deleted from the remove link
        shoppingCartPage.removeButonu.click();
        softAssert.assertFalse(shoppingCartPage.wordPresKursu.isSelected());
        softAssert.assertAll();

    }

    @Test
    public void TC_0002() {
        //When a valid coupon code is entered and applied, the discount should be shown in the price.
        shoppingCartPage.fieldApplyCoupon.sendKeys("PERCENT50");
        shoppingCartPage.applyButonu.click();
        softAssert.assertTrue(shoppingCartPage.indirimOraniElementi.isDisplayed());
        softAssert.assertAll();

    }

    @Test
    public void TC_0003() {
        //  When an invalid coupon code is entered and applied, the price should not change.
        shoppingCartPage.fieldApplyCoupon.sendKeys("PERCENT55");
        shoppingCartPage.applyButonu.click();
        softAssert.assertEquals(shoppingCartPage.indirimsizTotalFiyat, shoppingCartPage.indirimliTotalFiyat);
        softAssert.assertAll();

    }

    @Test
    public void TC_0004() {
        //  When the checkout button is pressed, it should redirect to the payment page
        shoppingCartPage.buttonCheckout.click();
        Assert.assertTrue(shoppingCartPage.butonÖdemeStripe.isDisplayed());

    }

    public void addCourseToCart(String courseName) {
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='query']"));
        searchBox.sendKeys("English" + Keys.ENTER);
        ReusableMethods.bekle(4);
        WebElement cours = Driver.getDriver().findElement(By.xpath("//a[text()='" + courseName + "']"));
        ReusableMethods.clickElementByJS(cours);
        Driver.getDriver().findElement(By.xpath("//button[text()='Add to Cart']")).click();
        Driver.getDriver().navigate().back();
        WebElement searchBox1 = Driver.getDriver().findElement(By.xpath("//input[@name='query']"));
        searchBox1.clear();
    }
}