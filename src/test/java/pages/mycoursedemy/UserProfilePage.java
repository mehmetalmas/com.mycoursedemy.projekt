package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserProfilePage {

    String directory = "home/profile/user_profile";
    String title = "User profile | MyCourseDemy";

    @FindBy(xpath = "//a[@href='https://mycoursedemy.com/home/profile/user_credentials']")
    public WebElement buttonAccount;

    @FindBy(xpath = "//a[@href='https://mycoursedemy.com/home/profile/user_photo']")
    public WebElement buttonPhoto;

    public UserProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        title = Driver.getDriver().getTitle();
    }

    public UserCredentialsPage gotoUserCredentialsPage() {
        buttonAccount.click();
        return new UserCredentialsPage();
    }

    public UserPhotoPage gotoUserPhotoPage() {
        buttonPhoto.click();
        return new UserPhotoPage();
    }

}
