package pages.sozialenMedien;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {


    @FindBy (xpath = "//h2[contains(text(),'Facebook')]")
    public WebElement facebookHomePage; // US_003_TC_0002

    @FindBy ( xpath ="//button[contains(text(), 'Erforderliche und optionale Cookies')]" )
    public  WebElement FacebookCookies; // US_003_TC_0002


    @FindBy (xpath = "//button[@id='join-form-submit']")
    public WebElement linkedinHomePage; // US_003_TC_0002

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[1]/div/div/div/div/div/div[1]/div[2]/div/div/div/form/div[1]/div/div/div/label/div[2]/div/input")
    public WebElement twitterHomePage; // US_003_TC_0002


    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
