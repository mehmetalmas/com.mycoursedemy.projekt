package pages.mycoursedemy.component;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SeoComp {

    @FindBy(xpath = "//div[@class='bootstrap-tagsinput']/input")
    @CacheLookup
    public WebElement fieldMetaKeywords;
    @FindBy(name = "meta_description")
    @CacheLookup
    public WebElement fieldMetaDescription;

    @FindBy(css = ".mdi.mdi-arrow-left-bold")
    @CacheLookup
    public WebElement buttonLeftArrow;

    @FindBy(css = ".mdi.mdi-arrow-right-bold")
    @CacheLookup
    public WebElement buttonRightArrow;

    @FindBy(xpath = "//a[text()=' Back to course list']")
    @CacheLookup
    public WebElement buttonBackToCourseList;

    public SeoComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
