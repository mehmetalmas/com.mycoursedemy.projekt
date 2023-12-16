package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TempMailPage {

    @FindBy(xpath = "//button[@id='accept']")
    public WebElement buttonCookies;

    @FindBy(xpath = "//div[@class='txtlien']")
    public WebElement buttonRandomEmailAdress;

    @FindBy(xpath = "//div[@id='egen']")
    public WebElement buttonRandomEmailAdressGenerator;

    @FindBy(xpath = "//*[text()='Check Inbox']")
    public WebElement buttonCheckInbox;

    @FindBy(xpath = "//p[text()='Your verification code is ']")
    public WebElement elementVerificationCode;

    public TempMailPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
}
