package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EnglishCourseSpeaking {
    public EnglishCourseSpeaking() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Add to Cart']")
    public WebElement buttonAddToCart;
    @FindBy(xpath = "//button[text()='Added to Cart']")
    public WebElement buttonAddedToCart;
    @FindBy(xpath = "//a[@class='course-title']")
    public WebElement englishCourseSpeaking;
}
