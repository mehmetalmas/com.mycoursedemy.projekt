package pages.mycoursedemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.mycoursedemy.component.HeaderComp;
import utilities.Driver;
import utilities.ReusableMethods;

public class InstructorPage {

    @FindBy(xpath = "//span[text()='Course manager']")
    public WebElement buttonCourseManager;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-outline-primary btn-rounded btn-icon'])[1]")
    public WebElement buttonFirstCourseOptions;
    @FindBy(xpath = "(//a[text()='Edit this course'])[1]")
    public WebElement optionFirstCourseEdit;
    @FindBy(xpath = "(//a[@class='btn btn-outline-primary btn-rounded btn-sm ml-1'])[1]")
    public WebElement buttonAddSection;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement fieldAddSectionTitle;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSubmitAddSection;
    @FindBy(xpath = "//h2[text()='Congratulations!']")
    public WebElement toastSuccessAddSection;
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement buttonCloseAddSection;
    @FindBy(xpath = "//a[text()=' Add lesson']")
    public WebElement buttonAddLesson;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[1]")
    public WebElement numberOfCourses;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[2]")
    public WebElement numberOfEnrolment;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[3]")
    public WebElement pendingBalance;

    @FindBy(xpath = "(//*[@class='card-body text-center'])[4]")
    public WebElement requestedWithdrawalAmount;

    @FindBy(xpath = "//a[@id='topbar-userdrop']")
    public WebElement testUserInstructorIcon;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement testUserInstructorLogout;

    @FindBy(xpath = "//*[text()='Add new course']")
    public WebElement buttonAddNewCourse;

    @FindBy(linkText = "Message")
    public WebElement messageInstructor;
    @FindBy(xpath = "//select[@class='form-control']")
    public WebElement dropDownMessage;
    @FindBy(xpath = "//*[text()='Admin User']")
    public WebElement adminMessageText;
    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement fieldMessageTextBox;
    @FindBy(xpath = "//button[text()='Send ']")
    public WebElement buttonSend;
    @FindBy(xpath = "(//div[@class='message-sender-head clearfix'])[1]")
    public WebElement fromTestUserMessages;
    @FindBy(xpath = "//div[text()='Test User'in Mesaji']")
    public WebElement testUsersMessage;
    @FindBy(xpath = "//*[text()=' Messages                  ']    ")
    public WebElement messages;
    @FindBy(xpath = "(//div[@class='message-sender-head clearfix'])[2]")
    public WebElement fromAdminMessages;
    @FindBy(xpath = "//div[text()='Admin's Message']")
    public WebElement adminsMessage;

    @FindBy(xpath = "(//div[@class='custom-control custom-radio'])[9]")
    public WebElement radioButtonLastLessonType;
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement buttonCloseAddLesson;
    @FindBy(xpath = "//a[text()='Next']")
    public WebElement buttonNext;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement fieldsAddNewInsructorBasic;

    public void testUserInstructorLogout(){

        testUserInstructorIcon.click();
        ReusableMethods.waitForVisibility(testUserInstructorLogout,3);
        testUserInstructorLogout.click();
    }

    public AddCoursePage goToNewCourseAddPage() {
        HeaderComp headerComp=new HeaderComp();
        headerComp.buttonInstructor.click();
        buttonCourseManager.click();
        buttonAddNewCourse.click();
        return new AddCoursePage();
    }
    @FindBy(id = "course_title")
    public WebElement fieldsCourseTitleBasic;

    @FindBy(id = "short_description")
    public WebElement fieldsShortDescriptionBasic;

    @FindBy(xpath = "//div[@class='note-editable card-block']")
    public WebElement fieldsDescriptionBasic;

    @FindBy(id = "select2-sub_category_id-container")
    public WebElement fieldsCategoryBasic;

    @FindBy(id = "level")
    public WebElement fieldsLevelBasic;

    @FindBy(xpath = "//*[text()='Add new course']")
    public WebElement buttonAddnewcourse;

    @FindBy(xpath = "//input[@name='enable_drip_content']")
    public WebElement buttonCheckboxEnableDripContentBasic;

