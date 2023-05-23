package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareersPage extends  BasePage{

    static  String PAGE_URL_CAREERS="https://useinsider.com/careers/";
//    @FindBy(id="#career-our-location")
//    private WebElement checkLocationLocator;
//    @FindBy(id="#career-our-location")
//    private WebElement checkTeamsLocator;
//    @FindBy("")
//    private WebElement checkLifeAtInsiderLocator;
//    @FindBy()
//    private WebElement seeAllTeamsButtonLocator;
//    @FindBy()
//    private WebElement qualityAssuranceButtonLocator;
    private By seeAllTeamsButtonLocator = By.cssSelector("#career-find-our-calling .btn");
//    @FindBy(xpath = "//*[@id=\"career-find-our-calling\"]/div/div/a")
//   private WebElement seeAllTeamsButtonLocator1;
    private By qualityAssuranceButtonLocator =By.xpath("//h3[normalize-space()='Quality Assurance']");
//    private By checkTeamsLocator = By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']");
//    private By checkLocationsLocator = By.cssSelector("h3[class='category-title-media ml-0']");
    public static By teams = By.xpath("//a[contains(text(),'See all teams')]");
    public static By location = By.xpath("//h3[contains(text(),'Our Locations')]");
    public static By lifeAtInsider = By.xpath("//h2[contains(text(),'Life at Insider')]");
    public static By ourStory = By.xpath("//h2[contains(text(),'Our story')]");

    public static By careerPageHead = By.id("page-head");


//    private By checkLifeAtInsiderLocator = By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[2]");

    public CareersPage(WebDriver driver) {
        super(driver);
    }


//    private String teamsGetText(){
//        return getTextAttribute(checkTeamsLocator);
//    }
//    private String locationGetText(){
//        return getTextAttribute(checkLocationsLocator);
//    }
//    private String lifeAtInsiderGetText(){
//        return getTextAttribute(checkLifeAtInsiderLocator);
//    }


    public  CareersPage verifyCareersPageOpened(){
        getPage(PAGE_URL_CAREERS);
//        Assert.assertEquals("",getPageTitle(),"Not on home page");
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

//        Assert.assertEquals("See all teams",teamsGetText(),"no teams");
//        Assert.assertEquals("Locations",locationGetText(),"no locations");
//        Assert.assertEquals("Life insider",lifeAtInsiderGetText()," no life insider");

        return this;
    }

    public CareersPage checkIsOpenedCareerPage(){
        Assertions.assertEquals("Insider Careers", getPageTitle(), "Not on Career Page");
        return this;
    }

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
