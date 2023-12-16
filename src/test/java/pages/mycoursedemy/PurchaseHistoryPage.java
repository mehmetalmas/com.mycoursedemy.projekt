package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.mycoursedemy.component.CookiesComp;
import utilities.Driver;
import utilities.ReusableMethods;

public class PurchaseHistoryPage {

    public String directory = "home/purchase_history";

    public String title = "Purchase History | QualityDemy";

    @FindBy(xpath = "//a[text()='Invoice']")
    public WebElement buttonInvoice;

    @FindBy(xpath = "//*[text()=' Purchase history']")
    public WebElement buttonPurchaseHistory;

    @FindBy(className = "purchase-history-course-title")
    public WebElement fieldCourseTitle;


    public void goToInvoicePage() {
        buttonInvoice.click();
        ReusableMethods.switchToWindow("Invoice | MyCourseDemy");

    }


    public PurchaseHistoryPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }
}
