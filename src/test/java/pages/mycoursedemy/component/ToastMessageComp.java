package pages.mycoursedemy.component;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ToastMessageComp {
    @FindBy(className = "toast-message")
    public WebElement toastMessage;

    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement toastMessageDiv;

    @FindAll(
            {@FindBy(className = "toast-message")}
    )
    List<WebElement> toastMessageList;

    public ToastMessageComp() {
        PageFactory.initElements(Driver.getDriver(), this);
        ReusableMethods.bekle(1);
    }

    public void hideToastMessage() {
        if (toastMessageList.size() > 0) {
            JavascriptExecutor driver = (JavascriptExecutor) Driver.getDriver();
            driver.executeScript("arguments[0].style.visibility='hidden'", toastMessageDiv);
        }
    }

    public String getText() {
        if (toastMessageList.size() > 0)
            return toastMessageList.get(0).getText();
        return "There is no visable toast message!";
    }

}
