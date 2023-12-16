package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentPage {
    public PaymentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//img[@class='payment-gateway-icon']")
    public WebElement logoStripe;

    @FindBy(xpath = "//button[@id='stripePayButton']")
    public WebElement buttonPayWithStripe;

    @FindBy(xpath = "//a[@class='close-btn-light float-end']")
    public WebElement buttonClose;
}
