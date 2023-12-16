package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class BecomeInstructorPage {

    public BecomeInstructorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h4[@class='page-title']")
    public WebElement labelBecomeAnInstructor;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement fieldNameBecomeAnInstructor;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement fieldEmailAddressBecomeAnInstructor;

    @FindBy(xpath = "//textarea[@name='address']")
    public WebElement fieldAddressBecomeAnInstructor;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement fieldPhoneBecomeAnInstructor;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement fieldAnyMessageBecomeAnInstructor;

    @FindBy(xpath = "//input[@name='document']")
    public WebElement fieldDocumentBecomeAnInstructor;

    @FindBy(xpath = "//button[@onclick='checkRequiredFields()']")
    public WebElement fieldApplyBecomeAnInstructor;

    @FindBy(xpath = "//span[@class='account-user-name']")
    public WebElement testUserStudentButton;

    @FindBy(xpath = "//a[@class=\"dropdown-item notify-item\"][2]")
    public WebElement logoutButton;
    //(//a[@class='dropdown-item notify-item'])[2]

    public void TestUserInstructorLogout(){
        testUserStudentButton.click();
        ReusableMethods.waitForVisibility(logoutButton,3);
        logoutButton.click();
    }

}