    @FindBy(xpath = "//input[@name='is_top_course']")
    public WebElement buttonCheckboxIstopCourseBasic;
    @FindBy(xpath = "//div[@class='card-body text-center']")
    public WebElement buttonActiveCourses;
    @FindBy(xpath = "(//i[@class='mdi mdi-dots-vertical'])[1]")
    public WebElement buttonActionCourse;
    @FindBy(xpath = "//a[text()='Delete']")
    public WebElement dropBoxDelete;
    @FindBy(xpath = "//a[@id='update_link']")
    public WebElement continueDelete;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelMessage;
    @FindBy(xpath = "//div[@class=\"message-details-box d-hidden\"]")
    public WebElement hiddenMessageBox;
    @FindBy(id = "NewMessage")
    public WebElement composeButton;
    @FindBy(xpath = "//*[text()='Basic']")
    public WebElement buttonBasic;
    @FindBy(id = "is_top_course")
    public WebElement checkBoxTopCourse;
    @FindBy(xpath = "//*[text()='Pricing']")
    public WebElement buttonPricing;
    @FindBy(id = "discount_flag")
    public WebElement checkBoxDiscount;
    @FindBy(xpath = "//label[text()='Course price ($)']")
    public WebElement fieldCoursePrice;
    @FindBy(id = "discounted_percentage")
    public WebElement discountedPercentage;
    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement buttonLogout;
    @FindBy(xpath = "//span[@class='account-user-name']")
    public WebElement buttonAccount;
    @FindBy(xpath = "(//input[@name='title'])[2]")
    public WebElement fieldLessonTitle;
    @FindBy(xpath = "//input[@name='video_url']")
    public WebElement fieldVideoUrl;
    @FindBy(xpath = "//input[@name='duration']")
    public WebElement fieldDuration;
    @FindBy(xpath = "//button[text()='Add lesson']")
    public WebElement buttonSubmitAddLesson;
    @FindBy(xpath = "//text()[contains(.,'kimbu')]")
    public WebElement textLessonName;
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public WebElement optionLessonSection;
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[5]")
    public WebElement fieldLessonSection;
    @FindBy(xpath = "//label[@id='invalid_url']")
    public WebElement textInvalidUrl;
    @FindBy(xpath = "//*[text()='Sales report']")
    public WebElement salesReport;
    @FindBy(xpath = "//input[@aria-controls='sales-report-datatable']")
    public WebElement fieldSearch;
    @FindBy(xpath = "(//*[text()='farkli bir kurs ismi olsun'])[1]")
    public WebElement nameKurs;
    @FindBy(xpath = "//*[@class='mdi mdi-calendar']")
    public WebElement calendar;
    @FindBy(xpath = "//*[text()='This Month']")
    public WebElement thisMonth;
    @FindBy(xpath = "//*[text()=' Filter']")
    public WebElement buttonFilter;
    @FindBy(xpath = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']")
    public WebElement toastSuccessAddLesson;
    @FindBy(xpath = "(//div[@class='note-editable card-block'])[2]")
    public WebElement summaryBox;
    @FindBy(xpath = "//input[@name='free_lesson']")
    public WebElement checkboxFreeLesson;

    @FindBy (xpath = "//span[text()='Course manager']")
    public WebElement uS_027_CourseManager;

    @FindBy (xpath = "/html/body/div[2]/div/div[2]/div/div[1]/div/div/div/h4/a")
    public  WebElement uS_027_AddNewCourse;

    @FindBy (xpath = "//*[@id=\"basicwizard\"]/ul/li[6]/a")
    public WebElement uS_027_Seo;

    @FindBy (xpath = "//*[@id=\"seo\"]/div/div[1]/div/div/div/input")
    public WebElement uS_027_MetaKeywords;

    @FindBy (xpath = "//*[@id=\"seo\"]/div/div[2]/div/div/textarea")
    public WebElement uS_027_MetaDescription;

    public InstructorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public CoursesPage gotoCoursesPage() {
        buttonCourseManager.click();
        return new CoursesPage();
    }
}
