package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.CoursesPage;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.component.CookiesComp;
import utilities.Driver;

public class US_004 {
    /*TC_0001
    -Go to url “https://www.qualitydemy.com/”
    -"Top categories" under the heading; Verify that ‘Web Design for Web Developers’ is visible as a subheading
    -Click on icon of ‘Web Design for Web Developers’ subheading
    -After clicking, check that the redirected Web Design for Web Developers-related webpages is visible
    -Go back to the home page.
    -"Top categories" under the heading; Verify that 'English Speaking Course’ is visible as a subheading
    -Click on icon of ‘English Speaking Course’ subheading
    -After clicking, check that the redirected English Speaking Course-related webpages is visible
    -Go back to the home page.
    -"Top categories" under the heading; Verify that 'Piano’ is visible as a subheading
    -Click on icon of ‘Piano’ subheading
    -After clicking, check that the redirected Piano Course-related webpages is visible
    -Go back to the home page.
    -"Top categories" under the heading; Verify that 'Disney Magic English’ is visible as a subheading
    -Click on icon of ‘Disney Magic English’ subheading
    -After clicking, check that the redirected Disney Magic English-related webpages is visible
    -Go back to the home page.
    -"Top categories" under the heading; Verify that 'English Grammar,’ is visible as a subheading
    -Click on icon of ‘English Grammar,’ subheading
    -After clicking, check that the redirected English Grammar,-related webpages is visible
    -Go back to the home page.
    -"Top categories" under the heading; Verify that 'HTML5 and CSS’ is visible as a subheading
    -Click on icon of ‘HTML5 and CSS’ subheading
    -After clicking, check that the redirected HTML5 and CSS-related webpages is visible
    -Go back to the home page
    ======================================================================================
    TC_0002
    -Go to url “https://www.qualitydemy.com/”
    -"Useful links" under the heading; Verify that 'Blog’ is visible as a subheading
    -Click on icon of ‘Blog’ subheading
    -After clicking, check that the redirected Blog-related webpages is visible
    - Go back to the home page.
    -"Useful links" under the heading; Verify that 'All courses’ is visible as a subheading
    -Click on icon of ‘All courses’ subheading
    -After clicking, check that the redirected All courses-related webpages is visible
    -Go back to the home page.
    -"Useful links" under the heading; Verify that 'Sign Up’ is visible as a subheading
    -Click on icon of ‘Sign Up’ subheading
    -After clicking, check that the redirected Sign Up-related webpages is visible
    -Go back to the home page
    ========================================================================================
    TC_0003
    -Go to url “https://www.qualitydemy.com/”
    -"Help" under the heading; Verify that 'About us’ is visible as a subheading
    -Click on icon of ‘About us’ subheading
    -After clicking, check that the redirected About us-related webpages is visible
    -Go back to the home page.
    -"Help" under the heading; Verify that 'Privacy policy’ is visible as a subheading
    -Click on icon of ‘Privacy policy’ subheading
    -After clicking, check that the redirected Privacy policy-related webpages is visible
    -Go back to the home page.
    -"Help" under the heading; Verify that 'Terms and condition’ is visible as a subheading
    -Click on icon of ‘Terms and condition’ subheading
    -After clicking, check that the redirected Terms and condition-related webpages is visible
    -Go back to the home page.
    -"Help" under the heading; Verify that 'Refund policy’ is visible as a subheading
    -Click on icon of ‘Refund policy’ subheading
    -After clicking, check that the redirected Refund policy-related webpages is visible
     */
    HomePage homePage = new HomePage();
    JavascriptExecutor jsexecutor = (JavascriptExecutor) Driver.getDriver();
    CoursesPage coursesPage = new CoursesPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());
    CookiesComp cookiesComp = new CookiesComp();

    @Test
    public void TC_0001_topCategoriesTests() {

        Driver.getDriver().get("https://www.qualitydemy.com/");
        cookiesComp.acceptCookies();

        //Verify that English Speaking Course's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonTopCategoriesEnglishSpeakingCourse.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonTopCategoriesEnglishSpeakingCourse);
        softAssert.assertTrue(coursesPage.labelEnglishSpeakingCourses.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that ‘Web Design for Web Developers' link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonTopCategoriesWebDesignForWebDevelopers.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonTopCategoriesWebDesignForWebDevelopers);
        softAssert.assertTrue(coursesPage.labelWebDisagnForWebDevelopersCourses.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that HTML5AndCSS's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonTopCategoriesHTML5AndCSS.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonTopCategoriesHTML5AndCSS);
        softAssert.assertTrue(coursesPage.labelHTML5AndCSSCourses.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that Piano's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonTopCategoriesPiano.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonTopCategoriesPiano);
        jsexecutor.executeScript("arguments[0].click();", coursesPage.labelShowMore);
        softAssert.assertTrue(coursesPage.labelPianoCourses.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that DisneyMagicEnglish's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonTopCategoriesDisneyMagicEnglish.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonTopCategoriesDisneyMagicEnglish);
        softAssert.assertTrue(coursesPage.labelDisneyMagicEnglishCourses.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that EnglishGrammar's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonTopCategoriesEnglishGrammar.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonTopCategoriesEnglishGrammar);
        softAssert.assertTrue(coursesPage.labelEnglishGrammar.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC_0002_usefullLinksTests() {

        //Verify that Blog's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonUsefulLinksBlog.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonUsefulLinksBlog);
        softAssert.assertTrue(coursesPage.pageBlog.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that All courses link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonUsefulLinksAllCourses.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonUsefulLinksAllCourses);
        softAssert.assertTrue(coursesPage.pageAllCourses.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that Sign Up's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonUsefulLinksSignUp.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonUsefulLinksSignUp);
        softAssert.assertTrue(coursesPage.pageSignUp.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();
    }

    @Test
    public void TC_0003_helpTests() {

        //Verify that About Us link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonHelpAboutUs.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonHelpAboutUs);
        softAssert.assertTrue(coursesPage.labelAboutUs.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that Privacy Policy's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonHelpPrivacyPolicy.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonHelpPrivacyPolicy);
        softAssert.assertTrue(coursesPage.labelPrivacyPolicy.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that Terms And Condition's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonHelpTermsAndCondition.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonHelpTermsAndCondition);
        softAssert.assertTrue(coursesPage.labelTermsAndCondition.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();

        //Verify that Refund Policy's link is visible, clickable and its related page visible
        softAssert.assertTrue(homePage.buttonHelpRefundPolicy.isEnabled());
        jsexecutor.executeScript("arguments[0].click();", homePage.buttonHelpRefundPolicy);
        softAssert.assertTrue(coursesPage.labelRefundPolicy.isDisplayed());
        softAssert.assertAll();
        Driver.getDriver().navigate().back();
    }

    @AfterClass
    public static void afterClass() {
        Driver.closeDriver();
    }
}






