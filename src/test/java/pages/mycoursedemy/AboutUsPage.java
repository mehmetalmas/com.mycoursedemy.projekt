package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AboutUsPage {

    @FindBy(xpath = "//a[@href='https://qualitydemy.com/home']")
    public WebElement AboutUsPageBreadcrumbLink;


    public AboutUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
