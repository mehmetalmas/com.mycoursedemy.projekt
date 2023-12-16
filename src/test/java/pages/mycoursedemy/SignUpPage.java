package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement fieldFirstName;

    @FindBy(xpath = "//input[@placeholder='Last name']")
    public WebElement fieldLastName;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement fieldPassword;

    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement buttonNewSignUp;

    @FindBy(xpath = "//p[text()='Sign up and start learning']")
    public WebElement textSignUpAndStartLearning;

    @FindBy(xpath = "//label[text()='Verification code']")
    public WebElement verificationPage;

    @FindBy(className = "toast-message")
    public WebElement toastMessage;

    @FindBy(xpath = "//div[text()='You have already registered. Please verify your email address']")
    public WebElement alreadyRegistered;

    @FindBy(xpath = " //div[text()='Your registration has been successfully done. Please check your mail inbox to verify your email address.']")
    public WebElement firstRegisteredMessage;

    @FindBy(xpath = "//p[text()='The First Name field must be at least 2 characters in length.']")
    public WebElement warningFirstNameWrong;

    @FindBy(xpath = " //p[text()='The Last name field must be at least 2 characters in length.']")
    public WebElement warningLastNameWrong;

    @FindBy(xpath = "//input[@id='verification_code']")
    public WebElement fieldVerificationCode;

    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement buttonContinue;

    @FindBy(xpath = "//*[text()='Congratulations!Your email address has been successfully verified.']")
    public WebElement verifiedMessage;


    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
