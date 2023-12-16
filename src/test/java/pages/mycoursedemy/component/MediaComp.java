package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MediaComp {


    @FindBy(id = "select2-course_overview_provider-container")
    @CacheLookup
    public WebElement dropdownOverviewProvider;

    @FindAll(@FindBy(xpath = "//ul[@id='select2-course_overview_provider-results']//li"))
    public List<WebElement> optionsOverviewProvider;

    @FindBy(id = "course_overview_url")
    @CacheLookup
    public WebElement fieldCourseOverviewURL;

    @FindBy(id = "course_thumbnail")
    @CacheLookup
    public WebElement fieldCourseThumbnail;

    @FindBy(css = ".mdi.mdi-arrow-left-bold")
    @CacheLookup
    public WebElement buttonLeftArrow;

    @FindBy(css = ".mdi.mdi-arrow-right-bold")
    @CacheLookup
    public WebElement buttonRightArrow;

    @FindBy(xpath = "//a[text()=' Back to course list']")
    @CacheLookup
    public WebElement buttonBackToCourseList;

    public MediaComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
