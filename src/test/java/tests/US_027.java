package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_027 {
    HomePage homePage = new HomePage();
    InstructorPage instructorPage = new InstructorPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void beforeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("teacher.293.mehmet");
        String password = ConfigReader.getPassword("password.293.mehmet");
        loginPage.login(email, password);

        homePage.uS_027_Instructor.click();
        instructorPage.uS_027_CourseManager.click();
        instructorPage.uS_027_AddNewCourse.click();
        instructorPage.uS_027_Seo.click();
        instructorPage.uS_027_MetaKeywords.sendKeys("Meta Keywords Test Yazisi");

        String expectedmetaKeyword = "Meta Keywords Test Yazisi";
        String actualmetaKeyword = instructorPage.uS_027_MetaKeywords.getText();
        System.out.println(actualmetaKeyword);
        softAssert.assertEquals(actualmetaKeyword, expectedmetaKeyword);

        instructorPage.uS_027_MetaDescription.sendKeys("Meta Description Test Yazisi");
        String expectedmetaDescription = "Meta Description Test Yazisi";
        String actualmetaDescription = instructorPage.uS_027_MetaDescription.getText();
        System.out.println(actualmetaDescription);
        softAssert.assertEquals(actualmetaDescription, expectedmetaDescription);


    }

    @AfterTest
    public void close() {
        ReusableMethods.bekle(3);
        Driver.getDriver().close();
    }

       /*
        - MyCourseDemy anasayfasi'na gidin
        - Login butonuna tiklayin
        - Instructor Email adresinizi girin
        - Instructor Sifrenizi girin
        - Login sekmesine tiklayin
        - Instructor butonunu tiklayin
        - Course Manager butonuna tiklayin
        - Add new course butonuna tiklayin
        - Seo sekmesine tiklayin
        - Meta keywords metin  kutusuna aciklama yazilabildigini test edin
        - Meta description metin kutusuna aciklama yazilabildigini test edin
     */

}
