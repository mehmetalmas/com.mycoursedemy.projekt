package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

import java.util.List;

public class US_032 {

    //US_32-""course_form/add_course
    //pricing ""
    //The functions of the course_form/add_course pricing section should work correctly
    //1- Check if this course is a free course checkbox should be selectable.
    //2- The desired price should be enterable as a number to Course price textbox.
    //3- Check if this course has discount checkbox should be selectable.
    //4- The desired discount should be enterable as number to Discounted price textbox.

    LoginPage loginPage;
    HeaderComp headerComp;


    @BeforeMethod
    public void beforeMethod() {
        loginPage=new LoginPage();
        headerComp=new HeaderComp();
        InstructorPage instructorPage=new InstructorPage();
        AddCoursePage addCoursePage=new AddCoursePage();

        loginPage.login("user_1106179@login.com","319927504");
        headerComp.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();
        addCoursePage.buttonPricingCourseManager.click();
        //addCoursePage.buttonAddNewCourse.click();
        //addCoursePage.buttonPricingCourseManager.click();
    }

    @AfterMethod
    public void tearDown() {
        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        WebElement buttonTestUserInstructorIconLogout=Driver.getDriver().findElement(By.xpath
                ("//i[@class='mdi mdi-logout mr-1']"));
        actions.click(buttonTestUserInstructorIconLogout).perform();
        Driver.closeDriver();
    }
    @AfterClass
    public void afterClass(){
        Driver.closeDriver();
    }

    @Test
    public void test01(){
        //1- Check if this course is a free course checkbox should be selectable.
        AddCoursePage addCoursePage=new AddCoursePage();
        addCoursePage.checkboxFreePricing.click();
        addCoursePage.checkboxFreePricing.click();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(addCoursePage.checkboxFreePricing.isSelected(),"Checkbox is selectable");
        softAssert.assertAll();
        ReusableMethods.bekle(3);
    }

    @Test
    public void test02(){
        //2- The desired price should be enterable as a number to Course price textbox.
        AddCoursePage addCoursePage=new AddCoursePage();

        String expCoursePrice="100";
        addCoursePage.fieldCoursePrice.click();

        addCoursePage.checkboxHasDiscountPricing.click();
        ReusableMethods.bekle(3);

        String actCoursePrice=addCoursePage.fieldCoursePrice.getAttribute("value");
        System.out.println("actCoursePrice : " + actCoursePrice);
        Assert.assertEquals(actCoursePrice,expCoursePrice,"Course price textbox is enterable");
        ReusableMethods.bekle(3);
    }

    @Test
    public void test03() {
        //3- Check if this course has discount checkbox should be selectable.
        AddCoursePage addCoursePage=new AddCoursePage();
        addCoursePage.checkboxHasDiscountPricing.click();
        ReusableMethods.bekle(3);
        addCoursePage.checkboxHasDiscountPricing.click();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(addCoursePage.checkboxHasDiscountPricing.isSelected(),"Checkbox is selectable");
        softAssert.assertAll();
        ReusableMethods.bekle(3);
    }

    @Test
    public void test04(){
        //4- The desired discount should be enterable as number to Discounted price textbox.
        AddCoursePage addCoursePage=new AddCoursePage();

        String expCoursePrice="50";
        addCoursePage.fieldDiscountedPrice.click();
        ReusableMethods.bekle(3);

        String actCoursePrice=addCoursePage.fieldDiscountedPrice.getAttribute("value");
        Assert.assertEquals(actCoursePrice,expCoursePrice,"Course Discounted price textbox is enterable");
        ReusableMethods.bekle(3);
    }

}
