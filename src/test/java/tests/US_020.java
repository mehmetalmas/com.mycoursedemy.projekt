package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import java.util.Set;

public class US_020 {
    // The functions of the course_form/course_edit page should work correctly
    LoginPage loginPage=new LoginPage();
    String user = ConfigReader.getUser("teacher.294.ilhan");
    String password = ConfigReader.getPassword("password.294.ilhan");
    InstructorPage instructorPage=new InstructorPage();
    Actions actions=new Actions(Driver.getDriver());
    HomePage homePage=new HomePage();
    SoftAssert softAssert=new SoftAssert();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    HeaderComp headerComp=new HeaderComp();


  @BeforeMethod
    public void login(){
      //3 Testte de login olduktan sonra "Instructer" kullanicisiyla "Course Maneger" sayfasina gidilir ve "Add new course" butonuna tiklanir
        loginPage.login(user,password);
        homePage.buttonInstructor.click();
        instructorPage.buttonCourseManager.click();
        shoppingCartPage.buttonaddNewCourse.click();
    }
    @AfterClass
    public static void tearDown(){

      Driver.getDriver().quit();
    }
    @Test
    public void TC0001(){
        // When the Back to course list button is clicked, it should redirect to the course manager page.
        shoppingCartPage.buttonBackToCourseList.click();
        softAssert.assertTrue(shoppingCartPage.textCourses.isDisplayed());
        softAssert.assertAll();
        logout();
    }

    private void logout() {
        shoppingCartPage.buttonAccount.click();
        ReusableMethods.bekle(1);
        shoppingCartPage.buttonLogout.click();
    }

    @Test
    public void TC0002(){
      //When the "View on frontend" button is clicked, it should redirect to the page of the relevant course content.
        shoppingCartPage.courseTitleKutusu.sendKeys("Qa Kursu");
        shoppingCartPage.categoryMenusu.click();
        shoppingCartPage.categorySecimi.click();
        shoppingCartPage.ilkNextButonu.click();
        shoppingCartPage.ilkNextButonu.click();
        shoppingCartPage.ilkNextButonu.click();
        shoppingCartPage.coursePrice.sendKeys("120");
        shoppingCartPage.discountKutusu.sendKeys("25");
        shoppingCartPage.ilkNextButonu.click();
        shoppingCartPage.ilkNextButonu.click();
        shoppingCartPage.ilkNextButonu.click();
        shoppingCartPage.submitButonu.click();
        String ilkWindowHandleDegeri=Driver.getDriver().getWindowHandle();
        shoppingCartPage.buttonViewOnFronten.click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        String ikinciWindowHandledegeri="";
        for (String each:windowHandles
             ) {
            if (!each.equals(ilkWindowHandleDegeri)){
                ikinciWindowHandledegeri=each;
            }

        }
        Driver.getDriver().switchTo().window(ikinciWindowHandledegeri);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectetUrl="https://qualitydemy.com/home/course/qa-kursu";
        softAssert.assertTrue(actualUrl.contains(expectetUrl));
        softAssert.assertAll();
        headerComp.logout();

    }
    @Test
    public void TC0003(){
      //It should be possible to switch between the menus with the arrows at the bottom of the page
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        shoppingCartPage.buttonSagaGecis.click();
        softAssert.assertTrue(shoppingCartPage.yaziRequirements.isDisplayed());
        softAssert.assertAll();
        logout();
    }
}