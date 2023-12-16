package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.BecomeInstructorPage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;

public class US_036 {
    /*TC_0001
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on the button of 'instructor' on the top of the page
    -Verify that shouldn't be changeable the name box on the 'Instructor Applicaton Form'
    -Logout from the page
    =====================================================================================
    TC_0002
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on the button of 'instructor' on the top of the page
    -Verify that Shouldn't be changeable the email address box on the 'Instructor Applicaton Form
    -Logout from the page
    ======================================================================================
    TC_0003
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on the button of 'instructor' on the top of the page
    -Verify that should be accessible 'address' box and the address information must be entered
    -Logout from the page
    =======================================================================================
    TC_0004
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on the button of 'instructor' on the top of the page
    -Verify that should be accessible 'phone number' box and the phone number must be entered
    -Logout from the page
    =========================================================================================
    TC_0005
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on the button of 'instructor' on the top of the page
    -Verify that should be accessible 'any message' section
    -Logout from the page
    ==========================================================================================
    TC_0006
    -Go to url “https://www.qualitydemy.com/”
    -Login to the page
    -Click on the button of 'instructor' on the top of the page
    -Verify that Should be accessible 'document' section and if desired document can be attached
    -Click on the button of 'apply'
    -Logout from the page
     */

    HeaderComp headerComp = new HeaderComp();
    BecomeInstructorPage becomeInstructorPage = new BecomeInstructorPage();
    Faker faker = new Faker();

    InstructorPage instructorPage = new InstructorPage();

    @BeforeMethod
    public void beforeMetmod() {
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("student.341.seher");
        String password = ConfigReader.getPassword("password.341.seher");
        loginPage.login(email, password);
        headerComp.buttonInstructor.click();
    }

    @Test
    public void TC_0001_instructorApplicatonForm_disabledNameBox() {
        //Verify that shouldn't be changeable the name box on the 'Instructor Applicaton Form'
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(becomeInstructorPage.fieldNameBecomeAnInstructor.isSelected());
        softAssert.assertAll();
    }

    @Test
    public void TC_0002_instructorApplicatonForm_disabledEmailBox() {
        //Verify that Shouldn't be changeable the email address box on the 'Instructor Applicaton Form
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(becomeInstructorPage.fieldEmailAddressBecomeAnInstructor.isSelected());
        softAssert.assertAll();
    }

    @Test
    public void TC_0003_instructorApplicatonForm_enabledAddressBox() {
        //Verify that should be accessible 'address' box and the address information must be entered
        becomeInstructorPage.fieldAddressBecomeAnInstructor.sendKeys(faker.address().fullAddress());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(becomeInstructorPage.fieldAddressBecomeAnInstructor.isEnabled());
        softAssert.assertAll();
    }

    @Test
    public void TC_0004_instructorApplicatonForm_enabledPhoneNumberBox() {
        //Verify that should be accessible 'phone number' box and the phone number must be entered
        becomeInstructorPage.fieldPhoneBecomeAnInstructor.sendKeys(faker.phoneNumber().phoneNumber());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(becomeInstructorPage.fieldPhoneBecomeAnInstructor.isEnabled());
        softAssert.assertAll();
    }

    @Test
    public void TC_0005_instructorApplicatonForm_enabledAnyMessageBox() {
        //Verify that should be accessible 'any message' section
        becomeInstructorPage.fieldAnyMessageBecomeAnInstructor.sendKeys("The Instructor Application Form is accessible");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(becomeInstructorPage.fieldAnyMessageBecomeAnInstructor.isEnabled());
        softAssert.assertAll();
    }

    @Test
    public void TC_0006_instructorApplicatonForm_enabledDocumentBox() {
        //Verify that Should be accessible 'document' section and if desired document can be attached
        becomeInstructorPage.fieldDocumentBecomeAnInstructor
                .sendKeys("C:\\Users\\alosy\\OneDrive\\Desktop\\InstructorApplicationForm.docx");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(becomeInstructorPage.fieldDocumentBecomeAnInstructor.isEnabled());
        softAssert.assertAll();
        becomeInstructorPage.fieldApplyBecomeAnInstructor.click();
        WebElement warningMessage = Driver.getDriver().findElement(By.xpath("//div[@class='jq-toast-wrap top-right']"));
        JavascriptExecutor jsExecuter = (JavascriptExecutor) Driver.getDriver();
        jsExecuter.executeScript("arguments[0].style.visibility='hidden'", warningMessage);
    }

    @AfterMethod
    public void afterMethod() {
        // Logout from the page
        becomeInstructorPage.TestUserInstructorLogout();

    }

    @AfterClass
    public static void afterClass() {
        Driver.closeDriver();
    }
}
