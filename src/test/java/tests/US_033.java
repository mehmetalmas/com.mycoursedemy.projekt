package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.AddCoursePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_033 {

    @BeforeMethod
    public void beforeMethod() {

        LoginPage loginPage = new LoginPage();

        String userEmail = ConfigReader.getUser("teacher.291.esra");
        String userPassword = ConfigReader.getPassword("password.291.esra");

        loginPage.login(userEmail, userPassword);
        InstructorPage instructorPage = new InstructorPage();

        AddCoursePage addCoursePage = new AddCoursePage();
        addCoursePage = instructorPage.goToNewCourseAddPage();
        addCoursePage.buttonMedia.click();

    }

    @Test
    public void test01() {

        AddCoursePage addCoursePage = new AddCoursePage();
        WebElement buttonCourseOverviewProvider = addCoursePage.buttonCourseOverviewProvider;
        WebElement fieldCourseOverviewProvider = addCoursePage.fieldCourseOverviewProvider;

        buttonCourseOverviewProvider.click();
        fieldCourseOverviewProvider.sendKeys("Vimeo" + Keys.ENTER);

        String actual = buttonCourseOverviewProvider.getText();
        String expected = "Vimeo";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();


    }

    @Test
    public void test02() {

        AddCoursePage addCoursePage = new AddCoursePage();

        WebElement webElement = addCoursePage.fieldCourseOverviewUrl;

        String expectedResult = "https://www.com";
        addCoursePage.fieldCourseOverviewUrl.sendKeys(expectedResult);

        List<WebElement> elements = Driver.getDriver().findElements(By.id("course_overview_url"));
        String actualtext = elements.get(0).getAttribute("value");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualtext, expectedResult);
        softAssert.assertAll();


    }

    @AfterMethod
    public void afterMethod() {

        InstructorPage instructorPage = new InstructorPage();
        instructorPage.testUserInstructorLogout();

    }

    @AfterClass
    public void afterClass() {

        Driver.getDriver().close();

    }

}
