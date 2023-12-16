package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.mycoursedemy.AddCoursePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;
import java.util.List;

public class US_029 {
    //US_29-"course_form/add_course/basic "
    //The functions of the course_form/add_course basic section should work correctly
    //1- Course title, Short description and description sections should be accessible.
    //2- The desired category should be selectable from the Category section.
    //3- The desired level sshould be selectable from the Level section.
    //4- Enable drip content button shold be changeble.
    //5- Check if this course is top course checkbox should be selectable.

    LoginPage loginPage=new LoginPage();
    InstructorPage instructorPage=new InstructorPage();
    HeaderComp headerComp=new HeaderComp();
    AddCoursePage addCoursePage=new AddCoursePage();

    @BeforeMethod
    public void beforeMethod() {
        loginPage=new LoginPage();
        loginPage.login("user_1106179@login.com","319927504");
        headerComp.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        addCoursePage.buttonAddNewCourse.click();
        instructorPage.buttonBasic.click();
    }

    @AfterMethod
    public void tearDown() {
        Actions actions=new Actions(Driver.getDriver());
        WebElement userIcon=Driver.getDriver().findElement(By.xpath("(//*[text()='Test User'])[1]"));
        actions.click(userIcon).perform();
        WebElement buttonTestUserInstructorIconLogout=Driver.getDriver().findElement(By.xpath
                ("//i[@class='mdi mdi-logout mr-1']"));
        actions.click(buttonTestUserInstructorIconLogout).perform();
    }

    @AfterClass
    public void afterClass(){
        Driver.closeDriver();
    }


    @Test
    public void test01(){
        //1- Course title, Short description and description sections should be accessible.
        Assert.assertTrue(instructorPage.fieldsCourseTitleBasic.isEnabled(),"Course Title sections is accessible");
        Assert.assertTrue(instructorPage.fieldsDescriptionBasic.isEnabled(),"Course descriptions sections is accessible");
        Assert.assertTrue(instructorPage.fieldsShortDescriptionBasic.isEnabled(),"Course Short descriptions sections is accessible");
        ReusableMethods.bekle(3);
    }

    @Test
    public void test02(){
        //2- The desired category should be selectable from the Category section.
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN);
        WebElement category=Driver.getDriver().findElement(
                By.xpath("//select[@name='sub_category_id']"));
        Select select=new Select(category);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        String expectedOptions="AWS Certification";
        select.selectByVisibleText(expectedOptions);
        String actualOptions=instructorPage.fieldsCategoryBasic.getText();
        Assert.assertTrue(actualOptions.equals(expectedOptions),"Category section is selectable");
    ReusableMethods.bekle(3);
    }

    @Test
    public void test03(){
        //3- The desired level should be selectable from the Level section.
        InstructorPage instructorPage=new InstructorPage();
        //Driver.getDriver().findElement(By.xpath("//*[text()='Deneme']")).click();
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
    }

    @Test
    public void test04(){
        //4- Enable drip content button shold be changeble
        InstructorPage instructorPage=new InstructorPage();
        //Driver.getDriver().findElement(By.xpath("//*[text()='Deneme']")).click();
        instructorPage.buttonBasic.click();

        instructorPage.fieldsCourseTitleBasic.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(3);
        ReusableMethods.clickElementByJS(instructorPage.buttonCheckboxEnableDripContentBasic);

        instructorPage.buttonCheckboxEnableDripContentBasic.isSelected();
        ReusableMethods.bekle(3);

    }

    @Test
    public void test05(){
        //5- Check if this course is top course checkbox should be selectable
        InstructorPage instructorPage=new InstructorPage();
        instructorPage.buttonBasic.click();

        ReusableMethods.clickElementByJS(instructorPage.buttonCheckboxIstopCourseBasic);
        instructorPage.buttonCheckboxIstopCourseBasic.isSelected();

        Assert.assertTrue(instructorPage.buttonCheckboxIstopCourseBasic.isSelected());
        ReusableMethods.bekle(3);
    }

}
