package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AllOpenPositionPage extends  BasePage{
    private By filterLocationDropdownLocator = By.cssSelector("span[id='select2-filter-by-location-container']");
    private By filterDepartmentDropdownLocator = By.cssSelector("span[id='select2-filter-by-department-container']");
    private By locationForExpectedLocator = By.cssSelector("select[name='filter-by-location']");
    private By departmentForExpectedLocator = By.cssSelector("select[name='filter-by-department']");
    private By jobPostingFrameLocator = By.xpath("(//p[@class='position-title font-weight-bold'])[4]");
    private By applyNowButtonLocator = By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[4]");
    private By jobShowingLocator = By.cssSelector("p[id='resultCounter']");
    private By departmentsLocatorsForList = By.cssSelector("span[class='position-department text-large font-weight-600 text-primary']");
    private By locationsLocatorForList = By.cssSelector("div[class='position-location text-large']");
    private By positionsLocatorForList = By.cssSelector("p[class='position-title font-weight-bold']");

    public AllOpenPositionPage(WebDriver driver) {
        super(driver);

    }

    public AllOpenPositionPage checkPositionNames() {
        setText(positionsLocatorForList, "Quality Assurance");
        return this;
    }

    public AllOpenPositionPage checkDepartmentNames() {
        setText(departmentsLocatorsForList, "Quality Assurance");
        return this;
    }

    public AllOpenPositionPage checkLocationNames() {
        setText(locationsLocatorForList, "Istanbul, Turkey");
        return this;
    }

    public AllOpenPositionPage checkJobList() {
        Assert.assertTrue(contains(jobShowingLocator, "Showing"), "There is no job on these filters!");
        return this;
    }

    public AllOpenPositionPage clickFilterLocationDropdown() throws InterruptedException {
        scrollToPage();
        Thread.sleep(1000);
        click(filterLocationDropdownLocator);
        return this;
    }

    public AllOpenPositionPage selectLocationForIstanbul(){
        selection(locationForExpectedLocator, "Istanbul, Turkey");
        click(filterLocationDropdownLocator);
        return this;
    }

    public AllOpenPositionPage selectDepartmentForQualityAssurance(){
       // click(filterDepartmentDropdownLocator);
        selection(departmentForExpectedLocator, "Quality Assurance");
        click(filterDepartmentDropdownLocator);
        return this;
    }

    public LeverAppFormPage selectApplyNow() throws InterruptedException {
        scrollToPage();
        Thread.sleep(2000);
        click(jobPostingFrameLocator);
        click(applyNowButtonLocator);
        return new LeverAppFormPage(driver);
    }


}
