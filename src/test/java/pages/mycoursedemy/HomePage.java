package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.mycoursedemy.component.HeaderComp;
import utilities.Driver;

public class HomePage {


    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement buttonInstructor;

    public HeaderComp headerComp = new HeaderComp();

    @FindBy(xpath = "//a[@href='https://facebook.com']")
    public WebElement uS_03_buttonFacebookIcon;
    @FindBy(xpath = "//i[@class='fab fa-twitter']")
    public WebElement uS_03_buttonTwitterkIcon;
    @FindBy(xpath = "//i[@class='fab fa-linkedin']")
    public WebElement uS_03_buttonLinkedinIcon;

    @FindBy(xpath = "//a[@href='https://qualitydemy.com/login']")
    public WebElement buttonLogin;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[2]")
    public WebElement buttonTopCategoriesWebDesignForWebDevelopers;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[4]")
    public WebElement buttonTopCategoriesPiano;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[1]")
    public WebElement buttonTopCategoriesEnglishSpeakingCourse;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[3]")
    public WebElement buttonTopCategoriesHTML5AndCSS;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[5]")
    public WebElement buttonTopCategoriesDisneyMagicEnglish;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[6]")
    public WebElement buttonTopCategoriesEnglishGrammar;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[7]")
    public WebElement buttonUsefulLinksBlog;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[8]")
    public WebElement buttonUsefulLinksAllCourses;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[9]")
    public WebElement buttonUsefulLinksSignUp;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[10]")
    public WebElement buttonHelpAboutUs;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[11]")
    public WebElement buttonHelpPrivacyPolicy;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[12]")
    public WebElement buttonHelpTermsAndCondition;

    @FindBy(xpath = "(//a[@class='link-secondary footer-hover-link'])[13]")
    public WebElement buttonHelpRefundPolicy;

    @FindBy(xpath = "//a[@class='btn btn-danger px-4 py-2']")
    public WebElement buttonJoinBecomeNewinstructor;

    @FindBy (xpath = "//h2[contains(text(),'ahead in life with mycoursedemy')]")
    public WebElement uS_0010_Text;

    @FindBy (xpath = "//div[@class = 'col-md-4 col-lg-3 col-xl-3 mb-3 m-md-0 p-0'][2]")
    public WebElement uS_0010_WebDesingforWebDevelopers;

    @FindBy (xpath = "//h5[contains(text(), 'English Course Learn')]")
    public WebElement uS_0010_EnglishCourse;

    @FindBy (xpath = "//*[@id=\"home-banner-area\"]/div/div/div/div/form/div/input")
    public WebElement us_0010_SearchBox;

    @FindBy (xpath = "/html/body/section[1]/div/nav/div[2]/div/a")
    public WebElement uS_027_Instructor;

    @FindBy(xpath = "//button[@class='btn red add-to-cart-btn  big-cart-button-4']")
    public WebElement addToCart;

    @FindBy(xpath = "//h2[@class='fw-bold']")
    public WebElement homepageText;

    @FindBy(xpath = "(//div[@class='text-box'])[1]")
    public WebElement buttonOnlineCoursesText;

    @FindBy(xpath = "(//div[@class='text-box'])[2]")
    public WebElement buttonExpertInstructionText;

    @FindBy(xpath = "(//div[@class='text-box'])[3]")
    public WebElement buttonLifetimeAccessText;

    @FindBy(xpath = "(//span[@class='header-underline-2'])[1]")
    public WebElement headerTopCategoriesText;

    @FindBy(xpath = "(//span[@class='header-underline-2'])[2]")
    public WebElement headerTopCoursesText;

    @FindBy(xpath = "(//span[@class='header-underline-2'])[3]")
    public WebElement headerTop10LatestCoursesText;

    @FindBy(xpath = "(//span[@class='header-underline-2'])[4]")
    public WebElement headerFeaturedInstructorText;

    @FindBy(xpath = "//a[text()='Get started']")
    public WebElement buttonGetStarted;
}

