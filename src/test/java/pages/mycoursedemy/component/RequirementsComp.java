package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;



public class RequirementsComp {


    @FindBy(xpath = "//input[@id='requirements']")
    @CacheLookup
    public WebElement fieldRequirements;

    @FindBy(xpath = "//button[@onclick='appendRequirement()']")
    @CacheLookup
    public WebElement buttonAppendRequirement;

    @FindBy(css = ".mdi.mdi-arrow-left-bold")
    public WebElement buttonLeftArrow;

    @FindBy(css = ".mdi.mdi-arrow-right-bold")
    @CacheLookup
    public WebElement buttonRightArrow;

    @FindBy(xpath = "//a[text()=' Back to course list']")
    @CacheLookup
    public WebElement buttonBackToCourseList;

    public RequirementsComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void addRequirement(String req) {
        fieldRequirements.sendKeys(req);
        buttonAppendRequirement.click();
        fieldRequirements.clear();
    }
}
