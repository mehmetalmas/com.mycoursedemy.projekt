package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CourseComparePage {

    @FindBy(xpath = "(//span[@class='select2 select2-container select2-container--default'])[1]")
    public WebElement ddmCourseCompare1;
    //Course compare sayfasından 1.dropdown sekmesinin locati.

    @FindBy(xpath = "(//span[@class='form-select compare-select-box'])[2]")
    public WebElement ddmCourseCompare2;
    //Course compare sayfasından 2.dropdown sekmesinin locati.

    @FindBy(xpath = "(//span[@class='form-select compare-select-box'])[3]")
    public WebElement ddmCourseCompare3;
    //Course compare sayfasından 3.dropdown sekmesinin locati.

    @FindBy(xpath = "//*[text()='Learn more ']")
    public WebElement linkButtonLearnMoreCompare;
    //Course compare sayfasındaki "Get Enrolled" butonu altındaki "learn more" linki.

    @FindBy(xpath = "//*[text()='Buy now']")
    public WebElement buttonBuyNowCompare;
    //Course compare sayfasındaki "Get Enrolled" butonu altındaki "learn more" linki.


    public CourseComparePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
