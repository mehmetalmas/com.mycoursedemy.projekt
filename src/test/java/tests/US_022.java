package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.AddCoursePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.UserProfilePage;
import pages.mycoursedemy.component.HeaderComp;
import pages.mycoursedemy.component.ToastMessageComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.List;

public class US_022 {

    // course_form/course_edit basic.
    //The functions of the course_form/course_edit basic section should work correctly.
    //1- When the Add new instructor section is clicked,
    //   it should be possible to choose from among the instructors added here.
    //2- It should be possible to make changes on the Course title,
    //   Short description and description
    //3- The desired category should be able to get selected from the Category section.
    //4- The desired level should be able to get selected from the Level section.
    //5- Enable drip content button can be changed.
    //6- Check if this course is top course checkbox should be selectable.

    HeaderComp header;


    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage();

        String email = ConfigReader.getUser("teacher.298.bicer");
        String password = ConfigReader.getPassword("password.298.bicer");
        loginPage.login(email, password);

        header= new HeaderComp();
        header.buttonInstructor.click();

        InstructorPage instructorPage=new InstructorPage();
        instructorPage.buttonCourseManager.click();

        new ToastMessageComp().hideToastMessage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        ReusableMethods.bekle(3);
    }

    @Test
    public void test01(){
        //1- When the Add new instructor section is clicked,
        //   it should be possible to choose from among the instructors added here.
        InstructorPage instructorPage=new InstructorPage();
        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();
        instructorPage.buttonBasic.click();
        instructorPage.fieldsAddNewInsructorBasic.sendKeys("Test User ( user_1106146@login.com )");
        instructorPage.fieldsAddNewInsructorBasic.isSelected();
        ReusableMethods.bekle(3);

        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        WebElement buttonTestUserInstructorIconLogout=Driver.getDriver().findElement(By.xpath
                ("//i[@class='mdi mdi-logout mr-1']"));
        actions.click(buttonTestUserInstructorIconLogout).perform();

    }
    @Test
    public void test02(){
        //2- It should be possible to make changes on the Course title,
        //   Short description and description

        SoftAssert softAssert=new SoftAssert();

        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();

        InstructorPage instructorPage=new InstructorPage();
        instructorPage.buttonBasic.click();
        instructorPage.fieldsCourseTitleBasic.clear();

        String expTitleText="testing";
        instructorPage.fieldsCourseTitleBasic.sendKeys("testing");
        String actTitleText=instructorPage.fieldsCourseTitleBasic.getText();
        softAssert.assertTrue(actTitleText.equals(expTitleText),"Course title text is changeable");

        instructorPage.fieldsShortDescriptionBasic.clear();
        String expShortDescriptionText="testing";
        instructorPage.fieldsShortDescriptionBasic.sendKeys("testing");
        String actShortDescriptionText=instructorPage.fieldsShortDescriptionBasic.getText();
        softAssert.assertTrue(actTitleText.equals(expTitleText),"Course ShortDescription text is changeable");

        instructorPage.fieldsDescriptionBasic.clear();
        String expDescriptionText="testing";
        instructorPage.fieldsDescriptionBasic.sendKeys("testing");
        String actDescriptionText=instructorPage.fieldsDescriptionBasic.getText();
        softAssert.assertTrue(actTitleText.equals(expTitleText),"Course Description text is changeable");

        ReusableMethods.bekle(3);
        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        WebElement buttonTestUserInstructorIconLogout=Driver.getDriver().findElement(By.xpath
                ("//i[@class='mdi mdi-logout mr-1']"));
        actions.click(buttonTestUserInstructorIconLogout).perform();

    }
    @Test
    public void test03(){
        //3- The desired category should be able to get selected from the Category section.
        InstructorPage instructorPage=new InstructorPage();
        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();
        instructorPage.buttonBasic.click();

        instructorPage.fieldsCourseTitleBasic.sendKeys(Keys.PAGE_DOWN);
        WebElement category=Driver.getDriver().findElement(
                By.xpath("//select[@name='sub_category_id']"));
        Select select= new Select(category);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        String expCategoryText="HTML5 and CSS";
        select.selectByVisibleText(expCategoryText);
        Assert.assertTrue(instructorPage.fieldsCategoryBasic.getText().contains(expCategoryText),"Category is selectable");
        ReusableMethods.bekle(3);

        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        WebElement buttonTestUserInstructorIconLogout=Driver.getDriver().findElement(By.xpath
                ("//i[@class='mdi mdi-logout mr-1']"));
        actions.click(buttonTestUserInstructorIconLogout).perform();

    }
    @Test
    public void test04(){
        //4- The desired level should be able to get selected from the Level section.
        InstructorPage instructorPage=new InstructorPage();
        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();
        instructorPage.buttonBasic.click();

        instructorPage.fieldsCourseTitleBasic.sendKeys(Keys.PAGE_DOWN);

        WebElement level=Driver.getDriver().findElement(
                By.id("level"));

        Select select= new Select(level);
        String expLevel="Intermediate";
        select.selectByVisibleText(expLevel);
        String actLevel=instructorPage.fieldsLevelBasic.getText();

        Assert.assertTrue(actLevel.contains(expLevel),"Level sections is selectable");
        ReusableMethods.bekle(5);

        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        actions.sendKeys("Logout").perform();
    }
    @Test
    public void test05(){
        //5- Enable drip content button can be changed.
        InstructorPage instructorPage=new InstructorPage();
        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();
        instructorPage.buttonBasic.click();

        instructorPage.fieldsCourseTitleBasic.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(3);
        ReusableMethods.clickElementByJS(instructorPage.buttonCheckboxEnableDripContentBasic);

        instructorPage.buttonCheckboxEnableDripContentBasic.isSelected();
        ReusableMethods.bekle(3);

        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        actions.sendKeys("Logout").perform();
    }
    @Test
    public void test06(){
        //6- Check if this course is top course checkbox should be selectable.
        InstructorPage instructorPage=new InstructorPage();
        Driver.getDriver().findElement(
                By.xpath("//*[text()='Deneme']")).click();
        instructorPage.buttonBasic.click();

        ReusableMethods.bekle(3);
        instructorPage.buttonCheckboxIstopCourseBasic.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.clickElementByJS(instructorPage.buttonCheckboxIstopCourseBasic);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(instructorPage.buttonCheckboxIstopCourseBasic.isSelected(),"Checkbox is selectable");
        softAssert.assertAll();

        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        WebElement buttonTestUserInstructorIconLogout=Driver.getDriver().findElement(By.xpath
                ("//i[@class='mdi mdi-logout mr-1']"));
        actions.click(buttonTestUserInstructorIconLogout).perform();
    }
}

