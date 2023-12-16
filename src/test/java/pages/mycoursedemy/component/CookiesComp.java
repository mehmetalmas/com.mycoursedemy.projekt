package pages.mycoursedemy.component;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class CookiesComp {
    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement buttonCookiesAccept;

    @FindBy(id = "cookieConsentContainer")
    public WebElement cookiesContainer;

    public CookiesComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void acceptCookies() {
        if (buttonCookiesAccept.isDisplayed()){
            ReusableMethods.waitForClickablility(buttonCookiesAccept,5);
            buttonCookiesAccept.click();
            hideCookies();
        }
    }

    public void hideCookies() {
            JavascriptExecutor driver = (JavascriptExecutor) Driver.getDriver();
            driver.executeScript("arguments[0].style.visibility='hidden'", cookiesContainer);

    }
}
