package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.HomePage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.CookiesComp;
import pages.mycoursedemy.component.HeaderComp;
import pages.mycoursedemy.component.ShoppingCartPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_026 {
    //The functions of the course_form/course_edit media section should work correctly

    LoginPage loginPage = new LoginPage();
    String user = ConfigReader.getUser("teacher.294.ilhan");
    String password = ConfigReader.getPassword("password.294.ilhan");
    InstructorPage instructorPage = new InstructorPage();
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    String dataPath = System.getProperty("user.home") + "\\Desktop\\TESTER\\DenemeProjesi\\data/";




    @BeforeMethod
    public void login() {
        loginPage.login(user, password);
        homePage.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        shoppingCartPage.buttonaddNewCourse.click();
        shoppingCartPage.buttonMedia.click();
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
    private void logout() {
        shoppingCartPage.buttonAccount.click();
        ReusableMethods.bekle(1);
        shoppingCartPage.buttonLogout.click();
    }
    @Test
    public void TC0001() {
        // The desired option should be searchable from the Course overview provider dropdown
        shoppingCartPage.overviewProviderDropDownMenu.click();
        shoppingCartPage.fieldoverviewProviderDropDownMenu.sendKeys("Vimeo"+ Keys.ENTER);
        String actualText=shoppingCartPage.overviewProviderDropDownMenu.getText();
        String expectetText="Vimeo";
        softAssert.assertEquals(actualText,expectetText);
        softAssert.assertAll();
        logout();

    }
    @Test
    public void TC0002() {
        // Relevant url should be entered in Course overview url textbox
        shoppingCartPage.yaziAlaniKutusuCourseOverviewUrl.sendKeys("https://vimeo.com/");
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//input[@id='course_overview_url']"));
        String searchBoxtext = elements.get(0).getAttribute("value");
        String expectetText="https://vimeo.com/";
        softAssert.assertEquals(searchBoxtext,expectetText);
        softAssert.assertAll();
        logout();

    }
    @Test
    public void TC0003() {
        // Image can be uploaded to Course thumbnail
        shoppingCartPage.resimEklemeCourseThumbnail.sendKeys(dataPath + "testPicture.png");
       logout();
    }
}