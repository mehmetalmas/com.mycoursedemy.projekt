package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddCoursePage {

    @FindBy(xpath = "//*[text()='Media']")
    public WebElement buttonMedia;

    @FindBy(xpath = "//span[@id='select2-course_overview_provider-container']")
    public WebElement buttonCourseOverviewProvider;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement fieldCourseOverviewProvider;

    @FindBy(id = "course_thumbnail")
    public WebElement buttonCourseThumbnail;

    @FindBy(xpath = "//a[@href='#basic']")
    public WebElement tabBasic;

    @FindBy(xpath = "//a[@href='#requirements']")
    public WebElement tabRequirements;

    @FindBy(xpath = "//a[@href='#outcomes']")
    public WebElement tabOutcomes;

    @FindBy(xpath = "//a[@href='#pricing']")
    public WebElement tabPricing;

    @FindBy(xpath = "//a[@href='#seo']")
    public WebElement tabSeo;

    @FindBy(xpath = "//a[@href='finish']")
    public WebElement tabFinish;

    @FindBy(xpath = "//a[@class='btn btn-outline-primary btn-rounded alignToTitle']")
    public WebElement buttonAddNewCourse;

    @FindBy(xpath = "//input[@id='course_title']")
    public WebElement fieldCourseTitle;

    @FindBy(xpath = "//span[@id='select2-sub_category_id-container']")
    public WebElement dropDownCategory;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement fieldCategory;

    @FindBy(xpath = "(//a[@class='btn btn-info'])[2]")
    public WebElement buttonNext;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement fieldCoursePrice;

    @FindBy(xpath = "//input[@id='discounted_price']")
    public WebElement fieldDiscountedPrice;
    @FindBy(xpath = "//input[@id='course_overview_url']")
    public WebElement fieldCourseOverviewUrl;

    @FindBy(xpath = "//button[@class='btn btn-primary text-center']")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//h2[text()='Congratulations!']")
    public WebElement toastMessage;

    @FindBy(xpath = "//*[text()='Pricing']")
    public WebElement buttonPricingCourseManager;

    @FindBy(xpath = "//*[text()='Check if this is a free course']")
    public WebElement checkboxFreePricing;

    @FindBy(xpath = "//*[text()='Check if this course has discount']")
    public WebElement checkboxHasDiscountPricing;

    public AddCoursePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}

