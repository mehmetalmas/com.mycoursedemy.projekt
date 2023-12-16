package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {
    @FindBy(xpath = "//h1[text()='Forgot password']")
    public WebElement TextForgotPassword;

    @FindBy(xpath = "//input[@id='forgot-password-email']")
    public WebElement fieldsMailForgotPassword;
    //Forgot Password sayfasındaki mail girilen "Email" alanı.

    @FindBy(xpath = "//*[text()='Send request']")
    public WebElement buttonSendRequest;
    //Forgot Password sayfasındaki Send request butonu.

    @FindBy(xpath = "(//a[@href='https://qualitydemy.com/login'])[2]")
    public WebElement buttonLoginForgotPassword;
    ////Forgot Password sayfasındaki "Want to go back?" yanındaki "Login" linki butonu.

    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}