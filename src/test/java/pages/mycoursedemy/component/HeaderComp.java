package pages.mycoursedemy.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.PurchaseHistoryPage;
import pages.mycoursedemy.UserProfilePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class HeaderComp {
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//img[@height='35']")
    public WebElement logo;

    @FindBy(xpath = "//span[text()='Categories']")
    public WebElement dropDownCategories;

    @FindBy(name = "query")
    public WebElement fieldSearchBox;

    @FindBy(xpath = "//i[@class='fas fa-shopping-cart']")
    public WebElement buttonCart;

    @FindBy(xpath = "(//a[text()='Sign Up'])[1]")
    public WebElement buttonSignUp;

    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement buttonInstructor;

    @FindBy(xpath = "//div/a[text()='My courses']")
    public WebElement buttonMyCourses;

    @FindBy(xpath = "//div[@id='wishlist_items']/div[@class='icon']/a")
    public WebElement buttonWishList;

    @FindBy(xpath = "//a[text()='Purchase history']")
    public WebElement optionPurchaseHistory;

    @FindBy(xpath = "//div[@class='user-box menu-icon-box']/div/a")
    public WebElement dropDownUserIcon;

    @FindBy(xpath = "//a[text()='User profile']")
    public WebElement optionUserProfile;

    @FindBy(xpath = "//a[text()=' Log out']")
    public WebElement optionLogout;

    @FindBy(xpath = "//div[@class='wishlist-box menu-icon-box']")
    public WebElement iconWishList;

    @FindBy(xpath = "//a[text()='Go to wishlist']")
    public WebElement dropDownGoToWishList;

    @FindBy(xpath = "(//button[@class='btn'])[1]")
    public WebElement buttonSearchBox;

    public HeaderComp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public UserProfilePage goToUserProfile() {
        ReusableMethods.hover(dropDownUserIcon);
        ReusableMethods.waitForVisibility(optionUserProfile, 3);
        optionUserProfile.click();
        return new UserProfilePage();
    }

    public InstructorPage gotoInstructorPage() {
        buttonInstructor.click();
        return new InstructorPage();
    }

    public void logout() {
        ReusableMethods.hover(dropDownUserIcon);
        ReusableMethods.bekle(5);
        optionLogout.click();
    }

    public PurchaseHistoryPage goToPurchaseHistory() {
        ReusableMethods.hover(dropDownUserIcon);
        ReusableMethods.bekle(5);
        optionPurchaseHistory.click();
        return new PurchaseHistoryPage();
    }

}

