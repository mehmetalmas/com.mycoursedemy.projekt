package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.mycoursedemy.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class UserHeaderComp {

    @FindBy(xpath = "//a[text()='Visit website']")
    public WebElement buttonVisitWebSite;
    @FindBy(xpath = "//span[@class='account-user-name']")
    public WebElement dropDownUserIcon;
    @FindBy(xpath = "//a[@class=\"dropdown-item notify-item\"][2]")
    public WebElement optionLogouot;

    public UserHeaderComp(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void userLogout(){
        dropDownUserIcon.click();
        ReusableMethods.waitForVisibility(optionLogouot,3);
        optionLogouot.click();
    }

}
