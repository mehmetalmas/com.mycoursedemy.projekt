package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyCoursesPage {

    @FindBy(xpath = "//*[text()=' Purchase history']")
    public WebElement buttonPurchaseHistory;

    @FindBy(xpath = "//a[text()='Invoice']")
    public WebElement buttonInvoice;

    @FindBy(xpath = "//div[@class='course-image']")
    public WebElement fieldFirstCourse;
    @FindBy(xpath = "(//div[@class='course-image'])[2]")
    public WebElement fieldSecondCourse;

    @FindBy(xpath = "//a[contains(text(), 'Res')]") //
    public WebElement buttonReset;

    @FindBy(xpath = "/html/body/section[1]/div/nav/div[3]/div/a")
    public WebElement uS_10_button_MyCourses;

    @FindBy(xpath = "/html/body/section[3]/div/div[1]/div/div[1]/div[2]/a")
    public WebElement uS_10_TC_01_button_Reset;

    @FindBy(xpath = "/html/body/section[3]/div/div[1]/div/div[2]/form/div/input")
    public WebElement uS_10_TC_02_SearchMyCourses;

    @FindBy(xpath = "//*[@id=\"my_courses_area\"]/div/div/div/a/div/span")
    public WebElement uS_10_TC_02_Wordpress;

    @FindBy(xpath = "//*[@id=\"edit_rating_btn_3\"]")
    public WebElement uS_10_TC_03_EditRating;

    @FindBy(xpath = "//select[@id=\"star_rating_of_course_3\"]")
    public WebElement uS_10_TC_03_ScoringScreen1;

    @FindBy(xpath = "//*[@id=\"star_rating_of_course_3\"]/option[4]")
    public WebElement uS_10_TC_07_ScoringScreen2;

    @FindBy(xpath = "//*[@id=\"course_rating_view_3\"]/form/a")
    public WebElement uS_10_TC_04_button_Cancel;

    @FindBy(xpath = "//*[@id=\"course_rating_view_3\"]/form/button")
    public WebElement uS_10_TC_05_PublishRating;

    @FindBy(xpath = "//*[@id=\"review_of_a_course_3\"]")
    public WebElement uS_10_TC_06_msgTextboox;

    @FindBy(xpath = "//*[@id=\"course_info_view_3\"]/div[2]/div/a")
    public WebElement uS_10_TC_07_startLesson;

    @FindBy(xpath = "/html/body/section[4]/div/div/div[1]/div[7]/div[2]/div/div[2]/ul/li[4]/span")
    public WebElement uS_10_TC_10_Reviews;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/h5")
    public WebElement uS_10_TC_07_WordpressKurs;

    @FindBy(xpath = "/html/body/section[1]/div/nav/div[1]/ul/li/a/span[1]")
    public WebElement uS_038_Categories;

    @FindBy(xpath = "/html/body/section[1]/div/nav/div[1]/ul/li/ul/li[7]/a/span[2]")
    public WebElement uS_038_AllCourses;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[2]/div[2]/ul/li[3]/div/div[2]/a")
    public WebElement uS_038_TC_01_WordpressCourse;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[2]/div/div/div[3]/ul/li[5]/a")
    public WebElement uS_038_TC_01_Compare;

    @FindBy(xpath = "/html/body/section[2]/div[2]/nav/ol/li[2]")
    public WebElement uS_038_TC_01_CourseCompare;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[2]/nav/ul/li[2]/a")
    public WebElement uS_038_TC_02_PageikiNo;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[2]/div[1]/div[1]/span")
    public WebElement uS_038_TC_02_Showing;

    @FindBy(xpath = "//a[text() = 'English Course Learn To Speak']")
    public WebElement uS_038_TC_02_EnglishCourse;

    @FindBy(xpath = "//*[@id=\"course_4\"]")
    public WebElement uS_038_TC_02_BuyNow;

    @FindBy(xpath = "/html/body/section[2]/div[2]/nav/ol/li[2]")
    public WebElement uS_038_TC_02_ShoppingCart;

    @FindBy(xpath = "(//a[text()='Ultimate AWS Certified Solutions Architect Associate SAA-C03'])[2]")
    public WebElement uS_038_TC_03_UltimateAWSCertified;

    @FindBy(xpath = "(//*[@id=\"14\"])[2]")
    public WebElement uS_038_TC_03_AddToCart;

    @FindBy(xpath = "//button[text() = 'Added to Cart']")
    public WebElement uS_038_TC_03_AddedToCart;

    @FindBy(xpath = "//h5[text()='English Speaking Course']")
    public WebElement englishSpeakingCourse;

    @FindBy (xpath = "//span[text()='Showing 6 Of 175 Results']")
    public WebElement uS_038_TC_03_Showing;

    @FindBy (xpath = "(//*[@id=\"14\"])[1]")
    public WebElement uS_038_TC_04_AddToWishlist;

    @FindBy (xpath = "//*[@id=\"wishlist_items\"]/div[1]")
    public WebElement uS_038_TC_04_AddedToWishlist;

    @FindBy (xpath = "//*[@id=\"wishlist_items\"]/div[1]/a/i")
    public WebElement uS_038_TC_04_WishListButton;

    @FindBy (xpath = "//a[text()='Go to wishlist']")
    public WebElement uS_038_TC_04_GotoWishList;

    @FindBy (xpath = "//*[@id=\"my_wishlists_area\"]/div/div/div/div[2]/a/h5")
    public WebElement uS_038_TC_04_WishListCourse;

    @FindBy (xpath = "//a[text()='React and Typescript']")
    public WebElement uS_038_TC_05_ReactAndTypescriptCourse;

    @FindBy (xpath = "/html/body/section[3]/div/div/div[2]/div/div[2]/div[3]/a")
    public WebElement uS_038_TC_05_GetEnrolled;

    @FindBy (xpath = "//a[text()='Already purchased']")
    public WebElement uS_038_TC_05_AlreadyPurchased;

    @FindBy (xpath = "/html/body/section[1]/div/nav/div[3]/div/a")
    public WebElement uS_038_TC_05_MyCourses;

    @FindBy (xpath = "//*[@id=\"course_info_view_2\"]/div[1]/a/h5")
    public WebElement uS_038_TC_05_ReactAndTypescriptisDisplay;

    @FindBy (xpath = "//span[text() = 'Showing 6 Of 175 Results']")
    public WebElement uS_038_TC_06_Showing6Of175;

    @FindBy (xpath = "/html/body/section[3]/div/div/div[2]/nav/ul/li[3]")
    public WebElement uS_038_TC_06_Number3;

    @FindBy(xpath = "//div[@class='lecture-group-title clearfix']")
    public WebElement contextMenu;

    @FindBy(xpath = "//span[text()='Installing Python']")
    public WebElement contextCourse;

    @FindBy(xpath = "//div[@id='heading-4']")
    public WebElement buttonFirstSection;

    @FindBy(xpath = "//a[@id='18']")
    public WebElement firstLesson;

    @FindBy(xpath = "//a[text()='Course details ']")
    public WebElement buttonCourseDetails;


    @FindBy(xpath = "//h1[@class='title']")
    public WebElement courseTitle;

    public MyCoursesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}