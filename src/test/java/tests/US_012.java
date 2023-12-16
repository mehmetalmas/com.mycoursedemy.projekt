package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.CourseComparePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_012 {
    //US_012
    //Course compare page functions should work correctly.
    //1- Courses should be searchable from dropboxes.
    //2- When the learn more link is clicked, it should redirect to the page of the relevant course.
    //3- When the buy now button is clicked, it should redirect to the shopping_cart page.

    CourseComparePage courseComparePage= new CourseComparePage();
    String courseName="Web Design for PHP";
    HeaderComp header;

    @AfterMethod
    public void tearDown() {
        //Driver.closeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        //Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        LoginPage loginPage = new LoginPage();

        String email = ConfigReader.getUser("teacher.298.bicer");
        String password = ConfigReader.getPassword("password.298.bicer");
        loginPage.login(email, password);

        header= new HeaderComp();
        InstructorPage instructorPage=new InstructorPage();

        Driver.getDriver().get(ConfigReader.getProperty("mycourseCompareUrl"));
    }

    @Test
    public void test01(){
        //1- Courses should be searchable from dropboxes.
        WebElement compareHDD1=Driver.getDriver().findElement(
                By.xpath("(//span[@class='select2-selection__arrow'])[1]"));
        //Select select=new Select(compareHDD1);
        ReusableMethods.clickElementByJS(compareHDD1);
        courseComparePage.ddmCourseCompare1.sendKeys(courseName);
        //select.selectByVisibleText("Web Design for PHP");
    }

    @Test
    public void test02(){
        //2- When the learn more link is clicked, it should redirect to the page of the relevant course.
        //Driver.getDriver().get(ConfigReader.getProperty("mycourseCompareUrl"));
        courseComparePage.ddmCourseCompare1.sendKeys("React and Typescript");
        Actions actions= new Actions(Driver.getDriver());
        courseComparePage.linkButtonLearnMoreCompare.click();

        ReusableMethods.bekle(15);
    }

    @Test
    public void test03(){
        //3- When the buy now button is clicked, it should redirect to the shopping_cart page.
        //Driver.getDriver().get(ConfigReader.getProperty("mycourseCompareUrl"));
        courseComparePage.ddmCourseCompare1.sendKeys("Wordpress");
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(courseComparePage.buttonBuyNowCompare).click();
        ReusableMethods.bekle(3);
    }
}
