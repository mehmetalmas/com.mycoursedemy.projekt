package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.ShoppingCartPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_015 {
    // The functions of the user_profile page should work correctly
    LoginPage loginPage=new LoginPage();
    String user = ConfigReader.getUser("student.345.ilhan");
    String password = ConfigReader.getPassword("password.345.ilhan");
    Actions actions=new Actions(Driver.getDriver());
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    SoftAssert softAssert=new SoftAssert();


    @Test
    public void TC0001(){
        // First name,Last name,Title,Your skills,Biography,Add your twitter link,
        // Add your facebook linkAdd your linkedin link texts should be able to get entered
        loginPage.login(user,password);
        ReusableMethods.bekle(6);
        actions.moveToElement(shoppingCartPage.homePageDropDown).click(shoppingCartPage.userProfileDropDown).perform();
        shoppingCartPage.firstNameKutusu.clear();
        shoppingCartPage.firstNameKutusu.sendKeys("Ilhan");
        shoppingCartPage.lastNameKutusu.clear();
        shoppingCartPage.lastNameKutusu.sendKeys("Sahin");
        Driver.getDriver().switchTo().frame(shoppingCartPage.iframeBiografiKutusu);
        shoppingCartPage.iframeYaziKutusu.sendKeys("Ben türkiyede dogdum");
        Driver.getDriver().switchTo().defaultContent();
        shoppingCartPage.twitterLinkKutusu.clear();
        shoppingCartPage.twitterLinkKutusu.sendKeys("ilhan@gmail.com");
        shoppingCartPage.facebookLinkKutusu.clear();
        shoppingCartPage.facebookLinkKutusu.sendKeys("ilhan@gmail.com");
        shoppingCartPage.linkedinLinkKutusu.clear();
        shoppingCartPage.linkedinLinkKutusu.sendKeys("ilhan@gmail.com");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        //When the "save button" is pressed after the changes made, the changes should be saved.
        shoppingCartPage.saveButonu.click();
        // profile button should redirect to user profile page
        shoppingCartPage.profilButonu.click();

        String expectetUrl="https://qualitydemy.com/home/profile/user_profile";  //profil sayfasi Url'si
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectetUrl);
        softAssert.assertAll();
    }
    @AfterClass
    public static void tearDown(){
       Driver.closeDriver();
    }
}
