package pages.stripe;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StripePage {

    public StripePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement fieldEPosta;

    @FindBy(xpath = "//input[@id='billingName']")
    public WebElement fieldKartUzerindekiAd;

    @FindBy(xpath = "//input[@id='cardNumber']")
    public WebElement fieldCardNumber;

    @FindBy(xpath = "//input[@id='cardExpiry']")
    public WebElement fieldCardExpiry;

    @FindBy(xpath = "//input[@id='cardCvc']")
    public WebElement fieldCardCvc;

    @FindBy(xpath = "//select[@id='billingCountry']")
    public WebElement dropDownBillingCountry;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement fieldPhoneNumber;

    @FindBy(xpath = "//button[@data-testid='hosted-payment-submit-button']")
    public WebElement buttonOde;

    @FindBy(xpath = "//input[@data-testid='sms-code-input-0']")
    public WebElement smsCodeInput_0;
    @FindBy(xpath = "//input[@data-testid='sms-code-input-1']")
    public WebElement smsCodeInput_1;
    @FindBy(xpath = "//input[@data-testid='sms-code-input-2']")
    public WebElement smsCodeInput_2;
    @FindBy(xpath = "//input[@data-testid='sms-code-input-3']")
    public WebElement smsCodeInput_3;
    @FindBy(xpath = "//input[@data-testid='sms-code-input-4']")
    public WebElement smsCodeInput_4;
    @FindBy(xpath = "//input[@data-testid='sms-code-input-5']")
    public WebElement smsCodeInput_5;

    @FindBy(xpath = "//input[@id='enableStripePass']")
    public WebElement checkBoxEnable;



}
