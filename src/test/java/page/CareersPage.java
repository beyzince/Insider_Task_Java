package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareersPage extends  BasePage{

    static  String PAGE_URL_CAREERS="https://useinsider.com/careers/";

public static By seeAllTeamsButtonLocator = By.cssSelector("#career-find-our-calling .btn");

public static By qualityAssuranceButtonLocator =By.xpath("//h3[normalize-space()='Quality Assurance']");

    public static By teams = By.xpath("//a[contains(text(),'See all teams')]");
    public static By location = By.xpath("//h3[contains(text(),'Our Locations')]");
    public static By lifeAtInsider = By.xpath("//h2[contains(text(),'Life at Insider')]");
    public static By ourStory = By.xpath("//h2[contains(text(),'Our story')]");

   // public static By careerPageHead = By.id("page-head");




    public CareersPage(WebDriver driver) {
        super(driver);
    }





    public  CareersPage verifyCareersPageOpened(){
        getPage(PAGE_URL_CAREERS);
        Assert.assertEquals("Insider Careers",getPageTitle(),"Not on Career Page");
        return  this;
    }


    public CareersPage checkIfBlocksOfCareerPageLoaded() throws InterruptedException {
        scrollToElement(location);
        Assert.assertTrue(isElementDisplayed(location),"Our Locations is not on screen!");
        scrollToElement(ourStory);
        Assert.assertTrue(isElementDisplayed(ourStory),"Our Story is not on screen!");
        scrollToElement(lifeAtInsider);
        Assert.assertTrue(isElementDisplayed(lifeAtInsider),"Life At Insider is not on screen!");
        scrollToElement(teams);
        Assert.assertTrue(isElementDisplayed(teams),"See All Teams is not on screen!");



        return this;
    }

//    public CareersPage checkIsOpenedCareerPage(){
//        Assertions.assertEquals("Careers – Insider", getPageTitle(), "Not on Career Page");
//        return this;
//    }

    public CareersPage clickSeeAllTeams() throws InterruptedException {
        Thread.sleep(2000);


        elementJS(seeAllTeamsButtonLocator);
       // click(seeAllTeamsButtonLocator);
        return this;
    }

    public QualityAssurancePage clickQualityAssurance() {

        elementJS(qualityAssuranceButtonLocator);
        //click(qualityAssuranceButtonLocator);
        return new QualityAssurancePage(driver);


    }
}
