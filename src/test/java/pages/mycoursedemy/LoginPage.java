package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.mycoursedemy.component.CookiesComp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class LoginPage {

    public String directory = "login";

    @FindBy(xpath = "//*[text()='Provide your valid login credentials']")
    public WebElement isLoginPage;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement fieldEmail;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement fieldPassword;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[@class='text-muted text-12px fw-500 float-end']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//h1[text()='Login']")
    public WebElement textLogin;

    @FindBy(xpath = "//p[text()='Provide your valid login credentials']")
    public WebElement textProvideYourValidLoginCredentials;

    @FindBy(xpath = "//*[text()='Forgot password?']")
    public WebElement buttonForgotPassword;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String email, String password) {
        String url = ConfigReader.getProperty("myUrl") + directory;
        Driver.getDriver().navigate().to(url);
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        CookiesComp cookiesComp = new CookiesComp();
        if (cookiesComp.buttonCookiesAccept.isDisplayed()) {
            cookiesComp.acceptCookies();
        }
        buttonLogin.click();
    }

}
