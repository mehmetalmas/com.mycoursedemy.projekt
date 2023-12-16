package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_010 {
    MyCoursesPage myCoursesPage = new MyCoursesPage();
    HomePage homePage = new HomePage();
    CoursesPage coursesPage = new CoursesPage();
    AllCourses_AllCategory allCategory = new AllCourses_AllCategory();
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void beforeMethod() {
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("student.344.mehmet");
        String password = ConfigReader.getPassword("password.344.mehmet");
        loginPage.login(email, password);
        myCoursesPage.uS_10_button_MyCourses.click();
    }

    @Test
    public void uS_010_TC_01_ResetButton() {
        myCoursesPage.uS_10_TC_01_button_Reset.click();
        String resetTitle = Driver.getDriver().getTitle();
        Driver.getDriver().navigate().refresh();
        String refreshTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(resetTitle, refreshTitle);
    }

    @Test
    public void uS_010_TC_02_SearchBox() {
        myCoursesPage.uS_10_TC_02_SearchMyCourses.sendKeys("Wordpress");
        ReusableMethods.bekle(3);
        softAssert.assertTrue(myCoursesPage.uS_10_TC_02_Wordpress.isDisplayed());
    }

    @Test
    public void uS_010_TC_03_ScoringScreen() {
        myCoursesPage.uS_10_TC_03_EditRating.click();
        softAssert.assertTrue(myCoursesPage.uS_10_TC_03_ScoringScreen1.isDisplayed());
    }

    @Test
    public void uS_010_TC_04_CancelButton() {
        myCoursesPage.uS_10_TC_04_button_Cancel.click();
        softAssert.assertTrue(myCoursesPage.uS_10_TC_03_EditRating.isDisplayed());
    }

    @Test
    public void uS_010_TC_05_ScoreRange() {
        myCoursesPage.uS_10_TC_03_EditRating.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(myCoursesPage.uS_10_TC_03_ScoringScreen1).perform();
        softAssert.assertTrue(myCoursesPage.uS_10_TC_03_ScoringScreen1.isEnabled());
        myCoursesPage.uS_10_TC_04_button_Cancel.click();
    }

    @Test
    public void uS_010_TC_06_MsgTextbox() {
        myCoursesPage.uS_10_TC_03_EditRating.click();
        myCoursesPage.uS_10_TC_06_msgTextboox.clear();
        myCoursesPage.uS_10_TC_06_msgTextboox.sendKeys("Bu kursu begendim");
        String expectedTextboox = "Bu kursu begendim";
        String actualTextboox = myCoursesPage.uS_10_TC_06_msgTextboox.getText();
        System.out.println(actualTextboox);
        softAssert.assertEquals(actualTextboox, expectedTextboox);
        myCoursesPage.uS_10_TC_05_PublishRating.click();
    }

    @Test
    public void uS_010_TC_07_PublishRatingButton() {
        myCoursesPage.uS_10_TC_03_EditRating.click();
        Select scoringScreen = new Select(myCoursesPage.uS_10_TC_03_ScoringScreen1);
        scoringScreen.getOptions().get(3).click();
        ReusableMethods.bekle(2);
        myCoursesPage.uS_10_TC_05_PublishRating.click();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qualitydemy.com/home/course/wordpress/3");
        softAssert.assertTrue(myCoursesPage.uS_10_TC_10_Reviews.isDisplayed());
        Driver.getDriver().navigate().to("https://qualitydemy.com/home/my_courses");
    }

    @Test
    public void uS_010_TC_08_StartLessonButton() {
        Driver.getDriver().get("https://qualitydemy.com/home/my_courses");
        myCoursesPage.uS_10_TC_07_startLesson.click();
        myCoursesPage.uS_10_TC_07_WordpressKurs.isDisplayed();
    }

    @AfterTest
    public void close() {
        ReusableMethods.bekle(3);
        Driver.getDriver().close();
    }

    /*
       @BeforeTest
        - MyCourseDemy anasayfasi'na gidin
        - Login butonuna tiklayin
        - Email adresini girin
        - Sifrenizi girin
        - Login sekmesine tiklayin
        - Kurslarim linkini tiklayin


      TC_01
        - Reset butonuna basıldığında sayfa yenilendigini test edin
      TC_02
        - Kurslarin, arama kutusundan seçilebilmelir oldugunu test edin
      TC_03
       - Edit rating linkine tiklandiginda puanlama ekraninin görünür oldugunu test edin
      TC_04
       - Edit rating linkine tiklayin
       - Cancel tusuna basildiginda puanlama ekraninin kapandigini test edin
      TC_05
       - Edit rating linkine tiklayin
       - Puan araliginin secilebilir oldugunu test edin
      TC_06
       - Edit rating linkine tiklayin
       - Msg metin kutusuna not yazmak mümkün oldugunu test edin
      TC_07
       - Edit rating linkine tiklayin
       - Bir puan araligi secin
       - Publish rating butonuna basildiginda secilen degerlendirmenin yayinladigini test edin
      TC_08
       - Start lesson butonuna tıklandığında ilgili ders sayfasına gidildigini test edin

     */


}
