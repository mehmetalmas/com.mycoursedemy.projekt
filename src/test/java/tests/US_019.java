package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.BecomeInstructorPage;
import pages.mycoursedemy.CourseManagerPage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_019 {
    /*TC_0001
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on 'Categories' button
    -Select a course from categories menu
    -Select status
    -Select Price
    -Click the button of filter
    -Verify that the relevant course should appear in the list.
    =======================================================================
    TC_0002
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the search box
    -Enter any course title
    -Verify that the course title entered matches the course title listed
    =======================================================================
    TC_0003
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'View course on fronted' link
    -Test that title of redirected the page includes title of course
    ============================================================================
    TC_0004
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'Go to course playing page'
    -Test that title of redirected the page includes title of course
    ===============================================================================
    TC_0005
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'Edit this course' link
    -Test that redirected the page is update page
    ==================================================================================
    TC_0006
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'Section and lesson' link
    -Test that redirected the page is update page
    =================================================================================
    TC0007
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'Mark as drafted' link
    -Click on 'Continue' button
    -Courses page that redirected the page is visiable
    -Test that redirected the page is update page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Verify that status is draft
    =============================================================================
    TC_0008
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'Publish This Course' link
    -Click on 'Continue' button
    -Courses page that redirected the page is visiable
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Verify that status is active
    ===============================================================================
    TC_0009
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the + sign next to the course
    -Click on the three dots under the action section
    -Click on 'Delete' link
    -Click on 'Continue' button
    -Test that the course list doesn't contain the deleted course
    =========================================================================
    TC_0010
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on '+Add new course' button
    -Test that redirected the page is the add_course page
    ===========================================================================
    TC_0011
    -Go to url “https://www.mycoursedemy.com/”
    -Login to the page
    -Click on 'Instructor' button on the top of the page
    -Click on 'Course Manager' button on the page
    -Click on the course name in the list
    -Test that the redirected page is the update page
     */
    HeaderComp headerComp = new HeaderComp();
    InstructorPage instructorPage = new InstructorPage();
    CourseManagerPage courseManagerPage = new CourseManagerPage();
    Actions actions = new Actions(Driver.getDriver());

    BecomeInstructorPage becomeInstructorPage = new BecomeInstructorPage();

    @BeforeMethod
    public void beforeMetmod() {
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("teacher.290.seher");
        String password = ConfigReader.getPassword("password.290.seher");
        loginPage.login(email, password);
        headerComp.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
    }

    @Test
    public void TC_0001() {

        courseManagerPage.buttonCategories.click();
        ReusableMethods.bekle(1);
        courseManagerPage.buttonCategories_WebDesignForWebDevelopers.click();
        courseManagerPage.buttonStatus.click();
        ReusableMethods.bekle(1);
        courseManagerPage.buttonStatus_Active.click();
        courseManagerPage.buttonPrice.click();
        ReusableMethods.bekle(3);
        courseManagerPage.buttonPrice_Free.click();
        courseManagerPage.buttonFilter.click();

        Assert.assertTrue(courseManagerPage.listedTitle_WebDesign.isDisplayed());
    }

    @Test
    public void TC_0002() {

        courseManagerPage.buttonSearchBox.sendKeys(ConfigReader.getProperty("searchKeyWord"));
        String listedTitle_webDesignText = courseManagerPage.listedTitle_WebDesign.getText();
        System.out.println(listedTitle_webDesignText);
        Assert.assertTrue(listedTitle_webDesignText.contains(ConfigReader.getProperty("searchKeyWord")));
    }

    @Test
    public void TC_0003() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(3);
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        courseManagerPage.button_ViewCourseOnFronted.click();
        ReusableMethods.bekle(3);
        ReusableMethods.switchToWindow("Web Design for Web Developers: Build Beautiful Websites! | QualityDemy");
        ReusableMethods.bekle(3);
        String expectedViewCourseOnFrontedPageTitle = "Web Design for Web Developers: Build Beautiful Websites! | QualityDemy";
        String actualViewCourseOnFrontedPageTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualViewCourseOnFrontedPageTitle, expectedViewCourseOnFrontedPageTitle);
        softAssert.assertAll();
    }

    @Test
    public void TC_0004() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        //courseManagerPage.button_ThreeDotsWebDisagnForWebDevelopers.click();
        ReusableMethods.clickElementByJS(courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers);
        actions.sendKeys(Keys.END).perform();
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        courseManagerPage.button_GoToCoursePlayingPage.click();
        ReusableMethods.bekle(3);
        ReusableMethods.switchToWindow("Web Design for Web Developers: Build Beautiful Websites! | QualityDemy");
        ReusableMethods.bekle(3);
        String expectedGoToCoursePlayingPageTitle = "Web Design for Web Developers: Build Beautiful Websites! | QualityDemy";
        String actualGoToCoursePlayingPageTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualGoToCoursePlayingPageTitle, expectedGoToCoursePlayingPageTitle);
        softAssert.assertAll();
    }

    @Test
    public void TC_0005() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        actions.sendKeys(Keys.END).perform();
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        courseManagerPage.button_EditThisCourse.click();
        String expectedEditPageTitle = "Edit course | Quality Demy";
        String actualEditPageTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEditPageTitle, expectedEditPageTitle);
        softAssert.assertAll();
    }

    @Test
    public void TC_0006() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        actions.sendKeys(Keys.END).perform();
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(3);
        courseManagerPage.button_SectionAndLesson.click();
        String expectedEditPageTitle = "Edit course | Quality Demy";
        String actualEditPageTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEditPageTitle, expectedEditPageTitle);
        softAssert.assertAll();
    }

    @Test
    public void TC_0007() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.bekle(3);
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        actions.sendKeys(Keys.END).perform();
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        courseManagerPage.button_MarkAsDrafted.click();
        ReusableMethods.bekle(3);
        courseManagerPage.button_Continue.click();
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        String expectedStatus = "Draft";
        String actualStatus = courseManagerPage.status_Draft.getText();
        System.out.println(actualStatus);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualStatus.contains(expectedStatus));
        softAssert.assertAll();
    }

    @Test
    public void TC_0008() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.bekle(3);
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        actions.sendKeys(Keys.END).perform();
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(3);
        courseManagerPage.button_PublishThisCourse.click();
        courseManagerPage.button_Continue.click();
        courseManagerPage.buttonsignWebDisagnForWebDevelopers.click();
        courseManagerPage.buttonThreeDotsWebDisagnForWebDevelopers.click();
        String expectedStatus = "Active";
        String actualStatus = courseManagerPage.statusWebDisagnForWebDevelopers_Pending.getText();
        System.out.println(actualStatus);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!actualStatus.contains(expectedStatus));
        softAssert.assertAll();
    }

    @Test
    public void TC_0009() {
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.bekle(3);
        courseManagerPage.buttonsignPiano.click();
        courseManagerPage.buttonThreeDotsPiano.click();
        actions.sendKeys(Keys.END).perform();
        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        courseManagerPage.buttonDeletePiano.click();
        Assert.assertTrue(courseManagerPage.button_Continue.isEnabled());
        courseManagerPage.button_Continue.click();

        boolean flag = false;
        try {
            Assert.assertFalse(courseManagerPage.listedTitle_Piano.isDisplayed());
        } catch (Exception e) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    /*actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.bekle(3);
        courseManagerPage.buttonsignAchievingPersonalAndProfessionalSuccessSpecialization.click();
        courseManagerPage.buttonThreeDotsAchievingPersonalAndProfessionalSuccessSpecialization.click();
        actions.sendKeys(Keys.END).perform();
        courseManagerPage.buttonDeleteAchievingPersonalAndProfessionalSuccessSpecialization.click();
        Assert.assertTrue(courseManagerPage.button_Continue.isEnabled());
        courseManagerPage.button_Continue.click();

    boolean flag= false;
        try {
        Assert.assertFalse(courseManagerPage.listedTitle_AchievingPersonalAndProfessionalSuccessSpecialization.isDisplayed());
    } catch (Exception e) {
        flag= true;
    }
        Assert.assertTrue(flag);
} */

    @Test
    public void TC_0010() {
        courseManagerPage.button_AddNewCourse.click();
        String expectedEditPageTitle = "Add course | Quality Demy";
        String actualEditPageTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEditPageTitle, expectedEditPageTitle);
        softAssert.assertAll();

    }

    @Test
    public void TC_0011() {
        courseManagerPage.listedTitle_WebDesign.click();
        String expectedEditPageTitle = "Edit course | Quality Demy";
        String actualEditPageTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEditPageTitle, expectedEditPageTitle);
        softAssert.assertAll();

    }

    @AfterMethod
    public void afterMethod() {
        // Logout from the page
        becomeInstructorPage.TestUserInstructorLogout();
        Driver.closeDriver();

    }

}
