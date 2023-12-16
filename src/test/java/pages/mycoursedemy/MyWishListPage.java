package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyWishListPage {

    public MyWishListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[text()='My wishlist']")
    public WebElement textMyList;

    @FindBy(xpath = "//button[@class='btn-compare-sm float-end']")
    public WebElement buttonCompare;

    @FindBy(xpath = "//select[@onchange='compareCourses(this.value, 1)']")
    public WebElement dropDownMyWishList_1;

    @FindBy(xpath = "//select[@onchange='compareCourses(this.value, 2)']")
    public WebElement dropDownMyWishList_2;

    @FindBy(xpath = "//select[@onchange='compareCourses(this.value, 3)']")
    public WebElement dropDownMyWishList_3;

    @FindBy(xpath = "//input[@placeholder='Search my wishlist']")
    public WebElement searchMyWishList;

    @FindBy(xpath = "//h5[text()='Web Design for PHP']")
    public WebElement webDesignForPHP;

}
