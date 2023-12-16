package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OutcomesComp {
    @FindBy(name = "outcomes[]")
    @CacheLookup
    public WebElement fieldProvideOutcomes;

    @FindBy(xpath = "//button[@onclick='appendOutcome()']")
    @CacheLookup
    public WebElement buttonPlus;

    @FindBy(css = ".mdi.mdi-arrow-left-bold")
    @CacheLookup
    public WebElement buttonLeftArrow;

    @FindBy(css = ".mdi.mdi-arrow-right-bold")
    @CacheLookup
    public WebElement buttonRightArrow;

    @FindBy(xpath = "//a[text()=' Back to course list']")
    @CacheLookup
    public WebElement buttonBackToCourseList;

    public OutcomesComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void addOutcome(String outcome) {
        fieldProvideOutcomes.sendKeys(outcome);
        buttonPlus.click();
        fieldProvideOutcomes.clear();
    }
}
