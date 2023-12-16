package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.MyCoursesPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_037 {

    @BeforeMethod
    public void beforeMethod() {

        LoginPage loginPage = new LoginPage();
        String userEmail = ConfigReader.getUser("student.342.esra");
        String userPassword = ConfigReader.getPassword("password.342.esra");
        loginPage.login(userEmail, userPassword);
        ReusableMethods.bekle(5);

        HeaderComp headerComp = new HeaderComp();
        headerComp.buttonMyCourses.click();

    }

    @Test
    public void test01() {

        MyCoursesPage myCoursesPage = new MyCoursesPage();
        String courseName = myCoursesPage.fieldFirstCourse.getText();
        myCoursesPage.fieldFirstCourse.click();

        String coursePageTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(coursePageTitle.contains(courseName));
        softAssert.assertAll();

    }

    @Test
    public void test02() {

        MyCoursesPage myCoursesPage = new MyCoursesPage();
        myCoursesPage.fieldSecondCourse.click();

        ReusableMethods.clickElementByJS(myCoursesPage.contextMenu);
        ReusableMethods.bekle(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(myCoursesPage.contextCourse.isDisplayed());
        softAssert.assertAll();

    }

    @Test
    public void test03() {

        MyCoursesPage myCoursesPage = new MyCoursesPage();
        myCoursesPage.fieldSecondCourse.click();
        ReusableMethods.clickElementByJS(myCoursesPage.contextMenu);
        ReusableMethods.bekle(5);
        ReusableMethods.clickElementByJS(myCoursesPage.contextCourse);
        myCoursesPage.buttonFirstSection.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(myCoursesPage.firstLesson.isSelected());
        softAssert.assertAll();

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2);


    }

    @Test
    public void test04() {

        MyCoursesPage myCoursesPage = new MyCoursesPage();
        myCoursesPage.fieldSecondCourse.click();
        ReusableMethods.clickElementByJS(myCoursesPage.contextMenu);
        ReusableMethods.clickElementByJS(myCoursesPage.contextCourse);
        ReusableMethods.clickElementByJS(myCoursesPage.buttonCourseDetails);

        String expectedCourseTitle = myCoursesPage.courseTitle.getText();
        String actualPageTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualPageTitle.contains(expectedCourseTitle));
        softAssert.assertAll();

    }

    @AfterMethod
    public void afterMethod() {

        ReusableMethods.bekle(2);
        HeaderComp headerComp = new HeaderComp();
        headerComp.logout();

    }


}
