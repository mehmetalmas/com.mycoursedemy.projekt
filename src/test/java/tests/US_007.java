package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.SignUpPage;
import pages.mycoursedemy.TempMailPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_007 {

    @Test
    public void tempMailTest() {

        TempMailPage tempMailPage = new TempMailPage();
        Driver.getDriver().get(ConfigReader.getProperty("tempMailUrl"));

        CookiesComp cookiesComp = new CookiesComp();
        tempMailPage.buttonCookies.click();
        tempMailPage.buttonRandomEmailAdress.click();

        String randomEmail = tempMailPage.buttonRandomEmailAdressGenerator.getText();
        String tempMailWindowHandle = Driver.getDriver().getWindowHandle();

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        HeaderComp headerComp = new HeaderComp();
        headerComp.buttonSignUp.click();
        cookiesComp.hideCookies();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.fieldFirstName.sendKeys("Melek"
                + Keys.TAB
                + "Kelek"
                + Keys.TAB
                + randomEmail
                + Keys.TAB
                + "Kelek3675."
                + Keys.TAB
                + Keys.ENTER);

        String qualityhandleDegeri = Driver.getDriver().getWindowHandle();

        Driver.getDriver().switchTo().window(tempMailWindowHandle);

        tempMailPage.buttonCheckInbox.click();
        Driver.getDriver().switchTo().frame("ifmail");
        ReusableMethods.bekle(3);

        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(tempMailPage.elementVerificationCode).perform();
        String codeText = tempMailPage.elementVerificationCode.getText();

        String[] codeSplit = codeText.split(" ");
        String code = codeSplit[codeSplit.length - 1];

        Driver.getDriver().switchTo().window(qualityhandleDegeri);
        cookiesComp.acceptCookies();

        signUpPage.fieldVerificationCode.sendKeys(code);
        signUpPage.buttonContinue.click();
        ReusableMethods.bekle(3);

        String actualResult = signUpPage.verifiedMessage.getText();
        String expectedResult = "Congratulations!Your email address has been successfully verified.";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll();

        Driver.getDriver().close();

    }
}
