package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mycoursedemy.*;
import pages.mycoursedemy.component.HeaderComp;
import pages.mycoursedemy.component.ShoppingCartPage;
import pages.stripe.StripePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_039 {
    LoginPage loginPage;
    HeaderComp headerComp;
    InstructorPage instructorPage;
    ShoppingCartPage shoppingCartPage;
    PaymentPage paymentPage;
    MyCoursesPage myCoursesPage;
    StripePage stripePage;
    SoftAssert softAssert;
    Actions actions;
    Faker faker;
    EnglishCourseSpeaking englishCourseSpeaking;
    String user = ConfigReader.getUser("student.350.muhammet");
    String password = ConfigReader.getPassword("password.350.muhammet");
    String userInstructor = ConfigReader.getUser("teacher.299.muhammet");
    String passwordInstructor = ConfigReader.getPassword("password.299.muhammet");
    String englishSpeakingCourse = ConfigReader.getProperty("englishSpeakingCourse");
    String cardNummer = ConfigReader.getProperty("cardNummer");
    String cardNummerFake = ConfigReader.getProperty("cardNummerFake");
    String cardExpiry = ConfigReader.getProperty("cardExpiry");
    String cardCvc = ConfigReader.getProperty("cardCvc");
    String phoneNummer = ConfigReader.getProperty("phoneNummer");
    String buttonOdeClasses;

    @Test(priority = 1)
    public void test_1_PayWithStripeVisibility() {
        loginPage = new LoginPage();
        loginPage.login(user, password);
        headerComp = new HeaderComp();
        englishCourseSpeaking = new EnglishCourseSpeaking();
        headerComp.fieldSearchBox.sendKeys(englishSpeakingCourse + Keys.ENTER);
        englishCourseSpeaking.englishCourseSpeaking.click();
        ReusableMethods.bekle(1);
        englishCourseSpeaking.buttonAddToCart.click();
        ReusableMethods.bekle(1);
        headerComp.buttonCart.click();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.buttonCheckout.click();
        paymentPage = new PaymentPage();
        paymentPage.logoStripe.click();
        ReusableMethods.bekle(2);
        softAssert = new SoftAssert();
        softAssert.assertTrue(paymentPage.buttonPayWithStripe.isEnabled());
        paymentPage.buttonClose.click();
        //shoppingCartPage.buttonRemove.click();
        ReusableMethods.bekle(1);
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void test_2_CheckoutStripeComPageVisibility() {
        loginPage = new LoginPage();
        loginPage.login(user, password);
        headerComp = new HeaderComp();
        ReusableMethods.bekle(2);
        englishCourseSpeaking = new EnglishCourseSpeaking();
        headerComp.fieldSearchBox.sendKeys(englishSpeakingCourse + Keys.ENTER);
        englishCourseSpeaking.englishCourseSpeaking.click();
        ReusableMethods.bekle(3);
        englishCourseSpeaking.buttonAddToCart.click();
        ReusableMethods.bekle(10);
        headerComp.buttonCart.click();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.buttonCheckout.click();
        paymentPage = new PaymentPage();
        paymentPage.logoStripe.click();
        paymentPage.buttonPayWithStripe.click();
        ReusableMethods.bekle(2);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expecttedUrl = "https://checkout.stripe.com/";
        softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expecttedUrl));
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_3_CloseButtonAndShoppingCartPageVisibility() {
        loginPage = new LoginPage();
        loginPage.login(user, password);
        headerComp = new HeaderComp();
        englishCourseSpeaking = new EnglishCourseSpeaking();
        headerComp.fieldSearchBox.sendKeys(englishSpeakingCourse + Keys.ENTER);
        englishCourseSpeaking.englishCourseSpeaking.click();
        ReusableMethods.bekle(2);
        englishCourseSpeaking.buttonAddToCart.click();
        ReusableMethods.bekle(1);
        headerComp.buttonCart.click();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.buttonCheckout.click();
        paymentPage = new PaymentPage();
        paymentPage.logoStripe.click();
        paymentPage.buttonPayWithStripe.isDisplayed();
        paymentPage.buttonClose.click();
        ReusableMethods.bekle(2);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expecttedUrl = "https://qualitydemy.com/home/shopping_cart";
        softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expecttedUrl));
        ReusableMethods.bekle(3);
        headerComp.logout();
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_4_OdeButtonInvisibility() {
        loginPage = new LoginPage();
        loginPage.login(user, password);
        headerComp = new HeaderComp();
        englishCourseSpeaking = new EnglishCourseSpeaking();
        headerComp.fieldSearchBox.sendKeys(englishSpeakingCourse + Keys.ENTER);
        englishCourseSpeaking.englishCourseSpeaking.click();
        ReusableMethods.bekle(1);
        englishCourseSpeaking.buttonAddToCart.click();
        ReusableMethods.bekle(2);
        headerComp.buttonCart.click();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.buttonCheckout.click();
        paymentPage = new PaymentPage();
        paymentPage.logoStripe.click();
        ReusableMethods.bekle(2);
        paymentPage.buttonPayWithStripe.click();
        ReusableMethods.bekle(4);
        actions = new Actions(Driver.getDriver());
        stripePage = new StripePage();
        buttonOdeClasses = stripePage.buttonOde.getAttribute("class");
        softAssert = new SoftAssert();
        softAssert.assertTrue(buttonOdeClasses.contains("SubmitButton--incomplete"));
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);
        stripePage = new StripePage();
        Select selectBillingCountry = new Select(stripePage.dropDownBillingCountry);
        selectBillingCountry.selectByValue("DE");
        ReusableMethods.bekle(1);
        faker = new Faker();
        stripePage.fieldKartUzerindekiAd.sendKeys(faker.name().fullName());
        ReusableMethods.bekle(1);
        stripePage.fieldCardCvc.sendKeys(cardCvc);
        ReusableMethods.bekle(1);
        stripePage.fieldCardExpiry.sendKeys(cardExpiry);
        ReusableMethods.bekle(1);
        stripePage.fieldCardNumber.sendKeys(cardNummerFake);
        ReusableMethods.bekle(1);
        stripePage.checkBoxEnable.click();
        stripePage.fieldPhoneNumber.sendKeys(phoneNummer);
        ReusableMethods.bekle(1);
        stripePage.fieldEPosta.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys().perform();
        buttonOdeClasses = stripePage.buttonOde.getAttribute("class");
        softAssert.assertTrue(buttonOdeClasses.contains("SubmitButton--incomplete"));
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_5_OdeButtonVisibility() {
        loginPage = new LoginPage();
        loginPage.login(user, password);
        headerComp = new HeaderComp();
        englishCourseSpeaking = new EnglishCourseSpeaking();
        headerComp.fieldSearchBox.sendKeys(englishSpeakingCourse + Keys.ENTER);
        englishCourseSpeaking.englishCourseSpeaking.click();
        ReusableMethods.bekle(1);
        englishCourseSpeaking.buttonAddToCart.click();
        ReusableMethods.bekle(1);
        headerComp.buttonCart.click();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.buttonCheckout.click();
        paymentPage = new PaymentPage();
        paymentPage.logoStripe.click();
        paymentPage.buttonPayWithStripe.click();
        ReusableMethods.bekle(1);
        stripePage = new StripePage();
        Select selectBillingCountry = new Select(stripePage.dropDownBillingCountry);
        selectBillingCountry.selectByValue("DE");
        ReusableMethods.bekle(1);
        faker = new Faker();
        stripePage.fieldKartUzerindekiAd.sendKeys(faker.name().fullName());
        ReusableMethods.bekle(1);
        stripePage.fieldCardCvc.sendKeys(cardCvc);
        ReusableMethods.bekle(1);
        stripePage.fieldCardExpiry.sendKeys(cardExpiry);
        ReusableMethods.bekle(1);
        stripePage.fieldCardNumber.sendKeys(cardNummer);
        ReusableMethods.bekle(1);
        stripePage.checkBoxEnable.click();
        stripePage.fieldPhoneNumber.sendKeys(phoneNummer);
        ReusableMethods.bekle(1);
        stripePage.fieldEPosta.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(1);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys().perform();
        ReusableMethods.bekle(1);
        buttonOdeClasses = stripePage.buttonOde.getAttribute("class");
        softAssert = new SoftAssert();
        softAssert.assertTrue(buttonOdeClasses.contains("SubmitButton--complete"));
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void test_6_OdeButtonCheckmarkAndMyCoursesPageVisibilityAndCourseIDisplayedOnTheMycoursePage() {
        loginPage = new LoginPage();
        loginPage.login(user, password);
        headerComp = new HeaderComp();
        englishCourseSpeaking = new EnglishCourseSpeaking();
        headerComp.fieldSearchBox.sendKeys(englishSpeakingCourse + Keys.ENTER);
        englishCourseSpeaking.englishCourseSpeaking.click();
        ReusableMethods.bekle(1);
        englishCourseSpeaking.buttonAddToCart.click();
        ReusableMethods.bekle(1);
        headerComp.buttonCart.click();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.buttonCheckout.click();
        paymentPage = new PaymentPage();
        paymentPage.logoStripe.click();
        paymentPage.buttonPayWithStripe.click();
        ReusableMethods.bekle(1);
        stripePage = new StripePage();
        Select selectBillingCountry = new Select(stripePage.dropDownBillingCountry);
        selectBillingCountry.selectByValue("DE");
        ReusableMethods.bekle(1);
        faker = new Faker();
        stripePage.fieldKartUzerindekiAd.sendKeys(faker.name().fullName());
        ReusableMethods.bekle(1);
        stripePage.fieldCardCvc.sendKeys(cardCvc);
        ReusableMethods.bekle(1);
        stripePage.fieldCardExpiry.sendKeys(cardExpiry);
        ReusableMethods.bekle(1);
        stripePage.fieldCardNumber.sendKeys(cardNummer);
        ReusableMethods.bekle(1);
        if (stripePage.checkBoxEnable.isEnabled()) {
            stripePage.checkBoxEnable.click();
            stripePage.fieldPhoneNumber.sendKeys(phoneNummer);
        }
        ReusableMethods.bekle(1);
        stripePage.fieldEPosta.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(1);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys();
        ReusableMethods.bekle(1);
        stripePage.buttonOde.click();
        ReusableMethods.bekle(25);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qualitydemy.com/home/my_courses";
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectedUrl);
        myCoursesPage = new MyCoursesPage();
        softAssert.assertTrue(myCoursesPage.englishSpeakingCourse.isDisplayed());
        headerComp.logout();
        deleteCourse();
        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() {
        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }

    public void deleteCourse() {
        loginPage = new LoginPage();
        loginPage.login(userInstructor, passwordInstructor);
        headerComp = new HeaderComp();
        headerComp.buttonInstructor.click();
        instructorPage = new InstructorPage();
        instructorPage.buttonCourseManager.click();
        instructorPage.buttonActiveCourses.click();
        ReusableMethods.bekle(2);
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        instructorPage.buttonActionCourse.click();
        instructorPage.dropBoxDelete.click();
        instructorPage.continueDelete.click();
    }
}
