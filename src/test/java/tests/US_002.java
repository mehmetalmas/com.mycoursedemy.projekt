package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.AboutUsPage;
import pages.mycoursedemy.CoursesPage;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_002 {
    //Logo,Categories,shopping cart icon,Search icon,Search button,"x+1" Online courses text,
    // Expert instruction text, Lifetime access text, Top categories text,Top courses text, Top 10 Latest courses text,
    // Featured instructor text ,Get started button,Join now button, facebook icon, twitter icon, should be visible

    HeaderComp headerComp = new HeaderComp();
    HomePage homePage = new HomePage();

    String email = ConfigReader.getUser("student.348.selman");
    String password = ConfigReader.getPassword("password.348.selman");
    LoginPage loginPage = new LoginPage();

    AboutUsPage aboutUsPage=new AboutUsPage();

    @Test
    public void Test01() {
        //Home Page

        loginPage.login(email, password);

        //Logo
        Assert.assertTrue(headerComp.logo.isDisplayed());

        //Categories
        Assert.assertTrue(headerComp.dropDownCategories.isDisplayed());

        //shopping cart icon
        Assert.assertTrue(headerComp.buttonCart.isDisplayed());

        //Search icon
        Assert.assertTrue(headerComp.fieldSearchBox.isDisplayed());

        //Search button
        Assert.assertTrue(headerComp.buttonSearchBox.isDisplayed());

        //"x+1" Online courses text
        Assert.assertTrue(homePage.buttonOnlineCoursesText.isDisplayed());

        //Expert instruction text
        Assert.assertTrue(homePage.buttonExpertInstructionText.isDisplayed());

        // Lifetime access text
        Assert.assertTrue(homePage.buttonLifetimeAccessText.isDisplayed());

        //Top categories text
        Assert.assertTrue(homePage.headerTopCategoriesText.isDisplayed());

        //Top courses text
        Assert.assertTrue(homePage.headerTopCoursesText.isDisplayed());

        //Top 10 Latest courses text
        Assert.assertTrue(homePage.headerTop10LatestCoursesText.isDisplayed());

        //Featured instructor text
        Assert.assertTrue(homePage.headerFeaturedInstructorText.isDisplayed());

        //Get started button
        Assert.assertTrue(homePage.buttonGetStarted.isDisplayed());

        //Join now button
        Assert.assertTrue(homePage.buttonJoinBecomeNewinstructor.isDisplayed());

        //facebook icon
        //Assert.assertTrue(homePage.buttonFacebookIcon.isDisplayed());

        // twitter icon
        //Assert.assertTrue(homePage.buttonTwitterkIcon.isDisplayed());
    }

    @Test
    public void Test02() {

        //About Us should be clickable
        //ReusableMethods.clickElementByJS(homePage.buttonHelpAboutUs);
        Assert.assertTrue(aboutUsPage.AboutUsPageBreadcrumbLink.isDisplayed());
    }
    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }

}