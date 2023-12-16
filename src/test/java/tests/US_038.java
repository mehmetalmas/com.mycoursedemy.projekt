package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.CoursesPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.MyCoursesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_038 {
    CoursesPage coursesPage = new CoursesPage();
    MyCoursesPage myCoursesPage = new MyCoursesPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void beforeTest() {
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        LoginPage loginPage = new LoginPage();
        String email = ConfigReader.getUser("student.344.mehmet");
        String password = ConfigReader.getPassword("password.344.mehmet");
        loginPage.login(email, password);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(myCoursesPage.uS_038_Categories).click(myCoursesPage.uS_038_AllCourses).perform();
    }

    @Test
    public void uS_038_TC_01_CompareThisCourseWithOtherButton() {
        myCoursesPage.uS_038_TC_01_WordpressCourse.click();
        myCoursesPage.uS_038_TC_01_Compare.click();
        softAssert.assertTrue(myCoursesPage.uS_038_TC_01_CourseCompare.isDisplayed());
    }

    @Test
    public void uS_038_TC_02_ButtonPressed() {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(myCoursesPage.uS_038_TC_02_Showing)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_02_EnglishCourse);
        myCoursesPage.uS_038_TC_02_BuyNow.click();
        softAssert.assertTrue(myCoursesPage.uS_038_TC_02_ShoppingCart.isDisplayed());
    }

    @Test
    public void uS_038_TC_03_bButtonShouldChangeToAddedtoCart() {
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_02_PageikiNo);
        Actions actions = new Actions(Driver.getDriver());
        actions.click(myCoursesPage.uS_038_TC_03_Showing)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_03_UltimateAWSCertified);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_03_AddToCart);
        String expectedCard = "Added to Cart";
        String actualCart = myCoursesPage.uS_038_TC_03_AddedToCart.getText();
        softAssert.assertEquals(actualCart, expectedCard);
    }

    @Test
    public void uS_38_TC_04_ButtonShouldChangeToAddedtoWishlist() {
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_02_PageikiNo);
        Actions actions = new Actions(Driver.getDriver());
        actions.click(myCoursesPage.uS_038_TC_03_Showing)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_03_UltimateAWSCertified);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_04_AddToWishlist);
        String expectedWishlist = "Added to wishlist";
        String actualWishlist = myCoursesPage.uS_038_TC_04_AddedToWishlist.getText();
        softAssert.assertEquals(actualWishlist, expectedWishlist);

        ReusableMethods.hover(myCoursesPage.uS_038_TC_04_WishListButton);
        myCoursesPage.uS_038_TC_04_GotoWishList.click();
        myCoursesPage.uS_038_TC_04_WishListCourse.isDisplayed();
    }

    @Test
    public void uS_38_TC_05_ButtonShouldChangeToAlreadyPurchased() {


        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMinutes(6));
        Driver.getDriver().manage().timeouts().scriptTimeout(Duration.ofDays(2));
        Driver.getDriver().manage().window().







        /*
        myCoursesPage.uS_038_TC_05_ReactAndTypescriptCourse.click();
        ReusableMethods.bekle(2);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_05_GetEnrolled);

        String expectedAlreadypurchased = "Already purchased";
        String actualAlreadypurchased = myCoursesPage.uS_038_TC_05_AlreadyPurchased.getText();
        softAssert.assertEquals(actualAlreadypurchased, expectedAlreadypurchased);

        myCoursesPage.uS_038_TC_05_MyCourses.click();
        myCoursesPage.uS_038_TC_05_ReactAndTypescriptisDisplay.isDisplayed();

         */
    }

    @Test
    public void uS_38_TC_06_ShouldRedirectToThePageWhereTheVideo() {
        /*

        Actions actions = new Actions(Driver.getDriver());
        actions.click(myCoursesPage.uS_038_TC_06_Showing6Of175)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER);
        ReusableMethods.clickElementByJS(myCoursesPage.uS_038_TC_06_Number3);

         */

    }


    /*
       *TC_01
        Bu kursu diğeriyle karşılaştır düğmesine tıklamak, Kurs karşılaştırma sayfasına yönlendirmelidir
       *TC_02
        Ücretli kurslar için şimdi satın al butonuna basıldığında alışveriş_cart sayfasına yönlendirilmelidir.
       *TC_03
        Ücretli dersler için sepete ekle butonuna basıldığında buton "Sepete eklendi" olarak değişmeli ve kurs sepet sayfasına eklenmelidir.
       *TC_04
        İstek listesine ekle butonuna basıldığında buton "İstek listesine eklendi" olarak değişmeli ve kurs istek listesi sayfasına eklenmelidir.
       *TC_05
        Satın alınmayan ücretsiz kurslar için kayıt ol butonuna basıldığında buton satın alınmış olarak değişmeli ve kurs mycourse sayfasına eklenmelidir.
       *TC_06
        Ders derslerine tıklandığında ilgili dersin videosunun olduğu sayfaya yönlendirilmelidir.
     */

}
