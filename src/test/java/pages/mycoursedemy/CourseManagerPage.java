package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CourseManagerPage {
    public CourseManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    public WebElement buttonCategories;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    public WebElement buttonStatus;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[3]")
    public WebElement buttonPrice;

    @FindBy(xpath = "//button[@name='button']")
    public WebElement buttonFilter;

    @FindBy(linkText = "//li[contains(text(),'English Speaking Course')]")
    public WebElement linkEnglishSpeakingCourse;

    @FindBy(xpath = "//li[contains(text(),'Web Design for Web Developers')]")
    public WebElement buttonCategories_WebDesignForWebDevelopers;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    public WebElement buttonStatus_Active;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    public WebElement buttonPrice_Free;

    @FindBy(xpath = "//a[@href='https://qualitydemy.com/user/course_form/course_edit/142']")
    public WebElement listedTitle_WebDesign;
    //a[text()='Piano Nanny  ']

    @FindBy(xpath = "//a[text()='Piano Nanny  ']")
    public WebElement listedTitle_Piano;

    @FindBy(xpath = "//a[contains(text(),'Achieving Personal and Professional Success Specialization')]")
    public WebElement listedTitle_AchievingPersonalAndProfessionalSuccessSpecialization;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement buttonSearchBox;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement buttonThreeDotsWebDisagnForWebDevelopers;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement buttonThreeDotsTimeManagement;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement buttonThreeDotsPiano;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement buttonThreeDotsAchievingPersonalAndProfessionalSuccessSpecialization;

    @FindBy(xpath = "(//a[@href='https://qualitydemy.com/home/course/web-design-for-web-developers-build-beautiful-websites/142'])[2]")
    public WebElement button_ViewCourseOnFronted;

    @FindBy(xpath = "(//td[@class='sorting_1'])[4]")
    public WebElement buttonsignWebDisagnForWebDevelopers;

    @FindBy(xpath = "(//td[@class='sorting_1'])[6]")
    public WebElement buttonsignPiano;

    @FindBy(xpath = "//td[contains(text(),'7')]")
    public WebElement buttonsignAchievingPersonalAndProfessionalSuccessSpecialization;

    @FindBy(linkText = "//h1[text()='The Piano Sonata: Beethoven and the Romantics']")
    public WebElement redirectedPageTitle;

    @FindBy(xpath = "(//a[text()='Go to course playing page'])[5]")
    public WebElement button_GoToCoursePlayingPage;
    //(//a[text()='Go to course playing page'])[5]
    @FindBy(xpath = "(//a[text()='Edit this course'])[5]")
    public WebElement button_EditThisCourse;

    @FindBy(xpath = "(//a[text()='Section and lesson'])[5]")
    public WebElement button_SectionAndLesson;

    @FindBy(xpath = "(//a[text()='Mark as drafted'])[5]")
    public WebElement button_MarkAsDrafted;

    @FindBy(xpath = "(//a[text()='Continue'])[1]")
    public WebElement button_Continue;
    //a[@href='https://qualitydemy.com/user/course_actions/draft/58']

    @FindBy(xpath = "(//span[text()='Pending'])[3]")
    public WebElement statusWebDisagnForWebDevelopers_Pending;

    @FindBy(xpath = "(//span[text()='Draft'])[2]")
    public WebElement status_Draft;
    //(//span[text()='Draft'])[2]

    @FindBy(xpath = "(//button[text()='Cancel'])[1]")
    public WebElement button_Cancel;

    @FindBy(xpath = "(//a[text()='Publish this course'])[2]")
    public WebElement button_PublishThisCourse;

    @FindBy(xpath = "(//a[text()='Delete'])[2]")
    public WebElement buttonDelete;

    @FindBy(xpath = "(//a[text()='Delete'])[7]")
    public WebElement buttonDeletePiano;

    @FindBy(xpath = "(//a[text()='Delete'])[8]")
    public WebElement buttonDeleteAchievingPersonalAndProfessionalSuccessSpecialization;

    @FindBy(xpath = "//a[@href='https://qualitydemy.com/user/course_form/add_course']")
    public WebElement button_AddNewCourse;




}
