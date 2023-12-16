package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserCredentialsPage {

    public String directory = "home/profile/user_credentials";
    public String title = "Credentials | MyCourseDemy";

    @FindBy(id = "current_password")
    public WebElement fieldCurrentPassword;

    @FindBy(id = "new_password")
    public WebElement fieldNewPassword;

    @FindBy(id = "confirm_password")
    public WebElement fieldConfirmPassword;

    @FindBy(xpath = "//button[text()='Save changes']")
    public WebElement buttonSaveChanges;

    public UserCredentialsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
