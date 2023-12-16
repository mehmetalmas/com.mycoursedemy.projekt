package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.sozialenMedien.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_003 {
    pages.mycoursedemy.HomePage homePage = new pages.mycoursedemy.HomePage();
    HomePage szlnHomePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void uS_03_TC_01_socialMediaIconsIsDisplayed() {
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        Assert.assertTrue(homePage.uS_03_buttonFacebookIcon.isDisplayed(), "Facebook icon is not displayed");
        Assert.assertTrue(homePage.uS_03_buttonTwitterkIcon.isDisplayed(), "Twitter icon is not displayed");
        Assert.assertTrue(homePage.uS_03_buttonLinkedinIcon.isDisplayed(), "Linkedin icon is not displayed");
    }

    @Test
    public void uS_03_TC_0002_socialMediaIconsCompanyClick() {

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.clickElementByJS(homePage.uS_03_buttonFacebookIcon);
        ReusableMethods.switchToWindow("Facebook - Giriş Yap veya Kaydol");
        szlnHomePage.FacebookCookies.click();
        Assert.assertTrue(new HomePage().facebookHomePage.isDisplayed());

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.clickElementByJS(homePage.uS_03_buttonTwitterkIcon);
        ReusableMethods.switchToWindow("Facebook - Giriş Yap veya Kaydol");
        Assert.assertTrue(new HomePage().twitterHomePage.isDisplayed());

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.clickElementByJS(homePage.uS_03_buttonLinkedinIcon);
        ReusableMethods.switchToWindow("Entdecken / Twitter");
        Assert.assertTrue(new HomePage().linkedinHomePage.isDisplayed());
    }


    @Test
    public void uS_03_TC_03_theCompanyPagesShouldIsDisplayed() {

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.clickElementByJS(homePage.uS_03_buttonFacebookIcon);
        String expectedFacebookUrl = "https://www.facebook.com/";
        String actualFacebookUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualFacebookUrl, expectedFacebookUrl);

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.clickElementByJS(homePage.uS_03_buttonTwitterkIcon);
        String expectedTwitterUrl = "https://twitter.com/";
        String actualTwitterUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualTwitterUrl, expectedTwitterUrl);

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.clickElementByJS(homePage.uS_03_buttonLinkedinIcon);
        String expectedLinkedinUrl = "https://www.linkedin.com/";
        String actualLinkedinUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualLinkedinUrl, expectedLinkedinUrl);
    }

    @AfterTest
    public void close() {
        ReusableMethods.bekle(3);
        Driver.getDriver().close();
    }



        /*

       TC_01
        - MyCourseDemy anasayfasi'na gidin
        - Facebook icon'unun görünür oldugunu test edin
        - Twitter  icon'unun görünür oldugunu test edin
        - LinkedIn  icon'unun görünür oldugunu test edin

       TC_0002
        - MyCourseDemy anasayfasi'na gidin
        - Facebook icon'unun tiklanabilir oldugunu test edin
        - Twitter  icon'unun tiklanabilir oldugunu test edin
        - LinkedIn  icon'unun tiklanabilir oldugunu test edin

        TC_03
        - Firmanin Sosyal Medya hesaplari olmadigindan test edilemedi
        - MyCourseDemy anasayfasi'na gidin
        - Facebook icon'unu tiklayin
        - Facebook sayfasinin acildigini test edin
        - Twitter icon'unu tiklayin
        - Twitter sayfasinin acildigini test edin
        - LinkedIn icon'unu tiklayin
        - LinkedIn sayfasinin acildigini test edin"

         */

}
