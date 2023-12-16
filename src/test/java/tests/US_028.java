package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mycoursedemy.AddCoursePage;
import pages.mycoursedemy.CoursesPage;
import pages.mycoursedemy.InstructorPage;
import pages.mycoursedemy.LoginPage;
import pages.mycoursedemy.component.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_028 {
    /*
- User goes to site https://qualitydemy.com/
- Accepts the cookies
- Clicks the login button
- Enters email address into the email field on the https://qualitydemy.com/login page
- Enters the password into the passsword field on the same page.
- Clicks the login button on the same page
- Waits for 6 Seconds until toas message disappears for the successful loin on the https://qualitydemy.com/home page
- Clicks to Instructor button and be redirected to the https://qualitydemy.com/user page
- Clicks the Course Manager button on the same page and be redirected to https://qualitydemy.com/user/courses page
- Clicks to the + Add new course button on the same page and be redirected to https://qualitydemy.com/user/course_form/add_course page
- Fills the fields in all the sections in turn and clicks the right arrow button until user reaches te Finish section.
- Confirms that the page is redirected to the https://qualitydemy.com/user/course_form/course_edit section with the course ID end of the url.
- Confirms that Congradulations! message is appearing in the toast message.
     */

    public HeaderComp header;
    public AddCoursePage addCoursePage;
    public CoursesPage coursesPage;
    //https://stackoverflow.com/questions/45612089/how-to-upload-file-with-relative-path-in-selenium-webdriver
    //String dataPath = System.getProperty("user.home") + "/IdeaProjects/DenemeProjesi/data/";
    String dataPath = System.getProperty("user.dir") + "/data/";


    @Test
    public void test01() {
        fillAllTabs();
        By byToastHeading = By.xpath("//h2[@class='jq-toast-heading']");
        WebElement elementToastHeadig = Driver.getDriver().findElement(byToastHeading);
        String actualMessage = elementToastHeadig.getText();
        Assert.assertEquals(actualMessage, "Congratulations!");
    }

    public void gotoAddCoursePage() {
        LoginPage loginPage = new LoginPage();
        header = new HeaderComp();
        String email = ConfigReader.getUser("teacher.301.anil");
        String password = ConfigReader.getPassword("password.301.anil");
        loginPage.login(email, password);
        new ToastMessageComp().hideToastMessage();
        InstructorPage instructorPage = header.gotoInstructorPage();
        coursesPage = instructorPage.gotoCoursesPage();
        addCoursePage = coursesPage.gotoAddCoursePage();
    }


    public void fillBasics() {
        BasicComp basicComp = new BasicComp();
        String courseTitle = randomCourseTitle();
        basicComp.fieldCourseTitle.sendKeys( courseTitle);
        basicComp.fieldShortDescription.sendKeys("Learning "+ courseTitle + " by practicing");
        basicComp.fieldDescription.sendKeys("We are testing each other with qualitydemy.com website!");

        basicComp.dropdownSubCategory.click();
        List<WebElement> optionsSubCategory = basicComp.optionsSubCategory;
        int randomIndex = (int) (Math.random() * optionsSubCategory.size());
        WebElement randomSubCategory = optionsSubCategory.get(randomIndex);
        ReusableMethods.hover(randomSubCategory);
        randomSubCategory.click();

        basicComp.dropdownLevel.click();
        List<WebElement> optionsLevel = basicComp.optionsLevel;
        randomIndex = (int) (Math.random() * optionsLevel.size());
        WebElement randomOptionElement = optionsLevel.get(randomIndex);
        ReusableMethods.hover(randomOptionElement);
        randomOptionElement.click();

        basicComp.buttonRightArrow.click();
    }

    public String randomCourseTitle() {
        String courseTitle = "Basics of ";
        String[] courseSubjects = {"Selenium", "TestNG", "Cucumber", "JUnit", "API", "Database " };
        int randomIndex = (int) (Math.random() * courseSubjects.length);
        courseTitle += courseSubjects[randomIndex] + " with ";
        String[] names = {"Selman", "Fatih", "Ilhan", "Mehmet", "Muhammet", "Seher", "Esra", "Mesut", "Muhammet", "Soner", "Anil"};
        randomIndex = (int) (Math.random() * names.length);
        courseTitle += names[randomIndex];
        return courseTitle;
    }

    public void fillRequirements() {
        RequirementsComp reqComp = new RequirementsComp();
        reqComp.addRequirement("Curiosity");
        reqComp.addRequirement("Determination");
        reqComp.addRequirement("Perseverance");
        reqComp.addRequirement("Stability");
        reqComp.addRequirement("Passion");
        reqComp.buttonRightArrow.click();
    }

    public void fillOutcomes() {
        OutcomesComp outcomesComp = new OutcomesComp();
        outcomesComp.addOutcome("Success");
        outcomesComp.addOutcome("Self-confidence");
        outcomesComp.addOutcome("Happiness");
        outcomesComp.addOutcome("Satisfaction");
        outcomesComp.buttonRightArrow.click();
    }

    public void fillPricing() {
        PricingComp pricingComp = new PricingComp();
        int price = (int) (Math.random() * 100);
        pricingComp.price.sendKeys(String.valueOf(price));
        pricingComp.buttonRightArrow.click();
    }


    public void fillMedia() {
        MediaComp mediaComp = new MediaComp();
        /*ReusableMethods.clickElementByJS(mediaComp.dropdownOverviewProvider);
        List<WebElement> optionsOverviewProvider = mediaComp.optionsOverviewProvider;
        int randomIndex = (int) (Math.random() * optionsOverviewProvider.size());
        WebElement randomSubCategory = optionsOverviewProvider.get(randomIndex);
        ReusableMethods.hover(randomSubCategory);
        randomSubCategory.click();*/
        mediaComp.fieldCourseOverviewURL.sendKeys("youtube.com");
        System.out.println("dataPath = " + dataPath);
        mediaComp.fieldCourseThumbnail.sendKeys(dataPath + "testPicture.png");
        mediaComp.buttonRightArrow.click();
    }

    public void fillSeo() {
        SeoComp seoComp = new SeoComp();
        seoComp.fieldMetaKeywords.sendKeys("Selenium Cucumber TestNG JUnit API Java");
        seoComp.fieldMetaDescription.sendKeys("Everything about testing!");
        seoComp.buttonRightArrow.click();
    }

    public void fillFinish() {
        new FinishComp().buttonSubmit.click();
    }

    private void fillAllTabs() {
        gotoAddCoursePage();
        fillBasics();
        fillRequirements();
        fillOutcomes();
        fillPricing();
        fillMedia();
        fillSeo();
        fillFinish();
    }

}
