package pages.mycoursedemy.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCartPage {

    public ShoppingCartPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    //****************SHOPPINGCART****************
    @FindBy(xpath = "(//i[@class='fas fa-shopping-cart'])[1]")
    public WebElement shoppingCartButton;

    @FindBy(xpath = "(//div[@onclick='removeFromCartList(this)'])[1]")
    public WebElement removeButonu;

    @FindBy(xpath = "//input[@id='coupon-code']")
    public WebElement fieldApplyCoupon;

    @FindBy(xpath = "//button[@onclick='applyCoupon()']")
    public WebElement applyButonu;

    @FindBy(xpath = "(//div[text()='Wordpress'])[2]")
    public WebElement wordPresKursu;


    @FindBy(xpath = "//span[@class='discount-rate']")
    public WebElement indirimOraniElementi;

    @FindBy(xpath = "//div[@class='total-price']")
    public WebElement indirimsizTotalFiyat;

    @FindBy(xpath = "//div[@class='total-price']")
    public WebElement indirimliTotalFiyat;

    @FindBy(xpath = "//button[@onclick='handleCheckOut()']")
    public WebElement buttonCheckout;

    //************USER PROFILE**************
    @FindBy (xpath = "(//div[@class='icon'])[5]")
    public WebElement homePageDropDown;

    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[5]")
    public WebElement userProfileDropDown;

    @FindBy (xpath = "//input[@name='query']")
    public WebElement fieldSearchForCoursesKutusu;

    @FindBy(xpath = "//img[@class='payment-gateway-icon']")
    public WebElement butonÖdemeStripe;

    @FindBy(xpath = "//input[@id='FristName']")
    public WebElement firstNameKutusu;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastNameKutusu;

    @FindBy(xpath = "//input[@name='twitter_link']")
    public WebElement twitterLinkKutusu;

    @FindBy(xpath = "//input[@name='facebook_link']")
    public WebElement facebookLinkKutusu;

    @FindBy(xpath = "//input[@name='linkedin_link']")
    public WebElement linkedinLinkKutusu;

    @FindBy(xpath = "//iframe[@id='Biography_ifr']")
    public WebElement iframeBiografiKutusu;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement iframeYaziKutusu;


    @FindBy(xpath = "//button[@class='btn red px-5 py-2 radius-8']")
    public WebElement saveButonu;

    @FindBy(xpath = "//i[@class='far fa-user-circle']")
    public WebElement profilButonu;


   // ****************COURSE PAGE***************
    @FindBy(xpath = "//i[@class='mdi mdi-arrow-left-bold']")
    public WebElement buttonSolaGecis;

    @FindBy(xpath = "//i[@class='mdi mdi-arrow-right-bold']")
    public WebElement buttonSagaGecis;

    @FindBy(xpath = "//label[text()='Requirements']")
    public WebElement yaziRequirements;

    @FindBy(xpath = "//a[@class='btn btn-outline-primary btn-rounded alignToTitle']")
    public WebElement buttonaddNewCourse;

    @FindBy(xpath = "//a[@class='alignToTitle btn btn-outline-secondary btn-rounded btn-sm my-1']")
    public WebElement buttonBackToCourseList;

    @FindBy(xpath = "//h4[text()=' Courses                    ']")
    public WebElement textCourses;

    // ******************COURSE ADDING FORM**********
    @FindBy(xpath = "//*[@id='course_title']")
    public WebElement courseTitleKutusu;

    @FindBy(xpath = "(//*[text()='Select a category'])[2]")
    public WebElement categoryMenusu;

    @FindBy(xpath = "(//*[text()='Web Design for Web Developers'])[2]")
    public WebElement categorySecimi;

    @FindBy(xpath = "//*[@class='mdi mdi-arrow-right-bold']")
    public WebElement ilkNextButonu;

    @FindBy(xpath = "//*[@placeholder='Enter course course price']")
    public WebElement coursePrice;

    @FindBy(xpath = "//*[@name='discounted_price']")
    public WebElement discountKutusu;

    @FindBy(xpath = "(//*[@placeholder='Write a keyword and then press enter button'])[2]")
    public WebElement metaKeywordsKutusu;

    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement submitButonu;

    @FindBy(xpath = "//*[text()=' Back to course list']")
    public WebElement backToCourseListButonu;

    @FindBy(xpath = "//a[@class='alignToTitle btn btn-outline-secondary btn-rounded btn-sm ml-1 my-1'] ")
    public WebElement buttonViewOnFronten;

    @FindBy (xpath = "//h1[text()='Qa Kursu']")
    public WebElement digerSayfaYaziElementiQa;

    //*****MEDIA**********
    @FindBy(xpath = "(//span[@class='d-none d-sm-inline'])[5] ")
    public WebElement buttonMedia;

    @FindBy (xpath = "(//span[@class='select2-selection select2-selection--single'])[4]")
    public WebElement overviewProviderDropDownMenu;

    @FindBy(xpath = "//input[@name='course_overview_url']")
    public WebElement yaziAlaniKutusuCourseOverviewUrl;

 //   @FindBy(xpath = "//div[@class='js--image-preview']")
 //   public WebElement resimEklemeCourseThumbnail;

    @FindBy(id = "course_thumbnail")
     public WebElement resimEklemeCourseThumbnail;

    @FindBy(xpath = "//label[@for='course_thumbnail']")
    public WebElement buttonCamera;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement fieldoverviewProviderDropDownMenu;


    //***********SEO*********
    @FindBy(xpath = "(//span[@class='d-none d-sm-inline'])[6] ")
    public WebElement buttonSeo;

    @FindBy(xpath = "//input[@size='43']")
    public WebElement yaziKutusuMetaKeywords;


    @FindBy(xpath = "//textarea[@name='meta_description']")
    public WebElement yaziKutusuMetaDescription;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement buttonLogout;

    @FindBy(xpath = "//span[@class='account-user-name']")
    public WebElement buttonAccount;


}
