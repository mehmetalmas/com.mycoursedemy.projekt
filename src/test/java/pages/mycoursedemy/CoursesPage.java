package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CoursesPage {

    public String title = "Active courses | Quality Demy";

    public CoursesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[@for='sub_category-2']")
    public WebElement labelWebDisagnForWebDevelopersCourses;

    @FindBy(xpath = "//label[@for='sub_category-13']")
    public WebElement labelPianoCourses;

    @FindBy(xpath = "//label[@for='sub_category-4']")
    public WebElement labelEnglishSpeakingCourses;

    @FindBy(xpath = "//label[@for='sub_category-5']")
    public WebElement labelDisneyMagicEnglishCourses;

    @FindBy(xpath = "//label[@for='sub_category-7']")
    public WebElement labelHTML5AndCSSCourses;

    @FindBy(xpath = "//label[@for='sub_category-10']")
    public WebElement labelAWSCertificationCourses;

    @FindBy (xpath = "(//*[@id=\"12\"])[2]")
    public WebElement uS_10_Build_Responsive_AddtoCart;

    @FindBy  (xpath = "//*[@id=\"course_12\"]")
    public  WebElement uS_10_Build_Responsive_BuyNow;

    @FindBy (xpath = "//*[@id=\"cart_items_details\"]/div[2]/div/button")
    public WebElement uS_10_Build_Responsive_Checkout;

    @FindBy (xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/div/div/img[2]")
    public WebElement uS_10_Build_Responsive_Stripe;

    @FindBy (xpath = "//*[@id=\"stripePayButton\"]")
    public WebElement uS_10_Build_Responsive_PayWithStripe;

    @FindBy (xpath = "//*[@id=\"email\"]")
    public WebElement uS_10_Build_Responsive_Eposta;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/form/div[2]/div/div[2]/button/div[3]")
    public WebElement uS_10_Build_Responsive_Ode;


    @FindBy(xpath = "//a[text()='Add new course']")
    public WebElement buttonAddNewCourse;
    public AddCoursePage gotoAddCoursePage() {
        buttonAddNewCourse.click();
        return new AddCoursePage();
    }
    @FindBy(xpath = "//label[@for='sub_category-6']")
    public WebElement labelEnglishGrammar;

    @FindBy(xpath = "//a[@id='city-toggle-btn']")
    public WebElement labelShowMore;

    //************************************************
    //Usefull Things

    @FindBy(xpath = "//h1[@class='display-4 fw-600 text-white']")
    public WebElement pageBlog;

    @FindBy(xpath = "//li[@class='breadcrumb-item display-6 fw-bold']")
    public WebElement pageAllCourses;

    @FindBy(xpath = "//h1[@class='fw-700']")
    public WebElement pageSignUp;

    //**************************************************
    //Help

    @FindBy(xpath = "//li[@class='breadcrumb-item active text-light display-6 fw-bold']")
    public WebElement labelAboutUs;

    @FindBy(xpath = "//div[@class='container-lg breadcrumb-container']")
    public WebElement labelPrivacyPolicy;

    @FindBy(xpath = "//li[@class='breadcrumb-item active text-light display-6 fw-bold']")
    public WebElement labelTermsAndCondition;

    @FindBy(xpath = "//li[@class='breadcrumb-item active text-light display-6 fw-bold']")
    public WebElement labelRefundPolicy ;

    @FindBy(xpath = "(//span[@class='d-none d-sm-inline'])[6]")
    public WebElement buttonMedia;


}
