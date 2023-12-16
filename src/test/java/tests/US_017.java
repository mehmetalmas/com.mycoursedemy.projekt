package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.UserPhotoPage;
import pages.mycoursedemy.UserProfilePage;
import pages.mycoursedemy.component.HeaderComp;
import pages.mycoursedemy.component.ToastMessageComp;
import utilities.ConfigReader;
import utilities.Driver;

public class US_017 {
    /*
 "- Repeats the steps in US-016 and TC_0001
- Clicks the Photo Button should redirect to https://mycoursedemy.com/home/profile/user_photo page
- Clicks the Choose file at the same page
- Confirms that windows folders can be opened."

"- Repeats the steps in TC_0001
- Selects a picture
- Clicks upload button.
- Confirms that toast message shows Updated successfully message"

"- Repeats the sreps in TC_0001
- Selects a picture
- Clicks upload button.
- Confirms that toast message shows Please select only jpg/png file message"
     */

    HeaderComp header;
    UserProfilePage userProfilePage;

    String dataPath = System.getProperty("user.home") + "/IdeaProjects/DenemeProjesi/data/";

    @BeforeMethod
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("student.352.anil");
        String password = ConfigReader.getPassword("password.352.anil");
        loginPage.login(email, password);

        new ToastMessageComp().hideToastMessage();

        header = new HeaderComp();
        userProfilePage = header.goToUserProfile();
    }

    @AfterMethod
    public void afterMethod() {
        header.logout();
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        UserPhotoPage userPhotoPage = userProfilePage.gotoUserPhotoPage();
        softAssert.assertEquals(Driver.getDriver().getTitle(), userPhotoPage.title);
        //if this code does not give any error message that choose file windows is clickable.
        userPhotoPage.fieldChooseFile.sendKeys(dataPath + "/testFile.txt");
        softAssert.assertAll();
    }

    @Test
    public void test02() {
        SoftAssert softAssert = new SoftAssert();
        UserPhotoPage userPhotoPage = userProfilePage.gotoUserPhotoPage();
        softAssert.assertEquals(Driver.getDriver().getTitle(), userPhotoPage.title);
        userPhotoPage.fieldChooseFile.sendKeys(dataPath + "/testPicture.png");
        userPhotoPage.buttonUpload.click();
        ToastMessageComp toastMessageComp = new ToastMessageComp();
        softAssert.assertEquals(toastMessageComp.toastMessage.getText(), "Updated successfully");
        toastMessageComp.hideToastMessage();
        softAssert.assertAll();
    }


}
