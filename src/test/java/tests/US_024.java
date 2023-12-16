package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.*;
import pages.mycoursedemy.component.HeaderComp;
import pages.mycoursedemy.component.OutcomesComp;
import pages.mycoursedemy.component.ToastMessageComp;
import pages.mycoursedemy.component.UserHeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_024 {
    /*
-- User goes to site https://mycoursedemy.com/
-- Accepts the cookies
-- Clicks the login button
-- Enters email address into the email field on the https://mycoursedemy.com/login page
-- Enters the password into the passsword field on the same page.
- Clicks the login button on the same page
-- Waits for 6 Seconds until toas message disappears for the successful loin on the https://mycoursedemy.com/home page
--  Clicks to Instructor button and be redirected to the https://mycoursedemy.com/user page
-- Clicks the Course Manager button on the same page and be redirected to https://mycoursedemy.com/user/courses page
-- Clicks to the + Add new course button on the same page and be redirected to https://mycoursedemy.com/user/course_form/add_course page
- Clicks the Outcomes button and confirms that below elements can be seen:
        - Provide outcomes field
        - + button
        - Back to course list button
        -  <- and -> arrows
- Confirms any value can be entered to Povide outcomes field
- Confirms if we click the + button the entered value to PRovide outcomes field is saved
- Confirms clicking Back to course list button brings us to the https://mycoursedemy.com/user/courses page
- Confirms that clicking left arrow brings the Requirement section
- Confirms that clicking right arrow brings the pricing section
     */

    public HeaderComp header;
    public AddCoursePage addCoursePage;
    public CoursesPage coursesPage;

    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage();
        header = new HeaderComp();
        String email = ConfigReader.getUser("teacher.301.anil");
        String password = ConfigReader.getPassword("password.301.anil");
        loginPage.login(email, password);
        new ToastMessageComp().hideToastMessage();
        InstructorPage instructorPage = header.gotoInstructorPage();
        coursesPage = instructorPage.gotoCoursesPage();
        addCoursePage = coursesPage.gotoAddCoursePage();
    }

    @AfterMethod
    public void afterMethod() {
        UserHeaderComp userHeaderComp = new UserHeaderComp();
        userHeaderComp.userLogout();
    }

    @AfterClass
    public static void afterClass() {
        Driver.getDriver().close();
    }

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        addCoursePage.tabOutcomes.click();
        OutcomesComp outcomesComp = new OutcomesComp();
        softAssert.assertTrue(outcomesComp.fieldProvideOutcomes.isDisplayed(), "Outcome field is not displayed!");
        softAssert.assertTrue(outcomesComp.buttonPlus.isDisplayed(), "+ button is not displayed!");
        softAssert.assertTrue(outcomesComp.buttonLeftArrow.isDisplayed(), "<- arrow button is not displayed!");
        softAssert.assertTrue(outcomesComp.buttonRightArrow.isDisplayed(), "-> button is not displayed!");
        String expectedOutcome = "Be able to write java code";
        outcomesComp.fieldProvideOutcomes.sendKeys(expectedOutcome);
        String actualOutcome = outcomesComp.fieldProvideOutcomes.getAttribute("value");
        softAssert.assertEquals(actualOutcome, expectedOutcome);
        outcomesComp.buttonPlus.click();
        WebElement savedOutcomeElement = Driver.getDriver().findElement(By.xpath("(//input[@name='outcomes[]'])[2]"));
        String savedOutcomeText = savedOutcomeElement.getAttribute("value");
        softAssert.assertEquals(savedOutcomeText, expectedOutcome);
        softAssert.assertAll();
    }

    @Test
    public void test02() {
        SoftAssert softAssert = new SoftAssert();
        addCoursePage.tabOutcomes.click();
        OutcomesComp outcomesComp = new OutcomesComp();
        outcomesComp.buttonBackToCourseList.click();
        softAssert.assertEquals(Driver.getDriver().getTitle(), coursesPage.title);
        softAssert.assertAll();
    }

    @Test
    public void test03() {
        SoftAssert softAssert = new SoftAssert();

        addCoursePage.tabOutcomes.click();
        OutcomesComp outcomesComp = new OutcomesComp();

        String classValueOfOutcomes = addCoursePage.tabOutcomes.getAttribute("class");
        boolean isOutcomesTabActive = classValueOfOutcomes.contains("active");
        softAssert.assertTrue(isOutcomesTabActive, "Outcomes tab is not selected (active)");

        outcomesComp.buttonLeftArrow.click();

        String classValueOfRequirements = addCoursePage.tabRequirements.getAttribute("class");
        boolean isRequirementTabIsActive = classValueOfRequirements.contains("active");
        softAssert.assertTrue(isRequirementTabIsActive, "Requirments tab is not selected (active)");

        softAssert.assertAll();
    }
    @Test
    public void test04() {
        SoftAssert softAssert = new SoftAssert();

        addCoursePage.tabOutcomes.click();
        OutcomesComp outcomesComp = new OutcomesComp();

        String classValueOfOutcomes = addCoursePage.tabOutcomes.getAttribute("class");
        boolean isOutcomesTabActive = classValueOfOutcomes.contains("active");
        softAssert.assertTrue(isOutcomesTabActive, "Outcomes tab is not selected (active)");

        outcomesComp.buttonRightArrow.click();

        String classValueOfPricing = addCoursePage.tabPricing.getAttribute("class");
        boolean isPricingTabIsActive = classValueOfPricing.contains("active");
        softAssert.assertTrue(isPricingTabIsActive, "Pricing tab is not selected (active)");

        softAssert.assertAll();
    }

}
