package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.SignUpPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_021 {
        /*
user Story is:
The functions of the course_form/course_edit Curriculum section should work correctly

Acceptance Criteries are:



Clicking the close button on the description screen should close the window
When the Sort sections button is pressed, it should be possible to change the order between the sections with drag drop.
When the sort sections button is pressed and changes are made, the change made with the update sorting button should be saved.
When hovering over the sections with the mouse, the sort lesson, edit section and delete section buttons should appear.
It should be possible to change the order between the lessons with the drag drop where the sort lesson button is pressed.
When the sort lesson button is pressed and a change is made, the change made by pressing the update sorting button should be saved.
When the Update section button is pressed, the title section should be able to be changed in the window that opens.
When the update section button is pressed, the window that opens should be closed with the close button.
The desired section should be get deleted with the delete section button.
When you hover over the course with your mouse, the edit and delete icons should appear.
When the edit icon is clicked, the update lesson window should open.
Changes can be made in the sections of the update lesson window
The update lesson window should be closed with the close button.
When the delete lesson icon is clicked, the desired lesson should be deleted
     */

     InstructorPage instructorPage = new InstructorPage();






    @BeforeMethod
    public void before(){
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        InstructorPage instructorPage = new InstructorPage();
        HeaderComp headerComp=new HeaderComp();
        loginPage.login(ConfigReader.getUser("teacher.292.fatih"), ConfigReader.getPassword("password.292.fatih"));
        homePage.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();

        instructorPage.buttonFirstCourseOptions.click();
        instructorPage.optionFirstCourseEdit.click();
    }


    //It is necessary to click on the add section button, enter the title text of the opened screen, press the submit button and add the new section.
    @Test
    public void test01_addSection() {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddSection.click();
        instructorPage.fieldAddSectionTitle.sendKeys("sasa");
        instructorPage.buttonSubmitAddSection.click();
        softAssert.assertTrue(instructorPage.toastSuccessAddSection.isDisplayed());

        ReusableMethods.bekle(5);
        softAssert.assertAll();
    }

    //The screen that opens by clicking the add section button should be closed with the close button.
    @Test
    public void test02_closeAddSectionScreen() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddSection.click();
        //ReusableMethods.hover(instructorPage.buttonCloseAddSection);
        Thread.sleep(450);
        instructorPage.buttonCloseAddSection.click();
        softAssert.assertTrue(instructorPage.buttonSubmitAddSection.isDisplayed());
        softAssert.assertAll();
    }

    //When the add lesson button is clicked, selections should be made for video types.
    @Test
    public void test03_selectVideoTypes() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        softAssert.assertTrue(instructorPage.radioButtonLastLessonType.isDisplayed());
        Thread.sleep(450);
        instructorPage.buttonCloseAddLesson.click();
        softAssert.assertAll();

    }

    //The screen that opens by clicking the add lesson button should be closed with the close button
    @Test
    public void test04_closeAddLessonScreen() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        Thread.sleep(450);
        instructorPage.buttonCloseAddLesson.click();
        softAssert.assertTrue(instructorPage.buttonCloseAddLesson.isDisplayed());
        softAssert.assertAll();
    }
    //After selecting the video type in the add lesson section, when the next button is clicked, the explanation screen related to the video should appear.
    @Test
    public void test05_ExplanationLessonType() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();
        Thread.sleep(450);
        instructorPage.buttonCloseAddLesson.click();
        softAssert.assertAll();
    }

    //The name should be able to get entered in the title textbox on the description screen.
    @Test
    public void test06_fillFieldTitle() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();

        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        Thread.sleep(450);
        instructorPage.buttonSubmitAddLesson.click();
        ReusableMethods.bekle(4);
        //softAssert.assertTrue(instructorPage.textLessonName.isEnabled());
        softAssert.assertAll();
    }

    //The desired section should be selected from the section dropbox on the description screen.
    @Test
    public void test07_selectSection() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();

        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        Thread.sleep(450);
        instructorPage.buttonSubmitAddLesson.click();
        ReusableMethods.bekle(4);
        softAssert.assertAll();
    }

    //A valid url should be able to get entered in the video url section on the description screen.
    @Test
    public void test08_enterVideoUrl() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();

        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        Thread.sleep(450);
        instructorPage.buttonSubmitAddLesson.click();
        softAssert.assertTrue(instructorPage.toastSuccessAddLesson.isDisplayed());
        softAssert.assertAll();

    }

    //After a valid url is entered in the video url section on the description screen, the duration section should automatically capture the duration in the system.
    @Test
    public void test09_videoUrl() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();
        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        ReusableMethods.bekle(2);
        instructorPage.fieldLessonTitle.click();
        String videoSuresi=instructorPage.fieldDuration.getText();

        System.out.println(videoSuresi);
        softAssert.assertEquals(videoSuresi,ConfigReader.getProperty("videoDuration"));
        instructorPage.buttonSubmitAddLesson.click();
        ReusableMethods.bekle(4);
        softAssert.assertAll();

    }

    //When an invalid url is entered in the video url section on the description screen, a warning should appear under the textbox.
    @Test
    public void test10_invalidVideoUrl() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();
        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("myUrl"));
        instructorPage.fieldDuration.click();
        ReusableMethods.bekle(1);
        softAssert.assertTrue(instructorPage.textInvalidUrl.isDisplayed());
        instructorPage.buttonCloseAddLesson.click();
        softAssert.assertAll();
    }

    //It should be possible to enter a description in the summary textbox on the description screen
    @Test
    public void test11_summaryTextbox(){
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();
        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        ReusableMethods.bekle(1);
        instructorPage.summaryBox.click();
        instructorPage.summaryBox.sendKeys("sasdsa");
        instructorPage.buttonSubmitAddLesson.click();
        softAssert.assertTrue(instructorPage.toastSuccessAddLesson.isDisplayed());
        softAssert.assertAll();
    }
    //Mark as free lesson checkbox should be clickable on the description screen
    @Test
    public void test12_checkBoxFreeLesson(){
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();
        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        ReusableMethods.bekle(1);
        instructorPage.checkboxFreeLesson.click();
        softAssert.assertTrue(instructorPage.checkboxFreeLesson.isSelected());
        instructorPage.buttonSubmitAddLesson.click();
        softAssert.assertTrue(instructorPage.toastSuccessAddLesson.isDisplayed());
        softAssert.assertAll();
    }

    //After filling the relevant sections on the explanation screen, the course should be added to the lesson section when the add lesson button is clicked.
    @Test
    public void test13_completeAddLesson(){
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        instructorPage.buttonNext.click();
        instructorPage.fieldLessonTitle.sendKeys("kimbu");
        instructorPage.fieldLessonSection.click();
        instructorPage.optionLessonSection.click();
        instructorPage.fieldVideoUrl.sendKeys(ConfigReader.getProperty("videoUrl"));
        instructorPage.fieldDuration.click();
        ReusableMethods.bekle(1);
        instructorPage.checkboxFreeLesson.click();
        instructorPage.buttonSubmitAddLesson.click();
        softAssert.assertTrue(instructorPage.toastSuccessAddLesson.isDisplayed());
        softAssert.assertAll();
    }

    //Clicking the close button on the description screen should close the window
    @Test
    public void test14_closeAddLessonScreen() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        instructorPage.buttonAddLesson.click();
        Thread.sleep(450);
        instructorPage.buttonCloseAddLesson.click();
        softAssert.assertTrue(instructorPage.buttonCloseAddLesson.isDisplayed());
        softAssert.assertAll();
    }












    @AfterMethod
   public void tearDown(){
        ReusableMethods.bekle(3);
        instructorPage.buttonAccount.click();
        instructorPage.buttonLogout.click();
       // Driver.closeDriver();

   }

}