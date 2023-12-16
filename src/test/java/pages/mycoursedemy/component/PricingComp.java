package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PricingComp {

    @FindBy(id = "price")
    @CacheLookup
    public WebElement price;

    @FindBy(css = ".mdi.mdi-arrow-left-bold")
    @CacheLookup
    public WebElement buttonLeftArrow;

    @FindBy(css = ".mdi.mdi-arrow-right-bold")
    @CacheLookup
    public WebElement buttonRightArrow;

    @FindBy(xpath = "//a[text()=' Back to course list']")
    @CacheLookup
    public WebElement buttonBackToCourseList;

    public PricingComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
