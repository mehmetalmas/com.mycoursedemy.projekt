package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.UserCredentialsPage;
import pages.mycoursedemy.UserProfilePage;
import pages.mycoursedemy.component.HeaderComp;
import pages.mycoursedemy.component.ToastMessageComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

/*
The functions of the user_credentials page should work correctly

--The account button should redirect to the user_credentials page
--Current password should be able to get entered,
--New password should be able to get entered,
--Confirm password should be able to get entered
--If the New password and Confirm password values are the same when save change is called, the change should be saved.
--If the New password and Confirm password values are different when save change is called, Mismatch password warning should be given.
 */

public class US_016 {

    HeaderComp header;
    UserCredentialsPage userCredentialsPage;

    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("student.352.anil");
        String password = ConfigReader.getPassword("password.352.anil");
        loginPage.login(email, password);

        new ToastMessageComp().hideToastMessage();

        header = new HeaderComp();
        UserProfilePage userProfilePage = header.goToUserProfile();
        userCredentialsPage = userProfilePage.gotoUserCredentialsPage();
    }

    @AfterMethod
    public void afterMethod() {
        header.logout();
        ReusableMethods.bekle(1);
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void test01_accountButtonRedirectToUserCredentialsPage() {
        Assert.assertEquals(Driver.getDriver().getTitle(), userCredentialsPage.title);
    }

    @Test
    public void test02_currentPasswordAbleToGetEntered() {
        SoftAssert softAssert = new SoftAssert();

        boolean isDisplayed = userCredentialsPage.fieldCurrentPassword.isDisplayed();
        softAssert.assertTrue(isDisplayed);

        boolean isEnabled = userCredentialsPage.fieldCurrentPassword.isEnabled();
        softAssert.assertTrue(isEnabled);

        String anyPassword = "AnyPassword";
        userCredentialsPage.fieldCurrentPassword.sendKeys(anyPassword);
        String writtenValue = userCredentialsPage.fieldCurrentPassword.getAttribute("value");
        softAssert.assertTrue(anyPassword.equals(writtenValue), writtenValue);

        userCredentialsPage.fieldCurrentPassword.clear();
        softAssert.assertAll();
    }


    @Test
    public void test03_newPasswordAbleToGetEntered() {
        SoftAssert softAssert = new SoftAssert();
        String anyPassword = "AnyPassword";
        userCredentialsPage.fieldNewPassword.sendKeys(anyPassword);
        String writtenValue = userCredentialsPage.fieldNewPassword.getAttribute("value");
        softAssert.assertTrue(anyPassword.equals(writtenValue));

        userCredentialsPage.fieldNewPassword.clear();
        softAssert.assertAll();
    }

    @Test
    public void test04_confirmPasswordAbleToGetEntered() {
        SoftAssert softAssert = new SoftAssert();
        String anyPassword = "AnyPassword";
        userCredentialsPage.fieldConfirmPassword.sendKeys(anyPassword);
        String writtenValue = userCredentialsPage.fieldConfirmPassword.getAttribute("value");
        softAssert.assertTrue(anyPassword.equals(writtenValue));

        userCredentialsPage.fieldConfirmPassword.clear();
        softAssert.assertAll();
    }

    @Test
    public void test05_ifNewPasswordAndConfirmPasswordAreSameChangeShouldBeSaved() {
        SoftAssert softAssert = new SoftAssert();
        //When new password and confirm password entries are the same
        String newPassword = ConfigReader.getPassword("password.352.anil");
        userCredentialsPage.fieldNewPassword.sendKeys(newPassword);
        userCredentialsPage.fieldConfirmPassword.sendKeys(newPassword);
        //And Save changes clicked
        userCredentialsPage.buttonSaveChanges.click();
        //Change should be saved
        ToastMessageComp toastMessageComp = new ToastMessageComp();
        softAssert.assertEquals(toastMessageComp.getText(), "Updated successfully");
        toastMessageComp.hideToastMessage();
        softAssert.assertAll();
    }

    @Test
    public void test06_ifNewPasswordAndConfirmPasswordAreSameChangeShouldNotBeSaved() {
        SoftAssert softAssert = new SoftAssert();
        //When new password and confirm password entries are the same
        String newPassword = ConfigReader.getPassword("password.352.anil");
        userCredentialsPage.fieldNewPassword.sendKeys(newPassword);
        userCredentialsPage.fieldConfirmPassword.sendKeys("DifferentValue");
        //And Save changes clicked
        userCredentialsPage.buttonSaveChanges.click();
        //Change should not be saved
        ToastMessageComp toastMessageComp = new ToastMessageComp();
        softAssert.assertEquals(toastMessageComp.getText(), "Confirm password does not match!");
        toastMessageComp.hideToastMessage();
        softAssert.assertAll();
    }
}
