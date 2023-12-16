package pages.mycoursedemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCourses_AllCategory {

    @FindBy (xpath = "//*[@id=\"collapseFilter\"]/div/div[2]/div/ul/li/div[3]/label")
    public WebElement uS_10_Price_Paid;

    @FindBy (xpath = "/html/body/section[3]/div/div/div[2]/div[2]/ul/li[5]/div/div[2]/a")
    public  WebElement uS_10_Build_Responsive;























    public AllCourses_AllCategory () {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /*
    PageFactory modeli , PageObject'inizin bir uzantısı olarak işlev görerek aşağıdaki gibi şeyler yapmanıza olanak tanır:

        userName.sendKeys("myUserName");
        password.sendKeys("myPassword");
        button.click();

   sayfa nesnesindeki daha standart Selenium findElement çağrıları yerine. Bu, çağrıları tanımlamanız gerekmediğinden sayfa nesnesi kodunuzu basitleştirir
   PageFactory.initElements(driver, pageObjectClass)dolaylı olarak findElementperde arkasındaki aramaları oluşturur.

     */

}
