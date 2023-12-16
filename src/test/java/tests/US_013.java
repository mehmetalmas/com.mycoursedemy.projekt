package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_013 {
    String actualText;
    String expectedText;


    @Test
    public void TC001() {
        SoftAssert softAssert = new SoftAssert();
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();
        Select select = new Select(instructorPage.dropDownMessage);
        select.selectByValue("265");
        select.getFirstSelectedOption().click();
        softAssert.assertTrue(instructorPage.adminMessageText.isDisplayed(), "Messages Text Box for Test" +
                " User is not displayed.");
        select.selectByVisibleText("Admin User");
        select.getFirstSelectedOption().click();
        softAssert.assertTrue(instructorPage.adminMessageText.isDisplayed(), "Messages Text Box for Admi" +
                "n is not displayed.");
        softAssert.assertAll();

    }

    @Test
    public void TC002() {
        SoftAssert softAssert = new SoftAssert();
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();
        softAssert.assertTrue(instructorPage.fieldMessageTextBox.isEnabled(), "Messages Box is not enabled.");
        softAssert.assertAll();

    }

    @Test
    public void TC003() {
        SoftAssert softAssert = new SoftAssert();
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();
        Select select = new Select(instructorPage.dropDownMessage);
        select.selectByValue("265");
        select.getFirstSelectedOption().click();
        instructorPage.fieldMessageTextBox.sendKeys(ConfigReader.getProperty("testUser'sMessage"));
        ReusableMethods.clickElementByJS(instructorPage.buttonSend);
        instructorPage.fromTestUserMessages.click();
        List<WebElement> chatBox = Driver.getDriver().findElements(By.className("message"));
        actualText = chatBox.get(chatBox.size() - 1).getText();
        expectedText = ConfigReader.getProperty("testUser'sMessage");
        softAssert.assertEquals(actualText, expectedText, "Test User's Message is not displayed");

        instructorPage.messages.click();
        instructorPage.fieldMessageTextBox.sendKeys(ConfigReader.getProperty("Admin'sMessage"));
        ReusableMethods.clickElementByJS(instructorPage.buttonSend);
        instructorPage.fromAdminMessages.click();
        List<WebElement> chatBox2 = Driver.getDriver().findElements(By.className("message"));
        actualText = chatBox2.get(chatBox2.size() - 1).getText();
        expectedText = ConfigReader.getProperty("Admin'sMessage");
        softAssert.assertEquals(actualText, expectedText, "Admin's Message is not displayed");
        softAssert.assertAll();
    }

    @Test
    public void TC004() {
        SoftAssert softAssert = new SoftAssert();
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();
        ReusableMethods.clickElementByJS(instructorPage.cancelMessage);
        softAssert.assertTrue(instructorPage.hiddenMessageBox.isDisplayed());
        softAssert.assertAll();

    }

    @Test
    public void TC005() {
        SoftAssert softAssert = new SoftAssert();
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();
        ReusableMethods.clickElementByJS(instructorPage.cancelMessage);
        instructorPage.composeButton.click();
        softAssert.assertTrue(instructorPage.fieldMessageTextBox.isEnabled(), "Messages Box is not enabled.");
        softAssert.assertAll();
    }

    @Test
    public void TC006() {
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();
        Select select = new Select(instructorPage.dropDownMessage);
        select.selectByValue("265");
        select.getFirstSelectedOption().click();
        instructorPage.fromTestUserMessages.click();
        List<WebElement> chatBoxTestUser = Driver.getDriver().findElements(By.className("message"));
        int YollananMesajAdedi = chatBoxTestUser.size();
        for (int i = 0; i < 2; i++) {
            instructorPage.fieldMessageTextBox.sendKeys(ConfigReader.getProperty("testUser'sMessage"));
            ReusableMethods.clickElementByJS(instructorPage.buttonSend);
            YollananMesajAdedi++;
        }

        List<WebElement> chatBoxTestUser2 = Driver.getDriver().findElements(By.className("message"));

        int actualTotalMessagesAmount = chatBoxTestUser2.size();
        int expectedTotalMessagesAmount = YollananMesajAdedi;


        Assert.assertEquals(actualTotalMessagesAmount, expectedTotalMessagesAmount, "The messages which are" +
                "from Test User's sent are not arrived.");

    }

    @Test
    public void TC0061() {
        InstructorPage instructorPage = new InstructorPage();
        instructorPage.messageInstructor.click();

        instructorPage.fromAdminMessages.click();
        List<WebElement> chatBoxTestUser = Driver.getDriver().findElements(By.className("message"));
        int YollananMesajAdedi = chatBoxTestUser.size();
        for (int i = 0; i < 2; i++) {
            instructorPage.fieldMessageTextBox.sendKeys(ConfigReader.getProperty("Admin'sMessage"));
            ReusableMethods.clickElementByJS(instructorPage.buttonSend);
            YollananMesajAdedi++;
        }
        List<WebElement> chatBoxTestUser2 = Driver.getDriver().findElements(By.className("message"));

        int actualTotalMessagesAmount = chatBoxTestUser2.size();
        int expectedTotalMessagesAmount = YollananMesajAdedi;

        Assert.assertEquals(actualTotalMessagesAmount, expectedTotalMessagesAmount, "The messages sent" +
                "from Test User's  are not arrived.");


    }

    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginpage = new LoginPage();
        HeaderComp headerComp = new HeaderComp();
        loginpage.login(("user_1106183@login.com"), "560826104");
        headerComp.buttonInstructor.click();
    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }


}
