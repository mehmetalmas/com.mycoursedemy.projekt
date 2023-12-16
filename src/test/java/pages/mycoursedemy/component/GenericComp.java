package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GenericComp {
    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement cookiesLogin;

    public GenericComp(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
