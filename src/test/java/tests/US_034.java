package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class US_034 {
    // The functions of the course_form/add_course seo section should work correctly
    LoginPage loginPage = new LoginPage();
    String user = ConfigReader.getUser("teacher.294.ilhan");
    String password = ConfigReader.getPassword("password.294.ilhan");
    InstructorPage instructorPage = new InstructorPage();
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeMethod
    public void login() {
        loginPage.login(user, password);
        homePage.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        shoppingCartPage.buttonaddNewCourse.click();
        shoppingCartPage.buttonSeo.click();
    }
    @AfterClass
    public static void tearDown() {
   // intructerPage'den intructerLogout metodu cagrilacak
         Driver.closeDriver();
    }
    private void logout() {
        shoppingCartPage.buttonAccount.click();
        ReusableMethods.bekle(1);
        shoppingCartPage.buttonLogout.click();
    }

    @Test
    public void TC0001() {
        //It should be possible to write descriptions in Meta keywords textboxes
        shoppingCartPage.yaziKutusuMetaKeywords.sendKeys("sifre123");
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//input[@size='43']"));
        String actualText = elements.get(0).getAttribute("value");
        String expectetText="sifre123";
        softAssert.assertEquals(actualText,expectetText);
        logout();

    }
    @Test
    public void TC0002() {
        // It should be possible to write descriptions in Meta description textboxes
        shoppingCartPage.yaziKutusuMetaDescription.sendKeys("Aciklama: Hallo");
        List<WebElement> elements1 = Driver.getDriver().findElements(By.xpath("//textarea[@name='meta_description']"));
        String actualText1 = elements1.get(0).getAttribute("value");
        String expectetText="Aciklama: Hallo";
        softAssert.assertEquals(actualText1,expectetText);
        logout();

    }
}
