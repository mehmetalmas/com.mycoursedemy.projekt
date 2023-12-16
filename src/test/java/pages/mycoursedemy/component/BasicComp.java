package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class BasicComp {

    @FindBy(id = "course_title")
    @CacheLookup
    public WebElement fieldCourseTitle;

    @FindBy(id = "short_description")
    @CacheLookup
    public WebElement fieldShortDescription;

    @FindBy(xpath = "//div[@class='note-editable card-block']/p")
    @CacheLookup
    public WebElement fieldDescription;

    @FindBy(id = "select2-sub_category_id-container")
    @CacheLookup
    public WebElement dropdownSubCategory;

    @FindAll(@FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']//li"))
    public List<WebElement> optionsSubCategory;

    @FindBy(id = "select2-level-container")
    @CacheLookup
    public WebElement dropdownLevel;

    @FindAll(@FindBy(xpath = "//ul[@id='select2-level-results']//li"))
    public List<WebElement> optionsLevel;

    @FindBy(css = ".mdi.mdi-arrow-left-bold")
    @CacheLookup
    public WebElement buttonLeftArrow;

    @FindBy(css = ".mdi.mdi-arrow-right-bold")
    @CacheLookup
    public WebElement buttonRightArrow;

    @FindBy(xpath = "//a[text()=' Back to course list']")
    @CacheLookup
    public WebElement buttonBackToCourseList;

    public BasicComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
