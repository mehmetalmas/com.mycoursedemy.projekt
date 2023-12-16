package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.AddCoursePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_025 {

    @Test
    public void TC_0001() {

        InstructorPage instructorPage = new InstructorPage();
        SoftAssert softAssert = new SoftAssert();
        instructorPage.buttonBasic.click();
        ReusableMethods.clickElementByJS(instructorPage.checkBoxTopCourse);
        softAssert.assertTrue(instructorPage.checkBoxTopCourse.isSelected(), "checkBoxTopCourse is" +
                " not selected");

        Assert.assertTrue(instructorPage.checkBoxTopCourse.isSelected());
        softAssert.assertAll();

    }

    @Test
    public void TC_0002() {

        InstructorPage instructorPage = new InstructorPage();
        SoftAssert softAssert = new SoftAssert();
        instructorPage.buttonPricing.click();
        ReusableMethods.clickElementByJS(instructorPage.checkBoxDiscount);
        softAssert.assertTrue(instructorPage.checkBoxDiscount.isSelected(), "checkBoxDiscount is" +
                " not selected");
        softAssert.assertAll();

    }

    @Test
    public void TC_0003() {
        InstructorPage instructorPage = new InstructorPage();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        double coursePrice = 1000;
        double discountedPrice = 42.5;
        double expectedRate = ((coursePrice - discountedPrice) / coursePrice * 100);
        String strExpectedRate = String.format("%.2f", expectedRate);

        instructorPage.buttonPricing.click();
        actions.click(instructorPage.fieldCoursePrice).sendKeys(String.valueOf(coursePrice)).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(String.valueOf(discountedPrice)).
                perform();

        String value = instructorPage.discountedPercentage.getText();
        String actualRate = value.replaceAll("%", "");

        softAssert.assertEquals(strExpectedRate, actualRate, "discounted Percentage Field does not properly work.");
        softAssert.assertAll();


    }


    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage();
        InstructorPage instructorPage = new InstructorPage();
        HeaderComp headerComp = new HeaderComp();
        AddCoursePage addCoursePage = new AddCoursePage();
        loginPage.login(("user_1106183@login.com"), "560826104");
        headerComp.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        addCoursePage.buttonAddNewCourse.click();
        instructorPage.buttonPricing.click();

    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();

    }


}
