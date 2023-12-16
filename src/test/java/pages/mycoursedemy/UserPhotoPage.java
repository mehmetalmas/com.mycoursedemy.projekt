package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;

public class UserPhotoPage {

    public String directory = "user_photo";
    public String title = "Update User Photo | MyCourseDemy";

    @FindBy(name = "user_image")
    public WebElement fieldChooseFile;

    @FindBy(xpath = "//button[text()=' Upload']")
    public WebElement buttonUpload;

    public UserPhotoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
