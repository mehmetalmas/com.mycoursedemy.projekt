package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCartPage {
    public ShoppingCartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='btn red w-100 radius-10 mb-3']")
    public WebElement buttonCheckout;

    @FindBy(xpath = "//div[@onclick='removeFromCartList(this)']")
    public WebElement buttonRemove;


}