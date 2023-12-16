package tests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class US_040 {


    @Test
    public void TC_0001() {

        InstructorPage instructorPage = new InstructorPage();
        SoftAssert softAssert = new SoftAssert();

        instructorPage.fieldSearch.sendKeys(ConfigReader.getProperty("nameKurs"));
        softAssert.assertTrue(instructorPage.nameKurs.isDisplayed(), "The relevant Kurs is not selectable");
        softAssert.assertAll();

    }

    @Test
    public void TC_0002() {

        InstructorPage instructorPage = new InstructorPage();
        SoftAssert softAssert = new SoftAssert();

        instructorPage.fieldSearch.sendKeys(ConfigReader.getProperty("nameKurs"));
        String firstWindowHandle = Driver.getDriver().getWindowHandle();
        ReusableMethods.waitForClickablility(instructorPage.nameKurs,60);
        instructorPage.nameKurs.click();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles
        ) {
            if (!each.equals(firstWindowHandle)) {
                secondWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(secondWindowHandle);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("kursLink");
        softAssert.assertEquals(actualUrl, expectedUrl, "The website of relevant Kurs is not available.");

    }

    @Test
    public void TC_0003() {
        InstructorPage instructorPage = new InstructorPage();
        SoftAssert softAssert = new SoftAssert();

        instructorPage.calendar.click();
        instructorPage.thisMonth.click();
        instructorPage.buttonFilter.click();
        softAssert.assertTrue(instructorPage.nameKurs.isDisplayed(), "the relevant Kurs is not displayed ");

    }

    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage();
        InstructorPage instructorPage = new InstructorPage();
        HeaderComp headerComp = new HeaderComp();
        loginPage.login(("user_1106183@login.com"), "560826104");
        headerComp.buttonInstructor.click();
        instructorPage.salesReport.click();
    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    //
    }

}
