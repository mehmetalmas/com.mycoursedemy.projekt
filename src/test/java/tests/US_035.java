package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.AddCoursePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;

public class US_035 {
    LoginPage loginPage = new LoginPage();
    HeaderComp headerComp = new HeaderComp();
    AddCoursePage addCoursePage = new AddCoursePage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    InstructorPage instructorPage = new InstructorPage();
    String user = ConfigReader.getUser("teacher.299.muhammet");
    String password = ConfigReader.getPassword("password.299.muhammet");
    String courseTitle = ConfigReader.getProperty("courseTitle");
    String coursePrice = ConfigReader.getProperty("coursePrice");
    String discountedPrice = ConfigReader.getProperty("discountedPrice");
    String courseOverviewUrl = ConfigReader.getProperty("courseOverviewUrl");

    @Test
    public void test_1_addCourse() throws IOException {
        loginPage.login(user, password);
        headerComp.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        addCoursePage.buttonAddNewCourse.click();
        addCoursePage.fieldCourseTitle.sendKeys(courseTitle);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.hover(addCoursePage.dropDownCategory);
        addCoursePage.dropDownCategory.click();
        addCoursePage.fieldCategory.sendKeys(courseTitle + Keys.ENTER);
        addCoursePage.buttonNext.click();
        addCoursePage.buttonNext.click();
        addCoursePage.buttonNext.click();
        addCoursePage.fieldCoursePrice.sendKeys(coursePrice);
        addCoursePage.fieldDiscountedPrice.sendKeys(discountedPrice);
        addCoursePage.buttonNext.click();
        addCoursePage.fieldCourseOverviewUrl.sendKeys(courseOverviewUrl);
        addCoursePage.buttonNext.click();
        addCoursePage.buttonNext.click();
        addCoursePage.buttonSubmit.click();
        String expectedUrl = "https://qualitydemy.com/user/course_form/course_edit/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        String expctedText = "Congratulations!";
        String alertText = "";
        ReusableMethods.bekle(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Congratulations!']")));
        alertText = addCoursePage.toastMessage.getText();
        ReusableMethods.getScreenshot("US_035 ");
        System.out.println("text = " + alertText);
        softAssert.assertTrue(alertText.contains(expctedText));
        softAssert.assertAll();
    }

    @AfterClass
    public void teardown() {
        ReusableMethods.bekle(5);
        Driver.getDriver().close();
    }
}
